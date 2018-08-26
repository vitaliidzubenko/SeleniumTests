package RiaPages;

import TestOptions.DriverInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DetailResPageRia extends DriverInit {
    private final Logger log = LogManager.getLogger(DetailResPageRia.class);
    private final By contentDisplayed = By.xpath("//div[@class = 'app-content']");
    private final By propose = By.xpath("//section[@class = 'view-auto_info-seller ']");
    private final By firstResultBuldozer = By.xpath("//div[@class = 'item ticket-title']");
    private final By proposeLink = By.xpath("//a[@class = 'na-card-item '][1]");
    private final By abroadLithuania = By.xpath("//div[@class = 'seo-catalog-main']//a[@title = 'Авто из Литвы ']");
    private final By vehicleType = By.xpath("//select[@name = 'vehicleClass_id']");
    private final By passengerType = By.xpath("//select[@name = 'vehicleClass_id']//option[2]");
    private final By brandOfCar = By.xpath("//select[@name = 'make_id']");
    private final By brandBMW = By.xpath("//select[@name = 'make_id']//option[3]");
    private final By modelOfCar = By.xpath("//select[@name = 'model_id']");
    private final By x5mModel = By.xpath("//select[@name = 'model_id']//option[@value = '149']");
    private final By filteredCar = By.xpath("//div[@class = 'ticket-item paid']//a[@title = 'Подробно']");

    public By getContentDisplayed() {
        return contentDisplayed;
    }

    public By getPropose() {
        return propose;
    }

    public DetailResPageRia detailedInfoElement() {
        log.info("detailedInfoElement");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(contentDisplayed));
        return this;
    }

    public DetailResPageRia detailsBuldozer() {
        log.info("detailsBuldozer");
        //Fixing trouble with stale element exception
        boolean breakIt;
        while (breakIt = true) {
            try {
                getWait().until(ExpectedConditions.elementToBeClickable(firstResultBuldozer)).click();
                getWait().until(ExpectedConditions.elementToBeClickable(contentDisplayed));
            } catch (Exception e) {
                if (e.getMessage().contains("element is not attached")) {
                    breakIt = false;
                }
            }
            if (breakIt) {
                break;
            }
        }
        return this;
    }

    public DetailResPageRia proposeChevy() {
        log.info("proposeChevrolet");
        oneLocClick(proposeLink);
        return this;
    }

    public DetailResPageRia clickLithuania() {
        log.info("clickLithuania");
        oneLocClick(abroadLithuania);
        return this;
    }

    public DetailResPageRia clickVehicleType() {
        log.info("clickVehicleType");
        oneLocClick(vehicleType);
        getDriver().findElement(passengerType).click();

        return this;
    }

    public DetailResPageRia clickBrandType() {
        log.info("clickBrandType");
        oneLocClick(brandOfCar);
        getDriver().findElement(brandBMW).click();
        return this;
    }

    public DetailResPageRia clickModelOfCar() {
        log.info("clickModelOfCar");
        //Fixing trouble with stale element exception
        boolean breakIt;
        while (breakIt = true) {
            try {
                oneLocClick(modelOfCar);
                getDriver().findElement(x5mModel).click();
                Thread.sleep(4000);
                log.info("Waiting for refreshed results");
            } catch (Exception e) {
                if (e.getMessage().contains("element is not attached")) {
                    breakIt = false;
                }
            }
            if (breakIt) {
                break;
            }
        }
        return this;
    }

    public DetailResPageRia clickFilteredCar() {
        log.info("clickFilteredCar");
        oneLocClick(filteredCar);
        return this;
    }
}
