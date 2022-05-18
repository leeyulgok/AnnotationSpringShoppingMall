package com.yulgok.web.service.product;

import java.io.File;
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
public class ProductService implements ProductServiceInt{

	@Autowired
	private DataSource dataSource;
	
	@Override
	public int register(String pNumber, String pName, String type, int price, String size, String content, int sale, String filePath, String fileName) {
		int result = 0;
		try {
			Connection con = dataSource.getConnection();
			String sql = String.format("INSERT INTO PRODUCT (P_NUMBER, P_NAME, TYPE, PRICE, SIZE, CONTENT, SALE, FILEPATH, FILENAME)"+
			" VALUES ('%s', '%s', '%s', %d, '%s', '%s', %d, '%s', '%s')", pNumber, pName, type, price, size, content, sale, filePath, fileName);
			Statement st = con.createStatement();
			result = st.executeUpdate(sql);
			
			if(result == 1) {
				System.out.println("제품을 등록했습니다.");
			} else {
				System.out.println("제품에 실패했습니다.");
			}
			
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<Product> list(){
		List<Product> list = new ArrayList<Product>();
		try {
			Connection con = dataSource.getConnection();
			String sql = "SELECT * FROM PRODUCT ORDER BY REGDATE DESC";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String pNumber = rs.getString(1);
				String pName = rs.getString(2);
				String type = rs.getString(3);
				int price = rs.getInt(4);
				String size = rs.getString(5);
				String content = rs.getString(6);
				int sale = rs.getInt(7);
				String filePath = rs.getString(8);
				String fileName = rs.getString(9);
				int hit = rs.getInt(10);
				String regdate = rs.getString(11);
				int totalSale = rs.getInt(12);
				Product product = new Product(pNumber, pName, type, price, size, content, sale, filePath, fileName, hit, regdate, totalSale);
				
				list.add(product);
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
	public List<Product> detail(String pNumber) {
		List<Product> list = new ArrayList<Product>();
		try {
			Connection con = dataSource.getConnection();
			String sql = String.format("SELECT * FROM PRODUCT WHERE P_NUMBER = '%s'", pNumber);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				pNumber = rs.getString(1);
				String pName = rs.getString(2);
				String type = rs.getString(3);
				int price = rs.getInt(4);
				String size = rs.getString(5);
				String content = rs.getString(6);
				int sale = rs.getInt(7);
				String filePath = rs.getString(8);
				String fileName = rs.getString(9);
				int hit = rs.getInt(10);
				String regdate = rs.getString(11);
				int totalSale = rs.getInt(12);
				Product product = new Product(pNumber, pName, type, price, size, content, sale, filePath, fileName, hit, regdate, totalSale);
				list.add(product);
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
	public void hit(String pNumber) {
		try {
			Connection con = dataSource.getConnection();
			String sql = String.format("UPDATE PRODUCT SET HIT = HIT + 1 WHERE P_NUMBER = '%s'", pNumber);
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int delete(String pNumber) {
		int result = 0;
		String filePath_ = "";
		try {
			Connection con_ = dataSource.getConnection();
			String sql_ = String.format("SELECT FILENAME FROM PRODUCT WHERE P_NUMBER = '%s'", pNumber);
			Statement st_ = con_.createStatement();
			ResultSet rs = st_.executeQuery(sql_);
			while(rs.next()) {
				filePath_ = rs.getString("FILENAME");
			}
			File file = new File("/Users/iyulgog/Documents/workspace-spring-tool-suite-4-4.14.0.RELEASE/AnnotationSpring/src/main/webapp/static/image/product" + filePath_);
			if(file.exists()) {
				if(file.delete()) {
					System.out.println("파일삭제 성공");
				} else {
					System.out.println("파일삭제 실패");
				}
			}				
			rs.close();
			st_.close();
			con_.close();
			
			Connection con = dataSource.getConnection();
			String sql = String.format("DELETE FROM PRODUCT WHERE P_NUMBER = '%s'", pNumber);
			Statement st = con.createStatement();
			result = st.executeUpdate(sql);
			
			if(result == 1) {
				System.out.println("게시글을 삭제했습니다.");
			} else {
				System.out.println("게시글을 삭제에 실패했습니다.");
			}			
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateFile(String pNumber, String pName, int price, String content, int sale, String filePath, String fileName) {
		int result = 0;
		String filePath_ = "";
		try {
			Connection con_ = dataSource.getConnection();
			String sql_ = String.format("SELECT FILENAME FROM PRODUCT WHERE P_NUMBER = '%s'", pNumber);
			Statement st_ = con_.createStatement();
			ResultSet rs = st_.executeQuery(sql_);
			while(rs.next()) {
				filePath_ = rs.getString("FILENAME");
			}
			File file = new File("/Users/iyulgog/Documents/workspace-spring-tool-suite-4-4.14.0.RELEASE/AnnotationSpring/src/main/webapp/static/image/product" + filePath_);
			if(file.exists()) {
				if(file.delete()) {
					System.out.println("파일삭제 성공");
				} else {
					System.out.println("파일삭제 실패");
				}
			}				
			rs.close();
			st_.close();
			con_.close();
			
			Connection con = dataSource.getConnection();
			String sql = String.format("UPDATE PRODUCT SET P_NAME = '%s', "
					+ "PRICE = %d, "
					+ "CONTENT = '%s', "
					+ "SALE = %d, "
					+ "FILEPATH = '%s', "
					+ "FILENAME = '%s'"
					+ " WHERE P_NUMBER = '%s'", pName, price, content, sale, filePath, fileName, pNumber);
			Statement st = con.createStatement();
			result = st.executeUpdate(sql);
			
			if(result == 1) {
				System.out.println("업데이트에 성공했습니다.");
			} else {
				System.out.println("업데이트에 실패했습니다.");
			}
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int update(String pNumber, String pName, int price, String content, int sale) {
		int result = 0;
		try {
			Connection con = dataSource.getConnection();
			String sql = String.format("UPDATE PRODUCT SET P_NAME = '%s', "
					+ "PRICE = %d, "
					+ "CONTENT = '%s', "
					+ "SALE = %d"
					+ " WHERE P_NUMBER = '%s'", pName, price, content, sale, pNumber);
			Statement st = con.createStatement();
			result = st.executeUpdate(sql);
			
			if(result == 1) {
				System.out.println("업데이트에 성공했습니다.");
			} else {
				System.out.println("업데이트에 실패했습니다.");
			}
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Product> search(String searchType, String search){
		List<Product> list = new ArrayList<Product>();
		
		try {
			Connection con = dataSource.getConnection();
			String sql = "SELECT * FROM PRODUCT WHERE " + searchType + " LIKE '%" + search + "%' ORDER BY REGDATE DESC";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String pNumber = rs.getString(1);
				String pName = rs.getString(2);
				String type = rs.getString(3);
				int price = rs.getInt(4);
				String size = rs.getString(5);
				String content = rs.getString(6);
				int sale = rs.getInt(7);
				String filePath = rs.getString(8);
				String fileName = rs.getString(9);
				int hit = rs.getInt(10);
				String regdate = rs.getString(11);
				int totalSale = rs.getInt(12);
				Product product = new Product(pNumber, pName, type, price, size, content, sale, filePath, fileName, hit, regdate, totalSale);
				
				list.add(product);
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
	public List<Product> list(String type) {
		List<Product> list = new ArrayList<Product>();
		try {
			Connection con = dataSource.getConnection();
			String sql = String.format("SELECT * FROM PRODUCT WHERE TYPE = '%s' ORDER BY REGDATE DESC", type);
			System.out.println(sql);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String pNumber = rs.getString(1);
				String pName = rs.getString(2);
				type = rs.getString(3);
				int price = rs.getInt(4);
				String size = rs.getString(5);
				String content = rs.getString(6);
				int sale = rs.getInt(7);
				String filePath = rs.getString(8);
				String fileName = rs.getString(9);
				int hit = rs.getInt(10);
				String regdate = rs.getString(11);
				int totalSale = rs.getInt(12);
				Product product = new Product(pNumber, pName, type, price, size, content, sale, filePath, fileName, hit, regdate, totalSale);
				
				list.add(product);
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
	public List<Product> list(String type, String pNumber) {
		List<Product> list = new ArrayList<Product>();
		try {
			Connection con = dataSource.getConnection();
			String sql = "SELECT * FROM PRODUCT WHERE P_NUMBER LIKE '"+ type+pNumber +"%' ORDER BY REGDATE DESC";
			System.out.println(sql);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				pNumber = rs.getString(1);
				String pName = rs.getString(2);
				type = rs.getString(3);
				int price = rs.getInt(4);
				String size = rs.getString(5);
				String content = rs.getString(6);
				int sale = rs.getInt(7);
				String filePath = rs.getString(8);
				String fileName = rs.getString(9);
				int hit = rs.getInt(10);
				String regdate = rs.getString(11);
				int totalSale = rs.getInt(12);
				Product product = new Product(pNumber, pName, type, price, size, content, sale, filePath, fileName, hit, regdate, totalSale);
				
				list.add(product);
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
	public List<Product> hitList() {
		List<Product> list = new ArrayList<Product>();
		try {
			Connection con = dataSource.getConnection();
			String sql = "SELECT * FROM PRODUCT ORDER BY HIT DESC LIMIT 4";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String pNumber = rs.getString(1);
				String pName = rs.getString(2);
				String type = rs.getString(3);
				int price = rs.getInt(4);
				String size = rs.getString(5);
				String content = rs.getString(6);
				int sale = rs.getInt(7);
				String filePath = rs.getString(8);
				String fileName = rs.getString(9);
				int hit = rs.getInt(10);
				String regdate = rs.getString(11);
				int totalSale = rs.getInt(12);
				Product product = new Product(pNumber, pName, type, price, size, content, sale, filePath, fileName, hit, regdate, totalSale);
				
				list.add(product);
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
	public List<Product> recentList() {
		List<Product> list = new ArrayList<Product>();
		try {
			Connection con = dataSource.getConnection();
			String sql = "SELECT * FROM PRODUCT ORDER BY REGDATE DESC LIMIT 4";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String pNumber = rs.getString(1);
				String pName = rs.getString(2);
				String type = rs.getString(3);
				int price = rs.getInt(4);
				String size = rs.getString(5);
				String content = rs.getString(6);
				int sale = rs.getInt(7);
				String filePath = rs.getString(8);
				String fileName = rs.getString(9);
				int hit = rs.getInt(10);
				String regdate = rs.getString(11);
				int totalSale = rs.getInt(12);
				Product product = new Product(pNumber, pName, type, price, size, content, sale, filePath, fileName, hit, regdate, totalSale);
				
				list.add(product);
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
	public List<Product> popularList() {
		List<Product> list = new ArrayList<Product>();
		try {
			Connection con = dataSource.getConnection();
			String sql = "SELECT * FROM PRODUCT ORDER BY TOTALSALE DESC LIMIT 4";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String pNumber = rs.getString(1);
				String pName = rs.getString(2);
				String type = rs.getString(3);
				int price = rs.getInt(4);
				String size = rs.getString(5);
				String content = rs.getString(6);
				int sale = rs.getInt(7);
				String filePath = rs.getString(8);
				String fileName = rs.getString(9);
				int hit = rs.getInt(10);
				String regdate = rs.getString(11);
				int totalSale = rs.getInt(12);
				Product product = new Product(pNumber, pName, type, price, size, content, sale, filePath, fileName, hit, regdate, totalSale);
				
				list.add(product);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
