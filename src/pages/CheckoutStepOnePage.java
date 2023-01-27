package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage {
    public CheckoutStepOnePage(WebDriver driver){
        super(driver);
    }

    By pageTitleBy = By.xpath("//span[@class='title']");
    String expectedPageTitle = "CHECKOUT: YOUR INFORMATION";
    By nameInputBy = By.id("first-name");
    By lastNameInputBy = By.id("last-name");
    By postalCodeInputBy = By.id("postal-code");
    By continueButonBy = By.id("continue");
    By formErrorBy = By.xpath("//h3[@data-test='error']");
    By continueCheckoutButtonBy = By.id("continue");
    

    public CheckoutStepOnePage verifyNavigationToCheckout(){
        String actualText = readText(pageTitleBy);
        assertTextEquals(expectedPageTitle, actualText);
        return this;
    }

    public CheckoutStepOnePage fillOutForm(String name, String lastName, String postalCode){
        writeText(nameInputBy, name);
        writeText(lastNameInputBy, lastName);
        writeText(postalCodeInputBy, postalCode);
        return this;
    }

    public CheckoutStepOnePage submitForm(){
        click(continueButonBy);
        return this;
    }
    public CheckoutStepOnePage navigateFromCheckoutStepOneToTwo(){
        click(continueCheckoutButtonBy);
        return this;
    }

    public CheckoutStepOnePage validateFormError(String expectedError){
        String actualError = readText(formErrorBy);
        assertTextEquals(expectedError, actualError);
        return this;
    }
}
