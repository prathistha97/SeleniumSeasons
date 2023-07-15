package jul15th;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowHandling {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void rightclickTest() throws InterruptedException
	{
		
		String homeWindowId=driver.getWindowHandle();
		
		Thread.sleep(3000);
		
		//this will click google play img
		driver.findElement(By.xpath("//img[contains(@src,'google-play')]")).click();
		
		Set<String> windowIds=driver.getWindowHandles();
		
		Iterator<String> it=windowIds.iterator();
		
		while(it.hasNext())
		{
			
			String windowId=it.next();
			
			driver.switchTo().window(windowId);
			
			Thread.sleep(3000);
			
			if(driver.getTitle().equals("Adactin Hotel App - Apps on Google Play"))
			{
				break;
			}
		}
		
		
		driver.findElement(By.xpath("//span[text()='Games']/ancestor::button")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().window(homeWindowId);
		
			
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[contains(@src,'ios-button')]")).click();
		
		 windowIds=driver.getWindowHandles();
		
		 it=windowIds.iterator();
		
		while(it.hasNext())
		{
			
			String windowId=it.next();
			
			driver.switchTo().window(windowId);
			
			Thread.sleep(3000);
			
			if(driver.getTitle().equals("TestFlight - Apple"))
			{
				break;
			}
		}
		
		driver.findElement(By.xpath("//a[text()='Terms of Service']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().window(homeWindowId);
		
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		
		driver.quit();
	}


}
