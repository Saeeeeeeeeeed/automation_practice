package pages.base;

import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends MainPage{
    public Login(WebDriver driver) {
        super(driver);
    }

    By username = By.id("email");
    By password = By.id("passwd");
    By loginButton = By.id("SubmitLogin");
    By errorMessage = By.xpath("//div[@class='alert alert-danger']//ol//li");
    By loginSuccessfully = By.xpath("//div[@id='center_column']//h1");
    By signInButton = By.xpath("//div[@class='header_user_info']");


    public String validateLoginCriteria (String userName, String Password) throws Exception {
        setText(username,userName);
        setText(password,Password);
        click(loginButton);

        if (isVisible(errorMessage))
        {
            return getText(errorMessage);
        }
        else return getText(loginSuccessfully);
    }

    public void loginSuccessfully (String userName, String passWord) throws Exception {
        click(signInButton);
        setText(username,userName);
        setText(password,passWord);
        click(loginButton);
    }
}
