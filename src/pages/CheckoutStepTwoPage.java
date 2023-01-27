package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends BasePage{
    public CheckoutStepTwoPage(WebDriver driver){
        super(driver);
    }
    By cancelShoppingButtonBy = By.id("cancel");
    By finishShoppingButtonBy = By.id("finish");



    By sauceLabsBackpackPurchasedBy = By.xpath("//div[@class='inventory_item_name']");
    String nameOfProduct = "Sauce Labs Backpack";

    public CheckoutStepTwoPage validateNavigationFromCheckoutStepOneToTwo(){
        String actualNameOfProduct = readText(sauceLabsBackpackPurchasedBy);
        assertTextEquals(nameOfProduct, actualNameOfProduct);
        return this;
    }
    public CheckoutStepTwoPage navigateFromCheckoutStepTwoToPlp(){
        click(cancelShoppingButtonBy);
        return this;
    }
    public CheckoutStepTwoPage finishShopping(){
        click(finishShoppingButtonBy);
        return this;
    }
}
