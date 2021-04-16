package pageObjects;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectPriceOption {
	
	private WebDriver driver;
	
	public SelectPriceOption() {
	}

	public SelectPriceOption(WebDriver driver) {
		this.driver = driver;
	}
	
	public SendQuote preencherAbaSelectPriceOption(String SelectPriceOption) {
		try {
			if (SelectPriceOption.equalsIgnoreCase("selectsilver")) {
				driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[1]/span")).click();
			}
			if (SelectPriceOption.equalsIgnoreCase("selectgold")) {
				driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[2]/span")).click();
			}
			if (SelectPriceOption.equalsIgnoreCase("selectplatinum")) {
				driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[3]/span")).click();
			}
			if (SelectPriceOption.equalsIgnoreCase("selectultimate")) {
				driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[4]/span")).click();
			}
		} catch (Exception ex) {
			fail("Os campos não foram carregados");
		}

		driver.findElement(By.id("nextsendquote")).click();
		return new SendQuote(driver);
	}

}
