package GoogleTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test configuration.
 */
public class TestConfig {
    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
    }

    /**
     * WebDriver instance.
     */
    protected WebDriver webDriver;

    @AfterMethod
    public void afterMethod() {

        webDriver.quit();
        webDriver = null;
    }
}
