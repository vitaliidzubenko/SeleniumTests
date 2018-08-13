package Study.PF_Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage_PF extends PageInit {

    @FindBy(xpath = "//*[@class = 'section-first']//a[@title = 'Open account']")
    private WebElement openButton;

    public void clickOnLoginButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(openButton));
        openButton.click();
    }
}
