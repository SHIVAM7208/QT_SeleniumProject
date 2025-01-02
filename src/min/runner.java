package min;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Assistance.WebDriverSingleton;
import Assistance.helper;
import pages.Cart_page;
import pages.login_page;
import pages.product_page;

public class runner {

	public static void main(String[] args) {
		WebDriver driver = WebDriverSingleton.getDriver(); 
		  
		  
		  login_page lp = new login_page(driver);
		  
		  helper hp = new helper();
		  
		  product_page pp = new product_page(driver);
		  
		  Cart_page cp = new Cart_page(driver);
		  
		  
		  
		 lp.Url();
		  
		 lp.cretaila("standard_user");
		  
	     lp.verifyTitle();
	     
	     lp.menu_bar();
	     
	     pp.sortpage();
	     
	     pp.listAllProducts();
	     
	     pp.add_product("Sauce Labs Backpack");
	     
	     cp.Check_out();
	     
	     cp.your_info("shivam","dubey");
	     
	     cp.finished_page();
	     
	     
	     
	    WebDriverSingleton.quitDriver();
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     

	}

}
