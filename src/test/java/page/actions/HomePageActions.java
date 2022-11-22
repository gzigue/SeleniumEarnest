package page.actions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.classes.HomePage;
import test.suites.TestSuite1;

public class HomePageActions extends HomePage {

	WebDriver driver;
	WebDriverWait wait;
	
	private static final Logger log = 
			LogManager.getLogger(TestSuite1.class.getName());
	
	public HomePageActions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	public void enterZebraQuantity(String qty) {
		log.info("Entering " + qty + " item(s) on the Zebra text box");
		super.zebraTextBox.sendKeys(qty);
	}
	
	public void enterLionQuantity(String qty) {
		log.info("Entering " + qty + " item(s) on the Lion text box");
		super.lionTextBox.sendKeys(qty);
	}
	
	public void enterElephantQuantity(String qty) {
		log.info("Entering " + qty + " item(s) on the Elephant text box");
		super.elephantTextBox.sendKeys(qty);
	}
	
	public void enterGirapheQuantity(String qty) {
		log.info("Entering " + qty + " item(s) on the Giraphe text box");
		super.girapheTextBox.sendKeys(qty);
	}
	
	public void selectState(String state) {
		log.info("Selecting \"" + state + "\" on the state dropdown");
		Select sel = new Select(super.stateDropdown);
		sel.selectByValue(state);
	}
	
	public void clickCheckoutButton() {
		log.info("Clicking the checkout button");
		super.checkoutButton.click();
	}
	
	public void clickCardapio() {
		super.linkCardapio.click();
	}
 	
	public double expectedSubtotal() {
		double subtotal = Double.parseDouble(super.zebraPrice.getText())
					+ Double.parseDouble(super.lionPrice.getText())
					+ Double.parseDouble(super.elephantPrice.getText())
					+ Double.parseDouble(super.giraphePrice.getText());
		
		return subtotal;
	}
	
	public double expectedTaxes(String state) {
		double taxes;
		
		if (state.equals("CA")){
			taxes = expectedSubtotal()*0.08;
		} else if (state.equals("NY")) {
			taxes = expectedSubtotal()*0.06;
		} else if (state.equals("MN")) {
			taxes = expectedSubtotal();
		} else {
			taxes = expectedSubtotal()*0.05;
		}
		
		return taxes;
	}
	
	public double expectedTotal(String state) {
		double total = expectedSubtotal()+expectedTaxes(state);
		
		return total;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
