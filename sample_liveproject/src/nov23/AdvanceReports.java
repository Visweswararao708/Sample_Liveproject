package nov23;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvanceReports {
ExtentReports reports;
ExtentTest logger;
WebDriver driver;
@BeforeTest
public void generateReport()
{
	// define path of html
	reports = new ExtentReports("./Reports/Demo.html");
}
@BeforeMethod
public void setup()
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https:google.com");
}
@Test
public void passtest()
{
	logger = reports.startTest("MyTest Pss");
	logger.assignAuthor("visweswararao");
	String Expected = "Google";
	String Actual = driver.getTitle();
	logger.log(LogStatus.INFO, Expected+"     "+Actual);
	if(Actual.equalsIgnoreCase(Expected))
	{
		logger.log(LogStatus.PASS, "Title is matching");
	}
	else
	{
		logger.log(LogStatus.FAIL, "Title is not matching");
	}
}
@Test
public void failtest()
{
	logger = reports.startTest("My fail test");
	logger.assignAuthor("visweswrarao");
	String Expected = "Gmail";
	String Actual = driver.getTitle();
	logger.log(LogStatus.INFO, Expected+"    "+Actual);
	if(Actual.equalsIgnoreCase(Expected))
	{
		logger.log(LogStatus.PASS, "Title is matching");
	}
	else 
	{
		logger.log(LogStatus.FAIL, "Title is not matching");
	}
}
@AfterMethod
public void tearDown()
{
	reports.endTest(logger);
	reports.flush();
	driver.quit();
}
}
