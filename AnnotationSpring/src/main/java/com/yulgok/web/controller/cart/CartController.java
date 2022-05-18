package com.yulgok.web.controller.cart;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yulgok.web.service.cart.Cart;
import com.yulgok.web.service.cart.CartServiceInt;
import com.yulgok.web.service.signup.Signup;
import com.yulgok.web.service.signup.SignupServiceInt;

@Controller
@RequestMapping("/")
public class CartController {
	
	@Autowired
	private CartServiceInt service;
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private SignupServiceInt signupService;
	
	@RequestMapping("cart")
 	public String cart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		int seq = service.seq(id);
		
		List<Cart> list = service.listCart(seq);
		request.setAttribute("cart", list);
				
		return "cart.cart";
	}
	
	@RequestMapping("addCart")
	public String addCart(HttpServletRequest request) throws IOException {
//		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8;");
		request.setCharacterEncoding("UTF-8");
		Random rand = new Random();
		int randNumber = 1 + rand.nextInt(9999);
		System.out.println(randNumber);
		if(randNumber < 10) {
			String.format("000%d", randNumber);
		} else if(randNumber > 9 && randNumber < 100) {
			String.format("00%d", randNumber);
		} else if(randNumber > 99 && randNumber < 1000) {
			String.format("0%d", randNumber);
		} else {
			String.format("%d", randNumber);
		}
		String site = "";
		String imagePath = request.getParameter("imagePath");
		String imageName = request.getParameter("imageName");
		String pNumber = request.getParameter("pNumber");
		String pName = request.getParameter("pName");
		int price = Integer.parseInt(request.getParameter("price"));
		int count = Integer.parseInt(request.getParameter("count"));
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		int seq = service.seq(id);
		String cartNumber = "C" + seq + randNumber;
		System.out.println(cartNumber);
		
		int result = service.addCart(cartNumber, seq, imagePath, imageName, pNumber, pName, price, count);
		
		if(result == 1) {
			site = "cart.cart";
		} else {
			site = "product.list";
		}
		
		return site;
	}
	
	@RequestMapping("deleteCart")
	public String deleteCart(HttpServletRequest request) {
		String site = "";
		String cartNumber = request.getParameter("cartNumber");
		
		int result = service.deleteCart(cartNumber);
		
		if(result == 1) {
			site = "cart.cart";
		} else {
			site = "cart.cart";
		}
		return site;
	}
	
	@RequestMapping("deleteCartAll")
	public String deleteCartAll(HttpServletRequest request) {
		String site = "";
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		int seq = service.seq(id);
		int result = service.deleteCartAll(seq);
		
		if(result == 1) {
			site = "cart.cart";
		} else {
			site = "cart.cart";
		}
		return site;
	}

	@RequestMapping("purchase")
	public String purchase(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String[] cartNumber = new String[0];
		
		if(request.getParameterValues("purchaseChoice") != null) {
			int inx = 0;
			for(int i = 0; i < request.getParameterValues("purchaseChoice").length; i++) {
				inx += i;
			}
			cartNumber = new String[inx];
			for(int i = 0; i < request.getParameterValues("purchaseChoice").length; i++) {
				cartNumber = request.getParameterValues("purchaseChoice");
			}
		}
		
		
		List<Signup> sign = signupService.list(id);
		List<Cart> cart = service.listCart(cartNumber);
		
		request.setAttribute("sign", sign);
		request.setAttribute("cart", cart);
		
		return "cart.purchase";
	}
}
