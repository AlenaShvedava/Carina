package pl.solvd.carina;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends AbstractPage {
    @FindBy(xpath = "//header")
    private Header header;
    @FindBy(xpath = "//nav[@aria-label='Navigation']")
    private Navigation navigation;
    @FindBy(xpath = "//h1")
    private ExtendedWebElement title;

    public OverviewPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public boolean isHeaderVisibleWhileScrolling() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return header.getRootExtendedElement().isVisible();
    }

    public boolean isHeaderAtTheTop() {
        Point headerTopPoint = header.getRootExtendedElement().getLocation();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return header.getRootExtendedElement().getLocation().equals(headerTopPoint);
    }

    public Header getHeader() {
        return header;
    }

    public boolean isHeaderPresent() {
        return header.isUIObjectPresent();
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public boolean isNavigationPresent() {
        return navigation.isUIObjectPresent();
    }
}
