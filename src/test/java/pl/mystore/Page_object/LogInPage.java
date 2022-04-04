package pl.mystore.Page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.mystore.Utility.Web_element_util;

import static pl.mystore.Utility.Web_element_util.setText;

public class LogInPage {
    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(id = "submit-login")
    private  WebElement sigInButton;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void logIn(String email, String password){
        setText(email, emailInput);
        setText(password, passwordInput);
        sigInButton.click();

    }
}
