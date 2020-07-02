/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-02 14:47:13
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/service/member/impl/MemberServiceImpl.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.service.member.impl;

import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import me.chanjar.weixin.common.error.WxErrorException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import cn.codingtalk.tacomallcommon.enumeration.BizEnum;
import cn.codingtalk.tacomallcommon.utils.RequestUtil;
import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallcommon.utils.ObjectUtil;
import cn.codingtalk.tacomallcommon.utils.IntUtil;
import cn.codingtalk.tacomallentity.member.Member;
import cn.codingtalk.tacomallmapper.member.MemberMapper;
import cn.codingtalk.tacomallentity.member.MemberWeixin;
import cn.codingtalk.tacomallmapper.member.MemberWeixinMapper;
import cn.codingtalk.tacomallentity.member.MemberWeixinMa;
import cn.codingtalk.tacomallmapper.member.MemberWeixinMaMapper;
import cn.codingtalk.tacomallcommon.utils.ExceptionUtil;
import cn.codingtalk.tacomallcommon.utils.JwtUtil;
import cn.codingtalk.tacomallapiportal.config.WxMaConfig;
import cn.codingtalk.tacomallapiportal.service.member.MemberService;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemberWeixinMapper memberWeixinMapper;

    @Autowired
    private MemberWeixinMaMapper memberWeixinMaMapper;

    @Autowired
    TransactionDefinition transactionDefinition;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

    @Override
    public ResponseVo<String> wxMaLogin(String iv, String code, String appid, String rawData, String signature,
            String encryptedData) throws Exception {
        final WxMaService wxService = WxMaConfig.getMaService(appid);
        ResponseVo<String> responseVo = new ResponseVo<>();
        WxMaJscode2SessionResult session;
        try {
            session = wxService.getUserService().getSessionInfo(code);
            this.logger.info(session.getSessionKey());
            this.logger.info(session.getOpenid());
            if (!wxService.getUserService().checkUserInfo(session.getSessionKey(), rawData, signature)) {
                responseVo.setStatus(false);
                responseVo.setCode(BizEnum.FALSE.getCode());
                responseVo.setMessage("user check failed");
                return responseVo;
            }
        } catch (WxErrorException e) {
            this.logger.error(e.getMessage(), e);
            responseVo.setStatus(false);
            responseVo.setCode(BizEnum.FALSE.getCode());
            responseVo.setMessage(e.toString());
            return responseVo;
        }

        WxMaUserInfo userInfo = wxService.getUserService().getUserInfo(session.getSessionKey(), encryptedData, iv);
        Member member = baseMapper.getMember("open_id", session.getOpenid());
        String token = "";

        if (ObjectUtil.isNull(member)) {
            TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
            try {

                member = new Member();
                member.setNickname(userInfo.getNickName());
                member.setAvatar(userInfo.getAvatarUrl());
                baseMapper.insert(member);

                MemberWeixin memberWeixin = new MemberWeixin();
                memberWeixin.setMemberId(member.getId());
                memberWeixin.setUnionId(userInfo.getUnionId());
                memberWeixin.setNickname(userInfo.getNickName());
                memberWeixin.setAvatar(userInfo.getAvatarUrl());
                memberWeixinMapper.insert(memberWeixin);

                MemberWeixinMa memberWeixinMa = new MemberWeixinMa();
                memberWeixinMa.setMemberId(member.getId());
                memberWeixinMa.setOpenId(userInfo.getOpenId());
                memberWeixinMaMapper.insert(memberWeixinMa);

                dataSourceTransactionManager.commit(transactionStatus);
            } catch (Exception e) {
                dataSourceTransactionManager.rollback(transactionStatus);
                ExceptionUtil.throwSqlException("sql错误");
            }
        }

        try {
            Map<String, String> claims = new HashMap<>(1);
            claims.put("id", IntUtil.toString(member.getId()));
            JwtUtil jwtUtil = new JwtUtil();
            jwtUtil.setISSUER("api-portal");
            token = jwtUtil.create(claims);
        } catch (Exception e) {
            ExceptionUtil.throwBizException("token生成失败");
        }
        responseVo.setData(token);
        return responseVo;

    }

    @Override
    public ResponseVo<Member> info() {
        ResponseVo<Member> responseVo = new ResponseVo<>();
        responseVo.setData(baseMapper.getMember("id", RequestUtil.getLoginUser().getString("id")));
        return responseVo;
    }

}
