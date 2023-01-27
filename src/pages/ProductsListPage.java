package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsListPage extends BasePage{
    
    public ProductsListPage(WebDriver driver){
        super(driver);
    }

    By pageTitleBy = By.xpath("//span[@class='title']");
    String pageTitle = "PRODUCTS";
    By hamburgerMenuBy = By.id("react-burger-menu-btn");
    By logoutLinkBy = By.id("logout_sidebar_link");
    By inventoryItemBy = By.xpath("//div[@class='inventory_item']");
    By filterBy = By.xpath("//select[@class='product_sort_container']");
    By firstProductNameBy = By.xpath("//div[@class='inventory_item_name']");
    By firstProductPriceBy = By.xpath("//div[@class='inventory_item_price']");
    By firstProductImageBy = By.xpath("//img[@class='inventory_item_img']");
    By addToCartBy = By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']");
    By cartIconBy = By.className("shopping_cart_link");
    By removeFromCartBy = By.xpath("//button[@data-test='remove-sauce-labs-backpack']");

    public ProductsListPage verifyUserIsOnPLP(){
        String actualPageTitle = readText(pageTitleBy);
        assertTextEquals(pageTitle, actualPageTitle);
        return this;
    }

    public ProductsListPage expandMenu(){
        click(hamburgerMenuBy);
        return this;
    }

    public ProductsListPage navigateToLogin(){
        click(logoutLinkBy);
        return this;
    }

    public ProductsListPage verifyNumberOfProducts(int expectedNumber){
        int actualNumber = countItems(inventoryItemBy);
        assertIntegerEquals(expectedNumber, actualNumber);
        return this;
    }

    public ProductsListPage selectFilterOptionByValue(String value){
        selectDropdownOptionByValue(filterBy, value);
        return this;
    }

    public ProductsListPage verifyFirstItemName(String expectedText){
        String actualText = readText(firstProductNameBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public ProductsListPage verifyFirstItemPrice(String expectedPrice){
        String actualPrice = readText(firstProductPriceBy);
        assertTextEquals(expectedPrice, actualPrice);
        return this;
    }

    public ProductsListPage navigateToPDPviaName(){
        click(firstProductNameBy);
        return this;
    }

    public ProductsListPage navigateToPDPviaImage(){
        click(firstProductImageBy);
        return this;
    }

    public ProductsListPage addProductToCart(){
        click(addToCartBy);
        return this;
    }

    public ProductsListPage removeProductFromCart(){
        click(removeFromCartBy);
        return this;
    }

    public ProductsListPage verifyProductRemoved(){
        assertElementVisible(addToCartBy);
        return this;
    }

    public ProductsListPage navigateToCart(){
        click(cartIconBy);
        return this;
    }
}
