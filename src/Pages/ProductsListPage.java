package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsListPage extends BasePage {
    public ProductsListPage(WebDriver driver){
        super(driver);
    }

    By locatorHamburgerMenu = By.id("react-burger-menu-btn");
    By pageTitleBy = By.xpath("//span[@class='title']");
    By locatorAllItemsBy = By.id("inventory_sidebar_link");
    By locatorCloseHamburgerMenu = By.id("react-burger-cross-btn");
    By locatorLogoutButton = By.id("logout_sidebar_link");
    By locatorForProductsBy = By.xpath("//div[@class='inventory_item']");
    String pageTitle = "PRODUCTS";
    String allItems = "ALL ITEMS";
    String filterOptionAZ = "NAME (A TO Z)";
    String filterOptionZA = "NAME (Z TO A)";
    String expectedFirstItemNameAtoZ = "Sauce Labs Backpack";
    String expectedFirstItemNameZtoA = "Test.allTheThings() T-Shirt (Red)";
    String expectedPriceFromLowToHigh = "$7.99";
    String expectedPriceFromHighToLow = "$49.99";
    By filterBy = By.xpath("//select[@class='product_sort_container']");
    By backPackItemTitleBy = By.xpath("//div[@class='inventory_item_name']");
    By firstItemSortedPriceHighBy = By.xpath("//div[@class='inventory_item_price']");
    By addToCartButtonBy = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
    By navigateToCheckoutBy = By.xpath("//a[@class='shopping_cart_link']");
    By removeFromCartButtonBy = By.xpath("//button[@class='btn btn_secondary btn_small btn_inventory']");
    By backpackPictureItemBy = By.xpath("//img[@alt='Sauce Labs Backpack']");
    
    

    public ProductsListPage verifyUserIsOnPlp(){
        String actualPageTitle = readText(pageTitleBy);
        assertTextEquals(pageTitle, actualPageTitle);
        return this;
    }

    public ProductsListPage clickHamburgerMenu(){
        click(locatorHamburgerMenu);
        String allItemsTxt = readText(locatorAllItemsBy);
        assertTextEquals(allItems, allItemsTxt);
        return this;
    }
    public ProductsListPage clickAllItems(){
        click(locatorAllItemsBy);
        return this;
    }
    public ProductsListPage clickLogout(){
        click(locatorLogoutButton);
        return this;
    }
    public ProductsListPage verifyNumberOfItems(int expectedNumber){
        int actualNumberOfItems = countItems(locatorForProductsBy);
        assertIntegerEquals(expectedNumber, actualNumberOfItems);
        return this;
    }
    public ProductsListPage selectFilterOptionByValue(String value){
        selectDropdownOptionByValue(filterBy, value);
        return this;
    }
    public ProductsListPage verifyFilterFromAtoZ(){
        String actualNameOfFirstItem = readText(backPackItemTitleBy);
        assertTextEquals(expectedFirstItemNameAtoZ, actualNameOfFirstItem);
        return this;
    }
    public ProductsListPage verifyFilterFromZtoA(){
        String actualNameOfProduct = readText(backPackItemTitleBy);
        assertTextEquals(expectedFirstItemNameZtoA, actualNameOfProduct);
        return this;
    }
    public ProductsListPage verifyFilterByPriceLowToHigh(){
       String actualPriceOfFirstItem = readText(firstItemSortedPriceHighBy);
       assertTextEquals(expectedPriceFromLowToHigh, actualPriceOfFirstItem);
       return this;
    }
    public ProductsListPage verifyFilterByPriceHighToLow(){
        String actualPriceOfFirstItem = readText(firstItemSortedPriceHighBy);
        assertTextEquals(expectedPriceFromHighToLow, actualPriceOfFirstItem);
        return this;
    }
    public ProductsListPage navigateToPdpFromTitle(){
        click(backPackItemTitleBy);
        return this;
    }
    public ProductsListPage navigateToPdpFromPicture(){
        click(backpackPictureItemBy);
        return this;
    }
    public ProductsListPage addToCart(){
        click(addToCartButtonBy);
        return this;
    }
    public ProductsListPage navigateToCart(){
        click(navigateToCheckoutBy);
        return this;
    }
    public ProductsListPage removeFromCart(){
        click(removeFromCartButtonBy);
        return this;
    }
    public ProductsListPage verifyRemoveFromCart(){
        assertElementVisible(addToCartButtonBy);
        return this;
    }
    public ProductsListPage verifyBackToPlp(){
        String actualPageTitle = readText(pageTitleBy);
        assertTextEquals(pageTitle, actualPageTitle);
        return this;
    }
}
