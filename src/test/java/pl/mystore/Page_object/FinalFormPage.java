package pl.mystore.Page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalFormPage {
    @FindBy(css = "#checkout-addresses-step > div > div > form > div.clearfix > button")
    WebElement addressContinue;
    @FindBy(css = "#js-delivery > button")
    WebElement deliveryContinue;
    @FindBy(id = "delivery_option_1")
    WebElement selectPrestaShop;
    @FindBy(id = "payment-option-1")
    WebElement selectPayByCheck;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement termsAgree;
    @FindBy(id = "payment-confirmation")
    WebElement submit;

    public FinalFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void contiuneWithSelectedAddreess(){
        addressContinue.click();
    }
    public void continueDelivery(){
        deliveryContinue.click();
    }
    public void selectPrestaShop() {
        if (selectPrestaShop.isSelected()) {
        } else {
            selectPrestaShop.click();
        }
    }
    public void selectPayByCheck () {
            selectPayByCheck.click();
    }
    public void checkTermsAgree(){
        termsAgree.click();
    }
    public void confirmForm(){
        submit.click();
    }

}
