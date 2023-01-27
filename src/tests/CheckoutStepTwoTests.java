package tests;

import org.junit.Test;

import pages.CartPage;
import pages.CheckoutStepOnePage;
import pages.CheckoutStepTwoPage;
import pages.CompleteShopping;
import pages.LoginPage;
import pages.ProductsListPage;

public class CheckoutStepTwoTests extends BaseTest {
    String validName = "John";
    String validLastname = "McClean";
    String validPostalCode = "11250";



    @Test
    public void verifyNavigationFromCheckoutStepTwoToPlp(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutStepOnePage checkoutStepOne = new CheckoutStepOnePage(driver);
        CheckoutStepTwoPage checkoutStepTwo = new CheckoutStepTwoPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.addProductToCart();
        productsPage.navigateToCart();
        cartPage.proceedToCheckout();
        checkoutStepOne.fillOutForm(validName, validLastname, validPostalCode);
        checkoutStepOne.navigateFromCheckoutStepOneToTwo();
        checkoutStepTwo.validateNavigationFromCheckoutStepOneToTwo();
        checkoutStepTwo.navigateFromCheckoutStepTwoToPlp();
        productsPage.verifyUserIsOnPLP();
    }
    @Test
    public void verifySuccesfulPurchase(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutStepOnePage checkoutStepOne = new CheckoutStepOnePage(driver);
        CheckoutStepTwoPage checkoutStepTwo = new CheckoutStepTwoPage(driver);
        CompleteShopping completeShopping = new CompleteShopping(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.addProductToCart();
        productsPage.navigateToCart();
        cartPage.proceedToCheckout();
        checkoutStepOne.fillOutForm(validName, validLastname, validPostalCode);
        checkoutStepOne.navigateFromCheckoutStepOneToTwo();
        checkoutStepTwo.validateNavigationFromCheckoutStepOneToTwo();
        checkoutStepTwo.finishShopping();
        completeShopping.validateSuccessfulPurchase();
    }
}
