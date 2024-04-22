import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/Escritorio/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//implicit wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		Thread.sleep(3000);
		
		addItems(driver, itemsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
//		driver.quit();

	}
	
	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		int count = 0;

		for (int i = 0; i < products.size(); i++) {
			String nameString = products.get(i).getText();
			// Format it to get actual vegetable name
			String[] name = nameString.split("-");
			String nameFormatted = name[0].trim();
			
			// Check whether name you extracted is present in array or not
			// Convert array into array list for easy search

			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			
			if (itemsNeededList.contains(nameFormatted)) {
				count++;
				// Click on add to cart
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// 3 times

				if (count == itemsNeeded.length) {
					break;
				}

			}
		}
		
	}

}
