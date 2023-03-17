package pl.solvd.carina;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.Location;
import java.lang.invoke.MethodHandles;

public class OverviewPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//header")
    private Header header;
    @FindBy(xpath = "//footer")
    private Footer footer;
    @FindBy(xpath = "//h1")
    private ExtendedWebElement title;

    public OverviewPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }
    public boolean isHeaderVisible() {
       // driver.manage().window().maximize();
//        Actions acts = new Actions(getDriver());
//        acts.sendKeys(Keys.PAGE_DOWN).scrollToElement((WebElement) footer).build().perform();
//        acts.sendKeys(Keys.PAGE_DOWN).scrollByAmount(0,1000).build().perform();
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
        return header.isAnyElementPresent();
    }

    public Footer getFooter() {
        return footer;
    }
}

