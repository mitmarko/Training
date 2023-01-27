package tests;

import org.junit.Test;

import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductsListPage;

public class ProductDetailsPageTests extends BaseTest {
    
    @Test
    public void verifyBackToPLP(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);
        ProductDetailsPage singleProductPage = new ProductDetailsPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.navigateToPDPviaName();
        singleProductPage.navigateToPLP();
        productsPage.verifyUserIsOnPLP();
    }

    @Test
    public void verifyUserCanAddProductToCartFromPDP(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);
        ProductDetailsPage singleProductPage = new ProductDetailsPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.navigateToPDPviaName();
        singleProductPage.addItemToCart();
        singleProductPage.verifyProductIsAdded();
    }

    @Test
    public void verifyUserCanRemoveProductFromCartFromPDP(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);
        ProductDetailsPage singleProductPage = new ProductDetailsPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.navigateToPDPviaName();
        singleProductPage.addItemToCart();
        singleProductPage.removeItemFromCart();
        singleProductPage.verifyProductIsRemoved();
    }

}
