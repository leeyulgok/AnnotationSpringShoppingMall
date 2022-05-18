package com.yulgok.web.service.cart;

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
public class CartService implements CartServiceInt{
	
	@Autowired
	private DataSource dataSource;

	@Override
	public int addCart(String cartNumber, int seq, String imagePath, String imageName, String pNumber, String pName, int price, int count) {
		int result = 0;
		try {
			Connection con = dataSource.getConnection();
			String sql = String.format("INSERT INTO CART VALUES ('%s', %d, '%s', '%s', '%s', '%s', %d, %d)", cartNumber, seq, imagePath, imageName, pNumber, pName, price, count);
			Statement st = con.createStatement();
			result = st.executeUpdate(sql);
			
			if(result == 1) {
				System.out.println("장바구니에 담겼습니다.");
			} else {
				System.out.println("실패!");
			}
			
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int seq(String id) {
		int seq = 0;
		try {
			Connection con = dataSource.getConnection();
			String sql = String.format("SELECT SEQ FROM SIGNUP WHERE ID = '%s'", id);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				seq = rs.getInt("SEQ");
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seq;
	}

	@Override
	public List<Cart> listCart(int seq) {
		List<Cart> list = new ArrayList<Cart>();
		try {
			Connection con = dataSource.getConnection();
			String sql = String.format("SELECT * FROM CART WHERE SEQ = %d", seq);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String cartNumber = rs.getString("CART_NUMBER");
				seq = rs.getInt("seq");
				String imagePath = rs.getString("IMAGEPATH");
				String imageName = rs.getString("IMAGENAME");
				String pNumber = rs.getString("P_NUMBER");
				String pName = rs.getString("P_NAME");
				int price = rs.getInt("PRICE");
				int count = rs.getInt("COUNT");
				
				Cart cart = new Cart(cartNumber,seq, imagePath, imageName, pNumber, pName, price, count);
				
				list.add(cart);
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
	public int deleteCart(String cartNumber) {
		int result = 0;
		try {
			Connection con = dataSource.getConnection();
			String sql = String.format("DELETE FROM CART WHERE CART_NUMBER = '%s'", cartNumber);
			Statement st = con.createStatement();
			result = st.executeUpdate(sql);
			
			if(result == 1) {
				System.out.println("카트에서 제품을 삭제했습니다.");
			} else {
				System.out.println("카트에서 제품 삭제에 실패했습니다.");
			}
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteCartAll(int seq) {
		int result = 0;
		try {
			Connection con = dataSource.getConnection();
			String sql = String.format("DELETE FROM CART WHERE SEQ = %d", seq);
			Statement st = con.createStatement();
			result = st.executeUpdate(sql);
			
			if(result >= 1) {
				System.out.println("카트에서 모든제품을 삭제했습니다.");
			} else {
				System.out.println("카트에서 모든제품 삭제에 실패했습니다.");
			}
			
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Cart> listCart(String[] cartNumber) {
		List<Cart> list = new ArrayList<Cart>();
		try {
			Connection con = dataSource.getConnection();
			for(int i = 0; i < cartNumber.length; i++) {				
				String sql = String.format("SELECT * FROM CART WHERE CART_NUMBER = '%s'", cartNumber[i]);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					cartNumber[i] = rs.getString("CART_NUMBER");
					int seq = rs.getInt("seq");
					String imagePath = rs.getString("IMAGEPATH");
					String imageName = rs.getString("IMAGENAME");
					String pNumber = rs.getString("P_NUMBER");
					String pName = rs.getString("P_NAME");
					int price = rs.getInt("PRICE");
					int count = rs.getInt("COUNT");
					
					Cart cart = new Cart(cartNumber[i], seq, imagePath, imageName, pNumber, pName, price, count);
					
					list.add(cart);
				}
				rs.close();
				st.close();
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	

}
