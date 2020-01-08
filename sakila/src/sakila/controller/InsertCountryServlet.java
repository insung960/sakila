package sakila.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.service.CountryService;

@WebServlet("/address/insertCountry")
public class InsertCountryServlet extends HttpServlet 
{
	private CountryService countryService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("charset=UTF-8");
		
		String country = request.getParameter("country");
		
		System.out.println("----------인서트컨트리서블릿----------");
		System.out.println("country : "+country);
		
		countryService = new CountryService();
		countryService.insertCountry(country);
	}
}
