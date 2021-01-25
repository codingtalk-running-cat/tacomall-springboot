/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-12-17 14:12:14
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/impl/MemberServiceImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service.impl;

import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.NumberUtil;

import store.tacomall.common.util.ExceptionUtil;
import store.tacomall.common.util.JwtUtil;
import store.tacomall.common.util.RequestUtil;
import store.tacomall.common.vo.ResponseVo;

import store.tacomall.common.entity.member.Member;
import store.tacomall.common.mapper.member.MemberMapper;
import store.tacomall.common.entity.member.MemberWeixin;
import store.tacomall.common.mapper.member.MemberWeixinMapper;
import store.tacomall.common.entity.member.MemberWeixinMa;
import store.tacomall.common.mapper.member.MemberWeixinMaMapper;
import store.tacomall.common.entity.member.MemberStatisticsInfo;
import store.tacomall.common.mapper.member.MemberStatisticsInfoMapper;
import store.tacomall.apiportal.config.WxMaConfig;
import store.tacomall.apiportal.service.MemberService;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemberWeixinMapper memberWeixinMapper;

    @Autowired
    private MemberWeixinMaMapper memberWeixinMaMapper;

    @Autowired
    private MemberStatisticsInfoMapper memberStatisticsInfoMapper;

    @Autowired
    TransactionDefinition transactionDefinition;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

    /***
     * @description: 微信小程序登录
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<String> wxMaLogin(String appid, JSONObject json) throws Exception {
        ResponseVo<String> responseVo = new ResponseVo<>();
        String iv = json.getString("iv");
        String code = json.getString("code");
        String rawData = json.getString("rawData");
        String signature = json.getString("signature");
        String encryptedData = json.getString("encryptedData");
        responseVo.setStatus(false);
        String token = "";

        final WxMaService wxService = WxMaConfig.getMaService(appid);

        WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);

        if (!wxService.getUserService().checkUserInfo(session.getSessionKey(), rawData, signature)) {
            responseVo.setMessage("user check failed");
            return responseVo;
        }
        WxMaUserInfo userInfo = wxService.getUserService().getUserInfo(session.getSessionKey(), encryptedData, iv);
        Member member = baseMapper.getMember(new QueryWrapper<Member>().lambda().inSql(Member::getId,
                String.format("select member_id from member_weixin_ma where open_id = '%s'", session.getOpenid())));

        if (ObjectUtil.isNull(member)) {
            logger.info("new member");
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

                MemberStatisticsInfo memberStatisticsInfo = new MemberStatisticsInfo();
                memberStatisticsInfo.setMemberId(member.getId());
                memberStatisticsInfo.setConsumeAmount(BigDecimal.ZERO);
                memberStatisticsInfo.setOrderNonPaymentCount(0);
                memberStatisticsInfo.setOrderPaidCount(0);
                memberStatisticsInfo.setOrderDoneCount(0);
                memberStatisticsInfo.setOrderReturnCount(0);
                memberStatisticsInfo.setIntegralCount(0);
                memberStatisticsInfo.setGrowthCount(0);
                memberStatisticsInfoMapper.insert(memberStatisticsInfo);

                dataSourceTransactionManager.commit(transactionStatus);
            } catch (Exception e) {
                dataSourceTransactionManager.rollback(transactionStatus);
                ExceptionUtil.throwSqlException(e.toString());
            }
        }

        Map<String, String> claims = new HashMap<>(1);
        claims.put("id", NumberUtil.toStr(member.getId()));
        JwtUtil jwtUtil = new JwtUtil();
        jwtUtil.setISSUER("api-portal");
        token = jwtUtil.create(claims);
        responseVo.setStatus(true);
        responseVo.setData(token);
        return responseVo;

    }

    /***
     * @description: 用户信息
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Member> info() {
        ResponseVo<Member> responseVo = new ResponseVo<>();
        responseVo.setData(baseMapper.getMember(
                new QueryWrapper<Member>().lambda().eq(Member::getId, RequestUtil.getLoginUser().getString("id"))));
        return responseVo;
    }

}
