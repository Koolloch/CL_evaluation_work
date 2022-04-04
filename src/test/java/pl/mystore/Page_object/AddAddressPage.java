package pl.mystore.Page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static pl.mystore.Utility.Web_element_util.setText;

public class AddAddressPage {
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")
    private WebElement aliasField;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[2]/div[1]/input")
    private WebElement firstNameField;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[3]/div[1]/input")
    private WebElement lastNameField;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[6]/div[1]/input")
    private WebElement address1Field;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[7]/div[1]/input")
    private WebElement address2Field;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input")
    private WebElement postCodeField;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input")
    private WebElement cityField;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select")
    private WebElement countryField;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input")
    private WebElement phoneField;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveButton;


    public AddAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillAddressForm(String alias, String address, String city, String postal, String phone) {
        setText(alias, aliasField);
        setText(address, address1Field);
        setText(city, cityField);
        setText(postal, postCodeField);
        setText(phone, phoneField);
    }

    public void selectCountry(){
        Select drpDown = new Select(countryField);
        drpDown.selectByValue("17");

    }

    public void saveAddress(){
        saveButton.click();
    }


}
