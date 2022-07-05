package week6.Day2.CRA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

////Week 2_Day 1 : Assignment 2
public class EditLead extends BaseClass {

@BeforeClass	
public void DataSetup_EditLead() {
	sheetName="EditLead";
}
	
	@Test (dataProvider = "TestDataDetail")
	public void edit_Lead(String cName, String fName, String lName, String fLocalName, String departName,
			String descr, String email, String state, String importantNote) throws InterruptedException {

		// TODO Auto-generated method stub
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("***Edit Lead***");
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

		// Select Drop down using Select class
		WebElement elementState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateDropdown = new Select(elementState);
		stateDropdown.selectByVisibleText(state);
		
		//click on Create Button
		driver.findElement(By.className("smallSubmit")).click();
		
		//Click on Edit Link
		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(2000);
		
		//Clear and Pass the text 
		driver.findElement(By.id("updateLeadForm_description")).clear();
		Thread.sleep(2000);
		driver.findElement(By.name("importantNote")).sendKeys(importantNote);
		
		//Click on Update 
		driver.findElement(By.name("submitButton")).click();
		
		System.out.println(driver.getTitle());

	}

}
