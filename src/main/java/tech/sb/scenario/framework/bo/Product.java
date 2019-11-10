package tech.sb.scenario.framework.bo;

import java.util.Arrays;

public class Product {

    private String category;
    private int count;
    private String priceFrom;
    private String priceTo;
    private String[] manufacturers;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
    }

    public String getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(String priceTo) {
        this.priceTo = priceTo;
    }

    public String[] getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(String[] manufacturers) {
        this.manufacturers = manufacturers;
    }

    @Override
    public String toString() {
        return "Product{"
                + "category='" + category + '\''
                + ", count=" + count
                + ", priceFrom='" + priceFrom + '\''
                + ", priceTo='" + priceTo + '\''
                + ", manufacturers=" + Arrays.toString(manufacturers)
                + '}';
    }

    public static Builder newEntity() {
        return new Product().new Builder();
    }

    public final class Builder {

        private Builder() {
        }

        public Builder withCategory(String categoryBuild) {
            Product.this.category = categoryBuild;
            return this;
        }

        public Builder withCount(int countBuild) {
            Product.this.count = countBuild;
            return this;
        }

        public Builder withPriceFrom(String priceFromBuild) {
            Product.this.priceFrom = priceFromBuild;
            return this;
        }

        public Builder withPriceTo(String priceToBuild) {
            Product.this.priceTo = priceToBuild;
            return this;
        }

        public Builder withManufacturers(String[] manufacturersBuild) {
            Product.this.manufacturers = manufacturersBuild;
            return this;
        }

        public Product build() {
            return Product.this;
        }
    }
}
