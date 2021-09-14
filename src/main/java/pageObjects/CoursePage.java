package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursePage{

	WebDriver driver = null;

	public CoursePage(WebDriver driver) {
		super();
		this.driver = driver;
		
	}
	
	By enrollButton = By.xpath("//input[@id='id_submitbutton']");
	By moduleName = By.xpath("//li[@class='allsectionnames']/a[contains(text(),'Module')]");
	By quiz = By.xpath("//div[contains(text(),'Quiz')]");
	By attempt = By.xpath("//input[@value='Attempt quiz now']");
	By attempt_quiz =  By.xpath("//input[@id='id_submitbutton']");
	By nextPage = By.xpath("//input[@value='Next page']");
	By answerList = By.xpath("//label");
	By finishAttempt = By.xpath("//div[@class='submitbtns']/input[@value='Finish attempt ...']");
	By finishReview = By.xpath("//div[@class='submitbtns']/a[contains(text(),'Finish review')]");
	By question = By.cssSelector("div.qtext");
	By badgeAndFeedback = By.xpath("//a[contains(text(),'Badge & Feedback')]");
	By badge = By.xpath("//div[contains(text(),'Click here to')]");
	By certificateSec = By.xpath("//a[contains(text(),'Certificate')]");
	By certificate = By.xpath("//div[contains(text(),'Certificate')]");
	By customCertificate = By.xpath("//input[@value='Get your custom certificate']");
	
	public WebElement getEnrollButoon() {
		return driver.findElement(enrollButton);
	}
	
	public List<WebElement> getModuleList() {
		return driver.findElements(moduleName);
	}
	
	public List<WebElement> getQuizList() {
		return driver.findElements(quiz);
	}
	
	public WebElement getAttemptButton() {
		return driver.findElement(attempt);
	}
	
	public WebElement getAttemptFinalButton() {
		return driver.findElement(attempt_quiz);
	}
	
	public WebElement getNextPageButton() {
		return driver.findElement(nextPage);
	}
	
	public List<WebElement> getAnswerList(){
		return driver.findElements(answerList);
	}
	
	public WebElement getFinishAttemptButton() {
		return driver.findElement(finishAttempt);
	}
	
	public List<WebElement> getNextButtonList(){
		return driver.findElements(nextPage);
	}
	
	public List<WebElement> getFinishButtonList(){
		return driver.findElements(finishAttempt);
	}
	
	public WebElement getFinishReview() {
		return driver.findElement(finishReview);
	}
	
	public String getQuestion() {
		
		return driver.findElement(question).getText();
	}
	
	public WebElement getBadgeAndFeedbackSection() {
		return driver.findElement(badgeAndFeedback);
	}
	
	public WebElement getCertificateSection() {
		return driver.findElement(certificateSec);
	}
	
	public WebElement getCertificateDownload() {
		return driver.findElement(certificate);
	}
	
	public WebElement getCustomCertificate() {
		return driver.findElement(customCertificate);
	}
	
	public WebElement getBadge() {
		return driver.findElement(badge);
	}
}
