package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Assistance.helper;

public class product_page {

	
	WebDriver d;
		
	public product_page(WebDriver driver) {				 
		
		this.d = driver; 
											}
	
		helper help = new helper();
		
		By sort_dropdown = By.className("product_sort_container");
		
	
	
	public void sortpage() {
		help.selectByText(sort_dropdown,"Price (low to high)");		}
	
	

	public void listAllProducts() {
	    List<WebElement> productNames = d.findElements(By.className("inventory_item_name"));
	    List<WebElement> productPrices = d.findElements(By.className("inventory_item_price"));

	    System.out.println("Available Products:");
	    for (int i = 0; i < productNames.size(); i++) {
	        System.out.println((i + 1) + ". " + productNames.get(i).getText() + " - " + productPrices.get(i).getText());
	    }

	    // Extract prices as a list of doubles
	    List<Double> prices = productPrices.stream()
	            .map(element -> Double.parseDouble(element.getText().replace("$", "")))
	            .collect(Collectors.toList());

	    // Verify if the prices are sorted (ascending order)
	    boolean isSortedByPrice = prices.stream().sorted().collect(Collectors.toList()).equals(prices);

	    // Output the verification results
	    if (isSortedByPrice) {
	        System.out.println("Products are correctly sorted by price.");
	    } else {
	        System.out.println("Products are NOT correctly sorted by price.");
	    }

	  
	}
	
	
	String Add_to_cart = "//div[contains(text(),'Sauce Labs Bike Light')]/ancestor::div[@class='inventory_item']//div[@class='inventory_item_description']/div[@class='pricebar']/button";
	
	
	public void add_product(String Pname) {
		
		WebElement Add_to_cart_B = d.findElement(By.xpath("//div[contains(text(),'"+Pname+"')]/ancestor::div[@class='inventory_item']//div[@class='inventory_item_description']/div[@class='pricebar']/button"));
		
		Add_to_cart_B.click();
		
		System.out.println("*****product Add to Cart******");
	}
	
	
	
	
	
	
	
	
	
	
	
}
