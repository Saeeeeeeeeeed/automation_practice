package pages.AddToCard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.MainPage;

import java.util.ArrayList;
import java.util.List;

public class cardPage extends MainPage {
    public cardPage(WebDriver driver) {
        super(driver);
    }

    By WomanCategory = By.xpath("//a[@title='Women']");
    By bluesOption = By.xpath("//div[@class='product-image-container']//a[@title='Blouse']");
    By whiteOption = By.xpath("//a[@id='color_8']");
    By addToCardButton = By.xpath("//button[@class='exclusive']");
    By successAddToCard = By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2");
    By checkOutButton = By.xpath("//a[@title='Proceed to checkout']");
    By checkOutButton2 = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']");
    By checkOutButton3 = By.xpath("//button[@class='button btn btn-default button-medium']");
    By termCheckBox = By.xpath("//div[@id='uniform-cgv']");
    By checkOutButton4 = By.xpath("//button[@class='button btn btn-default standard-checkout button-medium']");
    By payByBank = By.xpath("//a[@class='bankwire']");
    By confirmButton = By.xpath("//button[@class='button btn btn-default button-medium']");
    By orderSuccess = By.xpath("//p[@class='alert alert-success']");


    public List<String> validateOrderSubmitted () throws Exception {
        click(WomanCategory);
        click(bluesOption);
        click(whiteOption);
        click(addToCardButton);
        String successMessage = getText(successAddToCard);
        click(checkOutButton);
        scrollIntoView(checkOutButton2);
        click(checkOutButton2);
        scrollIntoView(checkOutButton3);
        click(checkOutButton3);
        click(termCheckBox);
        click(checkOutButton4);
        scrollIntoView(payByBank);
        click(payByBank);
        scrollIntoView(confirmButton);
        click(confirmButton);
        String orderSuccessMessage = getText(orderSuccess);

        List<String> messages = new ArrayList<>();
        messages.add(successMessage);
        messages.add(orderSuccessMessage);
        return messages;

    }
}
