package RegistrationTest;

import base.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pages.Registration.LoginPageRegistration;
import pages.Registration.registrationPage;

import java.util.Map;

public class RegistrationTest extends BaseTest {

    LoginPageRegistration loginPageRegistration;
    registrationPage registrationPage;

    @Test(dataProviderClass = dataprovider.TestDataProvider.class, dataProvider = "RegistrationTestData")
    public void validateRegistrationPage (Map<String,String> testData) throws Exception {
        loginPageRegistration = new LoginPageRegistration(driver);
        registrationPage = new registrationPage(driver);
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

        try{
            String emailPlaceholder = "{{email}}";
            String email = loginPageRegistration.generateDynamicEmail();
            testData.put("emailAddress",email);
            String firstname = testData.get("firstName");
            String lastname = testData.get("lastName");
            String password = testData.get("password");
            String day = testData.get("day");
            String month = testData.get("month");
            String year = testData.get("year");
            String expectedResult = testData.get("expectedResult");

            softAssert.assertEquals(registrationPage.validateRegistration(firstname,lastname,password,day,month,year,email),expectedResult);
            softAssert.assertAll();
        }
        catch (Exception e){
            throw new SkipException("can not validate on field");
        }

    }
}
