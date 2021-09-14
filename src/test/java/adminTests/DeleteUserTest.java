package adminTests;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BrowseListOfUsers;
import pageObjects.Login;
import pageObjects.Site_Administration;
import resources.Base;

public class DeleteUserTest extends Base{

	 public WebDriver driver = null;
	 @BeforeTest
	 public void setUp() {
		 try {
			driver = initializeDriver();
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
	 
	 @Test
	 public void deleteUser() {
		 driver.manage().window().maximize();
		 
		 //Navigate to the site_Administration page
		 driver.get(prop.getProperty("deletUserUrl"));
		 
		 //Login 
		 Login login = new Login(driver);
		 login.getUserName().sendKeys(prop.getProperty("adminName_1"));
		 login.getPassword().sendKeys(prop.getProperty("admin_1_password"));
		 login.getLoginButton().click();
		 
		 //click on the USERS tab
		 Site_Administration st = new Site_Administration(driver);
		 st.getUserButton().click();
		 
		 //click on the browse list of users 
		 st.getBrowseListOfUsers().click();
		 
		 //search username
		 BrowseListOfUsers bloUsers = new BrowseListOfUsers(driver);
		 bloUsers.getUserFullName().sendKeys(prop.getProperty("userFullName")+" "+prop.getProperty("userSurName"));
		 
		 //click on the filter
		 bloUsers.getAddFilter().click();
		 
		 //preCheck for userFound
		 List<WebElement> list = bloUsers.getNoUserFound();
		 Assert.assertEquals(list.size(), 0);
		 
		 //Scroll down and click on X mark to delete the user
		 
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView()", bloUsers.getXSymbol());
		 bloUsers.getXSymbol().click();
		 
		 //Confirm the deletion by clicking Delete Button
		 
		 bloUsers.getDeleteButton().click();
		 
		 
		 
		 
		 
		 
	 }
	 
	 @AfterTest
	 public void tearDown() {
		 driver.close();
	 }
	
}
