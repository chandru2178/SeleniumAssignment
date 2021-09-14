package adminTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Login;
import pageObjects.Site_Administration;
import pageObjects.User_Details;
import resources.Base;

public class CreateUserTest extends Base {
	public WebDriver driver = null;
	boolean isAlreadyLoggedIn = false;
	private Logger logger = LogManager.getLogger(CreateUserTest.class.getName());
	@BeforeTest
	public void initialize() {
		try {
			logger.info("Trying to initialize the webDriver");
			driver = initializeDriver();
			logger.debug("Hey this might print in in the console");
		} catch (IOException e) {
			logger.error("Driver is not initialized, please look into this");
		}
	}

	@Test(dataProvider = "provideUserData")
	public void createUser(String userName, String password, String fullName, String surName, String email) {

		driver.get(prop.getProperty("createUserUrl"));
		logger.info("url is clicked for user " + userName);
		driver.manage().window().maximize();

		

		// Login as admin
		if (!isAlreadyLoggedIn) {
			Login lg = new Login(driver);
			lg.getUserName().sendKeys(prop.getProperty("adminName_1"));
			lg.getPassword().sendKeys(prop.getProperty("admin_1_password"));
			lg.getLoginButton().click();
			isAlreadyLoggedIn = true;
		}

		// click on UserButton of administration site
		Site_Administration st = new Site_Administration(driver);
		try {
			st.getUserButton().click();
			st.getNewUser().click();

		} catch (Exception e) {
			System.out.println(e.getMessage());

			System.out.println(driver.findElement(By.className("errormessage")).getText());
		}

		// create a user

		User_Details us = new User_Details(driver);
		us.getUserName().sendKeys(userName);
		us.getnewPasswordClick().click();
		us.getNewPassord().sendKeys(password);
		us.getFirstName().sendKeys(fullName);
		us.getSurName().sendKeys(surName);
		us.getEmail().sendKeys(email);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", us.getCreateButton());
		us.getCreateButton().click();

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	@DataProvider
	public Object[][] provideUserData() throws FileNotFoundException {
		Object[][] obj = new Object[1][5];
		obj[0][0] = "chandru1";
		obj[0][1] = "Hari@123";
		obj[0][2] = "Harish";
		obj[0][3] = "M";
		obj[0][4] = "hari@gmail.com";
		
		
		return obj;
	}
}
