package com.training.utility;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * @author Naveen
 * @see This class will load the given driver, and follows factory pattern 
 * 	@since 16-Dec-2018 
 */
public class DriverFactory {
	// it only a reference 
	private static WebDriver driver; 
	
	public static WebDriver getDriver(String driverName){

		if(driverName.equals(DriverNames.CHROME)){
//			System.setProperty(Driver.CHROME, Driver.CHROME_PATH);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		
			
		}else if(driverName.equals(DriverNames.FIREFOX)){
//			System.setProperty(Driver.FIREFOX, Driver.FIREFOX_PATH);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(driverName.equals(DriverNames.EDGE)){
//			System.setProperty(Driver.EDGE, Driver.EDGE_PATH);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}else if(driverName.equals("IE")){
			// TODO 
		}else if(driverName.equals(DriverNames.PHANTOM)){
			// TODO 
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}