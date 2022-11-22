package test.suites;

import page.actions.HomePageActions;
import page.actions.HomePageActions2;
import test.suites.utils.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSuite1 {
	
	WebDriver driver;
	WebDriverWait wait;
	SoftAssert sa;
	
	HomePageActions home;
	HomePageActions2 home2;
	Utils util;
	
	private static final Logger log = 
			LogManager.getLogger(TestSuite1.class.getName());
	
	@Test(priority=1)
	public void happyPath() {
		log.info("Test 1 - Happy path");
		util = new Utils(driver, "Test1");
		
		String state = "NY";
		
		home.enterZebraQuantity("1");
		home.enterLionQuantity("1");
		home.enterElephantQuantity("1");
		home.enterGirapheQuantity("1");
		home.selectState(state);
		util.takeScreenshot("FirstScreen");
		
		double expectedSubtotal = home.expectedSubtotal();
		double expectedTaxes = home.expectedTaxes(state);
		double expectedTotal = home.expectedTotal(state);
		
		home.clickCheckoutButton();
		util.takeScreenshot("SecondScreen");
		
		home2.checkListOfAllItems();
		home2.validateSubtotal(expectedSubtotal);
		home2.validateTaxes(expectedTaxes);
		home2.validateTotal(expectedTotal);
	}
  
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
	}
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		sa = new SoftAssert();
		home = new HomePageActions(driver);
		home2 = new HomePageActions2(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get(home.URL);
	}
	@AfterMethod
	public void afterMethod(ITestResult testResult) {
		driver.close();
		
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			log.info("Succeeded: " + testResult.getName());
		}
		else if (testResult.getStatus() == ITestResult.FAILURE) {
			log.info("Failed: " + testResult.getName());
		}
		log.info("-------------");
	}

}
