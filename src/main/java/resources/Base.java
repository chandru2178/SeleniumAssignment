package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	
	public WebDriver driver=null;
	public Properties prop = null;
	
	
	
	public WebDriver initializeDriver() throws IOException {
		prop  = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\CHANDRA\\eclipse-workspace\\assingment_qualicoach\\src\\main\\java\\resources\\data1.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/CHANDRA/Downloads/chromedriver.exe");
			driver =new ChromeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void getScreenShotPath(String testName,WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File ft = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testName+".png";
		try {
			FileUtils.copyFile(ft, new File(destinationFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//clean the answers list to get the answers as String
	public List<String> cleanAnswerList(List<WebElement> answers) {
		List<String> answerList = new ArrayList<String>();
		
		for(int i=0;i<answers.size()-1;i++) {
			answerList.add(answers.get(i).getText().substring(3).trim());
		}
		return answerList;
	}
}
