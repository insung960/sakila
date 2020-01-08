package sakila.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.model.dao.AddressDao;
import sakila.model.dao.CountryDao;

/**
 * Servlet implementation class SelectAddressCountServlet
 */
@WebServlet("/SelectAddressCountServlet")
public class SelectAddressCountServlet extends HttpServlet 
{
	private AddressDao addressDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("application/json;charset=UTF-8");
		addressDao = new AddressDao();
		int count = addressDao.selectAddressCount();
		System.out.println("Address count : "+count);// 확인
		
		Gson gson = new Gson();
		String jsonCount = gson.toJson(count);
		response.getWriter().write(jsonCount);
	}
}
