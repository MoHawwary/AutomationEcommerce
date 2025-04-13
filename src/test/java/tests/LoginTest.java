package tests;

import driverFactory.Driver;
import listeners.testng.TestNGListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.DataReader;

@Listeners(TestNGListener.class)
public class LoginTest {

    public Driver driver;
    String credentialsJsonFilePath = "src/test/resources/testData/jsonData.json";

    @BeforeClass
    public void setUp() {
        driver = new Driver();
        DataReader.loadFiles(credentialsJsonFilePath);
    }

    @Test
    public void login() throws InterruptedException {
        String email = DataReader.getValue(credentialsJsonFilePath, "loginData.email");
        String password = DataReader.getValue(credentialsJsonFilePath, "loginData.password");
        new LoginPage(driver).fillEmailNameFiled(email)
                .openLoginPage()
                .fillEmailNameFiled(email)
                .fillPasswordField(password)
                .clickLoginBtn();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }

}
