package tech.sb.scenario.yandex.service;

import tech.sb.scenario.framework.bo.Product;
import tech.sb.scenario.yandex.pages.*;

public class SearchProductService {

    private Product product;
    private MainPage mainPage = new MainPage().open();
    private AllFiltersPage allFiltersPage;
    private ProductPage productPage;

    public SearchProductService(Product product) {
        this.product = product;
    }

    public ProductPage getProductPage() {
        return productPage;
    }

    public void prepareAllFiltersPage() {
        allFiltersPage = mainPage.goToMarket().openAllCategories().selectComputerTechnology()
                .goToListOfProducts(product.getCategory()).openAllFilters();
    }

    public void getFilterResults() {
        if (product.getPriceFrom() != null) {
            allFiltersPage = allFiltersPage.setPriceFrom(product.getPriceFrom());
        }
        if (product.getPriceTo() != null) {
            allFiltersPage = allFiltersPage.setPriceTo(product.getPriceTo());
        }
        productPage = allFiltersPage.setManufacturers(product.getManufacturers()).showFilterResults();
    }

}
