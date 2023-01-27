package tests;

import org.junit.Test;

import pages.CartPage;
import pages.CheckoutStepOnePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductsListPage;

public class CartTests extends BaseTest {

    @Test
    public void verifyNavigationBackToPLP(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.navigateToCart();
        cartPage.navigateToPLP();
        productsPage.verifyUserIsOnPLP();
    }

    @Test
    public void verifyNavigationBackToPDP(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.addProductToCart();
        productsPage.navigateToCart();
        cartPage.navigateToPDP();
        productDetailsPage.verifyNavigationToPdp();
    }

    @Test
    public void verifyUserCanRemoveItemFromCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.addProductToCart();
        productsPage.navigateToCart();
        cartPage.removeItemFromCart();
        cartPage.verifyItemIsRemoved();
    }

    @Test
    public void verifyUserCanProceedToCheckout(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutStepOnePage checkoutStepOne = new CheckoutStepOnePage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.addProductToCart();
        productsPage.navigateToCart();
        cartPage.proceedToCheckout();
        checkoutStepOne.verifyNavigationToCheckout();
    }
}
