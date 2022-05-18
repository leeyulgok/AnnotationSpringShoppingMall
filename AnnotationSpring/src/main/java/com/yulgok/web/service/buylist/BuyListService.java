package com.yulgok.web.service.buylist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yulgok.web.service.cart.Cart;
import com.yulgok.web.service.signup.Signup;

@Service
public class BuyListService implements BuyListServiceInt{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<BuyList> allList(int seq) {
		List<BuyList> list = new ArrayList<BuyList>();
		try {
			Connection con = dataSource.getConnection();
			String sql = String.format("SELECT * FROM BUYLIST WHERE SEQ = %d ORDER BY BUYDATE DESC", seq);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int buyNumber = rs.getInt("BUYNUMBER");
				String cartNumber = rs.getString("CART_NUMBER");
				seq = rs.getInt("SEQ");
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String pNumber = rs.getString("P_NUMBER");
				String pName = rs.getString("P_NAME");
				String imagePath = rs.getString("IMAGEPATH");
				String imageName = rs.getString("IMAGENAME");
				int price = rs.getInt("PRICE");
				String buyDate = rs.getString("BUYDATE");
				
				BuyList buyList = new BuyList(buyNumber, cartNumber, seq, id, name, address, phone, email, pNumber, pName, imagePath, imageName, price, buyDate);
				
				list.add(buyList);
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
	public int buyCompleted(List<Signup> sign, List<Cart> cart) {
		int result = 0;
		
		int seq = sign.get(0).getSeq();
		String id = sign.get(0).getId();
		String name = sign.get(0).getName();
		String address = sign.get(0).getAddress();
		String phone = sign.get(0).getPhone();
		String email = sign.get(0).getEmail();
		
		try {
			Connection con = dataSource.getConnection();
			for(int i = 0; i < cart.size(); i++) {
				String cartNumber = cart.get(i).getCartNumber();
				String pNumber = cart.get(i).getpNumber();
				String pName = cart.get(i).getpName();
				String imagePath = cart.get(i).getImagePath();
				String imageName = cart.get(i).getImageName();
				int price = cart.get(i).getPrice();
				
				String sql = String.format("INSERT INTO BUYLIST (CART_NUMBER, SEQ, ID, NAME, ADDRESS, PHONE, EMAIL, P_NUMBER, P_NAME, IMAGEPATH, IMAGENAME, PRICE) VALUES ('%s', %d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d)", cartNumber, seq, id, name, address, phone, email, pNumber, pName, imagePath, imageName, price);
				Statement st = con.createStatement();
				System.out.println(sql);
				result += st.executeUpdate(sql);
				
				st.close();
			}
			
			if(result == 0) {
				System.out.println("구매에 실패했습니다.");
			} else {
				System.out.println("구매에 성공했습니다.");
				int deleteResult = 0;
				for(int i = 0; i < cart.size(); i++) {					
					String deleteSql = String.format("DELETE FROM CART WHERE CART_NUMBER = '%s'", cart.get(i).getCartNumber());
					Statement st = con.createStatement();
					deleteResult += st.executeUpdate(deleteSql);
					
					st.close();
				}
				for(int i = 0; i < cart.size(); i++) {					
					String plusSql = String.format("UPDATE PRODUCT SET TOTALSALE = TOTALSALE + 1 WHERE P_NUMBER = '%s'", cart.get(i).getpNumber());
					Statement st = con.createStatement();
					st.executeUpdate(plusSql);
					
					st.close();
				}
				if(deleteResult == 0) {
					System.out.println("장바구니에서 제거를 실패했습니다.");
				} else {
					System.out.println("장바구니에서 제거했습니다.");
				}
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<BuyList> recentList(String[] cartNumber) {
		List<BuyList> list = new ArrayList<BuyList>();
		try {
			Connection con = dataSource.getConnection();
			for(int i = 0; i < cartNumber.length; i++) {				
				String sql = String.format("SELECT * FROM BUYLIST WHERE CART_NUMBER = '%s'", cartNumber[i]);
				System.out.println(sql);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					int buyNumber = rs.getInt("BUYNUMBER");
					cartNumber[i] = rs.getString("CART_NUMBER");
					int seq = rs.getInt("SEQ");
					String id = rs.getString("ID");
					String name = rs.getString("NAME");
					String address = rs.getString("ADDRESS");
					String phone = rs.getString("PHONE");
					String email = rs.getString("EMAIL");
					String pNumber = rs.getString("P_NUMBER");
					String pName = rs.getString("P_NAME");
					String imagePath = rs.getString("IMAGEPATH");
					String imageName = rs.getString("IMAGENAME");
					int price = rs.getInt("PRICE");
					String buyDate = rs.getString("BUYDATE");
					
					BuyList buyList = new BuyList(buyNumber, cartNumber[i], seq, id, name, address, phone, email, pNumber, pName, imagePath, imageName, price, buyDate);
					
					list.add(buyList);
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
