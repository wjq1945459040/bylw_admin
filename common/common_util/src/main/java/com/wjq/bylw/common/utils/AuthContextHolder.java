package com.wjq.bylw.common.utils;

import com.wjq.bylw.common.helper.JwtHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wjq
 * @date 2022/02/28
 **/

public class AuthContextHolder {

    //获取当前用户id
    public static Long getUserId(HttpServletRequest request) {
        //从header获取token
        String token = request.getHeader("token");
        //jwt从token获取userid

        return JwtHelper.getUserId(token);
    }

    //获取当前用户名称
    public static String getUserName(HttpServletRequest request) {
        //从header获取token
        String token = request.getHeader("token");
        //jwt从token获取username

        return JwtHelper.getUserName(token);
    }
}
