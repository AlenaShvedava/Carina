package pl.solvd.carina;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class NestedNavigationMenu extends AbstractUIObject {
    @FindBy(xpath = "//li//following-sibling::label[contains(@class,'md-nav__link')]")
    private ExtendedWebElement parentItem;
    @FindBy(xpath = "//li[contains(@class, 'nested')][contains(@class,'item')]//nav//ul[@class='md-nav__list']")
    private List<ExtendedWebElement> nestedBlock;

    public NestedNavigationMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getParentItem() {
        return parentItem;
    }

    public List<ExtendedWebElement> getNestedBlock() {
        return nestedBlock;
    }
}
