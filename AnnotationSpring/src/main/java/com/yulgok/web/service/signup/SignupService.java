package com.yulgok.web.service.signup;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService implements SignupServiceInt{
	
	@Autowired
	private DataSource dataSource;

	@Override
	public int regist(String name, String id, String password, String passwordCheck, String address, String phone, String email) {
		int result = 0;
		if(!password.equals(passwordCheck)) {
			System.out.println("비밀번호를 확인해주세요.");
			result = 2;
		} 
		if(password.length() == 0 && passwordCheck.length() == 0){
			System.out.println("비밀번호를 입력해주세요.");
			result = 3;
		} else {
			try {
				String sql = String.format("INSERT INTO SIGNUP (NAME, ID, PASSWORD, PASSWORDCHECK, ADDRESS, PHONE, EMAIL) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')", name, id, password, passwordCheck, address, phone, email);
				Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				result = st.executeUpdate(sql);
				
				if(result == 1) {
					System.out.println("회원가입에 성공했습니다.");
				} else {
					System.out.println("회원가입에 실패했습니다.");
				}
				
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public List<Signup> list(String id) {
		List<Signup> list = new ArrayList<Signup>();
		try {
			Connection con = dataSource.getConnection();
			String sql = String.format("SELECT * FROM SIGNUP WHERE ID = '%s'", id);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int seq = rs.getInt("SEQ");
				String name = rs.getString("NAME");
				id = rs.getString("ID");
				String password = rs.getString("PASSWORD");
				String passwordCheck = rs.getString("PASSWORDCHECK");
				String address = rs.getString("ADDRESS");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				
				Signup signup = new Signup(seq, name, id, password, passwordCheck, address, phone, email);
				
				list.add(signup);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int CheckPassword(String id, String password) {
		int result = 0;
		try {
			Connection con = dataSource.getConnection();
			String sql = String.format("SELECT PASSWORD FROM SIGNUP WHERE ID = '%s'", id);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				if(rs.getString(1).equals(password)) {
					result = 1;
				} else {
					System.out.println("비밀번호가 틀립니다.");
					result = 2;
				}
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateInformation(String id, String address, String phone, String email) {
		int result = 0;
		try {
			Connection con = dataSource.getConnection();
			String sql = String.format("UPDATE SIGNUP SET ADDRESS = '%s', PHONE = '%s', EMAIL = '%s' WHERE ID = '%s'", address, phone, email, id);
			
			Statement st = con.createStatement();
			
			result = st.executeUpdate(sql);
			
			if(result == 1) {
				System.out.println("개인정보를 업데이트했습니다.");
			} else {
				System.out.println("개인정보 업데이트에 실패했습니다.");
			}
			
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
}
