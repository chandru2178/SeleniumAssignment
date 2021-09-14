package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class User_Details {

	WebDriver driver = null;

	public User_Details(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	By newPassowrdclick = By.xpath("//img[contains(@src,'passwordunmask-edit')]");
	By newPassword = By.xpath("//input[@id='id_newpassword']");
	By userName = By.xpath("//input[@id='id_username']");
	By firstName = By.xpath("//input[@name='firstname']");
	By surName = By.cssSelector("input[name='lastname']");
	By email = By.cssSelector("input[id='id_email']");
	By createButton = By.xpath("//input[@value='Create user']");
	
	public WebElement getnewPasswordClick() {
		return driver.findElement(newPassowrdclick);
	}
	
	public WebElement getNewPassord() {
		return driver.findElement(newPassword);
	}
	
	public WebElement getUserName() {
		return driver.findElement(userName);
	}
	
	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}
	
	public WebElement getSurName() {
		return driver.findElement(surName);
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getCreateButton() {
		return driver.findElement(createButton);
	}
}
