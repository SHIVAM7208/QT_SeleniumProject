package Assistance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
	
	private static WebDriver driver;

    // Make the constructor private so no other class can create instances
    private WebDriverSingleton() {
    }

    // Provide a public method to get the WebDriver instance
    public static WebDriver getDriver() {
        // If no instance exists, create one
        if (driver == null) {
    driver = new ChromeDriver(); 
        }
        return driver; 
    }

    // Optional: Method to quit the driver when the test is finished
    public static void quitDriver() {
      
            driver.quit();
           
        
    }
}


