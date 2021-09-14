package userTests;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CoursePage;
import pageObjects.Login;
import pageObjects.UserHome;
import resources.Base;

public class CertificateTest extends Base {

	WebDriver driver = null;

	@BeforeTest
	public void setup() {
		try {
			driver = initializeDriver();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void certificateDownload() {
		// maximize the window
		driver.manage().window().maximize();
		driver.get(prop.getProperty("loginUrl"));

		// Login to the site
		Login login = new Login(driver);
		login.getUserName().sendKeys(prop.getProperty("userName_1"));
		login.getPassword().sendKeys(prop.getProperty("userPassword_1"));
		login.getLoginButton().click();

		// slide the page so you can view courses available
		UserHome uh = new UserHome(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView()", uh.getWhatWeOffer());
		List<WebElement> list = uh.getCourseList();
		ListIterator<WebElement> itr = list.listIterator();
		Actions act = new Actions(driver);

		while (itr.hasNext()) {
			WebElement webElement = (WebElement) itr.next();
			act.moveToElement(webElement).build().perform();
			if (webElement.getText().equalsIgnoreCase(prop.getProperty("userCourseName"))) {
				webElement.click();
				break;
			}

		}

		// now you are in course page
		CoursePage course = new CoursePage(driver);
		course.getCertificateSection().click();
		course.getCertificateDownload().click();
		course.getCustomCertificate().click();

	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
