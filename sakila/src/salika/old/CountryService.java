package salika.address.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import sakila.address.model.AddressDao;
import sakila.address.model.Country;
import sakila.address.model.CountryDao;
import sakila.address.model.CustomerDao;
import sakila.db.DBHelper;

public class CountryService 
{
	private CountryDao countryDao;
	
	public void insertCountry(String country)
	{
		System.out.println("----------인서트컨트리서비스----------");
		System.out.println("country : "+country);
		
		countryDao = new CountryDao();
		countryDao.insertCountry(country);
		
	}
	
	public List<Country> selectCountryList()
	{
		Connection conn =null;
		countryDao = new CountryDao();
		List<Country> list = new ArrayList<Country>();
		try
		{
			conn = DBHelper.getConnection();
			list = countryDao.selectCountryAllList();
			
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
