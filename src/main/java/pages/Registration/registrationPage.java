package pages.Registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.MainPage;

import java.util.List;

public class registrationPage extends MainPage {
    public registrationPage(WebDriver driver) {
        super(driver);
    }

    By emailAddress = By.id("email_create");
    By createAccountButton = By.id("SubmitCreate");
    By genderRadioButton = By.id("id_gender1");
    By firstName = By.id("customer_firstname");
    By lastName = By.id("customer_lastname");
    By Email = By.id("email");
    By passWord = By.id("passwd");
    By signUpButton = By.xpath("//div[@id='uniform-newsletter']");
    By registrationButton = By.id("submitAccount");
    @FindBy (xpath = "//Select[@id='days']")
    WebElement Day;
    @FindBy (xpath = "//Select[@id='months']")
    WebElement Month;
    @FindBy (xpath = "//Select[@id='years']")
    WebElement Year;
    @FindBy (xpath = "//div[@class='alert alert-danger']")
    List<WebElement> errorMessage;
    By errorText = By.xpath("//div[@class='alert alert-danger']//p");
    By registerSuccess = By.xpath("//p[@class='alert alert-success']");
    //List<WebElement> Day = driver.findElements(By.xpath("//Select[@id='days']"));
    //List<WebElement> month = driver.findElements(By.xpath("//Select[@id='months']"));
   // List<WebElement> year = driver.findElements(By.xpath("years"));

    public String validateRegistration (String firstname,String lastname, String password,String day,String month,String year,String email) throws Exception {
        setText(emailAddress,email);
        waitForElementToBeClickable(createAccountButton);
        click(createAccountButton);
        waitForVisibility(genderRadioButton);
        click(genderRadioButton);
        setText(firstName,firstname);
        setText(lastName,lastname);
        setText(Email,email);
        setText(passWord,password);
        selectOption(Day,day);
        selectOption(Month,month);
        selectOption(Year,year);
        click(signUpButton);
        click(registrationButton);

        if (!errorMessage.isEmpty()){
            return getText(errorText);
        }
        else {
            return getText(registerSuccess);

        }
    }
}
