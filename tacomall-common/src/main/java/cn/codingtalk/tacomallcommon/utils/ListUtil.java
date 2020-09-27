/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-23 11:13:52
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-common/src/main/java/cn/codingtalk/tacomallcommon/utils/ListUtil.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallcommon.utils;

import java.util.List;

public class ListUtil {
    public static <T> Boolean isEmpty(List<T> lst) {
        return lst.size() == 0;
    }
}
