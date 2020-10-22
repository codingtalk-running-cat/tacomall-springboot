/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-15 11:42:32
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-common/src/main/java/store/tacomall/common/vo/ResponseVo.java
 * @Just do what I think it is right
 */
package store.tacomall.common.vo;

import lombok.Data;

import store.tacomall.common.enumeration.BizEnum;

@Data
public class ResponseVo<T> {

    private Boolean status = true;

    private Integer code = BizEnum.OK.getCode();

    private String message = BizEnum.OK.getMessage();

    private T data;

}
