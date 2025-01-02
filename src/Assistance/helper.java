package Assistance;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class helper {
	

 
 private static WebDriver driver = WebDriverSingleton.getDriver();


	
	
	public static WebElement waitForElementVisible(  By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

	public static void PageBack() { driver.navigate().back(); }
	
	
   
    // Element Interaction
    public static void clickElement(  By locator) {
        driver.findElement(locator).click();
    }

    public static void enterText(  By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public static boolean verifyElementExists(  By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    // Drop-down Handling
    public static void selectByText(  By locator, String text) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(text);
    }

    // Alert Handling
    public static void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    static String path = "C:\\Users\\Acer\\eclipse-workspace\\learn_cucumber\\Learn_cucumber\\screenshort\\";
    // Screenshot Helper
    public static void takeScreenshot( String fileName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(path + fileName + ".png");
            Files.copy(screenshot, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void ElementScreenshot(WebElement Element, String fileName) {
        try {
            File screenshot = Element.getScreenshotAs(OutputType.FILE);
            File destination = new File(path + fileName + ".png");
            Files.copy(screenshot, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Frame/Window Handling
    public static void switchToFrame(  String frameName) {
        driver.switchTo().frame(frameName);
    }

    public static void switchToWindow(  String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

   

    // Mouse Actions
    public static void hoverOverElement(  WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }


	

	    // Method to get current timestamp as String
	    public static String getCurrentTimestamp(String format) {
	        SimpleDateFormat sdf = new SimpleDateFormat(format);
	        return sdf.format(new Date());
	    }
	 

	    // Method to generate a random string of a given length
	    public static String getRandomString(int length) {
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        Random random = new Random();
	        StringBuilder result = new StringBuilder();
	        for (int i = 0; i < length; i++) {
	            result.append(characters.charAt(random.nextInt(characters.length())));
	        }
	        return result.toString();
	    }
	    
	    // Method to generate a random number within a range
	    public static int getRandomNumber(int min, int max) {
	        Random random = new Random();
	        return random.nextInt((max - min) + 1) + min;
	    }


	    // Method to generate a random email address
	    public static String generateRandomEmail() {
	        return "user" + getRandomNumber(1000, 9999) + "@example.com";
	    }


	  

	   
}
