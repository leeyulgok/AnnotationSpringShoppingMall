package com.yulgok.web.controller.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yulgok.web.service.login.LoginServiceInt;

@Controller
@RequestMapping("/")
public class LoginContoller {
	
	@Autowired
	private LoginServiceInt loginService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	

	@RequestMapping("loginService")
	public String login() throws IOException {
		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = response.getWriter();
		String site = "";

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		int result = loginService.login(id, password);
		
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			out.println("<script language='javascript'>");
			out.println("alert('Welcome!')");
			out.println("</script>");
			out.flush();
			site = "root.index";
		} else if(result == 2) {
			out.println("<script language='javascript'>");
			out.println("alert('Check Your Password')");
			out.println("</script>");
			out.flush();
			site = "login.login";
		} else if (result == 3) {
			out.println("<script language='javascript'>");
			out.println("alert('Check Your ID')");
			out.println("</script>");
			out.flush();
			site = "login.login";
		}
		
		return site;
	}
	
	@RequestMapping("logoutService")
	public String logout() throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "root.index";
	}
}
