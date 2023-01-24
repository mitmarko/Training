package Tests;

import org.junit.Test;

import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ProductsListPage;

public class ProductDetailsTest extends BaseTest {

    @Test
    public void verifyBackToPlpButton(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.navigateToPdpFromPicture();
        productDetailsPage.navigateBackToPlp();
        productListPage.verifyBackToPlp();
    }
    @Test
    public void verifyAddToCartFromPdp(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.navigateToPdpFromPicture();
        productDetailsPage.addToCartFromPdp();
        productDetailsPage.verifyAddToCartFromPdp();
    }
}
