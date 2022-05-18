package com.yulgok.web.controller.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yulgok.web.service.buylist.BuyList;
import com.yulgok.web.service.buylist.BuyListServiceInt;
import com.yulgok.web.service.cart.CartServiceInt;
import com.yulgok.web.service.signup.Signup;
import com.yulgok.web.service.signup.SignupServiceInt;

@Controller
@RequestMapping("/")
public class MypageController {
	
	@Autowired
	private SignupServiceInt signupService;
	@Autowired
	private BuyListServiceInt buyListService;
	@Autowired
	private CartServiceInt cartService;
	@Autowired
	private HttpServletResponse response;
	
	@RequestMapping("checkMypage")
	public String mypageCheck(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		return "mypage.check";
	}
	
	@RequestMapping("mypage")
	public String mypage(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		String site = "";
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String id = (String) session.getAttribute("id");
		int seq = cartService.seq(id);
		String password = request.getParameter("password");
		
		int result = signupService.CheckPassword(id, password);
		
		if(result != 1) {
			out.println("<script language='javascript'>");
			out.println("alert('Check Your password')");
			out.println("</script>");
			out.flush();
			site="product.list";
		} else {
			List<Signup> sign = signupService.list(id);
			List<BuyList> buy = buyListService.allList(seq);
			request.setAttribute("sign", sign);
			request.setAttribute("buy", buy);
			site = "mypage.mypage";
		}
		
		return site;
	}
	@RequestMapping("updateInformation")
	public String updateInformation(HttpServletRequest request) throws UnsupportedEncodingException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		String id = (String) session.getAttribute("id");
		List<Signup> list = signupService.list(id);
		request.setAttribute("list", list);
		
		return "mypage.updateInformation";
	}
	
	@RequestMapping("updateInformationService")
	public String updateInformationService(HttpServletRequest request) throws IOException {
		String site = "";
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		String id = (String) session.getAttribute("id");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		int result = signupService.updateInformation(id, address, phone, email);
		
		if(result == 1) {
			out.println("<script language='javascript'>");
			out.println("alert('Update Success Your Information')");
			out.println("</script>");
			out.flush();
			site = "mypage.mypage";
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('Failed')");
			out.println("</script>");
			out.flush();
			site = "mypage.updateInformation";
		}
		
		return site;
	}
}
