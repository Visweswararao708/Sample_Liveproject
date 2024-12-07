package nov22;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Using_properties {
	WebDriver driver;
	Properties conpro;
	@Test
	public void starttest()throws Throwable{
	
		conpro = new Properties();
		// load property file
		conpro.load(new FileInputStream("Login.properties"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(conpro.getProperty("Url"));
		driver.findElement(By.xpath(conpro.getProperty("Objuser"))).sendKeys(conpro.getProperty("Enteruser"));
		driver.findElement(By.xpath(conpro.getProperty("Objpass"))).sendKeys(conpro.getProperty("Enterpass"));
		driver.findElement(By.xpath(conpro.getProperty("Objlogin"))).click();
		driver.findElement(By.xpath(conpro.getProperty("Objpim"))).click();
		driver.findElement(By.xpath(conpro.getProperty("Objleave"))).click();
		driver.findElement(By.xpath(conpro.getProperty("Objdashboard"))).click();
		Thread.sleep(3000);
		String Expected = "dashboard";
		String Actual = driver.getCurrentUrl();
		if (Actual.contains(Expected)) 
		{
			Reporter.log("login sucess:::"+Expected+"    "+Actual,true);
		}
		else 
		{
			// capture error message
			String Errormessage = driver.findElement(By.xpath(conpro.getProperty("Objerror"))).getText();
			Reporter.log(Errormessage+"    "+Expected+"     "+Actual,true);
		}
	driver.quit();
		
	}

}
