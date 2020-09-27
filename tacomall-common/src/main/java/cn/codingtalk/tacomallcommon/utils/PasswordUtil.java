package cn.codingtalk.tacomallcommon.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtil {

    public static String encode(String passwprd) {
        return DigestUtils.sha256Hex(passwprd);
    }
}
