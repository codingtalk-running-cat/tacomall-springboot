/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-15 15:06:09
 * @LastEditTime: 2021-01-20 17:01:39
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/controller/MerchantController.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;
import com.alibaba.fastjson.JSONObject;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.vo.ResponsePageVo;
import store.tacomall.common.entity.merchant.Merchant;
import store.tacomall.apiadmin.service.MerchantService;

@Api(tags = "商户模块")
@RestController
@RequestMapping(value = "/admin/merchant/")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    /***
     * @description: 商户分页
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "商户分页", notes = "商户分页接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "pageIndex", value = "分页码数", required = true, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页数量", required = true, paramType = "query"),
            @ApiImplicitParam(name = "json", value = "查询条件", required = true, paramType = "body") })
    @PostMapping("page")
    public ResponsePageVo<List<Merchant>> goodsPage(@RequestParam(value = "pageIndex") int pageIndex,
            @RequestParam(value = "pageSize") int pageSize, @RequestBody JSONObject json) {
        return merchantService.getMerchantPage(pageIndex, pageSize, json);
    }

    /***
     * @description: 商户详情
     * @param {type
     * @return:
     */
    @ApiOperation(value = "商户详情", notes = "商户详情接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "商户ID", required = true, paramType = "query") })
    @PostMapping("info")
    public ResponseVo<Merchant> info(@RequestParam(value = "id") int id) {
        return merchantService.info(id);
    }

    /***
     * @description: 商户详情
     * @param {type
     * @return:
     */
    @ApiOperation(value = "商户添加", notes = "商户添加接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "商户ID", required = true, paramType = "query") })
    @PostMapping("add")
    public ResponseVo<Merchant> add(@RequestBody JSONObject json) {
        return merchantService.add(json);
    }
}
