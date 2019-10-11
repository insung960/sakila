package sakila.customer.service;

import java.sql.Connection;
import java.sql.SQLException;

import sakila.address.model.Address;
import sakila.address.model.AddressDao;
import sakila.address.model.CustomerDao;
import sakila.customer.model.Customer;
import sakila.db.DBHelper;

public class CustomerService 
{
	private AddressDao addressDao;
	private CustomerDao customerDao;
	
	public void insertCustomer(Address address, Customer customer)
	{
		Connection conn =null;
		addressDao = new AddressDao();
		customerDao = new CustomerDao();
		
		try
		{
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false);
			
			int addressId =0;
			addressId = addressDao.insertAddress(address,conn);
			
			customer.getAddress().setAddressId(addressId);
			
			if(addressId==0)
			{
				System.out.println("addressId받기실패");
			}
			System.out.println(addressId);
		
			customerDao.insertcustomer(customer,conn);
			conn.commit();
		}
		catch(Exception e)
		{
			try
			{conn.rollback();}
			catch(SQLException e1)
			{}
			e.printStackTrace();
		}
		finally
		{
			DBHelper.close(null, null, conn);
		}
	}
}
