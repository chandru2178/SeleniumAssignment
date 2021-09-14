package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHome {

	WebDriver driver = null;

	public UserHome(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	By whatWeOffer = By.xpath("//h4[text()='What we offer']");
	By courseList = By.xpath("//div/a[@class='transparent_hover']/p");
	
	public WebElement getWhatWeOffer() {
		return driver.findElement(whatWeOffer);
	}
	
	public List<WebElement> getCourseList(){
		return driver.findElements(courseList);
	}
	
	
	
}
