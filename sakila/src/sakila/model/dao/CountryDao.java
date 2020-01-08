package sakila.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sakila.model.vo.Country;
import sakila.service.DBHelper;

public class CountryDao {
	public int selectCounyrtCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) as cnt FROM country";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		System.out.println("Dao / selectCount count : "+count);
		return count;
	}
	
	public void insertCountry(String country) {
		System.out.println("0");
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO country(country, last_update) VALUES(?,now())";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, country);
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
			} catch(Exception e) {
				DBHelper.close(null, stmt, conn);
			}
		}
	}
	
	//페이징하는 국가 리스트
	public List<Country> selectCountryList(int currentPage) {
		System.out.println("Dao / selectCountryList currentPage : "+currentPage);
		List<Country> list = new ArrayList<Country>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		final int ROW_PER_PAGE = 10;
		
		int beginRow = (currentPage -1)*ROW_PER_PAGE;
		
		String sql = "SELECT * FROM country ORDER BY country_id DESC LIMIT ?,?";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, ROW_PER_PAGE);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Country c = new Country();
				c.setCountryId(rs.getInt("country_id"));
				c.setCountry(rs.getString("country"));
				c.setLastUpdate(rs.getString("last_update"));
				list.add(c);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
			} catch(Exception e) {
				DBHelper.close(rs, stmt, conn);
			}
		}
		return list;
	}
	
	//페이징 없는 국가 리스트
		public List<Country> selectCountryAllList() 
		{
			List<Country> list = new ArrayList<Country>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
		
			String sql = "SELECT * FROM country ORDER BY country_id DESC ";
			
			try {
				conn = DBHelper.getConnection();
				stmt = conn.prepareStatement(sql);
			
				rs = stmt.executeQuery();
				while(rs.next()) {
					Country c = new Country();
					c.setCountryId(rs.getInt("country_id"));
					c.setCountry(rs.getString("country"));
					c.setLastUpdate(rs.getString("last_update"));
					list.add(c);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					
				} catch(Exception e) {
					DBHelper.close(rs, stmt, conn);
				}
			}
			return list;
		}
	
}