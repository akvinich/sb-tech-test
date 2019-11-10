package tech.sb.scenario;

import org.testng.annotations.DataProvider;
import tech.sb.scenario.framework.bo.Product;

public class DataProviders {

    public static final int COUNT = 10;

    @DataProvider(name = "Products")
    public static Object[][] newMessage() {
        return new Object[][] {
                {Product.newEntity()
                        .withCategory("planshety")
                        .withCount(COUNT)
                        .withManufacturers(new String[] {"HP", "Lenovo"})
                        .withPriceTo("30000")
                        .build() },
                {Product.newEntity()
                        .withCategory("noutbuki")
                        .withCount(COUNT)
                        .withManufacturers(new String[] {"Acer", "DELL"})
                        .withPriceFrom("20000")
                        .withPriceTo("25000")
                        .build() },
        };
    }
}
