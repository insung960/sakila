package sakila.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.model.vo.Address;
import sakila.model.vo.City;
import sakila.model.vo.Customer;
import sakila.model.vo.Store;
import sakila.service.CustomerService;

/**
 * Servlet implementation class InsertCustomer
 */
@WebServlet("/InsertCustomer")
public class InsertCustomerServlet extends HttpServlet 
{
	private CustomerService customerService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		customerService = new CustomerService();
		
		Address add = new Address();
		Customer cus = new Customer();
		
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		String district = request.getParameter("district");
		String postalcode = request.getParameter("postalcode");
		String phone = request.getParameter("phone");
		
		int storeid = Integer.parseInt(request.getParameter("storeid"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		System.out.println("------인서트커스터머서블릿------");
		System.out.println("cityId : "+cityId);
		System.out.println("address : "+address);
		System.out.println("address2 : "+address2);
		System.out.println("district : "+district);
		System.out.println("postalcode : "+postalcode);
		System.out.println("phone : "+phone);
		System.out.println("***************************");
		System.out.println("storeid : "+storeid);
		System.out.println("firstname : "+firstname);
		System.out.println("lastname : "+lastname);
		System.out.println("email : "+email);
		
		add.setCity(new City());
		add.getCity().setCityId(cityId);
		add.setAddress(address);
		add.setAddress2(address2);
		add.setDistrict(district);
		add.setPostalCode(postalcode);
		add.setPhone(phone);
		
		cus.setStore(new Store());
		cus.getStore().setStoreId(storeid);
		cus.setFirstName(firstname);
		cus.setLastName(lastname);
		cus.setEmail(email);
		cus.setAddress(new Address());
		
		customerService.insertCustomer(add,cus);
	}
}
