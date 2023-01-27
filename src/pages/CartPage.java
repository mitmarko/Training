package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver){
        super(driver);
    }

    By cartItemBy = By.xpath("//div[@class='cart_item']");
    By continueShoppingBy = By.id("continue-shopping");
    By itemNameBy = By.xpath("//div[@class='inventory_item_name']");
    By removeItemBy = By.xpath("//button[@class='btn btn_secondary btn_small cart_button']");
    By removedItemClassBy = By.className("removed_cart_item");
    By checkoutBtnBy = By.id("checkout");

    public CartPage validateProductAdded(){
        assertElementVisible(cartItemBy);
        return this;
    }

    public CartPage navigateToPLP(){
        click(continueShoppingBy);
        return this;
    }

    public CartPage navigateToPDP(){
        click(itemNameBy);
        return this;
    }

    public CartPage removeItemFromCart(){
        click(removeItemBy);
        return this;
    }
    
    public CartPage verifyItemIsRemoved(){
        assertElementNotVisible(removedItemClassBy);
        return this;
    }

    public CartPage proceedToCheckout(){
        click(checkoutBtnBy);
        return this;
    }
}
