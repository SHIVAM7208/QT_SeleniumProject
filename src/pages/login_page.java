package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Assistance.helper;

public class login_page {
	

	  WebDriver d;
	             		
			public login_page(WebDriver driver) {				 this.d = driver;  }
			
			helper help = new helper();
			
			
			By UserN = By.id("user-name");
			By UserP = By.name("password");
			By Menu_b = By.id("react-burger-menu-btn");
			By About = By.id("about_sidebar_link");
			
			public void Url() {
				
				d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				d.manage().window().maximize();
				d.get("https://www.saucedemo.com/"); 	 			}
			
			
			public void cretaila (String username) {
				String password ="secret_sauce";
				
				d.findElement(UserN).sendKeys(username);
				d.findElement(UserP).sendKeys(password);
				d.findElement(By.className("submit-button")).click();
			}
			
			public void verifyTitle() {
				
				String T = d.getTitle();
				String VT = "Swag Labs";
				
				if (T.equalsIgnoreCase(VT)) {
					System.out.println("*******Correct Title********");
				}else {System.out.println("*******Incorrect Title********");      }
				
			}
			
			public void menu_bar() {
				help.clickElement(Menu_b);
				help.waitForElementVisible(About, 5);
				help.clickElement(About);
				help.takeScreenshot("fullpages");
				help.PageBack();
				
			}
			
				 	    
}
