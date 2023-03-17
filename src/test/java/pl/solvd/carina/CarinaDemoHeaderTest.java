package pl.solvd.carina;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarinaDemoHeaderTest implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "ashvedava")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testZebrunnerLogoIsClickable() {
        OverviewPage overviewPage = new OverviewPage(getDriver());
        overviewPage.open();
        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page is not opened");
        Header header = overviewPage.getHeader();
        Assert.assertTrue(header.isUIObjectPresent(2), "Header element wasn't found!");
        Assert.assertTrue(header.isZebrunnerLogoPresent(2), "Zebrunner logo missing from header");
        Assert.assertTrue(header.isZebrunnerLogoRedirectToURL(Url.OVERVIEW), "Clicking on Zerunner logo doesn't redirect to Overview page");
    }

    @Test()
    @MethodOwner(owner = "ashvedava")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testCarinaText() {
        OverviewPage overviewPage = new OverviewPage(getDriver());
        overviewPage.open();
        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page is not opened");
        Header header = overviewPage.getHeader();
        Assert.assertTrue(header.isUIObjectPresent(2), "Header element wasn't found!");
        Assert.assertTrue(header.isCarinaBrandPresent(2), "Carina text is outside the header!");
        Assert.assertTrue(header.isCarinaBrandHasText(), "Header doesn't contain Carina text");
    }

    @Test()
    @MethodOwner(owner = "ashvedava")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testSearchComponent() {
        OverviewPage overviewPage = new OverviewPage(getDriver());
        overviewPage.open();
        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page is not opened");
        Header header = overviewPage.getHeader();
        Assert.assertTrue(header.isUIObjectPresent(2), "Header element wasn't found!");
        Assert.assertTrue(header.isSearchComponentPresent(2), "Search component element not found");
        Assert.assertTrue(header.isSearchComponentElementsPresent(2), "Search component elements not found");
    }

    @Test()
    @MethodOwner(owner = "ashvedava")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testGitHubLink() {
        OverviewPage overviewPage = new OverviewPage(getDriver());
        overviewPage.open();
        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page is not opened");
        Header header = overviewPage.getHeader();
        Assert.assertTrue(header.isUIObjectPresent(2), "Header element wasn't found!");
        Assert.assertTrue(header.isGitHubPresent(2), "Header doesn't contain GitHub link");
        Assert.assertTrue(header.isGitHubRedirectToURL(Url.GITHUB), "Clicking on GitHub link doesn't redirect to GitHub page");
    }

    @Test()
    @MethodOwner(owner = "ashvedava")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testHeaderSticky() {
        OverviewPage overviewPage = new OverviewPage(getDriver());
        overviewPage.open();
        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page is not opened");
        Header header = overviewPage.getHeader();
        Assert.assertTrue(header.isUIObjectPresent(2), "Header element wasn't found!");
        Footer footer = overviewPage.getFooter();
        Assert.assertTrue(overviewPage.isHeaderVisible(), "Header not visible while page scrolling");
        Assert.assertTrue(overviewPage.isHeaderAtTheTop(), "Header is not at the top of the page");
    }
}