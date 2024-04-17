package cart;

import AddToCard.cardPage;
import base.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.base.Login;

import java.util.List;
import java.util.Map;

public class CartTest extends BaseTest {

    String username = generalConfigurationProps.getProperty("userName");
    String password = generalConfigurationProps.getProperty("passWord");

    Login login;
    cardPage cardPage;

    @BeforeClass
    public void login() throws Exception {
        try {
            login = new Login(driver);
            login.loginSuccessfully(username,password);
            log.info("logged in successfully");
        }
        catch (Exception e)
        {
            throw new Exception("user can not login");
        }

    }

    @Test(dataProviderClass = dataprovider.TestDataProvider.class, dataProvider = "cart")
    public void validateOnAddCardFlow (Map<String,String> testdata) throws Exception {
        cardPage = new cardPage(driver);
        List<String> messages = cardPage.validateOrderSubmitted();
        String successMessage = messages.get(0);       // Get the first message
        String finalConfirmation = messages.get(1);
       // try {
            String expectresult1 = testdata.get("expectedResult1");
            String expectedresult2 = testdata.get("expectedResult2");
            softAssert.assertEquals(successMessage,expectresult1);
            softAssert.assertEquals(finalConfirmation,expectedresult2);
            softAssert.assertAll();
     //   } catch (Exception e) {
       //     throw new SkipException("can not validate field");
        //}
    }
}
