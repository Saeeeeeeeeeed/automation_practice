package pages.Registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.MainPage;

import java.util.List;

public class LoginPageRegistration extends MainPage {
    public LoginPageRegistration(WebDriver driver) {
        super(driver);
    }

    By emailAddress = By.id("email_create");
    By createAccountButton = By.id("SubmitCreate");
    @FindBy (xpath = "//div[@id='create_account_error']")
    List<WebElement> error;
    By errorWait = By.xpath("//div[@id='create_account_error']");
    By createAccountText = By.xpath("//div[@id='noSlide']//h1");

    public String addEmailAddress(String email) throws Exception {
        setText(emailAddress, email);
        waitForElementToBeClickable(createAccountButton);
        click(createAccountButton);
        Thread.sleep(3000);
        if (error.isEmpty()){
            waitForVisibility(createAccountText);
            System.out.println(getText(createAccountText));
            return getText(createAccountText);

        }
        else{
            waitForVisibility(errorWait);
            return error.get(0).getText();
        }


    }

    public String generateDynamicEmail() {
        // Implement logic to generate a dynamic username
        return "Saeed" + System.currentTimeMillis()+"@gmail.com";
    }
}
