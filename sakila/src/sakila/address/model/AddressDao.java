package sakila.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sakila.db.DBHelper;

public class AddressDao 
{
	public List<Address> selectAddressList(Connection conn) throws SQLException
	{
		System.out.println("----selectaddressListDao----");
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT address_id,address,district,city_id,postal_code FROM address LIMIT 0,10";
		List<Address> list = new ArrayList<Address>();
		
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
			
		while(rs.next())
		{
			Address address = new Address();
			address.setCity(new City());
			address.setAddressId(rs.getInt("address_id"));
			address.setAddress(rs.getString("address"));
			address.setDistrict(rs.getString("district"));
			address.getCity().setCityId(rs.getInt("city_id"));
			address.setPostalCode(rs.getString("postal_code"));
			list.add(address);
		}
		
		System.out.println();
		return list;
	}
	
	public int insertAddress(Address address,Connection conn) throws Exception
	{
		int addressId =0;
		System.out.println("-------AddressDao-------");
		System.out.println("cityId :"+address.getCity().getCityId());
		System.out.println("address :"+address.getAddress());
		System.out.println("address2 :"+address.getAddress2());
		System.out.println("district :"+address.getDistrict());
		System.out.println("postalcode :"+address.getPostalCode());
		System.out.println("phone :"+address.getPhone());
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql2 = "INSERT INTO address(city_id,address,address2,district,postal_code,phone,last_update)";
		String sql3 = "VALUES(?,?,?,?,?,?,now())";
		String sql = sql2+sql3;
		
		stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
		stmt.setInt(1,address.getCity().getCityId());
		stmt.setString(2, address.getAddress());
		stmt.setString(3, address.getAddress2());
		stmt.setString(4, address.getDistrict());			
		stmt.setString(5, address.getPostalCode());
		stmt.setString(6, address.getPhone());
		stmt.executeUpdate();
		rs = stmt.getGeneratedKeys();
			
			if(rs.next())				
			{
				addressId = rs.getInt(1);
			}
				
		System.out.println();
		return addressId;
	}

	
	
	public int selectAddressCount()
	{
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) as cnt FROM address";
		
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
}
