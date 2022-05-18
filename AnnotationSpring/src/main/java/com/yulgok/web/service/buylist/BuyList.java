package com.yulgok.web.service.buylist;

public class BuyList {
	
	private int buyNumber;
	private String cartNumber;
	private int seq;
	private String id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String pNumber;
	private String pName;
	private String imagePath;
	private String imageName;
	private int price;
	private String buyDate;
	
	public BuyList() {
		
	}
	

	public BuyList(int buyNumber, String cartNumber, int seq, String id, String name, String address, String phone, String email, String pNumber, String pName, String imagePath, String imageName, int price, String buyDate) {
		this.buyNumber = buyNumber;
		this.cartNumber = cartNumber;
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.pNumber = pNumber;
		this.pName = pName;
		this.imagePath = imagePath;
		this.imageName = imageName;
		this.price = price;
		this.buyDate = buyDate;
	}


	public int getBuyNumber() {
		return buyNumber;
	}


	public void setBuyNumber(int buyNumber) {
		this.buyNumber = buyNumber;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	
	
}
