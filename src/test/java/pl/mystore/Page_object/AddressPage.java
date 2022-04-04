package pl.mystore.Page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
    @FindBy(className = "alert-success")
    WebElement addressAddSucces;
    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/a")
    WebElement addNewAddress;
    @FindBy(className = "address-body")
    WebElement addressBox;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[2]")
    WebElement deleteAddress;

    public AddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isSucces(){
        return addressAddSucces.isEnabled();
    }

    public boolean checkIfContain(String alias, String address, String city, String postal, String phone){
        String addressString = addressBox.getText();
        boolean aliasTrue = addressString.contains(alias);
        boolean addressTrue = addressString.contains(address);
        boolean cityTrue = addressString.contains(city);
        boolean postalTrue = addressString.contains(postal);
        boolean phoneTrue = addressString.contains(phone);
        if (aliasTrue == true && addressTrue == true && cityTrue == true && postalTrue == true && phoneTrue == true){
            return true;
        }else {
            return false;
        }
    }

    public void deleteAddress(){
        deleteAddress.click();
    }

}
