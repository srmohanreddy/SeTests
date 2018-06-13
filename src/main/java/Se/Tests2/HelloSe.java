package Se.Tests2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HelloSe {

	    private WebDriver driver;
//Comment added
	    @BeforeClass
	    public void beforeClass() {
	      //  driver = new FirefoxDriver();
	        WebDriverManager.chromedriver().setup();
        	driver = new ChromeDriver();
	        
	    }

	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }

	    @Test
	    public void verifySearchButton() {

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        driver.get("http://www.google.com");

	        String search_text = "Google Search";
	        WebElement search_button = driver.findElement(By.name("btnK"));

	        String text = search_button.getAttribute("value");

	        Assert.assertEquals(text, search_text, "Text not found!");
	        
	        driver.get("http://www.flipkart.com");
	        Assert.assertEquals(driver.getTitle(), "Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More", "Text Found Flipkart Title");

	    }


	}