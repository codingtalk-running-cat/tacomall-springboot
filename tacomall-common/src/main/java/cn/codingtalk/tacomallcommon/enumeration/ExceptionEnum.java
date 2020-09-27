/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-16 16:33:07
 * @LastEditTime: 2020-07-13 11:23:04
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-common/src/main/java/cn/codingtalk/tacomallcommon/enumeration/ExceptionEnum.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallcommon.enumeration;

public enum ExceptionEnum {

    SERVER_ERROR(4000, "服务器发送未知错误"), SQL_ERROR(4200, "SQL错误");

    private int code;
    private String message;

    private ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessage(int code) {
        for (ExceptionEnum c : ExceptionEnum.values()) {
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