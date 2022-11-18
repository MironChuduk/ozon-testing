package pages.cart;

import utils.PropertiesParser;

import java.util.Objects;

public class Product {
    private String productTitle;
    private String price;
    private String priceBeforeDiscount;

    private Product(ProductBuilder builder) {
        this.productTitle = builder.productTitle;
        this.price = builder.price;
        this.priceBeforeDiscount = builder.priceBeforeDiscount;
    }

    public static class ProductBuilder {
        private String productTitle;
        private String price;
        private String priceBeforeDiscount;

        public ProductBuilder setProductTitle(String productTitle) {
            this.productTitle = productTitle;
            return this;
        }

        public ProductBuilder setPrice(String price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setPriceBeforeDiscount(String priceBeforeDiscount) {
            this.priceBeforeDiscount = priceBeforeDiscount;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productTitle='" + productTitle + '\'' +
                ", price='" + price + '\'' +
                ", priceBeforeDiscount='" + priceBeforeDiscount + '\'' +
                '}';
    }

    public static Product getExpectedProduct(String key) {
        PropertiesParser propertiesParser = new PropertiesParser();
        String[] listOfProperties = propertiesParser.parsProperties(key);
        return new ProductBuilder()
                .setProductTitle(listOfProperties[0])
                .setPrice(listOfProperties[1])
                .setPriceBeforeDiscount(listOfProperties[2])
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product giftCard = (Product) o;
        return Objects.equals(price, giftCard.price) && Objects.equals(priceBeforeDiscount, giftCard.priceBeforeDiscount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productTitle, price, priceBeforeDiscount);
    }
}
