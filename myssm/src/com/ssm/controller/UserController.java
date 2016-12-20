package com.ssm.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.po.User;
import com.ssm.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/login")
	public ModelAndView login(User user) throws IOException{
		User user2=userService.loginByUser(user);
		ModelAndView mv=new ModelAndView();
		if(user2!=null){
		System.out.println("登录成功!");
		mv.addObject("userinfo", user2);
		mv.setViewName("welcome");
		}else{
			mv.setViewName("login");
		}
		return mv;
		
	}
	
	
	
}
