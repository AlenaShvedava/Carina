package pl.solvd.carina;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchComponent extends AbstractUIObject {
    @FindBy (xpath = "//label[@class='md-search__icon md-icon']")
    private ExtendedWebElement searchIcon;
    @FindBy(xpath = "//input[@class='md-search__input']")
    private ExtendedWebElement searchInputText;

    public SearchComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public boolean isSearchIconPresent(int i) {
        return searchIcon.isElementPresent(i);
    }
    public boolean isSearchInputTextPresent(int i) {
        return searchInputText.isElementPresent(i);
    }
    public ExtendedWebElement getSearchIcon() {
        return searchIcon;
    }

    public ExtendedWebElement getSearchInputText() {
        return searchInputText;
    }
}
