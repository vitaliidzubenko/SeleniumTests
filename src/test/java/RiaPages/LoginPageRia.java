package RiaPages;

import TestOptions.DriverInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class LoginPageRia extends DriverInit {
    private final Logger log = LogManager.getLogger(LoginPageRia.class);
    private final By register = By.xpath("//a[@title= 'Зарегистрироваться на AUTO.RIA']");
    private final By enterWithGoogle = By.xpath("//a[@class = 'item g-social']");
    private final By emailPopUp = By.xpath("//input[@name= 'identifier']");
    private final By next = By.xpath("//div[@id = 'identifierNext']");
    private final By passwordPopUp = By.xpath("//input[@name= 'password']");
    private final By nextButtonPopUp = By.xpath("//div[@id= 'passwordNext']");
    private final By afterLoginField = By.xpath("//div[@class = 'position-login-block']");

    public By getAfterLoginField() {
        return afterLoginField;
    }

    public LoginPageRia clickEnterGoogle() {
        log.info("clickEnterGoogle");
        oneLocClick(enterWithGoogle);
        return this;
    }

    public LoginPageRia checkForEnabledGoogle() {
        log.info("checkForEnabledGoogle");
        oneLocClick(afterLoginField);
        return this;
    }

    public LoginPageRia clickRegister() {
        log.info("clickRegister");
        getDriver().switchTo().frame("login_frame");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(register)).click();
        return this;
    }

    public LoginPageRia fillPopUpGoogle(String email, String password) {
        log.info("fillPopUpGoogle");
        String parentWindow = getDriver().getWindowHandle();
        Set<String> handles = getDriver().getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                getDriver().switchTo().window(windowHandle);

                getWait().until(ExpectedConditions.visibilityOfElementLocated(emailPopUp));
                getDriver().findElement(emailPopUp).sendKeys(email);
                getDriver().findElement(next).click();
                getWait().until(ExpectedConditions.visibilityOfElementLocated(passwordPopUp));
                getDriver().findElement(passwordPopUp).sendKeys(password);
                getDriver().findElement(nextButtonPopUp).click();

                getDriver().close();
                getDriver().switchTo().window(parentWindow);
            }
        }
        return this;
    }
}
