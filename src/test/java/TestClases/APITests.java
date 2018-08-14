package TestClases;

import TestOptions.ApiOptions;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;

public class APITests extends ApiOptions {
    private final Logger log = LogManager.getLogger(APITests.class);

    @Description("Checking status code at AutoRia")
    @Test(priority = 1)
    public void getStatusCode() {
        log.info("Start of test #1");
        Response response =
                given().
                        when().get();
        int code = response.getStatusCode();
        System.out.println("Status code is " + code);
        Assert.assertEquals(code, 200, "***Verification failed***");
        log.info("Test #1 finished");
    }

    @Description("Getting time of response at AutoRia")
    @Test(priority = 2)
    public void getResponseTime() {
        log.info("Start of test #2");
        long timeInSeconds = get().timeIn(TimeUnit.MILLISECONDS);
        System.out.println("Time of response is " + timeInSeconds + " MILLISECONDS");
        log.info("Test #2 finished");
    }

    @Description("Verifying that body contains Cities in Vinnitsa Region after sending params")
    @Test(priority = 3)
    public void getCityList() {
        log.info("Start of test #3");
        given().
                when().
                get("auto/states/1/cities?" + APIKey).
                then().
                assertThat().body("name", hasItem("Винница")).
                assertThat().body("name", hasItem("Немиров")).
                assertThat().body("name", hasItem("Тульчин"));
        log.info("Test #3 finished");
    }

    @Description("Verifying that body contains Types of Transport after sending params")
    @Test(priority = 4)
    public void getTypeOfTransport() {
        log.info("Start of test #4");
        given().
                when().
                get("auto/categories/?" + APIKey).
                then().
                assertThat().body("value", hasItems(1, 2, 3, 4, 5, 6, 7, 8, 9));
        log.info("Test #4 finished");
    }

    @Description("Verifying that body contains Marks after sending params")
    @Test(priority = 5)
    public void getMarksList() {
        log.info("Start of test #5");
        given().
                when().
                get("auto/categories/1/marks?" + APIKey).
                then().
                assertThat().body("name", hasItem("Audi")).
                assertThat().body("name", hasItem("Bentley")).
                assertThat().body("name", hasItem("BMW")).
                assertThat().body("name", hasItem("Bugatti")).
                assertThat().body("name", hasItem("Chevrolet"));
        log.info("Test #5 finished");
    }

    @Description("Verifying that body contains Ferrari models after sending params")
    @Test(priority = 6)
    public void getModelsList() {
        log.info("Start of test #6");
        given().
                when().
                get("auto/categories/1/marks/22/models/_group?" + APIKey).
                then().
                assertThat().body("name", hasItem("LaFerrari")).
                assertThat().body("name", hasItem("Mondial")).
                assertThat().body("name", hasItem("Testarossa")).
                assertThat().body("name", hasItem("Scuderia Spider 16M Convertible")).
                assertThat().body("name", hasItem("California")).
                assertThat().body("name", hasItem("458 Italia"));
        log.info("Test #6 finished");
    }

    @Description("Displaying request body at Search service for Audi Q8 2010-2017 in Vinnitsa")
    @Test(priority = 7)
    public void getSearch() {
        log.info("Start of test #7");
        Response response =
                given().log().all().
                        param("marka_id", "6").
                        param("model_id", "54663").
                        param("s_yers", "2010").
                        param("po_yers", "2017").
                        param("city", "1").
                        when().
                        get("auto/search?" + APIKey);
        String body = response.prettyPrint();
        int code = response.getStatusCode();
        System.out.println(body);
        System.out.println("Status code is " + code);
        log.info("Test #7 finished");
    }

    @Description("Displaying average price for Ford Focus 2012-2018 in Vinnitsa")
    @Test(priority = 8)
    public void getAveragePrice() {
        log.info("Start of test #8");
        Response response =
                given().log().all().
                        param("marka_id", "24").
                        param("model_id", "240").
                        param("s_yers", "2012").
                        param("po_yers", "2018").
                        param("city", "1").
                        when().
                        get("auto/average_price?" + APIKey);
        String body = response.prettyPrint();
        int code = response.getStatusCode();
        System.out.println(body);
        System.out.println("Status code is " + code);
        log.info("Test #8 finished");
    }

    @Description("Displaying info by autoID after sending params")
    @Test(priority = 9)
    public void getCarInfo() {
        log.info("Start of test #9");
        Response response =
                given().
                        param("auto_id", "19050985").
                        when().
                        get("auto/info?" + APIKey);
        String body = response.prettyPrint();
        System.out.println(body);
        log.info("Test #9 finished");
    }

    @Description("Verifying that body contains options after sending params")
    @Test(priority = 10)
    public void getOptionsList() {
        log.info("Start of test #10");
        given().
                when().
                get("/auto/categories/1/options?" + APIKey).
                then().
                assertThat().body("name", hasItem("ABS")).
                assertThat().body("name", hasItem("ABD")).
                assertThat().body("name", hasItem("Пневмоподвеска"));
        log.info("Test #10 finished");
    }

}
