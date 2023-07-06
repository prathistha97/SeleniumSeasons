package jul6th;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementMethods1 {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("reyaz0607");
		
		driver.findElement(By.name("password")).sendKeys("reyaz123");
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("username")).clear();
		
		driver.findElement(By.name("password")).clear();
		
		
		driver.findElement(By.id("login")).click();
		
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.id("username_span")).getText());
		
		System.out.println(driver.findElement(By.id("username_span")).getAttribute("class"));
		
		System.out.println(driver.findElement(By.id("username_span")).getAttribute("name"));
		
		System.out.println(driver.findElement(By.id("username_span")).getCssValue("color"));
		
		System.out.println(driver.findElement(By.id("username_span")).getTagName());
		
		driver.quit();
		

	}

}
