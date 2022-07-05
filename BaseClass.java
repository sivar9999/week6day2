package week6.Day2.CRA;

import org.testng.annotations.Test;

//import com.beust.jcommander.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {
	
 public ChromeDriver driver;
 public String sheetName;
 
 @Parameters ({"url", "UserName" ,"Password"})
  @BeforeMethod
  public void preCondition(String url, String userName, String passWord) {
	// Setup Chrome Driver
			WebDriverManager.chromedriver().setup();
			// Open Browser
			 driver = new ChromeDriver();

			// Perform Launch and Login actions
			driver.manage().window().maximize();
			driver.get(url); 
			driver.findElement(By.id("username")).sendKeys(userName);
			driver.findElement(By.id("password")).sendKeys(passWord);
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
  }

  @AfterMethod
  public void postCondition() {
	  
	  driver.close();
  }
  
  
  @DataProvider(name = "TestDataDetail", indices = 0)
	public String[][] fetchData() throws IOException {
	  
  	return  ReadData.testData(sheetName);
	}
}
