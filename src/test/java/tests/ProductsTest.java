package tests;
import driverFactory.Driver;
import listeners.testng.TestNGListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.DataReader;

@Listeners(TestNGListener.class)

public class ProductsTest {

    public Driver driver;
    String cardsFilePath = "src/test/resources/testData/jsonData.json";

    @BeforeClass
    public void setUp() {
        driver = new Driver();
        DataReader.loadFiles(cardsFilePath);
    }

    @Test
    public void buyProduct() throws InterruptedException {
        String email = DataReader.getValue(cardsFilePath, "loginData.email");
        String password = DataReader.getValue(cardsFilePath, "loginData.password");
        String nameOnCard = DataReader.getValue(cardsFilePath, "validPaymentCard1.nameOnCard");
        String cardNumber = DataReader.getValue(cardsFilePath, "validPaymentCard1.cardNumber");
        String CVV = DataReader.getValue(cardsFilePath, "validPaymentCard1.CVV");
        String expiryMonth = DataReader.getValue(cardsFilePath, "validPaymentCard1.expiryMonth");
        String expiryYear = DataReader.getValue(cardsFilePath, "validPaymentCard1.expiryYear");


        new LoginPage(driver)
                .openLoginPage()
                .fillEmailNameFiled(email)
                .fillPasswordField(password)
                .clickLoginBtn();
        new ProductsPage( driver)
                .openProductsPage()
                .selectCategory()
                .selectSubcategory()
                .viewSpecificProduct()
                .addProductToCart()
                .viewCart()
                .clickProceedButton()
                .clickPlaceOrderButton()
                .fillNameOnCardField(nameOnCard)
                .fillCardNumberField(cardNumber)
                .fillCVCField(CVV)
                .fillExpiryMonthField(expiryMonth)
                .fillExpiryYearField(expiryYear)
                .clickPayButton();
        Thread.sleep(5000);
    }
}
