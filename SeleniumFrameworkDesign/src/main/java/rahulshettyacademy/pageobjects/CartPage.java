package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CartPage  extends AbstractComponents{

	WebDriver driver;
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutElement;
	
	@FindBy(css = ".cartSection h3")
	private List<WebElement> productTitles;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyProductDisplay(String productName) {
		Boolean match = productTitles.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout() {
		checkoutElement.click();
		return new CheckoutPage(driver);
	}
	
	
	
}
