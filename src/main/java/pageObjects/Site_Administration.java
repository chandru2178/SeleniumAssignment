package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Site_Administration {

WebDriver driver=null;
 public Site_Administration(WebDriver driver) {
	super();
	this.driver = driver;
}

By userButton =  By.xpath("//a[contains(@href,'linkusers')]");
By newUser = By.xpath("//li/a[text()='Add a new user']");
By courseButton = By.xpath("//a[contains(@href,'linkcourses')]");
By manageCourseCategory = By.xpath("//li/a[text()='Manage courses and categories']");
By browseListOfUsers = By.xpath("//li/a[text()='Browse list of users']");
 
 public WebElement getUserButton() {
	 return driver.findElement(userButton) ;
 }
 
 public WebElement getNewUser() {
	 return driver.findElement(newUser);
 }
 
 public WebElement getCourseButton() {
	 return driver.findElement(courseButton);
 }
 
 public WebElement getManageCAC() {
	 return driver.findElement(manageCourseCategory);
 }
 
 public WebElement getBrowseListOfUsers() {
	 return driver.findElement(browseListOfUsers);
 }
}
