package tech.sb.scenario.yandex.pages;

import org.openqa.selenium.By;

import static tech.sb.scenario.framework.util.Browser.*;

public class MainPage {

    public static final String URL = "https://yandex.ru";

    private By marketLinkLocator = By.cssSelector("a[data-id=market]");
    private By isOnThisPageElementLocator = By.cssSelector("div.container.container__search.container__line");

    public MainPage open() {
        getInstance().get(URL);
        if (!getInstance().isElementPresent(isOnThisPageElementLocator)) {
            throw new RuntimeException("This page is not MainPage.");
        }
        return this;
    }

    public MarketPage goToMarket() {
        getInstance().click(marketLinkLocator);
        return new MarketPage();
    }
}
