import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Excercise3 {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:/Escritorio/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.cssSelector("input[value='user']+span")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("modal-content"))));
		driver.findElement(By.id("okayBtn")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='user']+span")).isEnabled());
		driver.findElement(By.cssSelector("select")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select option[value='consult']")));
		driver.findElement(By.cssSelector("select option[value='consult']")).click();
		driver.findElement(By.id("terms")).click();
		Assert.assertTrue(driver.findElement(By.id("terms")).isSelected());
		driver.findElement(By.id("signInBtn")).click();
		wait.until(ExpectedConditions.urlMatches("https://rahulshettyacademy.com/angularpractice/shop"));
		List<WebElement> buttonsAdd = driver.findElements(By.cssSelector(".btn.btn-info"));
		for (WebElement button :buttonsAdd) {
			button.click();
		}
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
		driver.quit();
		
	}

}
