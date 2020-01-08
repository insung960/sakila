package sakila.service;

import java.util.ArrayList;
import java.util.List;

import sakila.model.dao.CityDao;
import sakila.model.vo.City;

public class CityService 
{
	private CityDao cityDao;
	public void insertCity(String city,int countryId)
	{
		System.out.println("----인서트시티서비스----");
		System.out.println(city);
		System.out.println(countryId);
		
		cityDao = new CityDao();
		cityDao.insertCity(city, countryId);
	}
	
	public List<City> selectCityList(int currentPage)
	{
		System.out.println("-------셀렉트시티서비스------- :");
		System.out.println("currentPage : "+currentPage);
		
		cityDao = new CityDao();
		List<City> list = new ArrayList<City>();
		
		list = cityDao.selectCityList(currentPage);
		
		return list;
	}
}
