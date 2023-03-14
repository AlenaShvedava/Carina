package pl.solvd.carina;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "shv")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testZebrunnerLogoIsClickable() {
        OverviewPage overviewPage = new OverviewPage(getDriver());
        overviewPage.open();
        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page is not opened");
        Assert.assertTrue(overviewPage.getHeader().isUIObjectPresent(2), "Header element wasn't found!");
        HeaderElement zebrunnerLogo = (HeaderElement) overviewPage.getHeader().getZebrunnerLogo();
        Assert.assertTrue(zebrunnerLogo.isUIObjectPresent(2), "Zebrunner logo missing from header");
        overviewPage.getHeader().clickZebrunnerLogo();
        Assert.assertTrue(overviewPage.getHeader().clickZebrunnerLogo().getPageURL().equalsIgnoreCase(Url.OVERVIEW.getUrl()), "Clicking on Zerunner logo doesn't redirect to Overview page");
}
    @Test()
    @MethodOwner(owner = "shv")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testCarinaText() {
        OverviewPage overviewPage = new OverviewPage(getDriver());
        overviewPage.open();
        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page is not opened");
        Assert.assertTrue(overviewPage.getHeader().isUIObjectPresent(2), "Header element wasn't found!");
        Assert.assertTrue(((HeaderElement) overviewPage.getHeader().getCarinaBrand()).isUIObjectPresent(), "Carina text is outside the header!");
        Assert.assertTrue(overviewPage.getHeader().getCarinaBrand().getText().equals("Carina"),"Header doesn't contain Carina text");
    }

    @Test()
    @MethodOwner(owner = "shv")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testSearchComponent() {
        OverviewPage overviewPage = new OverviewPage(getDriver());
        overviewPage.open();
        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page is not opened");
        HeaderElement headerElement = overviewPage.getHeader();
        Assert.assertTrue(headerElement.isUIObjectPresent(2), "Header element wasn't found!");
        Assert.assertTrue(headerElement.getSearchComponent().getSearchIcon().getLocation().equals(headerElement.getSearchComponent()),"Search component element not found");
        Assert.assertTrue(headerElement.getSearchComponent().getSearchInputText().getLocation().equals(headerElement.getSearchComponent()),"Search component element not found");
        Assert.assertTrue(headerElement.getSearchComponent().getRootExtendedElement().equals(headerElement),"Header doesn't contain Search component");
    }
    @Test()
    @MethodOwner(owner = "shv")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testGitHubLink() {
        OverviewPage overviewPage = new OverviewPage(getDriver());
        overviewPage.open();
        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page is not opened");
        HeaderElement headerElement = overviewPage.getHeader();
        Assert.assertTrue(headerElement.isUIObjectPresent(2), "Header element wasn't found!");
        Assert.assertTrue(headerElement.getGithubLink().getLocation().equals(headerElement),"Header doesn't contain GitHub link");
        overviewPage.getHeader().clickGitHubLink();
        Assert.assertTrue(overviewPage.getHeader().clickGitHubLink().getPageURL().equalsIgnoreCase(Url.GITHUB.getUrl()), "Clicking on GitHub link doesn't redirect to GitHub page");
    }
    @Test()
    @MethodOwner(owner = "shv")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testHeaderSticky() {
        OverviewPage overviewPage = new OverviewPage(getDriver());
        overviewPage.open();
        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page is not opened");
        HeaderElement headerElement = overviewPage.getHeader();
        Assert.assertTrue(headerElement.isUIObjectPresent(2), "Header element wasn't found!");
        Actions acts = new Actions(getDriver());
        acts.keyDown(Keys.PAGE_DOWN).build().perform();
        Assert.assertTrue(overviewPage.getHeader().isUIObjectPresent(),"Header doesn't contain GitHub link");
        overviewPage.getHeader().clickGitHubLink();
        Assert.assertTrue(overviewPage.getHeader().clickGitHubLink().getPageURL().equalsIgnoreCase(Url.GITHUB.getUrl()), "Clicking on GitHub link doesn't redirect to GitHub page");
    }
}