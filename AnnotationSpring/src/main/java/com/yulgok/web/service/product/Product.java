package com.yulgok.web.service.product;

public class Product {
	private String pNumber; //제품번호
	private String pName; //제품이름 
	private String type; // 제품종류 맨투맨, 신발 ... 
	private int price; // 가격
	private String size; // 사이즈 s m l
	private String content; // 설명
	private int sale; // 세일여부 
	private	String filePath; // 파일 위치
	private	String fileName; // 파일 이름
	private int hit; // 조회수
	private String regdate; // 게시일
	private int totalSale; // 판매 수
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String pNumber, String pName, String type, int price, String size, String content, int sale,
			String filePath, String fileName, int hit, String regdate, int totalSale) {
		this.pNumber = pNumber;
		this.pName = pName;
		this.type = type;
		this.price = price;
		this.size = size;
		this.content = content;
		this.sale = sale;
		this.filePath = filePath;
		this.fileName = fileName;
		this.hit = hit;
		this.regdate = regdate;
		this.totalSale = totalSale;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(int totalSale) {
		this.totalSale = totalSale;
	}

	@Override
	public String toString() {
		return "Product [pNumber=" + pNumber + ", pName=" + pName + ", type=" + type + ", price=" + price + ", size="
				+ size + ", content=" + content + ", sale=" + sale + ", filePath=" + filePath + ", fileName=" + fileName
				+ ", hit=" + hit + ", regdate=" + regdate + ", totalSale=" + totalSale + "]";
	}
		
}
