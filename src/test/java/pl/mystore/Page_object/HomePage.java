package pl.mystore.Page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(id = "_desktop_user_info")
    private WebElement sigIn;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void logIn() {
        sigIn.click();
    }
}
