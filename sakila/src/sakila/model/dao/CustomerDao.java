package sakila.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sakila.model.vo.Customer;
import sakila.service.DBHelper;

public class CustomerDao 
{
	public void insertcustomer(Customer customer,Connection conn) throws SQLException
	{
		System.out.println("--------CustomerDao--------");
		System.out.println("storeId : "+customer.getStore().getStoreId());
		System.out.println("firstName : "+customer.getFirstName());
		System.out.println("lastName : "+customer.getLastName());
		System.out.println("email : "+customer.getEmail());
		System.out.println("addressId : "+customer.getAddress().getAddressId());
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql2 ="INSERT INTO customer(store_id,first_name,last_name,email,address_id,create_date,last_update,active )";
		String sql3 ="VALUES (?,?,?,?,?,NOW(),NOW(),1)";
		
		String sql = sql2 + sql3;
		
		stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, customer.getStore().getStoreId());
		stmt.setString(2, customer.getFirstName());
		stmt.setString(3, customer.getLastName());
		stmt.setString(4, customer.getEmail());
		stmt.setInt(5, customer.getAddress().getAddressId());
		
		stmt.executeUpdate();

		System.out.println("커스터머 인서트완료");
	}
	
	////////////////////
	////////////////////
	
	public int selectCustomerCount()
	{
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) as cnt FROM customer";
		
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
