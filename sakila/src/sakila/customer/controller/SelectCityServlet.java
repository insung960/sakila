package sakila.addrees.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.City;
import sakila.address.model.CityDao;
import salika.address.service.CityService;

/**
 * Servlet implementation class SelectCityServlet
 */
@WebServlet("/address/SelectCityList")
public class SelectCityServlet extends HttpServlet 
{
	private CityService cityService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("apllication/json");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		System.out.println("-------셀렉트시티서블릿------- :");
		System.out.println("currentPage : "+currentPage);
		
		cityService = new CityService();
		
		List<City> list = new ArrayList<City>();
		
		list = cityService.selectCityList(currentPage);
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);
		System.out.println(jsonList);
		response.getWriter().write(jsonList);
	}
}
