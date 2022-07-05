package week6.Day2.CRA;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//Week2 Day2 Assignment - 2.2
public class DeleteLead extends BaseClass{

	@BeforeClass
	public void DataSetup_DeleteLead()
	{
		sheetName="DeleteLead";
	}
	
	@Test (dataProvider ="TestDataDetail")
	public void delete_Lead(String phnum) throws InterruptedException {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		// Login and Find Lead by using Phone Number
		System.out.println("***Delete Lead***");
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys(phnum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(3000);
		
		//Capture the First Lead ID
		String firstLeadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.getText();
		System.out.println("First Lead Id is : " + firstLeadId);

		// Click on the First Lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		//Click on the Delete 
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Delete']")).click();

		//Click on Find Leads by Using Lead ID
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[@name='id']")).sendKeys(firstLeadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Verification of Confirmation message
		String verification = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		System.out.println("Confirmation Message for Deletion : " + verification);

	}

}
