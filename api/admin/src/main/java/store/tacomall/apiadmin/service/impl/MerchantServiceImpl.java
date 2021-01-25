/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-18 14:15:03
 * @LastEditTime: 2021-01-22 11:17:53
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/service/impl/MerchantServiceImpl.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiadmin.service.impl;

import java.util.List;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import store.tacomall.apiadmin.service.MerchantService;
import store.tacomall.common.entity.merchant.Merchant;
import store.tacomall.common.entity.merchant.MerchantUser;
import store.tacomall.common.mapper.merchant.MerchantMapper;
import store.tacomall.common.mapper.merchant.MerchantUserMapper;
import store.tacomall.common.util.ExceptionUtil;
import store.tacomall.common.util.PasswordUtil;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.vo.ResponsePageVo;

@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant> implements MerchantService {

    @Autowired
    MerchantUserMapper merchantUserMapper;

    @Autowired
    TransactionDefinition transactionDefinition;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

    /***
     * @description: 平台商品分页
     * @param {type}
     * @return:
     */
    @Override
    public ResponsePageVo<List<Merchant>> getMerchantPage(int pageIndex, int pageSize, JSONObject json) {
        ResponsePageVo<List<Merchant>> responsePageVo = new ResponsePageVo<>();
        Page<Merchant> page = new Page<>(pageIndex, pageSize);
        LambdaQueryWrapper<Merchant> q = new QueryWrapper<Merchant>().lambda();
        if (ObjectUtil.isNotEmpty(json.getJSONObject("query"))
                && ObjectUtil.isNotEmpty(json.getJSONObject("query").get("keyword"))) {
            q.like(Merchant::getName, json.getJSONObject("query").get("keyword"));
        }
        IPage<Merchant> result = this.baseMapper.getMerchantPage(page, q);
        responsePageVo.setData(result.getRecords());
        responsePageVo.buildPage(result.getCurrent(), result.getSize(), result.getTotal());
        return responsePageVo;
    }

    /***
     * @description: 平台商品详情
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Merchant> info(int id) {
        ResponseVo<Merchant> responseVo = new ResponseVo<>();
        responseVo.setData(this.baseMapper.getMerchant(new QueryWrapper<Merchant>().lambda().eq(Merchant::getId, id)));
        return responseVo;
    }

    /***
     * @description: 商户商品添加
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Merchant> add(JSONObject json) {
        ResponseVo<Merchant> responseVo = new ResponseVo<>();
        responseVo.setStatus(false);
        Merchant merchant = JSON.toJavaObject(json, Merchant.class);

        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            this.baseMapper.insert(merchant);
            merchant.getMerchantUsers().stream().forEach((MerchantUser merchantUser) -> {
                merchantUser.setMerchantId(merchant.getId());
                merchantUser.setPasswd(PasswordUtil.encode(merchantUser.getPasswd()));
                merchantUserMapper.insert(merchantUser);
            });
            dataSourceTransactionManager.commit(transactionStatus);
            responseVo.setStatus(true);
            responseVo.setData(merchant);
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transactionStatus);
            ExceptionUtil.throwSqlException(e.toString());
        }

        this.baseMapper.insert(merchant);
        responseVo.setStatus(true);
        responseVo.setData(merchant);
        return responseVo;
    }

}