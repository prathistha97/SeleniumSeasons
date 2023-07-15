package jul13th;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTesting4 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		WebElement drop=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		
		//using Select class
		
		Select s1=new Select(drop);
		
		List<WebElement> allItems=s1.getOptions();
		
		System.out.println("No of items in dropdown "+allItems.size());
		
		for(WebElement item:allItems)
		{
			System.out.println(item.getText());
		}
		
		driver.quit();

	}

}
