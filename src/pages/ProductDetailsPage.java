package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver){
        super(driver);
    }

    By backToProductsBy = By.id("back-to-products");
    By addToCartBy = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
    By shopingCartBadgeBy = By.className("shopping_cart_badge");
    By removeFromCart = By.xpath("//button[@class='btn btn_secondary btn_small btn_inventory']");

    public ProductDetailsPage verifyNavigationToPdp(){
        assertElementVisible(backToProductsBy);
        return this;
    }

    public ProductDetailsPage navigateToPLP(){
        click(backToProductsBy);
        return this;
    }

    public ProductDetailsPage addItemToCart(){
        click(addToCartBy);
        return this;
    }

    public ProductDetailsPage verifyProductIsAdded(){
        assertElementVisible(shopingCartBadgeBy);
        return this;
    }

    public ProductDetailsPage removeItemFromCart(){
        click(removeFromCart);
        return this;
    }

    public ProductDetailsPage verifyProductIsRemoved(){
        assertElementVisible(addToCartBy);
        return this;
    }
}
