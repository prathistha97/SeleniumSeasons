package jul7th;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTesting2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		
		WebElement element=driver.findElement(By.id("searchDropdownBox"));
		
		//object of select class 
		
		Select s1=new Select(element);
		
		//selectByIndex(int)

		//s1.selectByIndex(10);
		
		//s1.selectByValue("search-alias=stripbooks");
		
		//selectByVisibleText(String)
		
		s1.selectByVisibleText("Books");
		
		Thread.sleep(3000);
		
		driver.quit();
		
		

	}

}
