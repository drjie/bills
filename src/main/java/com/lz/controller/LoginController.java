package com.lz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {

    /**
     * 跳转到登陆页面
     */
    @RequestMapping("toLogin")
    public String toLogin() {

        System.out.println("dfzsdsx");
        return "login";
    }
}