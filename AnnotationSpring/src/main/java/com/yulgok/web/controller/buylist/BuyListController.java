package com.yulgok.web.controller.buylist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yulgok.web.service.buylist.BuyList;
import com.yulgok.web.service.buylist.BuyListServiceInt;
import com.yulgok.web.service.cart.Cart;
import com.yulgok.web.service.cart.CartServiceInt;
import com.yulgok.web.service.signup.Signup;
import com.yulgok.web.service.signup.SignupServiceInt;

@Controller
@RequestMapping("/")
public class BuyListController {
	
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private BuyListServiceInt buyListService;
	@Autowired
	private CartServiceInt cartService;
	@Autowired
	private SignupServiceInt signupService;
	
	@RequestMapping("buyCompleted")
	public String buyCompleted(HttpServletRequest request) throws IOException {
		response.setContentType("text/html; charset=UTF-8;");
		request.setCharacterEncoding("UTF-8");
		String site = "";
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		String[] cartNumber = new String[0];
		if(request.getParameterValues("cartNumber") != null) {
			int inx = 0;
			for(int i = 0; i < request.getParameterValues("cartNumber").length; i++) {
				inx += i;
			}
			cartNumber = new String[inx];
			for(int i = 0; i < request.getParameterValues("cartNumber").length; i++) {
				cartNumber = request.getParameterValues("cartNumber");
			}
		}
		
		List<Cart> cart = cartService.listCart(cartNumber); 
		List<Signup> sign = signupService.list(id);
		
		int result = buyListService.buyCompleted(sign, cart);
		
		if(result == 0) {
			out.println("<script language='javascript'>");
			out.println("alert('Sorry Check My Server...')");
			out.println("</script>");
			out.flush();
			site = "cart.purchase";
		} else {
			List<BuyList> list = buyListService.recentList(cartNumber);
			request.setAttribute("list", list);
			request.setAttribute("sign", sign);
			out.println("<script language='javascript'>");
			out.println("alert('Success Buy it!!')");
			out.println("</script>");
			out.flush();
			site = "cart.successbuy";
		}
		
		return site;
	}
}
