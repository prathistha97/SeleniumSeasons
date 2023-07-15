package jul13th;

import org.testng.annotations.Test;

import graphql.Assert;

public class TestNGDemo1 {
	
	
	@Test(priority=2)
	public void loginTest()
	{
		System.out.println("Browser stared ...");
		System.out.println("App Launched ...");
		Assert.assertTrue(false);
		System.out.println("login successful ...");
		System.out.println("Browser Closed ....");
	}
	
	@Test(priority=1)
	public void registrationTest()
	{
		System.out.println("Browser stared ...");
		System.out.println("App Launched ...");
		System.out.println("registration successful ...");
		System.out.println("Browser Closed ....");
	}
	
	@Test(priority=3,enabled=true,dependsOnMethods="loginTest")
	public void changePasswordTest()
	{
		System.out.println("Browser stared ...");
		System.out.println("App Launched ...");
		System.out.println("change password successful ...");
		System.out.println("Browser Closed ....");
	}

}
