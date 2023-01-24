package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutSecondPage extends BasePage{
    public CheckoutSecondPage(WebDriver driver){
        super(driver);
    }
    By paymentInformationBy = By.xpath("//div[@class='summary_info_label']");
    By itemInSecondCheckoutBy = By.xpath("//div[@class='inventory_item_name']");
    By cancelShopFromCheckoutSecondPage = By.xpath("//button[@id='cancel']");
    By finishShoppingBy = By.xpath("//button[@id='finish']");
    By confirmedShoppingIsFinishedPictureBy = By.xpath("//img[@alt='Pony Express']");



    public CheckoutSecondPage verifyNavigationToCheckoutSecondPage(){
        assertElementVisible(paymentInformationBy);
        return this;
    }
    public CheckoutSecondPage navigationToPdpFromCheckoutSecondPage(){
        click(itemInSecondCheckoutBy);
        return this;
    }
    public CheckoutSecondPage navigationToPlpFromCheckoutSecondPage(){
        click(cancelShopFromCheckoutSecondPage);
        return this;
    }
    public CheckoutSecondPage finishShopping(){
        click(finishShoppingBy);
        return this;
    }
    public CheckoutSecondPage verifyFinishShopping(){
        assertElementVisible(confirmedShoppingIsFinishedPictureBy);
        return this;
    }
}
