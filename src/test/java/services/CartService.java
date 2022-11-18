package services;

import org.apache.commons.lang3.StringUtils;
import pages.cart.CartPage;
import pages.cart.Product;

public class CartService {
    CartPage cartPage;

    public Product getActualProduct() {
        cartPage = new CartPage();
        String productPrice = cartPage.getProductPrice();
        String productPriceBeforeDiscount = cartPage.getProductPriceBeforeDiscount();

        productPrice = StringUtils.deleteWhitespace(productPrice
                .replace("BYN", "")
                .replace(",", "."));
        productPriceBeforeDiscount = StringUtils.deleteWhitespace(productPriceBeforeDiscount
                .replace("BYN", "")
                .replace(",", "."));

        return new Product.ProductBuilder()
                .setProductTitle(cartPage.getProductTitle())
                .setPrice(productPrice)
                .setPriceBeforeDiscount(productPriceBeforeDiscount)
                .build();
    }
}
