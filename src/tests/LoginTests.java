package tests;

import org.junit.Test;

import pages.LoginPage;
import pages.ProductsListPage;

public class LoginTests extends BaseTest{
    String expectedErrorEmptyUsername = "Epic sadface: Username is required";
    String expectedErrorEmptyPassword = "Epic sadface: Password is required";
    String lockedUserUsername = "locked_out_user";
    String lockedUserErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
    String invalidUsername = "testUser";
    String invalidPassword = "testPass";
    String invalidUserExpectedError = "Epic sadface: Username and password do not match any user in this service";

    @Test
    public void verifySuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsListPage = new ProductsListPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsListPage.verifyUserIsOnPLP();
    }

    @Test
    public void verifyEmptyUsernameLoginAttempt(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login("", validPassword);
        loginPage.verifyUnsuccessfulLogin(expectedErrorEmptyUsername);
    }

    @Test
    public void verifyEmptyPasswordLoginAttempt(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, "");
        loginPage.verifyUnsuccessfulLogin(expectedErrorEmptyPassword);
    }

    @Test
    public void verifyLockedUserLoginAttempt(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(lockedUserUsername, validPassword);
        loginPage.verifyUnsuccessfulLogin(lockedUserErrorMessage);
    }

    @Test
    public void verifyInvalidUsernameLoginAttempt(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(invalidUsername, validPassword);
        loginPage.verifyUnsuccessfulLogin(invalidUserExpectedError);
    }

    @Test
    public void verifyInvalidPasswordLoginAttempt(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, invalidPassword);
        loginPage.verifyUnsuccessfulLogin(invalidUserExpectedError);
    }

    @Test
    public void verifyUserLogout(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productListPage = new ProductsListPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productListPage.expandMenu();
        productListPage.navigateToLogin();
        loginPage.verifySuccessfulLogout();
    }
}
