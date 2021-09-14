package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CourseAndCatogoryManagement {

	public WebDriver driver = null;

	public CourseAndCatogoryManagement(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	By createNewCategory = By.xpath("//a[text()='Create new category']");
	By createNewCourse = By.xpath("//a[text()='Create new course']");
	By getAllCategoryObj = By.className(".float-left.categoryname");
	
	
	
	
	
	
	public WebElement getCreateNewCategory() {
		return driver.findElement(createNewCategory);
	}
	
	public WebElement getCreateNewCourse() {
		return driver.findElement(createNewCourse);
	}
	
	public List<WebElement> getAllCategory() {
		return driver.findElements(getAllCategoryObj);
	}
}
