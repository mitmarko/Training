package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver){
        super(driver);
    }
    By continueShoppingButtonBy = By.id("continue-shopping");
    By itemTitleInCheckoutBy = By.xpath("//div[@class='inventory_item_name']");
    By removeButtonFromCheckoutBy = By.id("remove-sauce-labs-backpack");
    By checkoutButtonBy = By.id("checkout");
    By navigateFromCartToPdpBy = By.xpath("//div[@class='inventory_item_name']");
    By removedItemListBy = By.xpath("//div[@class='removed_cart_item']");
    String expectedTextCheckout = "Sauce Labs Backpack";

    public CartPage verifyAddToCart(){
        assertElementVisible(removeButtonFromCheckoutBy);
        return this;
    }
    public CartPage navigateFromCartToPlp(){
        click(continueShoppingButtonBy);
        return this;
    }
    public CartPage navigateToCheckoutButton(){
        click(checkoutButtonBy);
        return this;
    }
    public CartPage verifyCancelButton(){
        assertElementVisible(checkoutButtonBy);
        return this;
    }
    public CartPage navigateFromCartToPdP(){
        click(navigateFromCartToPdpBy);
        return this;
    }
    public CartPage removeItemFromCart(){
        click(removeButtonFromCheckoutBy);
        return this;
    }
    public CartPage verifyRemoveItemFromCart(){
        assertElementNotVisible(removedItemListBy);

        return this;
    }
}
