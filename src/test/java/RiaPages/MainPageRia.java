package RiaPages;

import TestOptions.DriverInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class MainPageRia extends DriverInit {
    private final Logger log = LogManager.getLogger(MainPageRia.class);
    private final By enterCabinet = By.xpath("//div[@class = 'app-head-bar']//*[text() = 'Вход в кабинет']");
    private final By brandSearchBlock = By.xpath("//div[@id= 'brandTooltipBrandAutocomplete-brand']/label");
    private final By modelSearchBlock = By.id("brandTooltipBrandAutocomplete-model");
    private final By regionSearchBlock = By.id("regionAutocompleteAutocomplete-1");
    private final By yearFromSearchBlock = By.id("yearFrom");
    private final By yearToSearchBlock = By.id("yearTo");
    private final By submitButtonSearchBlock = By.xpath("//button[@class= 'button']");
    private final By extendedSearchButton = By.xpath("//span[text() = 'Расширенный поиск']");
    private final By newCarsHeader = By.xpath("//div[@class = 'container-header']//a[text() = 'Новые авто']");
    private final By specialVehicleHome = By.xpath("//i[@class = 'i-tt-spectex']");
    private final By buldozerIconHome = By.xpath("//a[@title= 'Бульдозер']");
    private final By skodaList = By.xpath("//ul[@class= 'unstyle scrollbar autocomplete-select']//a[text() = 'Skoda']");
    private final By modelList = By.xpath("//ul[@class= 'unstyle scrollbar autocomplete-select']//a[text() = 'Octavia A5']");
    private final By regionList = By.xpath("//div[@class= 'autocomplete-search mhide']//a[text() = 'Винница']");
    private final By yearFromList = By.xpath("//select[@id= 'yearFrom']/option[10]");
    private final By yearToList = By.xpath("//select[@id= 'yearTo']/option[5]");
    private final By allForAuto = By.xpath("//li[@class= 'nav-list_item has-dropdown']");
    private final By catalogCTO = By.xpath("//li[@class= 'nav-list_item has-dropdown']//a[text() = 'Каталог СТО ']");
    private final By questionsFooter = By.xpath("//div[@class = 'support-app-footer']//a[@class = 'button button-primary']");
    private final By headerLinkRiaCom = By.xpath("//nav[@class = 'nav-head']//a[text() = 'RIA.com']");
    private final By headerLinkRealty = By.xpath("//nav[@class = 'nav-head']//a[text() = 'Недвижимость']");
    private final By headerLinkCarGoods = By.xpath("//nav[@class = 'nav-head']//a[text() = 'Автотовары']");
    private final By headerLinkAutoParts = By.xpath("//nav[@class = 'nav-head']//a[text() = 'Автозапчасти']");
    private final By abroadCar = By.xpath("//section[@id = 'recomended-section']//a[text() = 'Поиск авто из-за рубежа']");
    private final By typeTruck = By.xpath("//section[@class = 'box-panel line']//span[text() = 'Грузовики']");
    private final By truckTypeTank = By.xpath("//nav[@class = 'catalog-referrals open-mobile']//a[text() = 'Цистерна']");

    public MainPageRia clickCabinet() {
        log.info("clickCabinet");
        oneLocClick(enterCabinet);
        return this;
    }

    public MainPageRia fillBrand() {
        log.info("fillBrand");
        twoLocClick(brandSearchBlock, skodaList);
        return this;
    }

    public MainPageRia fillModel() {
        log.info("fillModel");
        twoLocClick(modelSearchBlock, modelList);
        return this;
    }

    public MainPageRia fillRegion() {
        log.info("fillRegion");
        twoLocClick(regionSearchBlock, regionList);
        return this;
    }

    public MainPageRia fillYear() {
        log.info("fillYear");
        twoLocClick(yearFromSearchBlock, yearFromList);
        twoLocClick(yearToSearchBlock, yearToList);
        return this;
    }

    public MainPageRia clickSubmitButton() {
        log.info("clickSubmitButton");
        oneLocClick(submitButtonSearchBlock);
        return this;
    }

    public MainPageRia clickExtendedSearch() {
        log.info("clickExtendedSearch");
        oneLocClick(extendedSearchButton);
        return this;
    }

    public MainPageRia clickNewCarsHeader() {
        log.info("clickNewCarsHeader");
        oneLocClick(newCarsHeader);
        return this;
    }

    public MainPageRia clickSpecialVehicle() {
        log.info("clickSpecialVehicle");
        oneLocClick(specialVehicleHome);
        return this;
    }

    public MainPageRia clickBuldozer() {
        log.info("clickBuldozer");
        oneLocClick(buldozerIconHome);
        return this;
    }

    public MainPageRia clickRiaCom() {
        log.info("clickRiaCom");
        oneLocClick(headerLinkRiaCom);
        return this;
    }

    public MainPageRia clickRealty() {
        log.info("clickRealty");
        oneLocClick(headerLinkRealty);
        return this;
    }

    public MainPageRia clickCarGoods() {
        log.info("clickCarGoods");
        oneLocClick(headerLinkCarGoods);
        return this;
    }

    public MainPageRia clickAutoParts() {
        log.info("clickAutoParts");
        oneLocClick(headerLinkAutoParts);
        return this;
    }

    public MainPageRia clickAbroadCar() {
        log.info("clickAbroadCar");
        oneLocClick(abroadCar);
        return this;
    }

    public MainPageRia clickTruck() {
        log.info("clickTruck");
        twoLocClick(typeTruck, truckTypeTank);
        return this;
    }

    public MainPageRia hoverClickCars() {
        log.info("hoverClickCars");
        Actions action = new Actions(getDriver());
        getWait().until(ExpectedConditions.visibilityOfElementLocated(allForAuto));
        action.moveToElement(getDriver().findElement(allForAuto)).build().perform();
        getDriver().findElement(catalogCTO).click();
        return this;
    }

    public MainPageRia clickQuestionsFooter() {
        log.info("clickQuestionsFooter");
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,4000)");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(questionsFooter)).click();
        return this;
    }

    public MainPageRia switchToNewWindow() {
        log.info("switchToNewWindow");
        String parentWindow = getDriver().getWindowHandle();
        Set<String> handles = getDriver().getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                getDriver().switchTo().window(windowHandle);
            }
        }
        return this;
    }
}
