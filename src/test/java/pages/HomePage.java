package pages;

import common.CommonActions;
import org.openqa.selenium.By;

public class HomePage extends BasePage{
    private final By searchBox = By.xpath("//div[@data-widget='searchBarDesktop']//input[@type='text']");
    private final By searchButton = By.xpath("//button[@type='submit']");

    public HomePage() {
        super();
    }

    public void fillSearchBox(String nameOfProduct) {
        CommonActions.waitForElementVisibility(searchBox);
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(nameOfProduct);
    }

    public ResultsOfSearchPage clickOnSearchButton() {
        CommonActions.waitForElementVisibility(searchButton);
        driver.findElement(searchButton).click();
        return new ResultsOfSearchPage();
    }
}
