package com.yulgok.web.service.signup;

import java.util.List;

public interface SignupServiceInt {
	int regist(String name, String id, String password, String passwordCheck, String address, String phone, String email);
	List<Signup> list(String id);
	int CheckPassword(String id, String password);
	int updateInformation(String id, String address, String phone, String email);
}
