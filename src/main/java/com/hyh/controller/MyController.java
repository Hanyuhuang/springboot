package com.hyh.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	//@ResponseBody
	@RequestMapping("/hello")
	//@Scheduled(cron="0/3 * * * * *")
	public String hello() {
		//return "Hello World!";
		System.out.println("Hello World!");
		return null;
	}
	
	@RequestMapping("/login")
	public String login(String username,String password,Map<String,Object> map,HttpSession session) {
		if("admin".equals(username)&&"123456".equals(password)) {
			session.setAttribute("User", username);
			return "redirect:/main";
		}else {
			map.put("msg", "用户名或密码错误");
			return "login";
		}		
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	@RequestMapping("/language")
	public String language() {
		return "login";
	}
}
