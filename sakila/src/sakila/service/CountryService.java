package sakila.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import sakila.model.dao.CountryDao;
import sakila.model.vo.Country;

public class CountryService 
{
	private CountryDao countryDao;
	
	public void insertCountry(String country)
	{
		System.out.println("-------Country서비스------- :");
		System.out.println("country : "+country);
		
		countryDao = new CountryDao();
		countryDao.insertCountry(country);
		
	}
	
	public List<Country> selectCountryListAll()
	{
		System.out.println("-------Country서비스------- :");
		countryDao = new CountryDao();
		List<Country> list = new ArrayList<Country>();
		
		//매서드호출
		list = countryDao.selectCountryAllList();
		
		return list;
	}
	
	public List<Country> selectCountryList(int currentPage)
	{
		System.out.println("-------Country서비스------- :");
		System.out.println("currentPage : "+currentPage);
		countryDao = new CountryDao();
		List<Country> list = new ArrayList<Country>();
		
		//매서드호출
		list = countryDao.selectCountryList(currentPage);
		
		return list;
	}
}
