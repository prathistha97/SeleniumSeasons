package jul13th;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTesting3 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		WebElement drop=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		
		List<WebElement> allItems=drop.findElements(By.tagName("option"));
		
		System.out.println("No of items in dropdown "+allItems.size());
		
		for(WebElement item:allItems)
		{
			System.out.println(item.getText());
		}
		
		driver.quit();

	}

}
