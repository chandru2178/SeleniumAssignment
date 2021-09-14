package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewCourse {

	public WebDriver driver = null;

	public NewCourse(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	By courseFullName = By.xpath("//input[@id='id_fullname']");
	By courseShortName = By.xpath("//input[@id='id_shortname']");
	By saveAndDisplayButton = By.xpath("//input[@id='id_saveanddisplay']");
	
	public WebElement getCourseFullName() {
		return driver.findElement(courseFullName);
	}
	
	public WebElement getCourseShortName() {
		return driver.findElement(courseShortName);
	}
	
	public WebElement getSaveAndDisplayButton() {
		return driver.findElement(saveAndDisplayButton);
	}
}
