package pageObjects;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EnterVehicleData {

	private WebDriver driver;

	public EnterVehicleData() {
	}

	public EnterVehicleData(WebDriver driver) {
		this.driver = driver;
	}

	public EnterVehicleData escolherMake(String make) {
		try {
			WebElement campoMake = driver.findElement(By.id("make"));
			new Select(campoMake).selectByVisibleText(make);
		} catch (Exception ex) {
			fail("Erro ao carregar o campo Make");
		}
		return this;

	}

	public EnterVehicleData escolherModel(String model) {
		try {
			WebElement campoModel = driver.findElement(By.id("model"));
			new Select(campoModel).selectByVisibleText(model);
		} catch (Exception ex) {
			fail("Erro ao carregar o campo Model");
		}
		return this;

	}

	public EnterVehicleData preencherCamposUm(String cylindercapacity, String engineperformance,
			String dateofmanufacture) {
		driver.findElement(By.id("cylindercapacity")).sendKeys(Keys.chord(cylindercapacity));
		driver.findElement(By.id("engineperformance")).sendKeys(Keys.chord(engineperformance));
		driver.findElement(By.id("dateofmanufacture")).sendKeys(Keys.chord(dateofmanufacture));
		return this;
	}

	public EnterVehicleData escolherNumberosSeats(String numberofseats) {
		WebElement campoNumber = driver.findElement(By.id("numberofseats"));
		new Select(campoNumber).selectByVisibleText(numberofseats);
		return this;
	}

	public EnterVehicleData escolherRighthanddriveyes(String right) {
		if (right == "Yes") {
			driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[1]/div[7]/p/label[1]/span")).click();
		} else
			driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[1]/div[7]/p/label[2]")).click();

		return this;
	}

	public EnterVehicleData escolherNumberosSeatsDois(String numberofseatsmotorcycle) {
		WebElement campoNumber = driver.findElement(By.id("numberofseatsmotorcycle"));
		new Select(campoNumber).selectByVisibleText(numberofseatsmotorcycle);
		return this;
	}

	public EnterVehicleData escolherFuelType(String fuel) {
		WebElement campoFuel = driver.findElement(By.id("fuel"));
		new Select(campoFuel).selectByVisibleText(fuel);
		return this;
	}

	public EnterVehicleData preencherCamposDois(String payload, String totalweight, String listprice,
			String licenseplatenumber, String annualmileage) {
		driver.findElement(By.id("payload")).sendKeys(Keys.chord(payload));
		driver.findElement(By.id("totalweight")).sendKeys(Keys.chord(totalweight));
		driver.findElement(By.id("listprice")).sendKeys(Keys.chord(listprice));
		driver.findElement(By.id("licenseplatenumber")).sendKeys(Keys.chord(licenseplatenumber));
		driver.findElement(By.id("annualmileage")).sendKeys(Keys.chord(annualmileage));
		driver.findElement(By.id("nextenterinsurantdata")).click();

		return this;
	}

	public EnterInsurantData preencherAbaEnterVehicleData(String make, String model, String cylindercapacity,
			String engineperformance, String dateofmanufacture, String numberofseats, String right,
			String numberofseatsmotorcycle, String fuel, String payload, String totalweight, String listprice,
			String licenseplatenumber, String annualmileage) throws InterruptedException {
		try {
			escolherMake(make);
			escolherModel(model);
			preencherCamposUm(cylindercapacity, engineperformance, dateofmanufacture);
			escolherNumberosSeats(numberofseats);
			escolherRighthanddriveyes(right);
			escolherNumberosSeatsDois(numberofseatsmotorcycle);
			escolherFuelType(fuel);
			preencherCamposDois(payload, totalweight, listprice, licenseplatenumber, annualmileage);
		} catch (Exception ex) {
			fail("Erro no preenchimento da aba Enter Vehicle Data");
		}
		return new EnterInsurantData(driver);

	}

}
