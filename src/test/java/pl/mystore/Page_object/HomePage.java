package pl.mystore.Page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(id = "_desktop_user_info")
    private WebElement sigIn;
    @FindBy(id = "category-3")
    private WebElement clothes;
    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[1] ")
    WebElement logout;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void logIn() {
        sigIn.click();
    }

    public void eneterClothes(){
        clothes.click();
    }

    public void logout(){
        logout.click();
    }
}
