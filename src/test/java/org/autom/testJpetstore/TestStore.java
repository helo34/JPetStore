package org.autom.testJpetstore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.firefox.FirefoxProfile;

public class TestStore {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		if(System.getProperty("navigateur").equalsIgnoreCase("firefox")){
			// commentaires à décommenter si problème avec firefox
		//FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
		//options.addPreference("browser.tabs.remote.autostart", false);
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Formation\\OWASP ZAP\\webdriver\\windows\\64\\geckodriver.exe");
		//driver = new FirefoxDriver(options);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/jpetstore/");
		}
		else if(System.getProperty("navigateur").equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Formation\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/jpetstore/");
		}
		// MODIF CONFLIT 2
	}
	
	@Test
	public void test() {
		driver.findElement(By.linkText("Enter the Store")).click();
		WebElement image = driver.findElement(By.id("MainImageContent"));
		image.isDisplayed();
		
	}
	
	@After
	public void teardown() {
		driver.quit();
	}

}
