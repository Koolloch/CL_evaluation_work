package pl.mystore.Page_object;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestAddAddress {
    private WebDriver driver;
    private HomePage Home_pgae;
    private LogInPage Log_In_page;
    private AccountPage Accont_page;
    private AddAddressPage Add_address_page;
    private AddressPage Address_page;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        Home_pgae = new HomePage(driver);
        Log_In_page = new LogInPage(driver);
        Accont_page = new AccountPage(driver);
        Add_address_page = new AddAddressPage(driver);
        Address_page = new AddressPage(driver);

    }

    @Test
    public void logInTest() {
        this.driver.get("https://mystore-testlab.coderslab.pl/index.php");
        Home_pgae.logIn();
        Log_In_page.logIn("edprfaloqmyoomqaeb@kvhrw.com", "Azrael01");
        Accont_page.enterAddAddress();
        Add_address_page.fillAddressForm("alias", "address", "city", "41-500", "505655700");
        Add_address_page.selectCountry();
        Add_address_page.saveAddress();
        Assertions.assertTrue(Address_page.isSucces());
        Assertions.assertTrue( Address_page.checkIfContain("alias", "address", "city", "41-500", "505655700"));
        Address_page.deleteAddress();
        Assertions.assertTrue(Address_page.isSucces());



//        driver.quit();
    }
}
