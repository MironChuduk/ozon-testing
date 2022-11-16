package pages;

import common.CommonActions;
import org.openqa.selenium.By;
import pages.cart.CartPage;

public class ResultsOfSearchPage extends BasePage {
    private final By sortList = By.xpath("//div[@role='listbox']");
    private final By sortParameter = By.xpath("//*[@role='option'][4]");
    private final By addToCartButton = By
            .xpath("//div[@class='kr6 rk6']//div[@class='d9r ds k4p']//button");
    private final By cartButton = By.xpath("//a[@href='/cart']");
    private final By productTitle = By.xpath("//span[@class='dy9 yd9 dz zd1 tsBodyL ko2']");
    private final By productPrice = By.xpath("//span[@class='_32-a2']");
    private final By productPriceBeforeDiscount = By.xpath("//span[@class='_32-b1 _32-a5']");

    public ResultsOfSearchPage() {
        super();
    }

    public void clickOnSortList() {
        CommonActions.waitElementIsVisible(sortList);
        driver.findElement(sortList).click();
    }

    public void chooseSortParameter() {
        driver.findElement(sortParameter).click();
    }

    public void chooseCategory(String categoryName) {
        driver.findElement(By.xpath(String.format("//aside//a[contains(text(), '%s')]", categoryName))).click();
    }

    public void addFirstProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public CartPage goToCart() {
        driver.findElement(cartButton).click();
        return new CartPage();
    }

    public String getProductTitle() {
        CommonActions.waitElementIsVisible(productTitle);
        return driver.findElement(productTitle).getText();
    }

    public String getProductPrice() {
        CommonActions.waitElementIsVisible(productPrice);
        return driver.findElement(productPrice).getText();
    }

    public String getProductPriceBeforeDiscount() {
        CommonActions.waitElementIsVisible(productPriceBeforeDiscount);
        return driver.findElement(productPriceBeforeDiscount).getText();
    }
}
