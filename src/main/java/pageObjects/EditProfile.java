package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProfile {

	WebDriver driver = null;

	public EditProfile(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	By cityOrTown = By.xpath("//input[@id=\"id_city\"]");
	By countryDropDown = By.xpath("//select[@id='id_country']");
	By updateProfile = By.xpath("//input[@id='id_submitbutton']");
	
	public WebElement getCityOrTown() {
		return driver.findElement(cityOrTown);
	}
	
	public WebElement getcountryDropDown() {
		return driver.findElement(countryDropDown);
	}
	
	public WebElement getUpdateProfileButton() {
		return driver.findElement(updateProfile);
	}
}
