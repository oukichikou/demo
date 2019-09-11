package com.ima.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.ima.utils.JavaWebToken.verifyJavaWebToken;

/**
 * Created by 符柱成 on 17-3-12.
 */
public class AuthUtil {
    private static Map<String, Object> getClientLoginInfo(HttpServletRequest request) throws Exception {
        Map<String, Object> r = new HashMap<String, Object>();
        String sessionId = request.getHeader("sessionId");
        if (sessionId != null) {
            r = decodeSession(sessionId);
            return r;
        }
        throw new Exception("session解析错误");
    }

    public static Long getUserId(HttpServletRequest request) throws Exception {
        return  Long.valueOf((Integer)getClientLoginInfo(request).get("userId"));

    }

    /**
     * session解密
     */
    public static Map<String, Object> decodeSession(String sessionId) {
        try {
            return verifyJavaWebToken(sessionId);
        } catch (Exception e) {
            System.err.println("");
            return null;
        }
    }
}
