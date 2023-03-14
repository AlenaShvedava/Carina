package pl.solvd.carina;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchComponent extends AbstractPage {
    @FindBy (xpath = "//label[@class='md-search__icon md-icon']")
    private WebElement searchIcon;
    @FindBy(xpath = "//input[@class='md-search__input']")
    private WebElement searchInputText;
    public SearchComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchIcon() {
        return searchIcon;
    }

    public WebElement getSearchInputText() {
        return searchInputText;
    }
}
