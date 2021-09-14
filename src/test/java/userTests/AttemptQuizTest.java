package userTests;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CoursePage;
import pageObjects.Login;
import pageObjects.SummuryOfAttempt;
import pageObjects.UserHome;
import resources.AnswerList;
import resources.Base;

public class AttemptQuizTest extends Base {

	public WebDriver driver = null;

	@BeforeTest
	public void setUp() {
		try {
			driver = initializeDriver();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void attemptQuiz() {
		driver.manage().window().maximize();
		driver.get(prop.getProperty("loginUrl"));

		driver.manage().deleteAllCookies();

		// Login
		Login login = new Login(driver);
		login.getUserName().sendKeys("user217");
		login.getPassword().sendKeys("User@3902");
		login.getLoginButton().click();

		// slide the page so you can view courses available
		UserHome uh = new UserHome(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView()", uh.getWhatWeOffer());
		List<WebElement> list = uh.getCourseList();
		ListIterator<WebElement> itr = list.listIterator();
		Actions act = new Actions(driver);

		while (itr.hasNext()) {
			WebElement webElement = (WebElement) itr.next();
			act.moveToElement(webElement).build().perform();
			if (webElement.getText().equalsIgnoreCase("ISTQB-ISEB")) {
				webElement.click();
				break;
			}

		}

		//to solve staleElement reference problem use the count variable
		
		CoursePage course = new CoursePage(driver);
		
		int moduleCount = course.getModuleList().size();
		int inc = 0;
//		ListIterator<WebElement> moduleItr = moduleList.listIterator();
//		ListIterator<WebElement> quizItr = quizList.listIterator();

		// Random class object ot to generate random numbers
		Random rd = new Random();
//		List<WebElement> moduleList = course.getModuleList();
//		for(WebElement ele:moduleList) {
//			ele.click();
//		}
		
		while (inc!=moduleCount) {
//			List<WebElement> moduleList = course.getModuleList();
			List<WebElement> quizList = course.getQuizList();
//			WebElement module = (WebElement) moduleList.get(inc);
			WebElement quiz = (WebElement) quizList.get(inc);
//			if () {
//				quiz.click();
//			} else {
//				module.click();
			List<WebElement> moduleList = course.getModuleList();
			for(WebElement ele:moduleList) {
				ele.click();
			}
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", quiz);
				quiz.click();
//			}
			course.getAttemptButton().click();
			course.getAttemptFinalButton().click();

//			FileInputStream answerFile=null;
//			try {
//				answerFile = new FileInputStream("C:\\Users\\CHANDRA\\eclipse-workspace\\assingment_qualicoach\\src\\main\\java\\resources\\QuizAnswers");
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//			Scanner input = new Scanner(answerFile);
//			
//			int k=0;
			HashMap<String,String> ansList = AnswerList.getAnswerList();
			while (course.getNextButtonList().size() == 1 || course.getFinishButtonList().size() == 1) {
				List<WebElement> answerWebList = course.getAnswerList();
				List<String> answerList = cleanAnswerList(answerWebList);
			
				
				String question = course.getQuestion();
				String answer = null;
				if(ansList.containsKey(question)) {
					answer = (String)ansList.get(question);
					answerWebList.get(answerList.indexOf(answer)).click();
				}
				else {
					int ans = Math.abs(rd.nextInt()) % 4;
					answerWebList.get(ans).click();
				}
				
				int nextCount =course.getNextButtonList().size();
				int finishCount = course.getFinishButtonList().size();
				if (nextCount == 1) {
					js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView()", course.getNextPageButton());
					course.getNextPageButton().click();
				} else {
					js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView()", course.getFinishAttemptButton());
					course.getFinishAttemptButton().click();
				}

//				ListIterator<String> answeritr = answerList.listIterator();
//				String option = input.nextLine();

//				while(answeritr.hasNext()) {
//				  	
//					if(option.equalsIgnoreCase(answerList.get(k))) {
//						answerWebList.get(k).click();
//						if(course.getNextButtonList().size()==1) {
//							course.getNextPageButton().click();
//						}
//						else {
//							course.getFinishAttemptButton().click();
//						}
//						
//						break;
//					}
//					else {
//						k=k+1;
//					}
//				}

			
			}
			SummuryOfAttempt soa = new SummuryOfAttempt(driver);
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView()", soa.getSubmitAllAndFinishButton());
			soa.getSubmitAllAndFinishButton().click();
			soa.confirmSubmitAllAndFinishButton().click();
			
			//click on finish review button at the bottom of the page
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView()", course.getFinishReview());
			course.getFinishReview().click();
			
			//move to the next module and quiz
			inc = inc + 1;
		}

	}

	@AfterTest
	public void tearDown() {
//		driver.close();
	}
}
