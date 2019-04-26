package com.mmall.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class CookieUtil {

    //X:domain=".happymmall.com"
    //a:A.happymmall.com            cookie:domain=A.happymmall.com;path="/"
    //b:B.happymmall.com            cookie:domain=B.happymmall.com;path="/"
    //c:A.happymmall.com/test/cc    cookie:domain=A.happymmall.com;path="/test/cc"
    //d:A.happymmall.com/test/dd    cookie:domain=A.happymmall.com;path="/test/dd"
    //e:A.happymmall.com/test       cookie:domain=A.happymmall.com;path="/test"

    private final static String COOKIE_DOMAIN = "happymmalltest.com";
    private final static String COOKIE_NAME = "mmall_login_token";

    public static void writeLoginToken(HttpServletResponse response,String token){
        Cookie ck = new Cookie(COOKIE_NAME,token);  // mmall_login_token : sessionId
        ck.setDomain(COOKIE_DOMAIN);  //Domain : happymmalltest.com
        ck.setPath("/");//代表设置在根目录  //Path : /
        ck.setHttpOnly(true);
        //单位是秒。
        //如果这个maxage不设置的话，cookie就不会写入硬盘，而是写在内存。只在当前页面有效。
        ck.setMaxAge(60 * 60 * 24 * 365);//如果是-1，代表永久
        log.info("write cookieName:{},cookieValue:{}",ck.getName(),ck.getValue());
        response.addCookie(ck);
    }


    public static String readLoginToken(HttpServletRequest request){
        Cookie [] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cks : cookies){
                log.info("read cookieName:{},cookieValue:{}",cks.getName(),cks.getValue());
                if(StringUtils.equals(cks.getName(),COOKIE_NAME)){
                    log.info("return cookieName:{},cookieValue:{}",cks.getName(),cks.getValue());
                    return cks.getValue();  //返回SessionId
                }
            }
        }
        return null;
    }

    public static void delLoginToken(HttpServletRequest request,HttpServletResponse response){
        Cookie [] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie ck : cookies){
                if(StringUtils.equals(ck.getName(),COOKIE_NAME)){
                    ck.setDomain(COOKIE_DOMAIN);
                    ck.setPath("/");
                    ck.setMaxAge(0); //设置成功 代表删除此cookie
                    log.info("del cookieName:{},cookieValue:{}",ck.getName(),ck.getValue());
                    response.addCookie(ck);
                    return;
                }
            }
        }

    }
}
