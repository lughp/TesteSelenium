package pageObjects;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EnterProductData {

	private WebDriver driver;

	public EnterProductData() {
	}

	public EnterProductData(WebDriver driver) {
		this.driver = driver;
	}
	
	public EnterProductData preencherCamposUmAbaTres(String startdate) {
		driver.findElement(By.id("startdate")).sendKeys(Keys.chord(startdate));
		return this;
	}

	public EnterProductData escolherInsurance(String insurancesum) {
		WebElement campoInsurance = driver.findElement(By.id("insurancesum"));
		new Select(campoInsurance).selectByVisibleText(insurancesum);
		return this;
	}

	public EnterProductData escolhermeritrating(String meritrating) {
		WebElement campomeritrating = driver.findElement(By.id("meritrating"));
		new Select(campomeritrating).selectByVisibleText(meritrating);
		return this;
	}

	public EnterProductData escolherdamageinsurance(String damageinsurance) {
		WebElement campodamageinsurance = driver.findElement(By.id("damageinsurance"));
		new Select(campodamageinsurance).selectByVisibleText(damageinsurance);
		return this;
	}

	public EnterProductData escolherEuroProtection(String EuroProtection, String LegalDefenseInsurance) {
		if (EuroProtection.equalsIgnoreCase("Yes")) {
			driver.findElement(By.xpath("//*[@id=\"EuroProtection\"]")).click();

		}
		if (LegalDefenseInsurance.equalsIgnoreCase("Yes")) {
			driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[2]/span")).click();
		}

		return this;
	}

	public EnterProductData escolherCourtesycar(String courtesycar) {
		WebElement campocourtesycar = driver.findElement(By.id("courtesycar"));
		new Select(campocourtesycar).selectByVisibleText(courtesycar);

		driver.findElement(By.id("nextselectpriceoption")).click();
		return this;
	}

	public SelectPriceOption preencherAbaEnterProductData(String startdate, String insurancesum,
			String meritrating, String damageinsurance, String EuroProtection, String LegalDefenseInsurance,
			String courtesycar) {
		try {
			preencherCamposUmAbaTres(startdate);
			escolherInsurance(insurancesum);
			escolhermeritrating(meritrating);
			escolherdamageinsurance(damageinsurance);
			escolherEuroProtection(EuroProtection, LegalDefenseInsurance);
			escolherCourtesycar(courtesycar);
		} catch (Exception ex) {
			fail("Erro no preenchimento da aba Enter Product Data");
		}
		return new SelectPriceOption(driver);

	}

}
