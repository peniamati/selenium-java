import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		FirefoxOptions options1 = new FirefoxOptions();
//		options1.setAcceptInsecureCerts(true);
//		
//		EdgeOptions options2 = new EdgeOptions();
//		options2.setAcceptInsecureCerts(true);
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipadress:4444");
		options.setCapability("proxy", proxy);
		
//		Set download directory
//		Map<String, Object> prefs = new HashMap<String, Object>();
//
//		prefs.put("download.default_directory", "/directory/path");
//
//		options.setExperimentalOption("prefs", prefs);
		
		System.setProperty("webdriver.chrome.driver", "D:/Escritorio/chromedriver-win64/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
	}

}
