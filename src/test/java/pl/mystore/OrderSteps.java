package pl.mystore;

import io.cucumber.java.cs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.mystore.Page_object.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;

public class OrderSteps {
    private WebDriver driver;
    private HomePage Home_pgae;
    private LogInPage Log_In_page;
    private AccountPage Accont_page;
    private AddAddressPage Add_address_page;
    private AddressPage Address_page;
    private ClothesPage Clothes_page;
    private ProductPage Product_page;
    private CartPage Cart_page;
    private FinalFormPage Final_form_page;

    @Given("^Open browser on (.*) page$")
    public void testSetupOrder(String pageUrl){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        Home_pgae = new HomePage(driver);
        Log_In_page = new LogInPage(driver);
        Accont_page = new AccountPage(driver);
        Add_address_page = new AddAddressPage(driver);
        Address_page = new AddressPage(driver);
        Clothes_page = new ClothesPage(driver);
        Address_page = new AddressPage(driver);
        Product_page = new ProductPage(driver);
        Cart_page = new CartPage(driver);
        Final_form_page = new FinalFormPage(driver);
        driver.get(pageUrl);
        Home_pgae.logIn();

    }
    @When("^Signs in (.*) (.*) for order$")
    public void userSigin(String user, String password){
        Log_In_page.logIn(user, password);
        /*
        if (Accont_page.checkIfExist()){
            Accont_page.enterAddAddress();
            Add_address_page.fillAddressForm("alias", "address", "city", "41-500", "505655700");
            Add_address_page.selectCountry();
            Add_address_page.saveAddress();
        }
        */
    }

    @And("Choose a product")
    public void chooseProduct(){
        Home_pgae.eneterClothes();
        Clothes_page.selectProduct();
    }
    @And("^Select size (.*)$")
    public void selectSize(String size){
        Product_page.slectSize(size);
    }
    @And("^Select quantity (.*)$")
    public void selectQuantity(String quantity){
        Product_page.changeQuantity(quantity);
    }
    @And("Add product to cart")
    public void addProduct(){
        Product_page.addToCart();
    }
    @And("Checkout")
    public void checkout(){
        Product_page.proceedToCheckout();
        Cart_page.proceedToFinallCheckout();
    }
    @And("Confirm address")
    public void confirmAddress(){
        Final_form_page.contiuneWithSelectedAddreess();
        Final_form_page.continueDelivery();
    }
    @And("Choose pickup method")
    public void choosePickup(){
        Final_form_page.selectPrestaShop();
    }
    @And("Choose payment option")
    public void choosePayment(){
        Final_form_page.selectPayByCheck();
    }
    @And("Agree to the terms")
    public void termsAgree(){
        Final_form_page.checkTermsAgree();
    }
    @And("Complete order")
    public void completeOrder(){
        Final_form_page.confirmForm();
        Home_pgae.logout();
        driver.quit();
    }

    @Then("Take order screen shot")
    public void takeScreenShot() throws IOException {
        File tmpScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:/Users/mkolo/Desktop/CL tester automatyczny/zaliczenie/screen", "zadanie2-"+currentDateTime+".png"));
    }
}