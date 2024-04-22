import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excercise5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:/Escritorio/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		WebElement frameTop = driver.findElement(By.cssSelector("frame[name='frame-top']"));		
		driver.switchTo().frame(frameTop);
		
		WebElement frameMiddle = driver.findElement(By.cssSelector("frame[name='frame-middle']"));
		driver.switchTo().frame(frameMiddle);
		
		System.out.println(driver.findElement(By.id("content")).getText());
		
	}

}
