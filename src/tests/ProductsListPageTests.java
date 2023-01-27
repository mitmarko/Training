package tests;

import org.junit.Test;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductsListPage;

public class ProductsListPageTests extends BaseTest {
    int expectedNumberOfProducts = 6;
    String sortAtoZ = "az";
    String sortAtoZfirstItemName = "Sauce Labs Backpack";
    String sortZtoA = "za";
    String sortZtoAfirstItemName = "Test.allTheThings() T-Shirt (Red)";
    String sortLowToHigh = "lohi";
    String sortLowToHighItemPrice = "$7.99";
    String sortHighToLow = "hilo";
    String sortHighToLowItemPrice = "$49.99";

    @Test
    public void verifyNumberOfProducts(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.verifyNumberOfProducts(expectedNumberOfProducts);
    }

    @Test
    public void verifySortAtoZ(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.selectFilterOptionByValue(sortAtoZ);
        productsPage.verifyFirstItemName(sortAtoZfirstItemName);
    }

    @Test
    public void verifySortZtoA(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.selectFilterOptionByValue(sortZtoA);
        productsPage.verifyFirstItemName(sortZtoAfirstItemName);
    }

    @Test
    public void verifySortLowToHigh(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.selectFilterOptionByValue(sortLowToHigh);
        productsPage.verifyFirstItemPrice(sortLowToHighItemPrice);  
    }

    @Test
    public void verifySortHighToLow(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.selectFilterOptionByValue(sortHighToLow);
        productsPage.verifyFirstItemPrice(sortHighToLowItemPrice);
    }

    @Test
    public void verifyPDPNavigationViaName(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.navigateToPDPviaName();
        productDetailsPage.verifyNavigationToPdp();
    }

    @Test
    public void verifyPDPNavigationViaImage(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.navigateToPDPviaImage();
        productDetailsPage.verifyNavigationToPdp();
    }

    @Test
    public void verifyProductCanBeAddedInCartFromPLP(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.addProductToCart();
        productsPage.navigateToCart();
        cartPage.validateProductAdded();
    }

    @Test
    public void verifyProductCanBeRemovedFromCartOnPLP(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsPage = new ProductsListPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsPage.addProductToCart();
        productsPage.removeProductFromCart();
        productsPage.verifyProductRemoved();
    }
}
