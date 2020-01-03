package salika.address.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sakila.address.model.Address;
import sakila.address.model.AddressDao;
import sakila.db.DBHelper;

public class AddressService 
{	
	private AddressDao addressDao;
	public List<Address> selectAddressList()
	{
		System.out.println("----서비스----");
		
		Connection conn =null;
		addressDao = new AddressDao();
		List<Address> list = new ArrayList<Address>();
		
		
		try
		{
			conn = DBHelper.getConnection();
			list = addressDao.selectAddressList(conn);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBHelper.close(null, null, conn);
		}
		return list;
	}
}