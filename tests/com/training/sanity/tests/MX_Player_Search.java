package com.training.sanity.tests;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import com.training.generics.ScreenShot;
import com.training.pom.MX_SearchPOM;
import com.training.utility.Driver;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MX_Player_Search {

	private WebDriver driver;
	private String baseUrl;
	private MX_SearchPOM Mx_SearchPOM;
	private static Properties properties;
	private ScreenShot screenShot;
    String url = "https://www.mxplayer.in/?search=true";



    @BeforeClass
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
//		driver = DriverFactory.getDriver(DriverNames.EDGE);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver = new EdgeDriver();
		Mx_SearchPOM = new MX_SearchPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(url);
        driver.manage().window().maximize();
    }

    
    @Test(priority = 1)
    public boolean testTopSearchesDisplayed() {
//        driver.get(url);
//        WebElement topSearches = Mx_SearchPOM; 
//        		driver.findElement(By.className("sc_top_search-results"));
        	Assert.assertTrue(Mx_SearchPOM.isDisplayed());
        boolean topSearchesDisplayed = Mx_SearchPOM.isDisplayed();
        	System.out.println("TSC-205 -> Today's Top Searches is displayed: " + topSearchesDisplayed);
        	screenShot.captureScreenShot("Top_Searches_Tsc_205");
			return topSearchesDisplayed;
    }

    @Test(priority = 2)
    public void testCategoriesDisplayed() {
//        driver.get(url);
//        WebElement categories = driver.findElement(By.className("sc_categories"));
        	Assert.assertTrue(Mx_SearchPOM.isDisplayed());
        boolean categoriesDisplayed = Mx_SearchPOM.isDisplayed();
        	System.out.println("TSC-206 -> Categories is displayed: " + categoriesDisplayed);
        	screenShot.captureScreenShot("Categories_Tsc_206");
    }

    @Test(priority = 3)
    public void testSearchBar() throws InterruptedException {
//        driver.get(url);
//        WebElement searchBar = driver.findElement(By.cssSelector("body #search-page input:first-child"));
    	Mx_SearchPOM.testSearchBar("Avengers");
        	Thread.sleep(3000);
        WebElement autosuggestPills = driver.findElement(By.className("sc_autosuggest-pills"));
        	Assert.assertTrue(autosuggestPills.isDisplayed());
        WebElement resultsCards = driver.findElement(By.className("sc_results-cards"));
        	Assert.assertTrue(resultsCards.isDisplayed());
        	screenShot.captureScreenShot("SearchBar_Tsc_208");
    }
    
    @Test(priority = 4)
    public void testMicrophone() throws InterruptedException {
//        driver.get(url);
        Thread.sleep(3000);
//        WebElement Mx_SearchPOM = driver.findElement(By.className("searchbar-mic-btn"));
//	        microphoneIcon.click();
	        Thread.sleep(3000);
        WebElement voiceErrorText = driver.findElement(By.cssSelector(".voice-error-text > span"));
	        Assert.assertTrue(voiceErrorText.isDisplayed());
	        Thread.sleep(3000);
        WebElement tryAgainButton = driver.findElement(By.className("voice-error-try-again"));
        	tryAgainButton.click();
        WebElement voiceListening = driver.findElement(By.className("voice-listening"));
        	Assert.assertTrue(voiceListening.isDisplayed());
        WebElement closeButton = driver.findElement(By.cssSelector(".modal-content [href='#close']"));
        	closeButton.click();
        	Thread.sleep(3000);
        WebElement homeButton = driver.findElement(By.className("hc_mx-logo"));
        	Assert.assertTrue(homeButton.isDisplayed());
        	screenShot.captureScreenShot("testMicrophone_Tsc_036");
    }

//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
}
