package Tests;

import org.junit.Test;
import org.openqa.selenium.By;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.CheckoutSecondPage;
import Pages.LoginPage;
import Pages.ProductsListPage;

public class CheckoutTests extends BaseTest {
    String customerName = "Marko";
    String customerLastName = "Mitrovic";
    String customerZipCode = "11000";

    By checkoutFirstNameFieldBy = By.id("first-name");
    By checkoutLastNameFieldBy = By.id("last-name");
    By checkoutZipCodeFieldBy = By.id("postal-code");




    @Test
    public void verifyCancelShopButton(){

        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);


        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.addToCart();
        productListPage.navigateToCart();
        cartPage.navigateToCheckoutButton();
        checkoutPage.CancelButton();
        cartPage.verifyCancelButton();
    }
    @Test
    public void verifySubmitCustomerDetails(){
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
        checkoutSecondPage.verifyNavigationToCheckoutSecondPage();
    }
}
