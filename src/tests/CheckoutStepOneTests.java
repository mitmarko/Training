package tests;

import org.junit.Test;

import pages.CartPage;
import pages.CheckoutStepOnePage;
import pages.CheckoutStepTwoPage;
import pages.LoginPage;
import pages.ProductsListPage;

public class CheckoutStepOneTests extends BaseTest{
    String validName = "John";
    String validLastname = "McClean";
    String validPostalCode = "11250";
    String expectedNameError = "Error: First Name is required";
    String expectedLastNameError = "Error: Last Name is required";
    String expectedZipCodeError = "Error: Postal Code is required";

    @Test
    public void verifyNameFieldIsRequired(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutStepOnePage checkoutStepOne = new CheckoutStepOnePage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.addProductToCart();
        productsPage.navigateToCart();
        cartPage.proceedToCheckout();
        checkoutStepOne.fillOutForm("", validLastname, validPostalCode);
        checkoutStepOne.submitForm();
        checkoutStepOne.validateFormError(expectedNameError);

    }
    @Test
    public void verifyLastNameFieldIsRequired(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutStepOnePage checkoutStepOne = new CheckoutStepOnePage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.addProductToCart();
        productsPage.navigateToCart();
        cartPage.proceedToCheckout();
        checkoutStepOne.fillOutForm(validName, "", validPostalCode);
        checkoutStepOne.submitForm();
        checkoutStepOne.validateFormError(expectedLastNameError);
    }
    @Test
    public void verifyZipFieldIsRequired(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutStepOnePage checkoutStepOne = new CheckoutStepOnePage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.addProductToCart();
        productsPage.navigateToCart();
        cartPage.proceedToCheckout();
        checkoutStepOne.fillOutForm(validName, validLastname, "");
        checkoutStepOne.submitForm();
        checkoutStepOne.validateFormError(expectedZipCodeError);
    }
    @Test
    public void verifyValidCheckoutInput(){
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
    }
}
