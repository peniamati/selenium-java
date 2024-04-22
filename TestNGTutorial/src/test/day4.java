package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day4 {
	
	@Parameters({"URL"})
	@Test
	public void WebloginCarloan(String urlname) {
		//selenium~
		System.out.println("webloginhomepersonalloan");
		System.out.println(urlname);
	}
	
	@Test(groups = {"Smoke"})
	public void MobileLoginCarloan() {
		//Appium
		System.out.println("mobileloginhome");
	}
	
	@Test
	public void LoginAPIcarLoan() {
		//Rest API automation
		System.out.println("APIloginhome");
	}
}
