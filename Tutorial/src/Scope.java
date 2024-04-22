import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:/Escritorio/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1.Give me the count of links on the page.
		//a
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2.Count of footer links
		
		//My way
//		System.out.println(driver.findElements(By.cssSelector("div[id='gf-BIG'] a")).size());
		
		//Way of the video
		WebElement footerDriverElement = driver.findElement(By.id("gf-BIG")); //Limiting webdriver scope
		System.out.println(footerDriverElement.findElements(By.tagName("a")).size());
		
		//3.Count of
		WebElement columnDriverElement = footerDriverElement.findElement(By.tagName("ul"));
		System.out.println(columnDriverElement.findElements(By.tagName("a")).size());
		
		//4.Click on each link in the column and check if the pages are opening
		//My way
//		List<WebElement> columnLinkSet = columnDriverElement.findElements(By.tagName("a"));
//		for (WebElement linkElement :columnLinkSet) {
//			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
//			linkElement.sendKeys(clickOnLinkTab);
//			Thread.sleep(5000);
//		}//opens all the tabs
//		
//		Set<String> abc = driver.getWindowHandles();
//		Iterator<String> it = abc.iterator();
//		while (it.hasNext()) {
//			driver.switchTo().window(it.next());
//			System.out.println(driver.getTitle());
//		}
		
		//Way of the video
		for(int i=1;i < columnDriverElement.findElements(By.tagName("a")).size(); i++){
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnDriverElement.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(5000);
		}
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		
	}

}
