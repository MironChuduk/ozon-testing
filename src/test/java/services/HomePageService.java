package services;

import pages.HomePage;

public class HomePageService {
    private HomePage homePage;

    public ResultsOfSearchService searchProduct(String productName) {
        homePage = new HomePage();
        homePage.fillSearchBox(productName);
        homePage.clickOnSearchButton();
        return new ResultsOfSearchService();
    }
}
