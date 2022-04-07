package pl.mystore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.mystore.Page_object.*;

import java.time.Duration;

public class AddAddressSteps {

    private WebDriver driver;
    private HomePage Home_pgae;
    private LogInPage Log_In_page;
    private AccountPage Accont_page;
    private AddAddressPage Add_address_page;
    private AddressPage Address_page;

    @Given("^Open browser on (.*) site$")
    public void testSetupAddresses(String pageUrl){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        Home_pgae = new HomePage(driver);
        Log_In_page = new LogInPage(driver);
        Accont_page = new AccountPage(driver);
        Add_address_page = new AddAddressPage(driver);
        Address_page = new AddressPage(driver);
        driver.get(pageUrl);
        Home_pgae.logIn();
    }
    @When("^Signs in (.*) (.*) for address$")
    public void userSigin(String user, String password){
        Log_In_page.logIn(user, password);
    }
    @And("^Add first address$")
    public void addFirstAddress(){
        Accont_page.enterAddAddress();
    }
    @And("^Fulfill address form with (.*) (.*) (.*) (.*) (.*)$")
    public void fullfillAddressForm(String alias, String address, String postal, String city, String phone){
        Add_address_page.fillAddressForm(alias, address, postal, city, phone);
        Add_address_page.selectCountry();
    }
    @And("Save")
    public void saveAddress(){
        Add_address_page.saveAddress();
    }
    @Then("Check address successfully added")
    public void checkAddressSuccesAdd(){
        Assertions.assertTrue(Address_page.isSucces());
    }
    @And("^Check address contain (.*) (.*) (.*) (.*) (.*)$")
    public void checkAddressData(String alias, String address, String postal, String city, String phone){
        Assertions.assertTrue(Address_page.checkIfContain(alias, address, postal, city, phone));
    }
    @Then("Delete address")
    public void deleteAddress(){
        Address_page.deleteAddress();    }
    @And("Check address successfully deleted")
    public void checkAddressSuccesDelete(){
        Assertions.assertTrue(Address_page.isSucces());
    }
}
