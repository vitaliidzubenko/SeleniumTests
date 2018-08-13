package TestOptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestAnnotation extends DriverInit {
    protected final Logger log = LogManager.getLogger(TestAnnotation.class);
    protected final String MainUrl = "https://auto.ria.com/";

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
    public void tearDown() {
        log.info("Closing Browser");
        System.out.println("==================================================================================");
        System.out.println("******************************====FINISH_OF_TEST===*******************************");
        System.out.println("==================================================================================");
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
}
