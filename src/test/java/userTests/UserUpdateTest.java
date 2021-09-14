package userTests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DashBoardPage;
import pageObjects.EditProfile;
import pageObjects.Login;
import pageObjects.UserProfile;
import resources.Base;

public class UserUpdateTest extends Base {
	 public WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
		try {
			driver = initializeDriver();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void userUpdate() {
		driver.manage().window().maximize();
		driver.get(prop.getProperty("userUpdateUrl"));
		
		//login to the page
		Login login = new Login(driver);
		login.getUserName().sendKeys(prop.getProperty("userName_1"));
		login.getPassword().sendKeys(prop.getProperty("userPassword_1"));
		login.getLoginButton().click();
		
		//click on user picture
		DashBoardPage dashboard = new DashBoardPage(driver);
		dashboard.getUserPhoto().click();
		
		//click on profile option
		dashboard.getProfileOption().click();
		
		//click on edit Profile
		UserProfile userProf = new UserProfile(driver);
		userProf.getEditProfile().click();
		
		//Edit the User Profile
		
		EditProfile editProfile = new EditProfile(driver);
//		editProfile.getCityOrTown().sendKeys("Vijayapura");
		Select countryDropdown = new Select(editProfile.getcountryDropDown());
		countryDropdown.selectByValue("KH");
		
		
		//scroll down to update profile
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",editProfile.getUpdateProfileButton());
		editProfile.getUpdateProfileButton().click();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
