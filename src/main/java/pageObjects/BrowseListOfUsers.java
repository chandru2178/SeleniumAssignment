package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowseListOfUsers {

	WebDriver driver = null;

	public BrowseListOfUsers(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	By userFullName = By.xpath("//input[@id='id_realname']");
	By addFilter = By.xpath("//input[@id='id_addfilter']");
	By noUserFound = By.xpath("//div[@role='main']/h2[2]");
	By xSymbol = By.xpath("//img[@title='Delete']");
	By deleteButton = By.xpath("//input[@value='Delete']");
	
	public WebElement getUserFullName() {
		return driver.findElement(userFullName);
	}
	
	public WebElement getAddFilter() {
		return driver.findElement(addFilter);
	}
	
	public List<WebElement> getNoUserFound() {
		return driver.findElements(noUserFound);
	}
	
	public WebElement getXSymbol() {
		return driver.findElement(xSymbol);
	}
	
	public WebElement getDeleteButton() {
		return driver.findElement(deleteButton);
	}
	
}
