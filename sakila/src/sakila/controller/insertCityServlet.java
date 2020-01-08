package sakila.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.service.CityService;

/**
 * Servlet implementation class insertCityServlet
 */
@WebServlet("/insertCityServlet")
public class insertCityServlet extends HttpServlet 
{
	private CityService cityService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		cityService = new CityService();
		
		int countryId = Integer.parseInt(request.getParameter("countryId"));
		String city = request.getParameter("city");
		
		System.out.println("----인서트시티서블릿----");
		System.out.println(city);
		System.out.println(countryId);
		
		cityService.insertCity(city, countryId);
	}
}
