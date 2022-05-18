package com.yulgok.web.service.product;

import java.util.List;

public interface ProductServiceInt {
	int register(String pNumber, String pName, String type, int price, String size, String content,
			int sale, String filePath, String fileName);
	List<Product> list();
	List<Product> list(String type);
	List<Product> list(String type, String pNumber);
	List<Product> detail(String pNumber);
	void hit(String pNumber);
	int delete(String pNumber);
	int update(String pNumber, String pName, int price, String content, int sale);
	int updateFile(String pNumber, String pName, int price, String content, int sale, String filePath, String fileName);
	List<Product> search(String searchType, String search);
	List<Product> hitList();
	List<Product> recentList();
	List<Product> popularList();
}
