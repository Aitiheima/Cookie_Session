package com.itheima.web.Cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //发送Cookie
//        //1. 创建Cookie对象
//        Cookie cookie = new Cookie("username","zs");
//        //设置存活时间   ，1周 7天
//        cookie.setMaxAge(60*60*24*7); //易阅读，需程序计算
//        //cookie.setMaxAge(604800); //不易阅读(可以使用注解弥补)，程序少进行一次计算
//        //2. 发送Cookie，response
//        resp.addCookie(cookie);

        //发送Cookie
        String value = "张三";
        //对中文进行URL编码
        value = URLEncoder.encode(value, "UTF-8");
        System.out.println("存储数据："+value);
        //将编码后的值存入Cookie中
        Cookie cookie = new Cookie("username",value);
        //设置存活时间   ，1周 7天
        cookie.setMaxAge(60*60*24*7);
        //2. 发送Cookie，response
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
