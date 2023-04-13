package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM logoutPOM;
	private static Properties properties;
	private ScreenShot screenShot;

//	@BeforeClass
//	public static void setUpBeforeClass() throws IOException {
//		properties = new Properties();
//		FileInputStream inStream = new FileInputStream("./resources/others.properties");
//		properties.load(inStream);
//	}

	@BeforeTest
	
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
//		driver = DriverFactory.getDriver(DriverNames.CHROME);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		logoutPOM = new LogoutPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=0)
	public void validLoginTest() {
		loginPOM.sendUserName("Admin");
		loginPOM.sendPassword("admin123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
	}
	@Test(priority=1)
	public void validLogoutTest() {
		logoutPOM.clicklogoutDropdown();
	}
}
