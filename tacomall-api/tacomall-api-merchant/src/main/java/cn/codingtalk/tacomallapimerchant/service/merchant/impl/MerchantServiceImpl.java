/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-15 11:28:32
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/cn/codingtalk/tacomallapimerchant/service/merchant/impl/MerchantServiceImpl.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapimerchant.service.merchant.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.codingtalk.tacomallcommon.utils.ExceptionUtil;
import cn.codingtalk.tacomallcommon.utils.IntUtil;
import cn.codingtalk.tacomallcommon.utils.ObjectUtil;
import cn.codingtalk.tacomallcommon.utils.JwtUtil;
import cn.codingtalk.tacomallcommon.utils.PasswordUtil;
import cn.codingtalk.tacomallcommon.utils.RequestUtil;
import cn.codingtalk.tacomallentity.merchant.Merchant;
import cn.codingtalk.tacomallmapper.merchant.MerchantMapper;
import cn.codingtalk.tacomallapimerchant.service.merchant.MerchantService;
import cn.codingtalk.tacomallcommon.vo.ResponseVo;

@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant> implements MerchantService {

    @Override
    public ResponseVo<String> login(String username, String password) {
        ResponseVo<String> responseVo = new ResponseVo<>();
        Merchant merchant = baseMapper
                .selectOne(new QueryWrapper<Merchant>().lambda().eq(Merchant::getUsername, username));
        if (ObjectUtil.isNull(merchant)) {
            responseVo.setStatus(false);
            responseVo.setMessage("用户不存在");
            return responseVo;
        }
        if (merchant.getPasswd() != PasswordUtil.encode(password)) {
            responseVo.setStatus(false);
            responseVo.setMessage("密码错误");
            return responseVo;
        }
        String token = "";
        try {
            Map<String, String> claims = new HashMap<>(1);
            claims.put("id", IntUtil.toString(merchant.getId()));
            JwtUtil jwtUtil = new JwtUtil();
            jwtUtil.setISSUER("api-merchant");
            token = jwtUtil.create(claims);
            responseVo.setData(token);
        } catch (Exception e) {
            ExceptionUtil.throwBizException("token生成失败");
        }
        return responseVo;
    }

    @Override
    public ResponseVo<String> logout() {
        ResponseVo<String> responseVo = new ResponseVo<>();
        return responseVo;
    }

    @Override
    public ResponseVo<Merchant> info() {
        ResponseVo<Merchant> responseVo = new ResponseVo<>();
        responseVo.setData(baseMapper.selectOne(
                new QueryWrapper<Merchant>().lambda().eq(Merchant::getId, RequestUtil.getLoginUser().getString("id"))));
        return responseVo;
    }

}
