/***
 * @Author: 码上talk|RC
 * @Date: 2021-01-20 15:01:44
 * @LastEditTime: 2021-01-20 15:03:12
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/admin/src/main/java/store/tacomall/apiadmin/service/impl/MemberServiceImpl.java
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
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import store.tacomall.apiadmin.service.MemberService;
import store.tacomall.common.entity.member.Member;
import store.tacomall.common.mapper.member.MemberMapper;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.vo.ResponsePageVo;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    /***
     * @description: 会员分页
     * @param {type}
     * @return:
     */
    @Override
    public ResponsePageVo<List<Member>> getMemberPage(int pageIndex, int pageSize, JSONObject json) {
        ResponsePageVo<List<Member>> responsePageVo = new ResponsePageVo<>();
        Page<Member> page = new Page<>(pageIndex, pageSize);
        LambdaQueryWrapper<Member> q = new QueryWrapper<Member>().lambda();
        if (ObjectUtil.isNotEmpty(json.getJSONObject("query"))
                && ObjectUtil.isNotEmpty(json.getJSONObject("query").get("keyword"))) {
            q.like(Member::getNickname, json.getJSONObject("query").get("keyword"));
        }
        IPage<Member> result = this.baseMapper.getMemberPage(page, q);
        responsePageVo.setData(result.getRecords());
        responsePageVo.buildPage(result.getCurrent(), result.getSize(), result.getTotal());
        return responsePageVo;
    }

    /***
     * @description: 会员详情
     * @param {type}
     * @return:
     */
    @Override
    public ResponseVo<Member> info(int id) {
        ResponseVo<Member> responseVo = new ResponseVo<>();
        responseVo.setData(this.baseMapper.getMember(new QueryWrapper<Member>().lambda().eq(Member::getId, id)));
        return responseVo;
    }

}