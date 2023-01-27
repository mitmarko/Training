package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompleteShopping extends BasePage {
    public CompleteShopping(WebDriver driver){
        super(driver);
    }
    By completedPurchaseImgBy = By.xpath("//img[@alt='Pony Express']");
    public CompleteShopping validateSuccessfulPurchase(){
        assertElementVisible(completedPurchaseImgBy);
        return this;
    }
}
