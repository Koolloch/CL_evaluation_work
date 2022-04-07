package pl.mystore.Page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    @FindBy(id = "address-link")
    private WebElement addFirstAddress;
    @FindBy(id = "addresses-link")
    private WebElement addresses;


    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterAddAddress() {
        addFirstAddress.click();
    }

    public void enterAddresses(){
        addresses.click();
    }
    public boolean checkIfExist(){
        if (addFirstAddress.isEnabled()){
            return true;
        }else {
            return false;
        }
    }
}

