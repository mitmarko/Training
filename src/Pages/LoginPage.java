package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    By usernameBy = By.id("user-name");
    By passwordBy = By.id("password");
    By loginButtonBy = By.id("login-button");
    By errorLocation = By.xpath("//h3[@data-test='error']");

    String baseUrl = "https://www.saucedemo.com/";

    public LoginPage goToBaseUrl(){
        driver.get(baseUrl);
        return this;
    }

    public LoginPage login(String username, String password){
         writeText(usernameBy, username);
         writeText(passwordBy, password);
         click(loginButtonBy);

        return this;
    }
    public LoginPage verifyIncorrectLogin(String expectedErrorString){
        String actualText = readText(errorLocation);
        assertTextEquals(actualText, expectedErrorString);

        return this;
    }
    public LoginPage verifySuccessfulLogout(){
        assertElementVisible(loginButtonBy);
        return this;
    }
}
