package july4th;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeLaunch1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\004 Live Tech\\softwares\\chromedriver_win32\\chromedriver.exe");
		new ChromeDriver();

	}

}

