package objects.components;

import org.apache.xalan.xsltc.runtime.Hashtable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.sql.Driver;
import java.util.*;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

//@Name("Date Picker")
//@FindBy(id = "date_dep")
public class DatePicker {

	public void hashMap() {
		Hashtable h = new Hashtable();
		h.put("January", 0);
		h.put("February", 1);
		h.put("March", 2);
		h.put("April", 3);
		h.put("May", 4);
		h.put("June", 5);
		h.put("July", 6);
		h.put("August", 7);
		h.put("September", 8);
		h.put("October", 9);
		h.put("November", 10);
		h.put("December", 11);

		int expMonth;
		int expYear;

		// Calendar Month and Year
		String calMonth = null;
		String calYear = null;
		boolean dateNotFound;
		dateNotFound = true;
		expMonth = 5;
		expYear = 2015;
		WebDriver driver;
		while (dateNotFound) {

			calMonth = driver.findElement(By.className("ui-datepicker-month"))
					.getText(); // get the text of month
			calYear = driver.findElement(By.className("ui-datepicker-year"))
					.getText();

			if (((Integer) h.get(calMonth)) + 1 == expMonth
					&& (expYear == Integer.parseInt(calYear))) {
				String block = "//div[@class='monthBlock first']/table/tbody/tr/td"; // THIS
																						// IS
																						// FIRST
																						// CALENDAR
				selectDate(expDate, block);
				dateNotFound = false;
			}
			// parseInt - Converts String to integer and indexof( It will return
			// the index position of String)
			else if (((Integer) h.get(calMonth)) + 1 < expMonth
					&& (expYear == Integer.parseInt(calYear))
					|| expYear > Integer.parseInt(calYear)) {
				String block = "//div[@class='monthBlock last']/table/tbody/tr/td"; // THIS
																					// IS
																					// SECOND
																					// CALENDAR

				selectDate(expDate, block); // PASSING DATE AND CALENDAR
				dateNotFound = false; // Otherwise it will rotate continuously
			} else if ((Integer) h.get(calMonth) + 1 > expMonth
					&& (expYear == Integer.parseInt(calYear))
					|| expYear < Integer.parseInt(calYear)) {
				System.out
						.println(" Please enter the date greater than Current date");
				dateNotFound = false;

			}
		}

	}

	// Thread.sleep(3000);
	
	public static void selectDate(String date, String block) throws IOException {
		
		
		String monthblock = block;
		
		List<WebElement> dateWidget = driver.findElements(By.xpath(monthblock));

		for (WebElement cell : dateWidget) {
			// Selects Date
			if (cell.getText().equals(date)) {
				cell.findElement(By.linkText(date)).click();
				break;
			}

		}

		// Doubt : How to verify the expected results and how to sort the
		// program

		driver.findElement(By.id("SearchBtn")).submit();

		// driver.quit();
	}

}