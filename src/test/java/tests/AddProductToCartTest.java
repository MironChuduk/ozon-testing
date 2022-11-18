package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.cart.Product;
import services.CartService;
import services.HomePageService;
import services.ResultsOfSearchService;

public class AddProductToCartTest extends BaseTest {
    private HomePageService homePageService;
    private ResultsOfSearchService resultsOfSearchService;
    private CartService cartService;

    @Test
    public void addProductToCartTest() {
        Product expectedProduct = Product.getExpectedProduct("product");

        homePageService = new HomePageService();
        resultsOfSearchService = homePageService.searchProduct("Christmas tree");
        resultsOfSearchService.chooseCategory("Дом и сад");
        resultsOfSearchService.sortProducts("Сначала дорогие");
        resultsOfSearchService.addFirstProductToCart();
        Product actualSearchedProduct = resultsOfSearchService.getSearchedProduct();
        Assert.assertEquals(actualSearchedProduct, expectedProduct);
        cartService = resultsOfSearchService.goToCartPage();

        Product actualProductInCart = cartService.getActualProduct();
        Assert.assertEquals(actualProductInCart, expectedProduct);
    }
}
