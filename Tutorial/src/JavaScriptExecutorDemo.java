import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:/Escritorio/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		WebElement table = driver.findElement(By.className("tableFixHead"));
		
		List<WebElement> values = table.findElements(By.cssSelector("td:nth-child(4)"));
		
		int sum = 0;
		for (WebElement value :values) {
			sum += Integer.parseInt(value.getText());
		}
		
		String amount = driver.findElement(By.className("totalAmount")).getText();
		String[] amountSplitted = amount.split(": ");
		int amountInt = Integer.parseInt(amountSplitted[1]);
		Assert.assertEquals(amountInt, sum);
		driver.quit();
		
	}

}
