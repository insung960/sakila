package sakila.addrees.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.City;
import sakila.address.model.CityDao;

/**
 * Servlet implementation class SelectCityListByCountryServlet
 */
@WebServlet("/SelectCityListByCountryServlet")
public class SelectCityListByCountryServlet extends HttpServlet 
{
	private CityDao cityDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		System.out.println("----시티바이컨트리리스트 서블릿----");
		System.out.println("(param)countryId: "+ request.getParameter("countryId"));
		
		response.setContentType("application/json;charset=UTF-8");
		cityDao = new CityDao();
		
		int countryId = Integer.parseInt(request.getParameter("countryId"));
		
		System.out.println("(int)countryId: "+countryId);
		
		List<City>list = cityDao.selectCityListByCountry(countryId);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);

		response.getWriter().write(jsonStr);
	}
}
