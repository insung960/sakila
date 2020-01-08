package sakila.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.model.vo.Country;
import sakila.service.CountryService;

/**
 * Servlet implementation class SelectCountryAllListServlet
 */
@WebServlet("/selectCountryAllList")
public class SelectCountryAllListServlet extends HttpServlet 
{
	private CountryService countryService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("application/json;charset=UTF-8");
		
		countryService = new CountryService();
		List<Country> list = new ArrayList<Country>();
		
		list = countryService.selectCountryListAll();
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);
		response.getWriter().write(jsonStr);
	}
}
