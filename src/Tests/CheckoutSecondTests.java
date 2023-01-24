package Tests;

import org.junit.Test;
import org.openqa.selenium.By;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.CheckoutSecondPage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ProductsListPage;

public class CheckoutSecondTests extends BaseTest{
    By checkoutFirstNameFieldBy = By.id("first-name");
    By checkoutLastNameFieldBy = By.id("last-name");
    By checkoutZipCodeFieldBy = By.id("postal-code");

    String customerName = "Unknown";
    String customerLastName = "Unknown";
    String customerZipCode = "11001";
    
    @Test
    public void verifyNavigationFromCheckoutSecondPageToPdp(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CheckoutSecondPage checkoutSecondPage = new CheckoutSecondPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);


        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.addToCart();
        productListPage.navigateToCart();
        cartPage.navigateToCheckoutButton();
        checkoutPage.inputCustomerName(checkoutFirstNameFieldBy, customerName);
        checkoutPage.inputCustomerSurname(checkoutLastNameFieldBy, customerLastName);
        checkoutPage.inputCustomerZipCode(checkoutZipCodeFieldBy, customerZipCode);
        checkoutPage.submitCustomerDetails();
        checkoutSecondPage.navigationToPdpFromCheckoutSecondPage();
        productDetailsPage.verifyNavigationToPdp();
    }
    @Test
    public void verifyNavigationFromCheckoutSecondPageToPlp(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CheckoutSecondPage checkoutSecondPage = new CheckoutSecondPage(driver);


        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.addToCart();
        productListPage.navigateToCart();
        cartPage.navigateToCheckoutButton();
        checkoutPage.inputCustomerName(checkoutFirstNameFieldBy, customerName);
        checkoutPage.inputCustomerSurname(checkoutLastNameFieldBy, customerLastName);
        checkoutPage.inputCustomerZipCode(checkoutZipCodeFieldBy, customerZipCode);
        checkoutPage.submitCustomerDetails();
        checkoutSecondPage.navigationToPlpFromCheckoutSecondPage();
        productListPage.verifyUserIsOnPlp();
    }
}
