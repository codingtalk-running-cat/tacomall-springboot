/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-15 11:42:32
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-common/src/main/java/cn/codingtalk/tacomallcommon/vo/ResponseVo.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallcommon.vo;

import lombok.Data;

import cn.codingtalk.tacomallcommon.enumeration.BizEnum;

@Data
public class ResponseVo<T> {

    private Boolean status = true;

    private Integer code = BizEnum.OK.getCode();

    private String message = BizEnum.OK.getMessage();

    private T data;

}
