package pl.solvd.carina;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderElement extends AbstractUIObject {
    @FindBy(xpath = "//*[@class= 'md-header-nav__button md-logo']")
    private WebElement zebrunnerLogo;
    @FindBy(xpath = "//nav[@aria-label='Header']//a[@aria-label='Carina']")
    private ExtendedWebElement zebrunnerLogoLink;
    @FindBy(xpath = "//div/span[1][contains(@class,'md-ellipsis')]")
    private WebElement carinaBrand;
    @FindBy(xpath = "//div[@role='dialog']")
    private SearchComponent searchComponent;
    @FindBy(xpath = "//div[3]/a")
    private WebElement githubLink;

    public HeaderElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public WebElement getZebrunnerLogo() {
        return zebrunnerLogo;
    }

    public WebElement getCarinaBrand() {
        return carinaBrand;
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public WebElement getGithubLink() {
        return githubLink;
    }
    public OverviewPage clickZebrunnerLogo() {
        zebrunnerLogoLink.click();
        return new OverviewPage(driver);
    }
    public OverviewPage clickGitHubLink() {
        githubLink.click();
        return new OverviewPage(driver);
    }
}
