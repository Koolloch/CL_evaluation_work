package pl.mystore.Page_object;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class testOrder {
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

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        Home_pgae = new HomePage(driver);
        Log_In_page = new LogInPage(driver);
        Accont_page = new AccountPage(driver);
        Add_address_page = new AddAddressPage(driver);
        Address_page = new AddressPage(driver);
        Clothes_page = new ClothesPage(driver);
        Product_page = new ProductPage(driver);
        Cart_page = new CartPage(driver);
        Final_form_page = new FinalFormPage(driver);
    }

    @Test
    public void test() {
        this.driver.get("https://mystore-testlab.coderslab.pl/index.php");
        Home_pgae.logIn();
        Log_In_page.logIn("edprfaloqmyoomqaeb@kvhrw.com", "Azrael01");
        Home_pgae.eneterClothes();
        Clothes_page.selectProduct();
        Product_page.slectSize("M");
        Product_page.changeQuantity("5");
        Product_page.addToCart();
        Product_page.proceedToCheckout();
        Cart_page.proceedToFinallCheckout();
        Final_form_page.contiuneWithSelectedAddreess();
        Final_form_page.continueDelivery();
        Final_form_page.selectPrestaShop();
        Final_form_page.selectPayByCheck();
        Final_form_page.checkTermsAgree();
        Final_form_page.confirmForm();
        //takeScreen(driver);
    }
}