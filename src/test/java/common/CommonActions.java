package common;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import static constants.Constants.TimeoutVariable.EXPLICIT_WAIT;

public class CommonActions {

    public static void waitForElementVisibility(By locator) {
        new WebDriverWait(BaseTest.getWebDriverInstance(), EXPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
