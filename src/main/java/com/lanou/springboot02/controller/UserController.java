package com.lanou.springboot02.controller;

import com.lanou.springboot02.pojo.User;
import com.lanou.springboot02.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;
    @RequestMapping("/list")
    public String list(Model model){
        List<User> userList = iUserService.selectAll();
        model.addAttribute("uList",userList);
        return "list";
    }
    @RequestMapping("/toadd")
    public String toAdd(){
        return "add";
    }
    @RequestMapping("/add")
    public String add(User user){
        iUserService.insert(user);
        return "redirect:list";
    }
    @RequestMapping("/updateShow")
    public String toUpdate(Integer id,Model model){
        User user = iUserService.selectOne(id);
        model.addAttribute("u",user);
        return "update";
    }
    @RequestMapping("/update")
    public String update(User user){
        iUserService.update(user);
        return "redirect:list";
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        iUserService.delete(id);
        return "redirect:list";
    }
}
