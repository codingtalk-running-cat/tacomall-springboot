/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-20 15:01:29
 * @LastEditTime: 2021-01-20 15:02:28
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/service/MemberService.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiadmin.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.alibaba.fastjson.JSONObject;

import store.tacomall.common.entity.member.Member;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.vo.ResponsePageVo;

public interface MemberService extends IService<Member> {

    /***
     * @description: 会员分页
     * @param {type}
     * @return:
     */
    ResponsePageVo<List<Member>> getMemberPage(int pageIndex, int pageSize, JSONObject json);

    /***
     * @description: 会员详情
     * @param {type}
     * @return:
     */
    ResponseVo<Member> info(int id);

}
