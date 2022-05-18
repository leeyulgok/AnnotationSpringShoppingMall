package com.yulgok.web.service.signup;

public class Signup {
	

	private int seq;
	private String name;
	private String id;
	private String password;
	private String passwordCheck;
	private String address;
	private String phone;
	private String email;
	
	public Signup() {
		// TODO Auto-generated constructor stub
	}

	public Signup(int seq, String name, String id, String password, String passwordCheck, String address, String phone, String email) {
		this.seq = seq;
		this.name = name;
		this.id = id;
		this.password = password;
		this.passwordCheck = passwordCheck;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
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
	
	@Override
	public String toString() {
		return "Signup [seq=" + seq + ", name=" + name + ", id=" + id + ", password=" + password + ", passwordCheck="
				+ passwordCheck + ", address=" + address + ", phone=" + phone + ", email=" + email + "]";
	}
}
