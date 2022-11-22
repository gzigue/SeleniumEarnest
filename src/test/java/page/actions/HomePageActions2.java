package page.actions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import page.classes.HomePage2;
import test.suites.TestSuite1;

public class HomePageActions2 extends HomePage2 {

	WebDriver driver;
	WebDriverWait wait;
	
	private static final Logger log = 
			LogManager.getLogger(TestSuite1.class.getName());
	
	public HomePageActions2(WebDriver driver) {
		super(driver);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	public void validateZebraOnCheckout() {
		boolean zebraIsDisplayed = super.zebraSock.isDisplayed();
		if (!zebraIsDisplayed) {
			log.info("Couldn't find Zebra on the page");
		} else {
			log.info("Zebra is on the page");
		}
		Assert.assertTrue(zebraIsDisplayed,
				"Couldn't find Zebra on the page");
	}
	
	public void validateLionOnCheckout() {
		boolean lionIsDisplayed = super.lionSock.isDisplayed();
		if (!lionIsDisplayed) {
			log.info("Couldn't find Lion on the page");
		} else {
			log.info("Lion is on the page");
		}
		Assert.assertTrue(lionIsDisplayed,
				"Couldn't find Lion on the page");
	}
	
	public void validateElephantOnCheckout() {
		boolean elephantIsDisplayed = super.elephantSock.isDisplayed();
		if (!elephantIsDisplayed) {
			log.info("Couldn't find Elephant on the page");
		} else {
			log.info("Elephant is on the page");
		}
		Assert.assertTrue(elephantIsDisplayed,
				"Couldn't find Elephant on the page");
	}
	
	public void validateGiraffeOnCheckout() {
		boolean giraffeIsDisplayed = super.giraffeSock.isDisplayed();
		if (!giraffeIsDisplayed) {
			log.info("Couldn't find Zebra on the page");
		} else {
			log.info("Giraffe is on the page");
		}
		Assert.assertTrue(giraffeIsDisplayed,
				"Couldn't find Giraffe on the page");
	}
	
	public void checkListOfAllItems() {
		validateZebraOnCheckout();
		validateLionOnCheckout();
		validateElephantOnCheckout();
		validateGiraffeOnCheckout();
	}
	
	public void validateSubtotal(double expectedSubtotal) {
		double displayedSubtotal = Double.parseDouble(super.subtotal.getText().substring(1));
		log.info("Expected subtotal: " + expectedSubtotal);
		log.info("Subtotal: " + displayedSubtotal);
		Assert.assertEquals(expectedSubtotal, displayedSubtotal,
				"Subtotal is different from expected subtotal");
		log.info("Subtotal matches expected subtotal");
	}
	
	public void validateTaxes(double expectedTaxes) {
		double displayedTaxes = Double.parseDouble(super.taxes.getText().substring(1));
		log.info("Expected taxes: " + expectedTaxes);
		log.info("Taxes: " + displayedTaxes);
		Assert.assertEquals(expectedTaxes, displayedTaxes,
				"Taxes value is different from expected taxes");
		log.info("Taxes match expected taxes");
	}
	
	public void validateTotal(double expectedTotal) {
		double displayedTotal = Double.parseDouble(super.total.getText().substring(1));
		log.info("Expected total: " + expectedTotal);
		log.info("Total: " + displayedTotal);
		Assert.assertEquals(expectedTotal, displayedTotal,
				"Total is different from expected total");
		log.info("Total matches expected total");
	}
	
	
	
}
