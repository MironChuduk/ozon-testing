package pages.cart;

import common.CommonActions;
import org.openqa.selenium.By;
import pages.BasePage;

public class CartPage extends BasePage {
    private final By productTitle =
            By.xpath("//div[@class='db9 eb']//span[contains(@class, 'tsBodyM')]");
    private final By productPrice = By.xpath("//div[@class='db9 be0']/span");
    private final By productPriceBeforeDiscount = By.xpath("//span[@class='b5c']");

    public CartPage() {
        super();
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
