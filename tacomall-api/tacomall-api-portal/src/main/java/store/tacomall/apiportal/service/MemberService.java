/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-29 09:22:53
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/service/MemberService.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.service;

import com.baomidou.mybatisplus.extension.service.IService;

import store.tacomall.common.vo.ResponseVo;
import store.tacomall.entity.member.Member;

public interface MemberService extends IService<Member> {

    /***
     * @description: 微信小程序登录
     * @param {type}
     * @return:
     */
    ResponseVo<String> wxMaLogin(String iv, String code, String appid, String rawData, String signature,
            String encryptedData) throws Exception;

    /***
     * @description: 用户信息
     * @param {type}
     * @return:
     */
    ResponseVo<Member> info();

}
