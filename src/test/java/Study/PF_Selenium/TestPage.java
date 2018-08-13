package Study.PF_Selenium;

import TestOptions.TestAnnotation;
import org.testng.annotations.Test;

public class TestPage extends TestAnnotation {

    protected MainPage_PF mainPage = new MainPage_PF();
    protected LoginPage_PF loginPage = new LoginPage_PF();
    protected FinishPage_PF finishPage = new FinishPage_PF();

    @Test
    public void start_PF() {
        getDriver().get("https://www.cryptomusu.com");
        mainPage.clickOnLoginButton();
        loginPage.fillingRegForm();
        finishPage.waitForFinshReg();
    }
}
