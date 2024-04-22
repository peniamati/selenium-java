package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {
	
	@Parameters({"URL", "APIKey/username"})
	@Test
	public void WebloginCarloan(String urlname, String key) {
		//selenium
		System.out.println("weblogincar");
		System.out.println(urlname);
		System.out.println(key);
	}
	
	@BeforeMethod
	public void Beforeevery() {
		System.out.println("I will execute before every test method in day 3 class");
	}
	
	@AfterMethod
	public void Afterevery() {
		System.out.println("I will execute after every test method in day 3 class");
	}
	
	@AfterClass
	public void AfterClass() {
		System.out.println("After executing all methods in the class");
	}
	
	@Test(groups = {"Smoke"})
	public void MobileLoginCarloan() {
		//Appium
		System.out.println("mobilelogincar");
	}
	
	@BeforeSuite
	public void Bfsuite() {
		System.out.println("I am no 1");
	}
	
	@Test(enabled = false)
	public void MobileSigninCarloan() {
		//Appium
		System.out.println("mobilesignincar");
	}
	
	@Test(dataProvider = "getData")
	public void MobileSignoutCarloan(String username, String password) {
		//Appium
		System.out.println("mobilesignoutcar");
		System.out.println(username);
		System.out.println(password);
	}
	
	@Test(dependsOnMethods = {"WebloginCarloan", "MobileSignoutCarloan"})
	public void APIcarLoan() {
		//Rest API automation
		System.out.println("APIlogincar");
	}
	
	@DataProvider
	public Object[][] getData() {
		//1st combination - username password - good credit history
		//2nd - username password - no credit history
		//3rd - fraudulent credit history
		Object[][] data = new Object[3][2];
		//1st set
		data[0][0] = "firstsetusername";
		data[0][1] = "password";
		//columns in the row are nothing but values for that particular combination (row)
		
		//2nd set
		data[1][0] = "secondsetusername";
		data[1][1] = "secondpassword";
		
		//3rd set
		data[2][0] = "thirdsetusername";
		data[2][1] = "thirdpassword";
		
		return data;
		
	}

}
