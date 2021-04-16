package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
	
	static String PATH = "./src/test/resources/drivers/chromedriver.exe";
		
	public static WebDriver createChrome() {
		System.setProperty("webdriver.chrome.driver", PATH);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://sampleapp.tricentis.com/101/app.php");
		return driver;
	}

}
