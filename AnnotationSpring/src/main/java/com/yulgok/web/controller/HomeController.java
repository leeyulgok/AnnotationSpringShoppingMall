package com.yulgok.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController{
	
	@RequestMapping("index")
	public String index() {
		return "root.index";
	}
	
	@RequestMapping("register")
	public String regist() {
		return "product.register";
	}
	
	@RequestMapping("login")
	public String login() {
		return "login.login";
	}
	
	@RequestMapping("signup")
	public String signup() {
		return "signup.signup";
	}
	
	@RequestMapping("/jusoPopup")
	public String jusoPopup() {
		return "signup/jusoPopup";
	}
}
