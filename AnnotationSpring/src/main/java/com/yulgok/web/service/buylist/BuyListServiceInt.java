package com.yulgok.web.service.buylist;

import java.util.List;

import com.yulgok.web.service.cart.Cart;
import com.yulgok.web.service.signup.Signup;

public interface BuyListServiceInt {
	List<BuyList> allList(int seq);
	int buyCompleted(List<Signup> sign, List<Cart> cart);
	List<BuyList> recentList(String[] cartNumber);
}
