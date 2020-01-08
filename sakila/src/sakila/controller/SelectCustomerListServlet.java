
package sakila.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.service.CustomerService;

/**
 * Servlet implementation class SelectCustomerList
 */
@WebServlet("/SelectCustomerList")
public class SelectCustomerListServlet extends HttpServlet 
{
	private CustomerService customerService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		customerService = new CustomerService();
		
		//customerService 에서  회원의 리스트를 불러오는 매서드 실행
	}

}
