package pl.solvd.carina;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.util.*;

public class Navigation extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//nav[@aria-label='Navigation']")
    private ExtendedWebElement navigationComponents;
    @FindBy(xpath = "//nav[@aria-label='Navigation']/ul[@class='md-nav__list']")
    private List<ExtendedWebElement> navigationList;
    @FindBy(xpath = "//li[@class='md-nav__item']")
    private List<ExtendedWebElement> listItem;
    @FindBy(xpath = "//a[contains(@class,'link--active')]/..")
    private ExtendedWebElement currentPage;
    @FindBy(xpath = "//a/../input[contains(@id,'__toc')]/..")
    private ExtendedWebElement highlitedPage;
    @FindBy(xpath = "//li[contains(@class, 'nested')]//nav//ul[@class='md-nav__list']")
    private NestedNavigationMenu nestedNavigationMenu;
    @FindBy(xpath = "//li//following-sibling::*[@class='md-nav__link']")
    private List<ExtendedWebElement> navigateLink;
    @FindBy(xpath = "//li//following-sibling::*[@class='md-nav__link'][@href]")
    private List<ExtendedWebElement> navigateLinkWithoutParent;

    public Navigation(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public NestedNavigationMenu getNestedNavigationMenu() {
        return nestedNavigationMenu;
    }

    public boolean isBrandFirstElement() {
        String brandName = "Carina";
        return navigationComponents.getElement().findElement(By.tagName("label")).getText().equals(brandName);
    }

    public boolean isNavigationListPresent() {
        for (ExtendedWebElement element : navigationList) {
            if (!element.isElementPresent()) {
                return false;
            }
        }
        return true;
    }

    public boolean isCurrentPageHighlighted() {
        return highlitedPage.getElement().equals(currentPage.getElement());
    }

    public boolean isNestedNavigationMenu() {
        for (ExtendedWebElement e : navigationList) {
            if (e.getElement().isSelected() == nestedNavigationMenu.getRootExtendedElement().getElement().isSelected()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean isHiddenElementInNavigationMenu() {
        for (ExtendedWebElement e : listItem) {
            if (!e.isVisible() || nestedNavigationMenu.getNestedBlock().contains(e)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSubPagesReveals() {
        for (int i = 0; i < navigationList.size(); ) {
            if (navigationList.get(i).getElement().isSelected() == nestedNavigationMenu.getParentItem().getElement().isSelected()) {
                nestedNavigationMenu.getParentItem().click();
                if (nestedNavigationMenu.getNestedBlock().get(0).isElementPresent(2)) {
                    return true;
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    public boolean isRedirectToURL() {
        for (int i = 0; i < navigateLink.size(); i++) {
            String u = navigateLink.get(i).getAttribute("href");
            if (!(navigateLink.get(i).isClickable())) {
                System.out.printf("URL %s is empty", u);
                LOGGER.error(String.format("URL %s is empty", u));
            } else {
                if (u == null) {
                    navigateLink.get(i++).click();
                }
                navigateLink.get(i).click();
//                System.out.println(u);
//                if (!u.startsWith(Url.OVERVIEW.getUrl()) && u != null) {
//                    System.out.println("URL belongs to another domain, skipping it.");
//                    continue;
//                }
                driver.navigate().back();
            }
        }
        return true;
    }
}
