package Tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {
    WebDriver driver;
    String validUsername = "standard_user";
    String validPassword = "secret_sauce";

    @Before
    public void setup(){
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false);

        driver = new FirefoxDriver(options);

        driver.manage().window().maximize();
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
