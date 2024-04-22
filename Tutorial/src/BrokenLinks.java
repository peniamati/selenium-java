import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:/Escritorio/chromedriver-win64/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		// Broken URL
		//Step 1 - Is to get all urls tied up to the links using Selenium
		// Java Methods will call URLs and gets you the status code
		// If status code >400 then that url is not working -> link which tied to url is broken
//	 	String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
//		
//	 	HttpURLConnection conn = (HttpURLConnection) new URI(url).toURL().openConnection();			
//	 	conn.setRequestMethod("HEAD");			
//	 	conn.connect();			
//	 	int responseCode = conn.getResponseCode();	
//	 	System.out.println(responseCode);
	 	
	 	List<WebElement> links = driver.findElements(By.cssSelector("#gf-BIG a"));
	 	SoftAssert a = new SoftAssert();
	 	for (WebElement link :links){
	 		String urlLink = link.getAttribute("href");
	 		
	 		HttpURLConnection conn = (HttpURLConnection) new URI(urlLink).toURL().openConnection();			
		 	conn.setRequestMethod("HEAD");			
		 	conn.connect();			
		 	int responseCode = conn.getResponseCode();	
		 	System.out.println(responseCode);
		 	a.assertTrue(responseCode<400, "The link with text " + link.getText() + " is broken with code " + responseCode);
		 	
	 	}
	 	a.assertAll();
	 			
		
	}

}
