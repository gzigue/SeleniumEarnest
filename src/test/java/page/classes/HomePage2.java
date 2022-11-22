package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage2 {

	public final String URL = "http://www.google.com";
	
	WebDriver driver;

	public HomePage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".line_item.zebra")
	protected WebElement zebraSock;
	@FindBy(css=".line_item.lion")
	protected WebElement lionSock;
	@FindBy(css=".line_item.elephant")
	protected WebElement elephantSock;
	@FindBy(css=".line_item.giraffe")
	protected WebElement giraffeSock;
	@FindBy(id="subtotal")
	protected WebElement subtotal;
	@FindBy(id="taxes")
	protected WebElement taxes;
	@FindBy(id="total")
	protected WebElement total;
	
}
