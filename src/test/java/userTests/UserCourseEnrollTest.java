package userTests;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CoursePage;
import pageObjects.Login;
import pageObjects.UserHome;
import resources.Base;

public class UserCourseEnrollTest extends Base {
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
	public void enrollToCourse() {
		driver.get(prop.getProperty("loginUrl"));
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		
		//Login to qualicourse
		
		Login login = new Login(driver);
		login.getUserName().sendKeys(prop.getProperty("userName_1"));
		login.getPassword().sendKeys(prop.getProperty("userPassword_1"));
		login.getLoginButton().click();
		
		//Enroll to the course
		
		UserHome uh =new UserHome(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView()", uh.getWhatWeOffer());
		List<WebElement> list = uh.getCourseList();
		ListIterator<WebElement> itr = list.listIterator();
		
		while (itr.hasNext()) {
			WebElement webElement = (WebElement) itr.next();
			act.moveToElement(webElement).build().perform();
			if(webElement.getText().equalsIgnoreCase(prop.getProperty("userCourseName"))) {
				webElement.click();
				break;
			}
			
			
		}
		
		CoursePage etc = new CoursePage(driver);
		Assert.assertTrue(etc.getEnrollButoon().isDisplayed());
//		etc.getEnrollButoon().submit();
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
