package RiaPages;

import TestOptions.DriverInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExtendSearchPageRia extends DriverInit {
    private final Logger log = LogManager.getLogger(ExtendSearchPageRia.class);
    private final By bodyTypeExtendedSearch = By.xpath("//div[@class = 'bg-transport__type']//*[@class= 'item-checkbox'][1]");
    private final By enterBrandExtendedSearch = By.xpath("//div[@id = 'brandContainer']//li[@title= 'Skoda']");
    private final By yearFromExtendedSearch = By.xpath("//div[@id = 'yearContainer']//input[@placeholder = 'Год от']");
    private final By yearToExtendedSearch = By.xpath("//div[@id = 'yearContainer']//input[@placeholder = 'до']");
    private final By regionExtendedSearch = By.xpath("//div[@id = 'regionContainer']//*[@data-index= '1']");
    private final By fuelTypeExtendedSearch = By.xpath("//div[@id = 'engineBlock']//*[text()= 'Бензин']");
    private final By showResultsExtendedSearch = By.xpath("//div[@class = 'wrap']//*[text() = 'Показать']");
    private final By chevroletIcon = By.xpath("//a[@title = 'Chevrolet']");
    private final By suburbanModel = By.xpath("//section[@class = 'box-panel m-margin']//a[text() = 'Suburban ']");
    private final By firstImageSuburban = By.xpath("//a[@class = 'photo-294x190']");
    private final By offersForElement = By.xpath("//section[@id = 'offers_count']//a");
    private final By allPageContent = By.xpath("//div[@class = 'app-content page-search']");
    private final By priceFrom = By.id("priceFrom");
    private final By priceTo = By.id("priceTo");
    private final By searchButton = By.xpath("//button[@class= 'button-primary']");
    private final By brandtruck = By.xpath("//div[@id = 'brandTooltipBrandAutocomplete-1']");
    private final By truckMAN = By.xpath("//ul[@class= 'unstyle scrollbar autocomplete-select']//span[text() = 'MAN']");
    private final By yearFrom = By.xpath("//select[@name = 's_yers[0]']");
    private final By yearFrom2010 = By.xpath("//select[@name = 's_yers[0]']//option[5]");
    private final By yearTo = By.xpath("//select[@name = 'po_yers[0]']");
    private final By yearTo2018 = By.xpath("//select[@name = 'po_yers[0]']//option[2]");
    private final By emptyResultsBlock = By.xpath("//div[@id = 'emptyResultsBlock']");

    public By getEmptyResultsBlock() {
        return emptyResultsBlock;
    }

    public ExtendSearchPageRia fillBodyType() {
        log.info("fillBodyType");
        oneLocClick(bodyTypeExtendedSearch);
        return this;
    }

    public ExtendSearchPageRia fillBrand() {
        log.info("fillBrand");
        oneLocClick(enterBrandExtendedSearch);
        return this;
    }

    public ExtendSearchPageRia fillregion() {
        log.info("fillregion");
        oneLocClick(regionExtendedSearch);
        return this;
    }

    public ExtendSearchPageRia fillFuelType() {
        log.info("fillFuelType");
        oneLocClick(fuelTypeExtendedSearch);
        return this;
    }

    public ExtendSearchPageRia clickShowResultsButton() {
        log.info("clickShowResultsButton");
        oneLocClick(showResultsExtendedSearch);
        return this;
    }

    public ExtendSearchPageRia clickChevrolet() {
        log.info("clickChevrolet");
        oneLocClick(chevroletIcon);
        return this;
    }

    public ExtendSearchPageRia clickSuburban() {
        log.info("clickSuburban");
        oneLocClick(suburbanModel);
        return this;
    }

    public ExtendSearchPageRia firstGenModel() {
        log.info("firstGenModel");
        oneLocClick(firstImageSuburban);
        return this;
    }

    public ExtendSearchPageRia offersForModel() {
        log.info("offersForModel");
        oneLocClick(offersForElement);
        return this;
    }

    public ExtendSearchPageRia fillBrandTruck() {
        log.info("fillBrandTruck");
        twoLocClick(brandtruck, truckMAN);
        return this;
    }

    public ExtendSearchPageRia modelInfo() {
        log.info("modelInfo");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(allPageContent));
        return this;
    }

    public ExtendSearchPageRia priceBuldozer(String priceF, String priceT) {
        log.info("priceBuldozer");
        getDriver().findElement(priceFrom).sendKeys(priceF);
        getDriver().findElement(priceTo).sendKeys(priceT);
        log.info("SubmitButton");
        oneLocClick(searchButton);
        return this;
    }

    public ExtendSearchPageRia fillYearstruck() {
        log.info("fillYearsTruck");
        twoLocClick(yearFrom, yearFrom2010);
        twoLocClick(yearTo, yearTo2018);
        log.info("SubmitButton");
        oneLocClick(searchButton);
        return this;
    }

    public ExtendSearchPageRia fillYear(String yearF, String yearT) {
        log.info("fillYear");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(yearFromExtendedSearch)).sendKeys(yearF);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(yearToExtendedSearch));
        getDriver().findElement(yearToExtendedSearch).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        getDriver().findElement(yearToExtendedSearch).sendKeys(yearT);
        return this;
    }
}
