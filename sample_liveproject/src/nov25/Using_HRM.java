package nov25;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Using_HRM {
	ExtentReports reports;
	ExtentTest logger;
	WebDriver driver;
	@BeforeTest
	public void setup() 
	{
	// define path of html report
		reports = new ExtentReports("./ExtentReports./login.html");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "dp")
	public void verifylogin(String user,String pass)throws Throwable{
		// test case starts here
		logger = reports.startTest("Validate login test");
		logger.assignAuthor("visweswararao");
		driver.get("http://orangehrm.qedgetech.com/");
		driver.findElement(By.name("txtUsername")).sendKeys(" user");
		driver.findElement(By.name("txtPassword")).sendKeys("pass");
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		String Expected = "dashboard";
		String Actual = driver.getCurrentUrl();
		logger.log(LogStatus.INFO,user+"   " +pass);
		if(Actual.contains(Expected))
		{
			logger.log(LogStatus.PASS, "valid credentials");
		}
		else 
		{
			// capture error message
			String Errormessage = driver.findElement(By.id("spanMessage")).getText();
			logger.log(LogStatus.FAIL, Errormessage);	
		}
	
	}

	@DataProvider
	public Object[][] dp() {
		// store login data
		Object login [][]= {{"Admin","Qedge123!@#"},{"test","Qedge123!@#"},{"","Qedge123!@#"},{"Admin",""},
				{"Admin","Qedge"}};
		return login;
	}
	@AfterTest
	public void afterTest() {
		reports.endTest(logger);
		reports.flush();
		driver.quit();
	}

}
