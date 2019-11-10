package tech.sb.scenario.yandex.pages;

import org.openqa.selenium.By;

import static tech.sb.scenario.framework.util.Browser.*;

public class MarketPage {

    private By isOnThisPageElementLocator = By.cssSelector("a.logo_part_market");
    private By allCategoriesLocator = By.cssSelector("div.n-w-tab_interaction_click-navigation-menu");
    private By computerTechnologyLocator = By.xpath("//div[contains(@class, 'n-w-tabs__vertical-tabs')]"
            + "//a[contains(@href, 'kompiuternaia-tekhnika')]");

    public MarketPage() {
        if (getInstance().isElementPresent(isOnThisPageElementLocator)) {
            getInstance().click(isOnThisPageElementLocator);
        } else {
            throw new RuntimeException("This page is not MarketPage.");
        }
    }

    public MarketPage openAllCategories() {
        getInstance().click(allCategoriesLocator);
        return this;
    }

    public ComputerCatalogPage selectComputerTechnology() {
        getInstance().click(computerTechnologyLocator);
        return new ComputerCatalogPage();
    }

}
