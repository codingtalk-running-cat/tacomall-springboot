/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-15 15:06:09
 * @LastEditTime: 2021-01-20 15:11:12
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/controller/MemberController.java
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
import store.tacomall.common.entity.member.Member;
import store.tacomall.apiadmin.service.MemberService;

@Api(tags = "会员模块")
@RestController
@RequestMapping(value = "/admin/member/")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /***
     * @description: 会员分页
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "会员分页", notes = "会员分页接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "pageIndex", value = "分页码数", required = true, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页数量", required = true, paramType = "query"),
            @ApiImplicitParam(name = "json", value = "查询条件", required = true, paramType = "body") })
    @PostMapping("page")
    public ResponsePageVo<List<Member>> page(@RequestParam(value = "pageIndex") int pageIndex,
            @RequestParam(value = "pageSize") int pageSize, @RequestBody JSONObject json) {
        return memberService.getMemberPage(pageIndex, pageSize, json);
    }

    /***
     * @description: 会员详情
     * @param {type}
     * @return:
     */
    @ApiOperation(value = "会员详情", notes = "会员详情接口", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "商户ID", required = true, paramType = "query") })
    @PostMapping("info")
    public ResponseVo<Member> info(@RequestParam(value = "id") int id) {
        return memberService.info(id);
    }
}
