package tech.sb.scenario;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import tech.sb.scenario.framework.bo.Product;
import tech.sb.scenario.yandex.pages.*;
import tech.sb.scenario.yandex.service.SearchProductService;

import static tech.sb.scenario.framework.util.Browser.*;

public class MarketTest extends Assert {

    private SearchProductService searchProductService;
    private SoftAssert softAssert = new SoftAssert();

    @Test(dataProvider = "Products", dataProviderClass = DataProviders.class)
    public void searchTest(Product product) {
        searchProductService = new SearchProductService(product);
        searchProductService.prepareAllFiltersPage();
        searchProductService.getFilterResults();
        ProductPage productPage = searchProductService.getProductPage();
        softAssert.assertEquals(productPage.getCountOfProducts(), product.getCount());
        String nameOfFirstProduct = productPage.getNameOfFirstProduct();
        productPage = productPage.findProductInMarket(nameOfFirstProduct);
        String firstSearchResult = productPage.getNameOfFirstProduct();
        assertEquals(firstSearchResult, nameOfFirstProduct);
        softAssert.assertAll();
    }

    @AfterTest
    public void closeBrowser() {
        getInstance().stopBrowser();
    }
}
