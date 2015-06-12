package tests;

import java.io.IOException;

import objects.OrderForm;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import utils.DriverSetup;

public class UZdTest extends DriverSetup {

	WebDriver driver;
	OrderForm orderForm;

	@BeforeClass
	public void init() throws IOException {
		driver = setUp();

		orderForm = new OrderForm(driver);
	}

	@Test
	@Features("Demo")
	@Stories("Demo test")
	public void testDemo() throws Exception {

		orderForm.setFrom("Kyiv");
		orderForm.setWhere("Dnipropetrovsk Holovny");
		orderForm.setDate();
		orderForm.setTime();
		orderForm.submit();
		
		int count = orderForm.getCount();
		
		Assert.assertTrue(count>0, "message");
		

	}

	@AfterClass
	public void shutDown() {
		driver.quit();
	}

}
