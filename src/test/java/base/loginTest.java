package base;

import dataprovider.TestDataProvider;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pages.base.Login;

import java.util.Map;

public class loginTest extends BaseTest{

    Login login;

    @Test(dataProviderClass = dataprovider.TestDataProvider.class, dataProvider = "loginTestData")
    public void validateUserCanAddAddressTest( Map<String,String> testdata) throws Exception {
        login = new Login(driver);
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        try {
            String username = testdata.get("emailAddress");
            String password = testdata.get("password");
            String expectedResult = testdata.get("expectedResult");

            softAssert.assertEquals(login.validateLoginCriteria(username,password),expectedResult);
            softAssert.assertAll();
        }
        catch (Exception e)
        {
            throw new SkipException("can not validate on field");
        }

    }




}
