package com.lanou.springboot02.controller;

import com.lanou.springboot02.pojo.User;
import com.lanou.springboot02.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private IUserService iUserService;
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(User user, Model model){
        List<User>  u = iUserService.selectPassword(user.getUsername(), user.getPassword());
        if(u.get(0)!=null){
            return "redirect:/list";
        }else {
            model.addAttribute("message","账号或者密码错误！！！");
            return "login";
        }

    }


}
