package Study.PF_Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FinishPage_PF extends PageInit {

    @FindBy(xpath = "//div[@class = 'wrap-content-pandats']")
    private WebElement cashier;

    public void waitForFinshReg() {
        getWait().until(ExpectedConditions.visibilityOf(cashier));

    }
}
