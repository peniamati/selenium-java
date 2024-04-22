import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Excercise2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/Escritorio/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.xpath("//form //input[@name='name']")).sendKeys("Matias");
		driver.findElement(By.cssSelector("[name='email']")).sendKeys("matias@mail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("pass123");
		driver.findElement(By.id("exampleCheck1")).click();
		Assert.assertTrue(driver.findElement(By.id("exampleCheck1")).isSelected());
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Male')]")).click();
		driver.findElement(By.id("inlineRadio1")).click();
		Assert.assertTrue(driver.findElement(By.id("inlineRadio1")).isSelected());
		driver.findElement(By.name("bday")).sendKeys("1995-09-26");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//strong")).getText(), "Success!");
		driver.quit();
		
	}
	
}
