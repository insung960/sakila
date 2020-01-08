package sakila.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.model.dao.CityDao;

/**
 * Servlet implementation class selectCityCountServlet
 */
@WebServlet("/adrees/selectCityCount")
public class selectCityCountServlet extends HttpServlet
{
	private CityDao cityDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("application/json;charset=UTF-8");
		
		cityDao = new CityDao();
		int count = cityDao.selectCityCount();
		
		System.out.println("CityCount :"+ count );
		
		Gson gson = new Gson();
		String jsonCount = gson.toJson(count);
		response.getWriter().write(jsonCount);	
	}
}
