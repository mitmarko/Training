package Tests;

import org.junit.Test;

import Pages.LoginPage;
import Pages.ProductsListPage;

public class LoginTests extends BaseTest {
    String incorrectUsername = "wrong_username";
    String incorrectPassword = "wrongPassword";
    String lockedOutUsername = "locked_out_user";
    String noUsername = "";
    String noPassword = "";
    String errorMessage = "Epic sadface: Username and password do not match any user in this service";
    String errorMessageLockedUser = "Epic sadface: Sorry, this user has been locked out.";
    String errorMessageNoInput = "Epic sadface: Username is required";
    String errorMessageNoPassword = "Epic sadface: Password is required";
    
    @Test
    public void verifySuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsListPage = new ProductsListPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(validUsername, validPassword);
        productsListPage.verifyUserIsOnPlp();

    }
    @Test
    public void verifyWrongUsernameLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(incorrectUsername,incorrectPassword);
        loginPage.verifyIncorrectLogin(errorMessage);
    }
    @Test
    public void verifyLockedOutUserLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(lockedOutUsername, validPassword);
        loginPage.verifyIncorrectLogin(errorMessageLockedUser);
    }
    @Test
    public void verifyNoUsernameLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(noUsername, validPassword);
        loginPage.verifyIncorrectLogin(errorMessageNoInput);
    }
    @Test
    public void verifyNoPasswordLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(validUsername,noPassword);
        loginPage.verifyIncorrectLogin(errorMessageNoPassword);
    }
}
