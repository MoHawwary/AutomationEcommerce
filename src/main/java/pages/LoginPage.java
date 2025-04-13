package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {
    private Driver driver;

    By signUpAndLoginTopMenu = By.cssSelector("a[href=\"/login\"]");
    By  emailField = By.xpath("//input[@data-qa='login-email']");
    By passwordField = By.xpath("//input[@data-qa='login-password']");
    By loginButton = By.xpath("//button[@data-qa='login-button']");
    By errorSelector = By.xpath("//p[@style='color: red;']");

    public LoginPage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Actions  *****************************************************/


    @Step("Open Login Page")
    public LoginPage openLoginPage(){
        driver.element().hoverOnItem(signUpAndLoginTopMenu).click(signUpAndLoginTopMenu);
        return this;
    }
    @Step("Fill username filed")
    public LoginPage fillEmailNameFiled(String username){
        driver.element().fillField(emailField,username);
        return this;
    }
    @Step("Fill password filed")
    public LoginPage fillPasswordField(String password) {
        driver.element().fillField(passwordField, password);
        return this;
    }
    @Step("Click login button")
    public LoginPage clickLoginBtn() throws InterruptedException {
        driver.element().click(loginButton);
        Thread.sleep(500);
        return this;
    }

    /*********************************  Verifications  *****************************************************/

    @Step("Check error message")
    public LoginPage checkErrorMessage() throws InterruptedException {
        Thread.sleep(100);
        Assert.assertFalse(driver.element().isDisplayed(errorSelector));
        return this;
    }

}
