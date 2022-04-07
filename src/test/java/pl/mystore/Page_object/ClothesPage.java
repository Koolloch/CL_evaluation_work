package pl.mystore.Page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClothesPage {
    @FindBy(css = "#js-product-list > div.products.row > article:nth-child(1) > div > div.product-description > h2 > a")
    WebElement product;

    public ClothesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectProduct(){
        product.click();
    }
}
