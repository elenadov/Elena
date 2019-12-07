package pages.pageElements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * Created by Андрей Гугля on 03.12.2019.
 */

@FindBy(xpath = ".//*[@class='sidebar-menu']")

public class LeftMenu extends HtmlElement {
    @FindBy(id = "dictionary")
    private Link menuDictionary;

    @FindBy(id = "spares")
    private Link subMenuSpares;

    public void clickOnMenuDictionary(){
        menuDictionary.click();

    }

    public void clickOnSubMenuSpare() {
        subMenuSpares.click();
    }
}
