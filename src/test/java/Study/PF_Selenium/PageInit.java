package Study.PF_Selenium;

import TestOptions.DriverInit;
import org.openqa.selenium.support.PageFactory;

public abstract class PageInit extends DriverInit {

    public PageInit() {
        PageFactory.initElements(getDriver(), this);
    }

}
