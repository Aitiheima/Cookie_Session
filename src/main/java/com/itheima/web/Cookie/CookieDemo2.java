package com.itheima.web.Cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/CookieDemo2")
public class CookieDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //获取Cookie
//        //1. 获取Cookie数组
//        Cookie[] cookies = req.getCookies();
//        //2. 遍历数组
//        for (Cookie cookie : cookies) {
//            //3. 获取数据
//            String name = cookie.getName();
//            if("username".equals(name)){
//                String value = cookie.getValue();
//                System.out.println(name+":"+value);
//                break;
//            }
//        }

        //获取Cookie
        //1. 获取Cookie数组
        Cookie[] cookies = req.getCookies();
        //2. 遍历数组
        for (Cookie cookie : cookies) {
            //3. 获取数据
            String name = cookie.getName();
            if("username".equals(name)){
                String value = cookie.getValue();//获取的是URL编码后的值 %E5%BC%A0%E4%B8%89
                //URL解码
                value = URLDecoder.decode(value,"UTF-8");
                System.out.println(name+":"+value);//value解码后为 张三
                break;
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
