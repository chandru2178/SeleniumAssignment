package userTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Login;
import resources.Base;

public class UserLoginTest extends Base {
	public WebDriver driver = null;
	@BeforeTest
	public void setUpLogin() {
		try {
			driver = initializeDriver();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test
	public void loginTest() {
		driver.get(prop.getProperty("loginUrl"));
		System.out.println(driver.getTitle());
		Login login = new Login(driver);
		login.getUserName().sendKeys(prop.getProperty("userName_1"));
		login.getPassword().sendKeys(prop.getProperty("userPassword_1"));
		login.getLoginButton().click();
		System.out.println(driver.getTitle());
		
	}
	
	@AfterTest
	public void closeLogin() {
		driver.close();
	}
}
