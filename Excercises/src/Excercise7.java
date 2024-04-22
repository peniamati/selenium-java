import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excercise7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:/Escritorio/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0, 570)");
		
		//1.Print number of rows
		WebElement table = driver.findElement(By.cssSelector("table[name='courses']"));
		System.out.println(table.findElements(By.tagName("tr")).size());
		//2.Print number of columns
		System.out.println(table.findElements(By.tagName("th")).size());
		//3.Print 2 row
		System.out.println(table.findElement(By.cssSelector("tr:nth-child(3)")).getText());
		driver.quit();
	}

}
