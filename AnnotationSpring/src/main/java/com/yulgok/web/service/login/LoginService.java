package com.yulgok.web.service.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginServiceInt{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public int login(String id, String password) {
		int result = 0;
		try {
			Connection con = dataSource.getConnection();
			String sql = String.format("SELECT PASSWORD FROM SIGNUP WHERE ID = '%s'", id);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				if(rs.getString(1).equals(password)) {
					System.out.println("로그인 성공");
					result = 1;
				} else {
					System.out.println("비밀번호가 틀립니다.");
					result = 2;
				}
			} else {
				System.out.println("아이디 확인");
				result = 3;
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
