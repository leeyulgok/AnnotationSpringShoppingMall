package com.yulgok.web.service.cart;

import java.util.List;

public interface CartServiceInt {
	int addCart(String cartNumber,int seq, String imagePath, String imageName, String pNumber, String pName, int price, int count);
	int seq(String id);
	List<Cart> listCart(int seq);
	List<Cart> listCart(String[] cartNumber);
	int deleteCart(String cartNumber);
	int deleteCartAll(int seq);
}