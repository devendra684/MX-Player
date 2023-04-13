package com.training.utility;

public interface Driver {
	// KEYS 
	String CHROME ="webdriver.chrome.driver"; 
	String FIREFOX ="webdriver.firefox.marionette"; 
	String IE ="webdriver.ie.driver";
	String PHANTOM="phantomjs.binary.path";
	String EDGE="webdriver.edge.driver";
	
	// PATH 
	String CHROME_PATH="C:\\Users\\chromedriver_win32\\chromedriver.exe";
	String FIREFOX_PATH ="C:\\Users\\geckodriver-v0.32.2-win32\\geckodriver.exe";
	String EDGE_PATH ="C:\\Users\\edgedriver_win64\\msedgedriver.exe";
	String IE_PATH ="";
	String PHANTOM_PATH="";
	
}
//System.setProperty("webdriver.edge.driver",
//        "C:\Users\ghs6kor\Desktop\Java\msedgedriver.exe");
     //instance of EdgeDriver
//     WebDriver driver = new EdgeDriver();