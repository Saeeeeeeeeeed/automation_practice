package dataprovider;

import org.testng.annotations.DataProvider;
import utilites.JsonHandler;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestDataProvider {

    @DataProvider(name = "testData")
    public static Object[][] provideLoginTestData() throws IOException {
        JsonHandler jsonFileHandler = new JsonHandler("src/test/resources/testdata/testdata.json");
        List<Map<String, String>> loginTestData = jsonFileHandler.getTestData("RegistrationTestDataInLoginPage");

        Object[][] testData = new Object[loginTestData.size()][1];
        for (int i = 0; i < loginTestData.size(); i++) {
            testData[i][0] = loginTestData.get(i);
        }
        return testData;
    }

    @DataProvider(name = "RegistrationTestData")
    public static Object[][] provideLRegistrationTestData() throws IOException {
        JsonHandler jsonFileHandler = new JsonHandler("src/test/resources/testdata/testdata.json");
        List<Map<String, String>> loginTestData = jsonFileHandler.getTestData("RegistrationTestPage");

        Object[][] testData = new Object[loginTestData.size()][1];
        for (int i = 0; i < loginTestData.size(); i++) {
            testData[i][0] = loginTestData.get(i);
        }
        return testData;
    }

    @DataProvider(name = "loginTestData")
    public static Object[][] provideInvalidLoginTestData() throws IOException {
        JsonHandler jsonFileHandler = new JsonHandler("src/test/resources/testdata/testdata.json");
        List<Map<String, String>> loginTestData = jsonFileHandler.getTestData("loginTestData");

        Object[][] testData = new Object[loginTestData.size()][1];
        for (int i = 0; i < loginTestData.size(); i++) {
            testData[i][0] = loginTestData.get(i);
        }
        return testData;
    }

    @DataProvider(name = "cart")
    public static Object[][] providecartTestData() throws IOException {
        JsonHandler jsonFileHandler = new JsonHandler("src/test/resources/testdata/testdata.json");
        List<Map<String, String>> loginTestData = jsonFileHandler.getTestData("cart");

        Object[][] testData = new Object[loginTestData.size()][1];
        for (int i = 0; i < loginTestData.size(); i++) {
            testData[i][0] = loginTestData.get(i);
        }
        return testData;
    }
}
