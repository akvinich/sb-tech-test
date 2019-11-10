package tech.sb.scenario.yandex.pages;

import org.openqa.selenium.By;

import static tech.sb.scenario.framework.util.Browser.*;

public class ComputerCatalogPage {

    private By isOnThisPageElementLocator = By.cssSelector("div[data-reactroot] h1");

    public ComputerCatalogPage() {
        if (!getInstance().isElementPresent(isOnThisPageElementLocator)) {
            throw new RuntimeException("This page is not ComputerCatalogPage.");
        }
    }

    public ProductPage goToListOfProducts(String product) {
        By allCategoriesLocator = By.xpath("//a[contains(@href, 'catalog--" + product + "')]");
        getInstance().click(allCategoriesLocator);
        return new ProductPage();
    }

}
