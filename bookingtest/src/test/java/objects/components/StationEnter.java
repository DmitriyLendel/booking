package objects.components;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;


@Name("Search Station")
@FindBy(id = "station_from")
public class StationEnter extends HtmlElement {

    @Name("Search Station input")
    @FindBy(xpath = ".//*[@id='stations_from']/div[1]")
    private TextInput requestInput;

    
    public void search(String request) {
        requestInput.sendKeys(request);
    }

    
}