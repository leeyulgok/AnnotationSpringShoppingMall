package com.yulgok.web.controller.signup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yulgok.web.service.signup.SignupServiceInt;

@Controller
@RequestMapping("/")
public class SignupController {
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private SignupServiceInt SignupService;
	
	@RequestMapping("signupService")
	public String signupService() throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8;");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String passwordCheck = request.getParameter("passwordCheck");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		int result = SignupService.regist(name, id, password, passwordCheck, address, phone, email);
		String site = "";
		if(result == 1) {
			out.println("<script language='javascript'>");
			out.println("alert('Thaks Sign Up!')");
			out.println("</script>");
			out.flush();			
			site="root.index";
		} else if(result == 2) {
			out.println("<script language='javascript'>");
			out.println("alert('Check Your Password!')");
			out.println("</script>");
			out.flush();
			site="signup.signup";
		} else if(result == 3) {
			out.println("<script language='javascript'>");
			out.println("alert('Input Your Password!')");
			out.println("</script>");
			out.flush();
			site="signup.signup";
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('Failed Sign Up!!')");
			out.println("</script>");
			out.flush();
			site="signup.signup";
		}
		return site;
	}
}
