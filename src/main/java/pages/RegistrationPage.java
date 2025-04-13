package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

public class RegistrationPage {

    private Driver driver;
    By signUpAndLoginSideMenu = By.cssSelector("a[href=\"/login\"]");
    By nameFieldSignUpForm1 = By.xpath("//input[@data-qa='signup-name']");
    By emailFieldSignUpForm1 = By.xpath("//input[@data-qa='signup-email']");
    By buttonSignUpForm1 = By.xpath("//button[@data-qa='signup-button']");
    By errorMsgForExistingMail = By.xpath("//p[@style=\"color: red;\"]");
    /*String value;
    String selectedGender ="//input[@value=\""+ value +"\"]";
    By genderSelectingButtonSignUpForm2 = By.xpath(selectedGender);*/
    By selectedGenderAsMr = By.xpath("//input[@value=\"Mr\"]");
    By selectedGenderAsMrs = By.xpath("//input[@value=\"Mrs\"]");
    By nameSecondFieldSignUpForm2 = By.xpath("//input[@data-qa='name']");
    By emailSecondFieldSignUpForm2 = By.xpath("//button[@data-qa='signup-button']");
    By passwordFielldSignUpForm2 = By.xpath("//input[@data-qa='password']");
    By daysListSignUpForm2 = By.xpath("//select[@data-qa='days']");
    By monthsListSignUpForm2 = By.xpath("//select[@data-qa='months']");
    By yearsListSignUpForm2 = By.xpath("//select[@data-qa='years']");
    By firstNameFieldSignUpForm2 = By.xpath("//input[@data-qa='first_name']");
    By lastNameFieldSignUpForm2 = By.xpath("//input[@data-qa='last_name']");
    By addressSignUpForm2 = By.xpath("//input[@data-qa='address']");
    By countriesListSignUpForm2 = By.xpath("//select[@data-qa='country']");
    By stateFieldSignUpForm2 = By.xpath("//input[@data-qa='state']");
    By cityFieldSignUpForm2 = By.xpath("//input[@data-qa='city']");
    By zipCodeFieldSignUpForm2 = By.xpath("//input[@data-qa='zipcode']");
    By mobileNumberSignUpForm2 = By.xpath("//input[@data-qa='mobile_number']");
    By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    By registred_mail_error = By.xpath("//p[text()='Email Address already exist!']");
    public RegistrationPage (Driver driver) {
        this.driver = driver;
    }

    @Step("Open Registration Page")
        public RegistrationPage openRgistrationPage(){
        driver.element().hoverOnItem(signUpAndLoginSideMenu);
        driver.element().click(signUpAndLoginSideMenu);
        return this;
    }
    @Step("Fill name filed")
        public RegistrationPage fillNameField(String name){
        driver.element().fillField(nameFieldSignUpForm1,name);
        return this;
    }
        @Step("Fill email filed")
        public RegistrationPage fillEmailField(String email) {
            driver.element().fillField(emailFieldSignUpForm1, email);
            return this;
        }
        @Step("Click signup button")
        public RegistrationPage clicksignUpButton(){
            driver.element().click(buttonSignUpForm1);
            return this;
        }

        @Step("Select Gender")
        public RegistrationPage selectGender(String value) {

        if (Objects.equals(value, "Mr"))
        {
            driver.element().click(selectedGenderAsMr);
        }
        else if (Objects.equals(value, "Mrs")){
            driver.element().click(selectedGenderAsMrs);
        }
        else {
            System.out.println("Gender should be 'Mr' or 'Mrs'");
        }
        return this;
    }


    @Step("Check that name transferred successfully")
    public RegistrationPage nameAssertion(){
        String name1=  driver.element().getTextOf(nameFieldSignUpForm1);
        String name2=  driver.element().getTextOf(nameSecondFieldSignUpForm2);
        Assert.assertEquals(name1, name2, "Error: Name changed");
        return this;
    }
    @Step("Check that mail transferred successfully")
    public RegistrationPage emailCheck() {
        String mail1=  driver.element().getTextOf(emailFieldSignUpForm1);
        String mail2=  driver.element().getTextOf(emailSecondFieldSignUpForm2);
        Assert.assertEquals(mail1, mail2, "Error: mail changed");
        return this;
    }
    @Step("Fill password filed")
    public RegistrationPage passwordFilling(String password){
        driver.element().fillField(passwordFielldSignUpForm2,password);
        return this;
    }

    @Step("Select day")
    public RegistrationPage selectDay(String d) {
        driver.element().selectByValue(daysListSignUpForm2, d);
        return this;
    }

    @Step("Select month")
    public RegistrationPage selectMonth(String m) {
        driver.element().selectByValue(monthsListSignUpForm2, m);
        return this;
    }

    @Step("Select year")
    public RegistrationPage selectyear(String y) {
        driver.element().selectByValue(yearsListSignUpForm2, y);
        return this;
    }
    @Step("Fill first name filed")
    public RegistrationPage firstNameFilling(String firstName) {
        driver.element().fillField(firstNameFieldSignUpForm2, firstName);
        return this;
    }
    @Step("Fill last name filed")
    public RegistrationPage lastNameFilling(String lastName) {
        driver.element().fillField(lastNameFieldSignUpForm2, lastName);
        return this;
    }

    @Step("Select country")
    public RegistrationPage selectCountry(String selectedCountry) {
        driver.element().selectByValue(countriesListSignUpForm2, selectedCountry);
        return this;
    }

    @Step("Fill address filed")
    public RegistrationPage addressfilling(String address) {
        driver.element().fillField(addressSignUpForm2, address);
        return this;
    }
    @Step("Fill state filed")
    public RegistrationPage stateFilling(String state){
        driver.element().fillField(stateFieldSignUpForm2,state);
        return this;
    }
    @Step("Fill city filed")
    public RegistrationPage cityFilling(String city) {
        driver.element().fillField(cityFieldSignUpForm2, city);
        return this;
    }
    @Step("Fill zip code filed")
    public RegistrationPage zipCodeFilling(String zipCode){
        driver.element().fillField(zipCodeFieldSignUpForm2,zipCode);
        return this;
    }
    @Step("Fill mobile number filed")
    public RegistrationPage mobileNumberFilling(String mobileNumber) {
        driver.element().fillField(mobileNumberSignUpForm2, mobileNumber);
        return this;
    }
    @Step("Click Create Account Button")
    public RegistrationPage clickCreateAccountButton(){
        driver.element().scrollToEndOfPage();
        driver.element().click(createAccountButton);
        System.out.println("Created Successfully");
        return this;
    }
    @Step ("Check If Mail PreRegisterred")
    public RegistrationPage checkMail(){


        Assert.assertTrue(driver.element().isDisplayed(registred_mail_error), "Mail isn't inserted before");
        Assert.assertEquals(driver.element().getTextOf(registred_mail_error), "Email Address already exist!", "The mail is inserted before");
        return this;
    }




}


