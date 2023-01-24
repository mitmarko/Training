package Tests;

import org.junit.Test;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ProductsListPage;

public class ProductsListTest extends BaseTest{
    int expectedNumber = 6;
    String filterOptionNameAZ = "az";
    String filterOptionNameZA = "za";
    String filterOptionPriceLohi= "lohi";
    String filterOptionPriceHilo = "hilo";

    @Test
    public void verifyClickHamburgerMenu(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productListPage.clickHamburgerMenu();
    }
    @Test
    public void verifyLogoutButtonClick(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.clickHamburgerMenu();
        productListPage.clickLogout();
        loginPage.verifySuccessfulLogout();
    }
    @Test
    public void verifyNumberOfItems(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.clickHamburgerMenu();
        productListPage.clickAllItems();
        productListPage.verifyNumberOfItems(expectedNumber);
    }
    @Test
    public void verifyFilterFromAtoZ(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.selectFilterOptionByValue(filterOptionNameAZ);
        productListPage.verifyFilterFromAtoZ();
    }
    @Test
    public void verifyFilterFromZtoA(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.selectFilterOptionByValue(filterOptionNameZA);
        productListPage.verifyFilterFromZtoA();
    }
    @Test
    public void verifyFilterByPriceFromLowToHigh(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.selectFilterOptionByValue(filterOptionPriceLohi);
        productListPage.verifyFilterByPriceLowToHigh();
    }
    @Test
    public void verifyFilterByPriceFromHighToLow(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.selectFilterOptionByValue(filterOptionPriceHilo);
        productListPage.verifyFilterByPriceHighToLow();
    }
    @Test
    public void verifyNavigationFromPlpToPdpfromTitle(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.navigateToPdpFromTitle();
        productDetailsPage.verifyNavigationToPdp();
    }
    @Test
    public void verifyNavigationFromPlpToPdpFromPicture(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.navigateToPdpFromPicture();
        productDetailsPage.verifyNavigationToPdp();
    }
    @Test
    public void verifyAddingItemToCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        CartPage checkoutPage = new CartPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.addToCart();
        productListPage.navigateToCart();
        checkoutPage.verifyAddToCart();      
    }
    @Test
    public void verifyRemovingItemFromCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(validUsername,validPassword);
        productListPage.addToCart();
        productListPage.removeFromCart();
        productListPage.verifyRemoveFromCart();

    }
}
