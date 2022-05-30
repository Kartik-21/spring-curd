package com.kartik.curd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

    //ModelMap -> view data in jsp file

    @RequestMapping("login")
    public String login(){
        return "login";
    }
}
