package com.tz.lu.controler;

import com.tz.lu.service.MailService;
import com.tz.lu.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@ResponseBody
public class UserController {

    @Autowired
    private MailService mailService;

    @PostMapping("/sendEmail")
    public String sendEmail(String email, HttpSession httpSession){
        mailService.sendMimeMail(email, httpSession);
        return "sucess";
    }

    @PostMapping("/regist")
    public String regist(UserVo userVo, HttpSession session){
        mailService.registered(userVo,session);
        return "sucess";
    }

    @PostMapping("/login")
    public String login(String email, String password){
        mailService.loginIn(email,password);
        return "sucess";
    }

    @GetMapping("/test")
    public String sendEmail(){
        return "sucess";
    }
}