package RiaPages;

import TestOptions.DriverInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class OtherRiaSites extends DriverInit {
    private final Logger log = LogManager.getLogger(OtherRiaSites.class);
    private final By contentHeaderLinks = By.xpath("//div[@class = 'container-header']");

    public By getContentHeaderLinks() {
        return contentHeaderLinks;
    }

    public void baseCheck(String LogText, String URLsite) {
        log.info(LogText);
        String parentWindow = getDriver().getWindowHandle();
        Set<String> handles = getDriver().getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                getDriver().switchTo().window(windowHandle);

                getWait().until(ExpectedConditions.visibilityOfElementLocated(contentHeaderLinks));

                compareLinks(URLsite);
                getDriver().close();
                getDriver().switchTo().window(parentWindow);
            }
        }
    }

    public void compareLinks(String trueLink) {
        log.info("Comparing links");
        String actualLink = getDriver().getCurrentUrl();
        if (trueLink.equals(actualLink)) {
            System.out.println("Current Link " + trueLink + " is RIGHT: " + actualLink);
        } else
            System.out.println("Current Link " + trueLink + " is WRONG: " + actualLink);
    }

    public OtherRiaSites checkRiaCom() {
        baseCheck("checkRiaCom", "https://www.ria.com/");
        return this;
    }

    public OtherRiaSites checkRealty() {
        baseCheck("checkRealty", "https://dom.ria.com/");
        return this;
    }

    public OtherRiaSites checkCarGoods() {
        baseCheck("checkCarGoods", "https://market.ria.com/");
        return this;
    }

    public OtherRiaSites checkAutoParts() {
        baseCheck("checkAutoParts", "https://zapchasti.ria.com/");
        return this;
    }
}
