package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MX_SearchPOM {
	private WebDriver driver; 
	
	public MX_SearchPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className=".sc_top_search-results")
	private WebElement Top_Searches_Tsc_205; 
	
	@FindBy(className=".sc_categories")
	private WebElement Categories_Tsc_206; 
	
	@FindBy(css="body #search-page input:first-child")
	private WebElement SearchBar_Tsc_208; 

	@FindBy(className=".searchbar-mic-btn")
	private WebElement testMicrophone_Tsc_036; 
	
	
	public void testTopSearchesDisplayed() {
//		driver.findElement("sc_top_search-results");
		System.out.println("TSC-205 -> Today's Top Searches is displayed: " + Top_Searches_Tsc_205);
    
	}
	
	public void testCategoriesDisplayed() {
//		this.Categories_Tsc_206;
	System.out.println("TSC-206 -> Categories is displayed: " + Categories_Tsc_206);
	}
	
	public void testSearchBar(String SearchBar_Tsc_208) {
		this.SearchBar_Tsc_208.clear();
		this.SearchBar_Tsc_208.sendKeys(SearchBar_Tsc_208);
	}
	
	public void testMicrophone() {
		this.testMicrophone_Tsc_036.click(); 
	}

	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
