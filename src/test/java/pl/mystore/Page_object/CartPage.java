package pl.mystore.Page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(css = "#main > div > div.cart-grid-right.col-xs-12.col-lg-4 > div.card.cart-summary > div.checkout.cart-detailed-actions.card-block > div > a")
    private WebElement finallCheckout;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void proceedToFinallCheckout(){
        finallCheckout.click();
    }
}
