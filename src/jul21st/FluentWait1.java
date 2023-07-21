package jul21st;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWait1 {
	
WebDriver driver;
	
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
		driver.manage().window().maximize();
		
		//implicit wait statement
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void waitsTest() throws IOException, InterruptedException
	{
		
		
		driver.findElement(By.xpath("//span[text()='1']")).click();
		
		driver.findElement(By.xpath("//span[text()='+']")).click();
		
		driver.findElement(By.xpath("//span[text()='2']")).click();
		
		driver.findElement(By.xpath("//span[text()='=']")).click();
		
		//WebDriverWait myWait=new WebDriverWait(driver, 30);
		
		FluentWait<WebDriver> myWait=new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(30))
		.pollingEvery(Duration.ofMillis(300))
		.ignoring(NoSuchElementException.class);
		
		
		myWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@id='spinner']")));
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='screen']")).getText(), "3")  ;
		
		
		
	}
	
	@AfterMethod
	public void teardowm() throws InterruptedException
	{
		
		
		driver.quit();
	}
	

}
