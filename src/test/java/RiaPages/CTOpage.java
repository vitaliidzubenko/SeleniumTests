package RiaPages;

import TestOptions.DriverInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CTOpage extends DriverInit {
    private final Logger log = LogManager.getLogger(CTOpage.class);
    private final By cityList = By.xpath("//div[@id= 'brandTooltipBrandAutocomplete-2']");
    private final By cityVin = By.xpath("//form[@class= 'c-search']//div[@id = 'brandTooltipBrandAutocomplete-2']//a[text() = 'Винницкая']");
    private final By searchButton = By.xpath("//form[@class = 'c-search']//button[@class = 'button-primary']");
    private final By officialTick = By.xpath("(//div[@class = 'mhide checkbox-area']//div[@class= 'checkbox-item']/label)[3]");
    private final By searchCTO = By.xpath("//form[@class = 'sto-main_form']/button");
    private final By showPhone = By.xpath("//div[@class = 'item-result-services']//a[text() = 'показать']");
    private final By phoneShown = By.xpath("//div[@class = 'item-result-services']//span[@class = 'bold green pointer']");

    public By getPhoneShown() {
        return phoneShown;
    }

    public CTOpage chooseCity() {
        log.info("chooseCity");
        twoLocClick(cityList, cityVin);
        log.info("Submit");
        oneLocClick(searchButton);
        return this;
    }

    public CTOpage chooseOfficial() {
        log.info("chooseOfficial");
        twoLocClick(officialTick, searchCTO);
        return this;
    }

    public CTOpage showHiddenPhone() {
        log.info("showHiddenPhone");
        oneLocClick(showPhone);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(phoneShown));
        return this;
    }
}
