package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Assistance.WebDriverSingleton;
import Assistance.helper;

public class Cart_page {
	

	  WebDriver d;
	
		
	public Cart_page(WebDriver driver) {				 this.d = driver;
				PageFactory.initElements(d, this);
	}
	
	helper help = new helper();
	
	
	@FindBy (className="shopping_cart_link")
	WebElement Shop_cart;
	
	@FindBy (css="button[name='checkout']")
	WebElement Check_b;
	
	@FindBy (name="firstName")
	WebElement FName;
	
	@FindBy (name="lastName")
	WebElement LName;
	
	@FindBy (id="postal-code")
	WebElement addss;
	
	@FindBy (xpath="//*[@value='Continue']")
	WebElement Continue;
	
	@FindBy (className="cart_button")
	WebElement Finish_cart;
	
	@FindBy (css=" div[data-test='total-label']")
	WebElement total_vaule;
	
	public void Check_out() {
		
		Shop_cart.click();
		Check_b.click();
						
	}
	
	public void your_info (String Fname ,String Lname) {
		
		int address=help.getRandomNumber(100000, 999999);
		
	FName.sendKeys(Fname);
	LName.sendKeys(Lname);
	addss.sendKeys(String.valueOf(address));
	Continue.click();	
		
	}
	
	
	public void finished_page() {
		
		System.out.println("****TotalV="+total_vaule.getText().split(" ")[1]);
		
		Finish_cart.click();
		
		help.takeScreenshot("thank_you_page");
		
		
		
		
	}
	
	
	
	
	

}
