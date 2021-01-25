/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-10 16:00:50
 * @LastEditTime: 2020-11-10 16:19:47
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-common/src/main/java/store/tacomall/common/vo/ResponsePageVo.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.common.vo;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

import store.tacomall.common.enumeration.BizEnum;

@Data
public class ResponsePageVo<T> {

    private Boolean status = true;

    private Integer code = BizEnum.OK.getCode();

    private String message = BizEnum.OK.getMessage();

    private T data;

    private Map<String, Object> page = new HashMap<>();

    public void buildPage(long pageIndex, long pageSize, long total) {
        page.put("pageIndex", pageIndex);
        page.put("pageSize", pageSize);
        page.put("total", total);
    }

}
