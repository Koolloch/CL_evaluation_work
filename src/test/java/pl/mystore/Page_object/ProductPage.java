package pl.mystore.Page_object;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ProductPage {
    @FindBy(id = "group_1")
    WebElement sizeSelect;
    @FindBy(id = "quantity_wanted")
    WebElement quantityWanted;
    @FindBy(className = "add-to-cart")
    WebElement addToCart;
    @FindBy(css = "#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a")
    private WebElement checkout;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void slectSize(String sieze){
        Select drpDown = new Select(sizeSelect);

        switch (sieze){
            case "S":
                drpDown.selectByValue("1");
                break;
            case "M":
                drpDown.selectByValue("2");
                break;
            case  "L":
                drpDown.selectByValue("3");
                break;
            case  "XL":
                drpDown.selectByValue("4");
                break;
        }
    }

    public void changeQuantity(String quantity) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        quantityWanted.clear();
        quantityWanted.sendKeys(quantity);
    }
    public void addToCart(){
        addToCart.click();;
    }
    public void proceedToCheckout(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkout.click();
    }
}
