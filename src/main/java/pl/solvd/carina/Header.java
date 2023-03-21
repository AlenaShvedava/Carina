package pl.solvd.carina;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {
    @FindBy(xpath = "//*[@class= 'md-header-nav__button md-logo']")
    private ExtendedWebElement zebrunnerLogo;
    @FindBy(xpath = "//nav[@aria-label='Header']//a[@aria-label='Carina']")
    private ExtendedWebElement zebrunnerLogoLink;
    @FindBy(xpath = "//div/span[1][contains(@class,'md-ellipsis')]")
    private ExtendedWebElement carinaBrand;
    @FindBy(xpath = "//div[@role='dialog']")
    private SearchComponent searchComponent;
    @FindBy(xpath = ".//a[@title='Go to repository']")
    private ExtendedWebElement githubLink;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public boolean isZebrunnerLogoPresent(int i) {
        return zebrunnerLogo.isElementPresent(i);
    }

    public OverviewPage clickZebrunnerLogo() {
        zebrunnerLogoLink.click();
        return new OverviewPage(driver);
    }

    public boolean isZebrunnerLogoRedirectToURL(Url url) {
        return clickZebrunnerLogo().getPageURL().equalsIgnoreCase(url.getUrl());
    }

    public boolean isCarinaBrandPresent(int i) {
        return carinaBrand.isElementPresent(i);
    }

    public boolean isCarinaBrandHasText() {
        return carinaBrand.getText().equals("Carina");
    }

    public boolean isSearchComponentPresent(int i) {
        return searchComponent.isUIObjectPresent(i);
    }

    public boolean isSearchComponentElementsPresent(int i) {
        return searchComponent.isSearchIconPresent(i) & searchComponent.isSearchInputTextPresent(i);
    }

    public boolean isGitHubPresent(int i) {
        return githubLink.isElementPresent(i);
    }

    public boolean isGitHubRedirectToURL(Url url) {
        return getGithubLink().getAttribute("href").equalsIgnoreCase(url.getUrl());
    }

    public ExtendedWebElement getGithubLink() {
        return githubLink;
    }
}
