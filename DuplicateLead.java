package week6.Day2.CRA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//Week2 Day2 Assignment - 2.3
public class DuplicateLead extends BaseClass{

	@BeforeClass
	public void DataSetup_DuplicateLead() {
		sheetName="DuplicateLead";
	}
	@Test (dataProvider ="TestDataDetail")
	public void duplicate_Lead(String emailId) throws InterruptedException {
		// TODO Auto-generated method stub
		// Drive and Browser Setup

		// Login and Find Lead by using Email Address
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("***Duplicate Lead***");
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys(emailId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(3000);

		// Capture Name of the First Lead
		String firstName = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a"))
				.getText();
		String lastName = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-lastName']//a"))
				.getText();
		String capturedLeadName = firstName + lastName;
		System.out.println("Captured Lead Name : " + capturedLeadName);

		// Click on the first lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();

		// Click on Duplicate
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();

		// Print Title of the Page
		System.out.println("The Title of the Page : " + driver.getTitle());
		
		//Click on Lead
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();

		// Capture Duplicate Lead Name
		String firstNameOfDuplicateLead = driver.findElement(By.id("viewLead_firstName_sp")).getText();
				//driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
		String lastNameOfDuplicateLead = driver.findElement(By.id("viewLead_lastName_sp")).getText();
				//driver.findElement(By.id("createLeadForm_lastName")).getAttribute("value");
		String duplicateLeadName = firstNameOfDuplicateLead + lastNameOfDuplicateLead;
		System.out.println("Duplicate Lead Name : " + duplicateLeadName);

		// Verification of Duplicate Lead details
		if (capturedLeadName.equalsIgnoreCase(duplicateLeadName))

			System.out.println("Confirmation Result : The Duplicated Lead Name is same as Captured Name");

		else
			System.out.println("Confirmation Result : The Duplicated Lead Name is not same as Captured Name");
	

	}

}
