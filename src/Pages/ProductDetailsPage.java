package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver){
        super(driver);
    }
    By backpackItemBy = By.xpath("//div[@class='inventory_item_name']");
    By backToPlpButton = By.xpath("//button[@class='btn btn_secondary back btn_large inventory_details_back_button']");
    By addToCartFromPdpButtonBy = By.id("add-to-cart-sauce-labs-backpack");
    By removeFromCartButtonInPdpB = By.id("remove-sauce-labs-backpack");


    public ProductDetailsPage verifyNavigationToPdp(){
        assertElementVisible(backToPlpButton);
        return this;
    }
    public ProductDetailsPage navigateBackToPlp(){
        click(backToPlpButton);
        return this;
    }
    public ProductDetailsPage addToCartFromPdp(){
        click(addToCartFromPdpButtonBy);
        return this;
    }
    public ProductDetailsPage verifyAddToCartFromPdp(){
        assertElementVisible(removeFromCartButtonInPdpB);
        return this;
    }
}
