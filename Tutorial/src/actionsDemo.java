import java.io.NotActiveException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class actionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:/Escritorio/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("https://www.ebay.com/");
		Actions a = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement move = driver.findElement(By.cssSelector("a[title='Mi eBay']"));
		WebElement searchInput = driver.findElement(By.id("gh-ac"));
		
		a.moveToElement(searchInput).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//move to specific element
		a.moveToElement(move).contextClick().build().perform();
		//drag and drop
		
		
	}

}
