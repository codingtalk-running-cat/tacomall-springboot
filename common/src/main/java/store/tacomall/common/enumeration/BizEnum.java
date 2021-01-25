/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-16 16:32:58
 * @LastEditTime: 2020-12-23 16:21:59
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/enumeration/BizEnum.java
 * @Just do what I think it is right
 */
package store.tacomall.common.enumeration;

public enum BizEnum {
    OK(2000, "正确响应"), FALSE(2001, "服务异常"), USER_NOT_EXIST(2100, "用户不存在"), USER_NOT_LOGGED_IN(2101, "用户未登陆"),
    PAGE_NOT_EXSIT(2200, "页面不存在"), ORDER_FROM_TYPE_NOT_EXSIT(2300, "订单来源方式不存在"), GOODS_ITEM_STOCK_NONE(2400, "商品库存不足");

    private int code;
    private String message;

    private BizEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessage(int code) {
        for (BizEnum c : BizEnum.values()) {
            if (c.getCode() == code) {
                return c.message;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
