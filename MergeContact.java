package week6.Day2.CRA;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//Week4 Day1 Assignments - 1.1
public class MergeContact extends BaseClass {

	@Test 
	public void Merge_Contact() throws InterruptedException {
		// TODO Auto-generated method stub

		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("***Merge Lead***");
		
		// 5. Click on contacts Button
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		// 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		// 7. Click on Widget of From Contact
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		
		//Get Parent Window
		String parentWindow = driver.getWindowHandle();
		// Get the number of Child Windows
		Set<String> windowHandles1 = driver.getWindowHandles();
		// Convert set to list
		List<String> windows1 = new ArrayList<String>(windowHandles1);
		//Switch To Child Windows
		System.out.println("Title of the Page : " + driver.switchTo().window(windows1.get(1)).getTitle());
		// 8. Click on First Resulting Contact
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
		//Switch To Parent Windows
		System.out.println("Title of the Page : " + driver.switchTo().window(parentWindow).getTitle());
		// 9. Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		// Get All Open Child Windows
		Set<String> windowHandles2 = driver.getWindowHandles();
		// Convert set to list
		List<String> windows2 = new ArrayList<String>(windowHandles2);
		//SwitchTo Child Window
		System.out.println("Title of the Page : " + driver.switchTo().window(windows2.get(1)).getTitle());
		Thread.sleep(2000);
		// 10. Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]//a")).click();
		// 11. Click on Merge button using Xpath Locator
		System.out.println("Title of the Page : " + driver.switchTo().window(parentWindow).getTitle());
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		// 12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert Confirmation: " + alert.getText());
		alert.accept();
		// 13. Verify the title of the page
		String currentTitle = driver.getTitle();
		System.out.println("The title of the Page : " + currentTitle);

	}

}
