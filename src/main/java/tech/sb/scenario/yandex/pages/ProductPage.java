package tech.sb.scenario.yandex.pages;

import org.openqa.selenium.By;

import static tech.sb.scenario.framework.util.Browser.*;

public class ProductPage {

    private By isOnThisPageElementLocator = By.cssSelector("div.layout__col");
    private By allFiltersButtonLocator = By.cssSelector("div[data-zone-name=all-filters-button] a");
    private By productsLocator = By.cssSelector("div.layout__col_search-results_normal div.n-snippet-card2__title a");
    private By firstProductLocator =
            By.cssSelector("div.layout__col_search-results_normal div.n-snippet-card2__title a:first-child");
    private By searchFieldLocator = By.id("header-search");
    private By findButtonLocator = By.cssSelector("span.search2__button button");

    public ProductPage() {
        if (!getInstance().isElementPresent(isOnThisPageElementLocator)) {
            throw new RuntimeException("This page is not ProductPage.");
        }
    }

    public String getNameOfFirstProduct() {
        return getInstance().getText(firstProductLocator);
    }

    public int getCountOfProducts() {
        return getInstance().getCountOfElements(productsLocator);
    }

    public ProductPage findProductInMarket(String text) {
        getInstance().sendKeys(searchFieldLocator, text);
        getInstance().click(findButtonLocator);
        return this;
    }

    public AllFiltersPage openAllFilters() {
        getInstance().click(allFiltersButtonLocator);
        return new AllFiltersPage();
    }
}
