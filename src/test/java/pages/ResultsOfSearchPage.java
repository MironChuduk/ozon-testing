package pages;

import common.CommonActions;
import org.openqa.selenium.By;
import pages.cart.CartPage;

public class ResultsOfSearchPage extends BasePage {
    private final By sortList = By.xpath("//div[@role='listbox']");
    private final By addToCartButton = By
            .xpath("//div[@class='sd3 d4s k1q']//button");
    private final By cartButton = By.xpath("//a[@href='/cart']");
    private final By productTitle = By.xpath("//span[@class='d3z z3d d4z d6z tsBodyL ok9']");
    private final By productPrice = By.xpath("//span[@class='_32-a3 _32-a5 _32-b']");
    private final By productPriceBeforeDiscount = By.xpath("//span[@class='_32-b1 _32-a5']");
    private final By closeOfferWindowButton = By.xpath("//div[@class='cu5 _4-a']/button");

    public ResultsOfSearchPage() {
        super();
    }

    public void clickOnSortList() {
        CommonActions.waitForElementVisibility(sortList);
        driver.findElement(sortList).click();
    }

    public void chooseSortParameter(String sortOptionName) {
        //By sortParameter = By.xpath("//*[@role='option' and contains(text(), 'Сначала дорогие']");
        By sortParameter = By.xpath(String.format("//*[contains(text(), '%s')]", sortOptionName));
        driver.findElement(sortParameter).click();
    }

    public void chooseCategory(String categoryName) {
        driver.findElement(By.xpath(String.format("//aside//a[contains(text(), '%s')]", categoryName))).click();
    }

    public void addFirstProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void closeOfferWindow() {
        CommonActions.waitForElementVisibility(closeOfferWindowButton);
        driver.findElement(closeOfferWindowButton).click();
    }

    public CartPage goToCart() {
        driver.findElement(cartButton).click();
        return new CartPage();
    }

    public String getProductTitle() {
        CommonActions.waitForElementVisibility(productTitle);
        return driver.findElement(productTitle).getText();
    }

    public String getProductPrice() {
        CommonActions.waitForElementVisibility(productPrice);
        return driver.findElement(productPrice).getText();
    }

    public String getProductPriceBeforeDiscount() {
        CommonActions.waitForElementVisibility(productPriceBeforeDiscount);
        return driver.findElement(productPriceBeforeDiscount).getText();
    }
}
