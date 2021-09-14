package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewCategory {

	public WebDriver driver = null;

	public NewCategory(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	By parentCategory = By.xpath("//select[@id='id_parent']");
	By categoryName = By.xpath("//input[@id='id_name']");
	By createCategoryButton = By.xpath("//input[@id='id_submitbutton']");
	
	
	
	public WebElement getParentCategory() {
		return driver.findElement(parentCategory);
	}
	
	public WebElement getCategoryName() {
		return driver.findElement(categoryName);
	}
	
	public WebElement getCreateCategoryButton() {
		return driver.findElement(createCategoryButton);
	}
}
