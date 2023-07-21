package jul21st;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits1 {
	
WebDriver driver;
	
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		//implicit wait statement
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void waitsTest() throws IOException, InterruptedException
	{
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
			
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Riyaz");
		
	
		
	}
	
	@AfterMethod
	public void teardowm() throws InterruptedException
	{
		
		
		driver.quit();
	}
	

}
