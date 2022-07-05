package week6.Day2.CRA;

import org.testng.annotations.Test;

public class CustomerBoard {
	//Customer Details
@Test (dependsOnMethods = "customerAddress" , invocationCount = 4)
public void customerdetails() {
	System.out.println("Customer Details are available");
}

@Test (groups = {"CustomerCreation"})
public void customerAddress()
{
	System.out.println("Customer Address Section");
}

@Test (priority =1 ,groups = {"CustomerCreation"})
public void customerPhoneNumber()
{
	System.out.println("Customer Phone Number Section");
}

@Test (enabled = false)
public void employmentDetail()
{
	System.out.println("Employment Section");
}

}

