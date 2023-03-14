package pl.solvd.carina;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends AbstractPage {
    @FindBy(xpath = "//header")
    private WebElement header;

    public OverviewPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker((ExtendedWebElement) header);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public HeaderElement getHeader() {
        return (HeaderElement) header;
    }
}
