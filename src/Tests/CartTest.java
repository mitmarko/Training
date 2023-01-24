package Tests;

import org.junit.Test;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ProductsListPage;

public class CartTest extends BaseTest {
   
    @Test
    public void verifyNavigationFromCartToPlp(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.addToCart();
        productListPage.navigateToCart();
        cartPage.navigateFromCartToPlp();
        productListPage.verifyBackToPlp();
    }
    @Test
    public void  verifyNavigationToCheckout(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.addToCart();
        productListPage.navigateToCart();
        cartPage.navigateToCheckoutButton();
        checkoutPage.verifyCheckoutButtonNavigation();
    }
    @Test
    public void verifyNavigationFromCartToPdp(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);


        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.addToCart();
        productListPage.navigateToCart();
        cartPage.navigateFromCartToPdP();
        productDetailsPage.verifyNavigationToPdp();
    }
        @Test
        public void verifyRemoveFromCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.addToCart();
        productListPage.navigateToCart();
        cartPage.removeItemFromCart();
        cartPage.verifyRemoveItemFromCart();
    }
}
