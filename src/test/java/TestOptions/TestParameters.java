package TestOptions;

import org.testng.annotations.DataProvider;

public class TestParameters {

    @DataProvider(name = "CredentialsForLogin")
    public static Object[][] login() {
        return new Object[][]{{"test.for.ria@gmail.com", "test.for.ria123"}, {"test.for.ria@gmail.com", "test.for.ria123"}};
    }

    @DataProvider(name = "DataYear")
    public static Object[][] year() {
        return new Object[][]{{"2003", "2006"}, {"2008", "2012"}, {"2012", "2016"}};
    }

    @DataProvider(name = "DataPrice")
    public static Object[][] price() {
        return new Object[][]{{"35000", "70000"}, {"50000", "80000"}, {"60000", "90000"}};
    }
}
