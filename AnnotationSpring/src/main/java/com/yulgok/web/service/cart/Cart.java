package com.yulgok.web.service.cart;

public class Cart {
	// 카드번호 추가해서 삭제 중복피하기.
	private String cartNumber;
	private int seq;
	private String imagePath;
	private String imageName;
	private String pNumber;
	private String pName;
	private int price;
	private int count;
	
	public Cart() {
		
	}

	public Cart(String cartNumber, int seq, String imagePath, String imageName, String pNumber, String pName, int price, int count) {
		this.cartNumber = cartNumber;
		this.seq = seq;
		this.imagePath = imagePath;
		this.imageName = imageName;
		this.pNumber = pNumber;
		this.pName = pName;
		this.price = price;
		this.count = count;
	}


	public String getCartNumber() {
		return cartNumber;
	}

	public void setCartNumber(String cartNumber) {
		this.cartNumber = cartNumber;
	}


	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getpNumber() {
		return pNumber;
	}

	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
}
