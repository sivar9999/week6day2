package week6.Day2.CRA;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//Week 2_Day 1 : Assignment 1
public class CreateLead extends BaseClass {

	@BeforeClass
	  public void DataSetup_CreateLead() {
		  sheetName="CreadLead";
	  }
	@Test(dataProvider = "TestDataDetail")
	public void create_Lead(String cName, String fName, String lName, String fLocalName, String departName,
			String descr, String email, String phnoenum, String state) throws InterruptedException {
		// TODO Auto-generated method stub

		// driver.get("http://leaftaps.com/opentaps/control/login");
		System.out.println("***Create Lead***");
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();

		// passing the Text in the fields
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(fLocalName);
		driver.findElement(By.name("departmentName")).sendKeys(departName);
		driver.findElement(By.name("description")).sendKeys(descr);
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phnoenum);

		// Select Drop down using Select class
		WebElement elementState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateDropdown = new Select(elementState);
		stateDropdown.selectByVisibleText(state);
		driver.findElement(By.className("smallSubmit")).click();

		// to slow execution the for a seconds
		Thread.sleep(2000);

		// get title of the page.
		String titlePage = driver.getTitle();
		System.out.println("Titel of the Page is : " + titlePage);
	}

	
}
