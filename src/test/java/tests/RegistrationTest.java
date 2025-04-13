package tests;

import driverFactory.Driver;
import listeners.testng.TestNGListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utilities.DataReader;

@Listeners(TestNGListener.class)

public class RegistrationTest {
    public Driver driver;
    String credentialsJsonFilePath = "src/test/resources/testData/jsonData.json";


    @BeforeClass
    public void setUp() {
        driver = new Driver();
        DataReader.loadFiles(credentialsJsonFilePath);
    }
    @Test
    public void signupWithAnExistedMail() throws InterruptedException {
        String name = DataReader.getValue(credentialsJsonFilePath, "preRegisteredData.name");
        String email = DataReader.getValue(credentialsJsonFilePath, "preRegisteredData.email");

        new RegistrationPage(driver)
                .openRgistrationPage()
                .fillNameField(name)
                .fillEmailField(email)
                .clicksignUpButton()
                        .checkMail();
    }
    @Test
    public void signup() throws InterruptedException {
        String name = DataReader.getValue(credentialsJsonFilePath, "newRegistrationData.name");
        String new_Email = DataReader.getValue(credentialsJsonFilePath, "newRegistrationData.email");
        String gender = DataReader.getValue(credentialsJsonFilePath, "newRegistrationData.gender");
        String password = DataReader.getValue(credentialsJsonFilePath, "newRegistrationData.password");
        String day = DataReader.getValue(credentialsJsonFilePath, "newRegistrationData.birthdateDay");
        String month = DataReader.getValue(credentialsJsonFilePath, "newRegistrationData.birthdateMonth");
        String year = DataReader.getValue(credentialsJsonFilePath, "newRegistrationData.birthdateYear");
        String fName = DataReader.getValue(credentialsJsonFilePath, "newRegistrationData.firstName");
        String lName = DataReader.getValue(credentialsJsonFilePath, "newRegistrationData.lastName");
        String country = DataReader.getValue(credentialsJsonFilePath, "newRegistrationData.country");
        String address = DataReader.getValue(credentialsJsonFilePath, "newRegistrationData.Address");
        String state = DataReader.getValue(credentialsJsonFilePath, "newRegistrationData.state");
        String city = DataReader.getValue(credentialsJsonFilePath, "newRegistrationData.city");
        String zipCode = DataReader.getValue(credentialsJsonFilePath, "newRegistrationData.zipCode");
        String mobileNumber = DataReader.getValue(credentialsJsonFilePath, "newRegistrationData.mobileNumber");

        new RegistrationPage(driver)
                .openRgistrationPage()
                .fillNameField(name)
                .fillEmailField(new_Email)
                .clicksignUpButton()
                .selectGender(gender)
                /*.nameAssertion()
                .emailCheck()*/
                .passwordFilling(password)
                //Date of birth select
                .selectDay(day)
                .selectMonth(month)
                .selectyear(year)
                .firstNameFilling(fName)
                .lastNameFilling(lName)
                .addressfilling(address)
                //country select
                .selectCountry(country)
                .stateFilling(state)
                .cityFilling(city)
                .zipCodeFilling(zipCode)
                .mobileNumberFilling(mobileNumber)
                .clickCreateAccountButton();

        Thread.sleep(6000);
    }



/*        @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }*/
    }
