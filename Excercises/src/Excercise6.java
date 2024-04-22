import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Excercise6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:/Escritorio/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1.Select any checkbox
		driver.findElement(By.id("checkBoxOption1")).click();
		//2.Grab the label of selected checkbox //put into a variable
		String labelString = driver.findElement(By.cssSelector("label[for='bmw']")).getText();
		//3.Select an option in dropdown. Here option to select should come from step 2 //Do not hard code text
		driver.findElement(By.id("dropdown-class-example")).click();
		WebElement labelStringOption = driver.findElement(By.xpath("//option[@value='" + labelString.toLowerCase() + "']"));
		wait.until(ExpectedConditions.visibilityOf(labelStringOption));
		labelStringOption.click();
		//4.Enter the step 2 grabbed label text in Editbox
		driver.findElement(By.id("name")).sendKeys(labelString);
		//5.Click alert and then verify if text grabbed from step 2 is present in the pop up message
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		String[] alertTextSplitted = alertText.split(",");
		System.out.println(alertTextSplitted[0].split(" ")[1]);
	}

}
