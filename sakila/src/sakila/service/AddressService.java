package sakila.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import sakila.model.dao.AddressDao;
import sakila.model.vo.Address;

public class AddressService 
{	
	private AddressDao addressDao;
	public List<Address> selectAddressList(int currentPage)
	{
		System.out.println("----서비스----");
		
		Connection conn =null;
		addressDao = new AddressDao();
		List<Address> list = new ArrayList<Address>();
		
		
		try
		{
			conn = DBHelper.getConnection();
			list = addressDao.selectAddressList(conn,currentPage);
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