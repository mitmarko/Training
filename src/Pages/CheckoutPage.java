package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver){
        super(driver);
    }
    By continueButtonBy = By.xpath("//input[@id='continue']");
    By cancelShopButtonBy = By.id("cancel");
    By checkoutFirstNameFieldBy = By.id("first-name");
    By checkoutLastNameFieldBy = By.id("last-name");
    By checkoutZipCodeFieldBy = By.id("postal-code");
    String customerName = "Marko";
    String customerLastName = "Mitrovic";
    String customerZipCode = "11000";
    
    public CheckoutPage verifyCheckoutButtonNavigation(){
        assertElementVisible(continueButtonBy);
        return this;
    }
    public CheckoutPage CancelButton(){
        click(cancelShopButtonBy);
        return this;
    }
    public CheckoutPage inputCustomerName(By elementBy, String customerFirstName){
        writeText(elementBy,customerFirstName);
        return this;
    }
    public CheckoutPage inputCustomerSurname (By elementBy, String customerLastName){
        writeText(elementBy,customerLastName);
        return this;
    }
    public CheckoutPage inputCustomerZipCode (By elementBy, String customerZipCode){
        writeText(elementBy,customerZipCode);
        return this;
    }
    public CheckoutPage submitCustomerDetails(){
        click(continueButtonBy);
        return this;
    }
}
