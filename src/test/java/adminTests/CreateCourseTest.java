package adminTests;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CourseAndCatogoryManagement;
import pageObjects.Login;
import pageObjects.NewCategory;
import pageObjects.NewCourse;
import pageObjects.Site_Administration;
import resources.Base;

public class CreateCourseTest extends Base{
	 public WebDriver driver=null;
	public Logger logger = LogManager.getLogger(CreateCourseTest.class.getName());
	boolean isAlreadyLoggedIn=false;
	@BeforeTest
	public void setUp() {
		try {
			logger.info("Trying to initialize the webDriver");
			driver = initializeDriver();
			logger.debug("Hey this might print in in the console");
		} catch (IOException e) {
			logger.error("Driver is not initialized, please look into this");
		}
	}
	@Test
	public void createCourse() {
		driver.get(prop.getProperty("createCourseUrl"));
//		logger.info("url is clicked for user " );
		driver.manage().window().maximize();

		if (!isAlreadyLoggedIn) {
			Login lg = new Login(driver);
			lg.getUserName().sendKeys(prop.getProperty("adminName_1"));
			lg.getPassword().sendKeys(prop.getProperty("admin_1_password"));
			lg.getLoginButton().click();
			isAlreadyLoggedIn = true;
		}

		//click on the course
		Site_Administration st = new Site_Administration(driver);
		st.getCourseButton().click();
		st.getManageCAC().click();
		
		CourseAndCatogoryManagement cac = new CourseAndCatogoryManagement(driver);
		cac.getCreateNewCategory().click();
		
		//create New Category
		NewCategory ncategory = new NewCategory(driver);
		Select staticSelect = new Select(ncategory.getParentCategory());
		staticSelect.selectByIndex(3);
		ncategory.getCategoryName().sendKeys(prop.getProperty("categoryName"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", ncategory.getCreateCategoryButton());
		ncategory.getCreateCategoryButton().click();
		
		//click on the category created
		List<WebElement> categories = cac.getAllCategory();
		ListIterator<WebElement> itr = categories.listIterator();
		while (itr.hasNext()) {
			WebElement webElement = (WebElement) itr.next();
			if(webElement.getText().equalsIgnoreCase(prop.getProperty("categoryName"))) {
				webElement.click();
				break;
			}
		}
		//create New Course
		cac.getCreateNewCourse().click();
		NewCourse nCourse = new NewCourse(driver);
		nCourse.getCourseFullName().sendKeys(prop.getProperty("courseFullName"));
		nCourse.getCourseShortName().sendKeys(prop.getProperty("courseShortName"));
		js.executeScript("arguments[0].scrollIntoView()", nCourse.getSaveAndDisplayButton());
		nCourse.getSaveAndDisplayButton().click();
		
		
		
	}
	
	@AfterTest
	public void clean() {
		driver.close();
	}
}
