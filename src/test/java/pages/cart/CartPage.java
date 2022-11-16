package pages.cart;

import common.CommonActions;
import org.openqa.selenium.By;
import pages.BasePage;

public class CartPage extends BasePage {

    private final By closeWindowButton = By.xpath("//div[@class='uc2 _4-a']/button");
    private final By productTitle = By.xpath("//span[@class='dy9 yd9 zd zd2 tsBodyM b6c']");
    private final By productPrice = By.xpath("//span[@class='dy9 yd9 y9d d1z tsBodyLBold b6c']");
    private final By productPriceBeforeDiscount = By.xpath("//span[@class='b5c']");

    public CartPage() {
        super();
    }

    public void closeWindow() {
        CommonActions.waitElementIsVisible(closeWindowButton);
        driver.findElement(closeWindowButton).click();
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
