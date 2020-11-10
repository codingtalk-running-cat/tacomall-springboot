/***
 * @Author: ,: 码上talk|RC
 * @Date: ,: 2020-10-19 16:12:03
 * @LastEditTime: 2020-11-06 08:22:23
 * @LastEditors: 码上talk|RC
 * @Description: ,: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/store/tacomall/apimerchant/service/impl/OrderServiceImpl.java
 * @微信: ,:  13680065830
 * @邮箱: ,:  3189482282@qq.com
 * @oops: ,: Just do what I think it is right
 */
package store.tacomall.apimerchant.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;

import store.tacomall.apimerchant.service.OrderService;
import store.tacomall.entity.order.Order;
import store.tacomall.mapper.order.OrderMapper;
import store.tacomall.common.vo.ResponseVo;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    /***
     * @description: 商户商品分页
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<List<Order>> getOrderPage(int pageIndex, int pageSize) {
        ResponseVo<List<Order>> responseVo = new ResponseVo<>();
        Page<Order> page = new Page<>(pageIndex, pageSize);
        IPage<Order> result = this.baseMapper.getOrderPage(page, null);
        responseVo.setData(result.getRecords());
        return responseVo;
    }

    /***
     * @description: 商户商品详情
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Order> info(int id) {
        ResponseVo<Order> responseVo = new ResponseVo<>();
        responseVo.setData(this.baseMapper.getOrder(null));
        return responseVo;
    }

}