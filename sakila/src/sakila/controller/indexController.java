package sakila.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.model.dao.ActorDao;
import sakila.model.dao.AddressDao;
import sakila.model.dao.CategoryDao;
import sakila.model.dao.CityDao;
import sakila.model.dao.CountryDao;
import sakila.model.dao.CustomerDao;
import sakila.model.dao.FilmDao;
import sakila.model.dao.Film_actorDao;
import sakila.model.dao.Film_categoryDao;
import sakila.model.dao.Film_textDao;
import sakila.model.dao.InventoryDao;
import sakila.model.dao.LanguageDao;
import sakila.model.dao.PaymentDao;
import sakila.model.dao.RentalDao;
import sakila.model.dao.StaffDao;
import sakila.model.dao.StoreDao;

/**
 * Servlet implementation class indexController
 */
@WebServlet("/indexController")
public class indexController extends HttpServlet 
{
	private CountryDao countryDao;
	private CityDao cityDao;
	private	sakila.model.dao.StoreDao storeDao;
	private sakila.model.dao.StaffDao staffDao;
	private	sakila.model.dao.RentalDao rentalDao;
	private	sakila.model.dao.PaymentDao paymentDao;
	private	sakila.model.dao.LanguageDao languageDao;
	private	sakila.model.dao.InventoryDao inventoryDao;
	private sakila.model.dao.FilmDao filmDao;
	private	sakila.model.dao.Film_textDao film_textDao;
	private sakila.model.dao.Film_categoryDao film_categoryDao;
	private	sakila.model.dao.Film_actorDao film_actorDao;
	private	sakila.model.dao.CustomerDao customerDao;
	private	sakila.model.dao.CategoryDao categoryDao;
	private	sakila.model.dao.AddressDao addressDao;
	private	sakila.model.dao.ActorDao actorDao;
	
	//모든 테이블 Dao추가
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("application/json;charset=UTF-8");
		
		
		
		Map<String,Integer> map = new HashMap<String, Integer>();
		// Imteger 오토박싱 언박싱
		countryDao = new CountryDao();
		cityDao = new CityDao();
		storeDao = new StoreDao();
		staffDao = new StaffDao();
		rentalDao = new RentalDao();
		paymentDao = new PaymentDao();
		languageDao = new LanguageDao();
		inventoryDao = new InventoryDao();
		filmDao = new FilmDao();
		film_textDao = new Film_textDao();
		film_categoryDao = new Film_categoryDao();
		film_actorDao = new Film_actorDao();
		customerDao = new CustomerDao();
		categoryDao = new CategoryDao();
		addressDao = new AddressDao();
		actorDao = new ActorDao();
		
		int countryRow = countryDao.selectCounyrtCount();
		map.put("countryRow", countryRow);
		int cityRow = cityDao.selectCityCount();
		map.put("cityRow", cityRow);
		int storeRow = storeDao.selectStoreCount();
		map.put("storeRow", storeRow);
		int staffRow = staffDao.selectStaffCount();
		map.put("staffRow", staffRow);
		int rentalRow = rentalDao.selectRentalCount();
		map.put("rentalRow", rentalRow);
		int paymentRow = paymentDao.selectPaymenyCount();
		map.put("paymentRow", paymentRow);
		int languageRow = languageDao.selectLanguageCount();
		map.put("languageRow", languageRow);
		int inventoryRow = inventoryDao.selectInventoryCount();
		map.put("inventoryRow", inventoryRow);
		int filmRow = filmDao.selectFilmCount();
		map.put("filmRow", filmRow);
		int film_textRow = film_textDao.selectFilm_textCount();
		map.put("film_textRow", film_textRow);
		int film_categoryRow = film_categoryDao.selectFilm_categoryCount();
		map.put("film_categoryRow", film_categoryRow);
		int film_actorRow = film_actorDao.selectFilm_actorCount();
		map.put("film_actorRow", film_actorRow);
		int customerRow = customerDao.selectCustomerCount();
		map.put("customerRow", customerRow);
		int categoryRow = categoryDao.selectcategoryCount();
		map.put("categoryRow", categoryRow);
		int addressRow = addressDao.selectAddressCount();
		map.put("addressRow", addressRow);
		int actorRow = actorDao.selectActorCount();
		map.put("actorRow", actorRow);
	
		
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
		
		response.getWriter().write(jsonStr);
	}
}
