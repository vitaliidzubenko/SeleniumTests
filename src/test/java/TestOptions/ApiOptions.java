package TestOptions;

import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class ApiOptions {
    private final Logger log = LogManager.getLogger(ApiOptions.class);
    protected final String APIKey = "api_key=3gGaWJ5XsrkOF7gx3qrg2Nhaw7iy8g4EjqYCbSQL";

    @BeforeTest(alwaysRun = true)
    public static void setup() {
        RestAssured.baseURI = "https://developers.ria.com/";
        RestAssured.port = 8080;
        RestAssured.basePath = "";
    }

    @BeforeMethod
    public void open() {
        System.out.println("==================================================================================");
        System.out.println("******************************====START_OF_TEST====*******************************");
        System.out.println("==================================================================================");
        log.info("Start of Test/ Opening Browser");
    }

    @AfterMethod
    public void close(ITestResult result) {
        log.info("Closing Browser");
        System.out.println("==================================================================================");
        System.out.println("******************************====FINISH_OF_TEST===*******************************");
        System.out.println("==================================================================================");
    }

}
