package stepsDefinitions;

import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageObjects.EnterInsurantData;
import pageObjects.EnterProductData;
import pageObjects.EnterVehicleData;
import pageObjects.SelectPriceOption;
import pageObjects.SendQuote;
import pageObjects.ValidarMensagem;
import utils.Utils;

@RunWith(Runner.class)

public class Tricentis {
	
	private WebDriver driver;

	@Before
	public void iniciar() {
		driver = Utils.createChrome();
	}
	
	@Quando("^informo os campos da aba enter Vehicle Data e prossigo$")
	public void informoOsCamposDaAbaEnterVehicleDataEProssigo() throws Throwable {
		new EnterVehicleData(driver).preencherAbaEnterVehicleData("Mazda", "Moped", "103", "17", "03/30/2021",
				"2", "No", "1", "Electric Power", "320", "798", "20000", "A1B2C3D4", "15698");
	}

	@Quando("^informo os dados da aba enter Insurant Data e prossigo$")
	public void informoOsDadosDaAbaEnterInsurantDataEProssigo() throws Throwable {
		new EnterInsurantData(driver).preencherEnterInsurantData("Luciano", "Porto", "08/09/1982", "Quada 100",
				"M", "Brazil", "70100100", "Brasilia", "Public Official", "No", "Yes", "No", "No", "Yes");
	}

	@Quando("^informo os dados da aba enter Product Data e prossigo$")
	public void informoOsDadosDaAbaEnterProductDataEProssigo() throws Throwable {
		new EnterProductData(driver).preencherAbaEnterProductData("06/25/2021", "30.000.000,00", "Malus 17",
				"No Coverage", "No", "Yes", "Yes");
	}

	@Quando("^informo os dados da aba Select Price Option e prossigo$")
	public void informoOsDadosDaAbaSelectPriceOptionEProssigo() throws Throwable {
		new SelectPriceOption(driver).preencherAbaSelectPriceOption("selectultimate");
	}

	@Quando("^informo os dados da aba Send Quote e envio$")
	public void informoOsDadosDaAbaSendQuoteEEnvio() throws Throwable {
		new SendQuote(driver).preencherAbaSendQuote("alias@servermail.com", "0123456789", "nickname",
				"P4ssw0rd", "P4ssw0rd");
	}

	@Entao("^valido a mensagem de sucesso$")
	public void validoAMensagemDeSucesso() throws Throwable {
		new ValidarMensagem(driver).validaMensagens();
	}

}
