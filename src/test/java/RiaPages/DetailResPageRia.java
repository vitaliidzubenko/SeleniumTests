package RiaPages;

import TestOptions.DriverInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DetailResPageRia extends DriverInit {
    private final Logger log = LogManager.getLogger(DetailResPageRia.class);
    private final By contentDisplayed = By.xpath("//div[@class = 'app-content']");
    private final By firstResultBuldozer = By.xpath("//div[@class = 'item ticket-title']");
    private final By proposeContent = By.xpath("//a[@class = 'na-card-item']");
    private final By abroadLithuania = By.xpath("//section[@id = 'autoinerCountryDefault']//a[@title = 'Авто из Латвии ']");
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

    public By getProposeContent() {
        return proposeContent;
    }

    public DetailResPageRia detailedInfoElement() {
        log.info("detailedInfoElement");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(contentDisplayed));
        return this;
    }

    public DetailResPageRia detailsBuldozer() {
        log.info("detailsBuldozer");
        oneLocClick(firstResultBuldozer);
        getWait().until(ExpectedConditions.elementToBeClickable(contentDisplayed));
        return this;
    }

    public DetailResPageRia proposeChevy() {
        log.info("proposeChevrolet");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(proposeContent));
        return this;
    }

    public DetailResPageRia clickLithuania() {
        log.info("clickLithuania");
        oneLocClick(abroadLithuania);
        return this;
    }

    public DetailResPageRia clickVehicleType() {
        log.info("clickVehicleType");
        twoLocClick(vehicleType, passengerType);
        return this;
    }

    public DetailResPageRia clickBrandType() {
        log.info("clickBrandType");
        twoLocClick(brandOfCar, brandBMW);
        return this;
    }

    public DetailResPageRia clickModelOfCar() throws InterruptedException {
        log.info("clickModelOfCar");
        twoLocClick(modelOfCar, x5mModel);
        Thread.sleep(4000);
        log.info("Waiting for refreshed results");
        return this;
    }

    public DetailResPageRia clickFilteredCar() {
        log.info("clickFilteredCar");
        oneLocClick(filteredCar);
        return this;
    }
}
