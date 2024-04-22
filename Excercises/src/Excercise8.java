
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Excercise8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/Escritorio/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1.Enter 3 letters and move mouse to a country and check is in the input
		WebElement suggestionInput = driver.findElement(By.id("autocomplete"));
		suggestionInput.sendKeys("ind");
		Thread.sleep(3000);
		suggestionInput.sendKeys(Keys.DOWN);
		suggestionInput.sendKeys(Keys.DOWN);
		Assert.assertEquals(suggestionInput.getAttribute("value"), "India");
		driver.quit();
		
	}

}
