package TestOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class DriverInit {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public void setDriver(String... browser) {
        String brLoc = browser.length > 0 ? browser[0] : "chrome";
        switch (brLoc) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
        }
        wait = new WebDriverWait(driver, 10);
    }

    public WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    //Base Method for clicking at single locator
    public void oneLocClick(By Loc_0) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(Loc_0)).click();
    }

    //Base Method for clicking at dual locators
    public void twoLocClick(By Loc_1, By Loc_2) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(Loc_1)).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(Loc_2)).click();
    }
}
