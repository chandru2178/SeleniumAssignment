package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummuryOfAttempt {
	public WebDriver driver = null;

	public SummuryOfAttempt(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	By submitAllAndFinish = By.xpath("//input[@value='Submit all and finish']");
	By confirmSAF = By.xpath("//div[@class='confirmation-buttons form-inline justify-content-around']/input[@value='Submit all and finish']");
	
	
	public WebElement getSubmitAllAndFinishButton() {
		return driver.findElement(submitAllAndFinish);
	}
	
	public WebElement confirmSubmitAllAndFinishButton() {
		return driver.findElement(confirmSAF);
	}
}
