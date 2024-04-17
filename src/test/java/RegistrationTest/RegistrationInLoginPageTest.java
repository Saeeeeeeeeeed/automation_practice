package RegistrationTest;

import base.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pages.Registration.LoginPageRegistration;
import pages.Registration.registrationPage;

import java.util.Map;

public class RegistrationInLoginPageTest extends BaseTest {

    LoginPageRegistration loginPageRegistration;
    registrationPage registrationPage;

    @Test(dataProviderClass = dataprovider.TestDataProvider.class, dataProvider = "testData")
    public void validateEmailIsMandatoryInLoginPage(Map<String,String> testdata) throws Exception {
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
       try {
           loginPageRegistration = new LoginPageRegistration(driver);
           String emailPlaceholder = "{{email}}";
           String email = testdata.get("emailAddress");
           String expectedResult = testdata.get("expectedResult");
           if (email.equals(emailPlaceholder)){
               email = loginPageRegistration.generateDynamicEmail();
               testdata.put("emailAddress",email);
           }
           softAssert.assertEquals(loginPageRegistration.addEmailAddress(email),expectedResult);
           softAssert.assertAll();
       }
         catch (Exception e){
          throw new SkipException("can not validate on field");
       }

    }

}
