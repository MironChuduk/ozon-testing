package services;

import org.apache.commons.lang3.StringUtils;
import pages.ResultsOfSearchPage;
import pages.cart.CartPage;
import pages.cart.Product;

public class ResultsOfSearchService {
    ResultsOfSearchPage resultsOfSearchPage;

    public void sortProducts(String sortOptionName) {
        resultsOfSearchPage = new ResultsOfSearchPage();
        resultsOfSearchPage.clickOnSortList();
        resultsOfSearchPage.chooseSortParameter(sortOptionName);
    }

    public void chooseCategory(String categoryName) {
        resultsOfSearchPage = new ResultsOfSearchPage();
        resultsOfSearchPage.chooseCategory(categoryName);
    }

    public void addFirstProductToCart() {
        resultsOfSearchPage.addFirstProductToCart();
    }

    public CartService goToCartPage() {
        resultsOfSearchPage.goToCart();
        resultsOfSearchPage.closeOfferWindow();
        return new CartService();
    }

    public Product getSearchedProduct() {
        String productPrice = resultsOfSearchPage.getProductPrice();
        String productPriceBeforeDiscount = resultsOfSearchPage.getProductPriceBeforeDiscount();

        productPrice = StringUtils.deleteWhitespace(productPrice
                .replace("BYN", "")
                .replace(",", "."));
        productPriceBeforeDiscount = StringUtils.deleteWhitespace(productPriceBeforeDiscount
                .replace("BYN", "")
                .replace(",", "."));
        return new Product.ProductBuilder()
                .setProductTitle(resultsOfSearchPage.getProductTitle())
                .setPrice(productPrice)
                .setPriceBeforeDiscount(productPriceBeforeDiscount)
                .build();
    }
}
