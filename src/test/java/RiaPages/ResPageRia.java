package RiaPages;

import TestOptions.DriverInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ResPageRia extends DriverInit {
    private final Logger log = LogManager.getLogger(ResPageRia.class);
    private final By firstElementSearch = By.xpath("//div[@class = 'content-bar']//a[@class = 'address']");
    private final By fifthElementSearch = By.xpath("//div[@class = 'ticket-photo loaded']");

    public ResPageRia resultSearchHomePage() {
        log.info("resultSearchHomePage");
        getDriver().switchTo().parentFrame();
        oneLocClick(fifthElementSearch);
        return this;
    }

    public ResPageRia clickFirstElementSearch() {
        log.info("clickFirstElementSearch");
        oneLocClick(firstElementSearch);
        return this;
    }
}
