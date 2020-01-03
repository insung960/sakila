package sakila.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sakila.db.DBHelper;

public class CityDao 
{
	public List<City> selectCityListByCountry(int countryId)
	{
		System.out.println("----cityDao----");
		System.out.println("countryId :" +countryId);
		
		List<City> list = new ArrayList<City>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT city_id , city FROM city WHERE country_id=?";
		try 
		{
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, countryId);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				City city = new City();
				city.setCityId(rs.getInt("city_id"));
				city.setCity(rs.getString("city"));
				list.add(city);
			}
		}
			//캐치
		catch(Exception e)
		{
			e.printStackTrace();
		}
			//파이널리 트라이
		finally
		{
			try 
			{}
			catch(Exception e) 
			{
				DBHelper.close(rs, stmt, conn);
			}
			
		}
		return list;
	}
	
	public void insertCity(String city,int countryId) {
		System.out.println("인서트시티");
		System.out.println(city);
		System.out.println(countryId);
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO city(city,country_id, last_update) VALUES(?,?,now())";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,city );
			stmt.setInt(2,countryId);
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
	
	public int selectCityCount()
	{
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) as cnt FROM city";
		
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
	
	
	public List<City> selectCityList(int currentPage)
	{
		//배열만들고
		List<City> list = new ArrayList<City>();
		//널초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//로퍼페이지
		int ROW_PER_PAGE = 10;
		//비긴로
		int beginRow = (currentPage - 1) * ROW_PER_PAGE;
		//쿼리
		String sql = "SELECT c.city_id , c.city , co.country_id , co.country , c.last_update FROM city c INNER JOIN country co ON c.country_id = co.country_id ORDER BY c.city_id DESC LIMIT ?,?";
			//트라이
		try 
		{
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, ROW_PER_PAGE);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				City c = new City();
				c.setCityId(rs.getInt("c.city_id"));
				c.setCity(rs.getString("c.city"));
				c.setLastUpdate(rs.getString("c.last_update"));
				c.setCountry(new Country());
				c.getCountry().setCountryId(rs.getInt("co.country_id"));
				c.getCountry().setCountry(rs.getString("co.country"));
				list.add(c);
			}
		}
			//캐치
		catch(Exception e)
		{
			e.printStackTrace();
		}
			//파이널리 트라이
		finally
		{
			try 
			{}
			catch(Exception e) 
			{
				DBHelper.close(rs, stmt, conn);
			}
			
		}
			//캐치
		return list;		
	}
	
	
}
