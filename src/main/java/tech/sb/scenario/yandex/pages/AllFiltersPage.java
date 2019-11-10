package tech.sb.scenario.yandex.pages;

import org.openqa.selenium.By;

import static tech.sb.scenario.framework.util.Browser.*;

public class AllFiltersPage {

    private By isOnThisPageElementLocator = By.cssSelector("div.layout.layout_type_search.i-bem");
    private By priceFromLocator = By.id("glf-pricefrom-var");
    private By priceToLocator = By.id("glf-priceto-var");
    private By showFilteredButtonLocator = By.cssSelector("a.button_action_show-filtered");
    private By moreManufacturersButtonLocator = By.cssSelector("div[data-filter-id='7893318'] button");

    public AllFiltersPage() {
        if (!getInstance().isElementPresent(isOnThisPageElementLocator)) {
            throw new RuntimeException("This page is not ComputerCatalogPage.");
        }
    }

    public AllFiltersPage setPriceFrom(String from) {
        getInstance().sendKeys(priceFromLocator, from);
        return this;
    }

    public AllFiltersPage setPriceTo(String to) {
        getInstance().sendKeys(priceToLocator, to);
        return this;
    }

    public AllFiltersPage setManufacturers(String... manufacturers) {
        getInstance().click(moreManufacturersButtonLocator);
        for (String item : manufacturers) {
            By showFilteredButtonLocator  = By.xpath("//div[@data-filter-id='7893318']//label[contains(., '"
                    + item + "')]");
            getInstance().jsClickElement(showFilteredButtonLocator);
        }
        return this;
    }

    public ProductPage showFilterResults() {
        getInstance().jsClickElement(showFilteredButtonLocator);
        return new ProductPage();
    }
}
