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

import sakila.model.vo.Address;
import sakila.service.AddressService;

/**
 * Servlet implementation class SelectAddressListServlet
 */
@WebServlet("/SelectAddressListServlet")
public class SelectAddressListServlet extends HttpServlet 
{
	private AddressService addressService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("---어드레스서블릿-");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		response.setContentType("application/json;charset=UTF-8");
		
		addressService = new AddressService();
		List<Address> list = new ArrayList<Address>();
		
		System.out.println("----서블릿----");
		
		list = addressService.selectAddressList(currentPage);
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);
		System.out.println(jsonList);
		response.getWriter().write(jsonList);
	}
}
