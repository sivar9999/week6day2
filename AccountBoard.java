package week6.Day2.CRA;

import org.testng.annotations.Test;

public class AccountBoard {
	
	//Account Details
@Test (dependsOnGroups = "Accountcreation")
public void accountdetails() {
	System.out.println("Account Details are available");
}

@Test (groups= {"Accountcreation"})
public void loandetail()
{
	System.out.println("loan section");
}

@Test (priority =1, groups= {"Accountcreation"})
public void paymentdetail()
{
	System.out.println("Payment Section");
}

@Test (timeOut = 200)
public void timeout() throws InterruptedException
{Thread.sleep(3000);
System.out.println("Timout - Failed");
}

}
