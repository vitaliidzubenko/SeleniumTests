package TestOptions;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestAnnotation extends DriverInit {
    private final Logger log = LogManager.getLogger(TestAnnotation.class);
    private final String MainUrl = "https://auto.ria.com/";

    @BeforeMethod
    public void setUp() {
        System.out.println("==================================================================================");
        System.out.println("******************************====START_OF_TEST====*******************************");
        System.out.println("==================================================================================");
        log.info("Start of Test/ Opening Browser");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().get(MainUrl);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        log.info("Closing Browser");
        System.out.println("==================================================================================");
        System.out.println("******************************====FINISH_OF_TEST===*******************************");
        System.out.println("==================================================================================");
        if (!result.isSuccess()) {
            saveScreenshot(getDriver());
        }
    }

    @AfterTest
    public void finish() {
        log.info("Closing session");
        getDriver().manage().deleteAllCookies();
        getDriver().close();
        System.out.println("==================================================================================");
        System.out.println("******************************====END_OF_SESSION===*******************************");
        System.out.println("==================================================================================");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
