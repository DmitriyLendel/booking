package objects;

import java.util.concurrent.TimeUnit;

import objects.components.StationEnter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class OrderForm {

	private final WebDriver driver;

	public OrderForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new HtmlElementDecorator(driver), this);
	}

	private StationEnter setFrom;

	@FindBy(name = "station_till")
	private StationEnter setWhere;

	@FindBy(name = "date_dep")
	private WebElement setDate;

	@FindBy(name = "time_dep")
	private WebElement setTime;

	@FindBy(name = "search")
	private WebElement submit;

	public void setFrom(String stationName) {

		setFrom.search(stationName);

	}

	public void setWhere(String stationName) {

		setWhere.search(stationName);

	}

	public void setDate() {

		setDate.click();
		WebElement myElement = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.elementToBeClickable(By
						.xpath("html/body/div[2]/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td[5]")));
		driver.findElements(
				By.cssSelector(".rui-calendar .month td:not(.disabled):not(.blank)"))
				.get(0).click();

	}

	public void setTime() {

		setDate.click();
		WebElement myElement = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.elementToBeClickable(By
						.cssSelector("select[ name='time_dep']>option[value ^='01:00']")));
		driver.findElement(
				By.cssSelector("select[ name='time_dep']>option[value ^='01:00']"))
				.click();

	}

	public void submit() {

		submit.click();

	}

	public void getText() {

		driver.findElements(
				By.cssSelector(".vToolsDataTable [class ^= 'vToolsDataTableRow']"))
				.size();

	}

	public int getCount() {
		return driver
				.findElements(
						By.cssSelector(".vToolsDataTable [class ^= 'vToolsDataTableRow']"))
				.size();

	}
}
