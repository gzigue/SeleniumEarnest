package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public final String URL = "https://jungle-socks.herokuapp.com/";
	
	WebDriver driver;
	
	@FindBy(id="line_item_quantity_zebra")
	protected WebElement zebraTextBox;
	@FindBy(id="line_item_quantity_lion")
	protected WebElement lionTextBox;
	@FindBy(id="line_item_quantity_elephant")
	protected WebElement elephantTextBox;
	@FindBy(id="line_item_quantity_giraffe")
	protected WebElement girapheTextBox;
	@FindBy(name="commit")
	protected WebElement checkoutButton;
	@FindBy(css=".line_item.zebra > td:nth-child(2)")
	protected WebElement zebraPrice;
	@FindBy(css=".line_item.lion > td:nth-child(2)")
	protected WebElement lionPrice;
	@FindBy(css=".line_item.elephant > td:nth-child(2)")
	protected WebElement elephantPrice;
	@FindBy(css=".line_item.giraffe > td:nth-child(2)")
	protected WebElement giraphePrice;
	@FindBy(name="state")
	protected WebElement stateDropdown;
	
	@FindBy(xpath="//div//li//a[@class='qa-Cl_Menu c-site-nav-main-link-1']")
	protected WebElement linkCardapio;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
