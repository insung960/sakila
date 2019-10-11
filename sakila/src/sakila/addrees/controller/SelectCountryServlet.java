package sakila.addrees.controller;

import java.util.*;
import sakila.address.model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/address/selectCountryList")
public class SelectCountryServlet extends HttpServlet {
	private CountryDao countryDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("apllication/json");
		
		System.out.println("/address/selectCountryList");
		System.out.println("currentPage : "+request.getParameter("currentPage"));
		
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		
		countryDao = new CountryDao();
		List<Country> list = countryDao.selectCountryList(currentPage);
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);
		System.out.println(jsonList);
		response.getWriter().write(jsonList);
	}
}
