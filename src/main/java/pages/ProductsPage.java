package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
     private Driver driver;

    //Products from Top Menu
    By productsFromTopMenu = By.xpath("//a[@href='/products']");
    //Category (Men)
    By menCategorySideMenu = By.xpath("//a[@href='#Men']");
    //Subcategory (Jeans)
    By jeansSubCategorySideMenu = By.xpath("//a[@href='/category_products/6']");
    //View Product Details
    By viewProductButton = By.xpath("//a[contains(text(),'View Product') and @href='/product_details/33']");
    //Add Product To Cart
    By addProductToCart = By.xpath("//button[normalize-space()='Add to cart']");
    //View Cart
    By viewCart = By.xpath("//u[normalize-space()='View Cart']");
    //Proceed Tp Checkout Button
    By proceedToCheckoutButton = By.xpath("//a[contains(@class, 'check_out')]");
    //|Place Order Button
    By placeOrderButton = By.xpath("//a[text()='Place Order']");
    // Name On Card Field In Payment Page
    By nameOnCardField = By.xpath("//input[@data-qa='name-on-card']");
    // Card Number Field In Payment Page
    By cardNumberField = By.xpath("//input[@data-qa='card-number']");
    // CVC Field In Payment Page
    By cvcNumberField = By.xpath("//input[@data-qa='cvc']");
    // Expiry Month Field In Payment Page
    By expiryMonthField = By.xpath("//input[@data-qa='expiry-month']");
    // Expiry Year Field In Payment Page
    By expiryYearField = By.xpath("//input[@data-qa='expiry-year']");
    // Pay And Confirm Order Button In Payment Page
    By payButton = By.xpath("//button[@data-qa='pay-button']");

    public ProductsPage( Driver driver) {this.driver = driver;}

    @Step("Open Products Page")
    public ProductsPage openProductsPage(){
        driver.element().click(productsFromTopMenu);
        return this;
    }

    public ProductsPage selectCategory() {
        driver.element().safeClick(menCategorySideMenu);
        return this;
    }

/*    @Step("Select Category")
    public ProductsPage selectCategory(){

        driver.element().scrollToElement(menCategorySideMenu).hoverOnItem(menCategorySideMenu).click(menCategorySideMenu);
        return this;
    }*/

    @Step("Select Subcategory")
    public ProductsPage selectSubcategory(){
        driver.element().safeClick(jeansSubCategorySideMenu);
        return this;
    }

    @Step("view Specific Product")
    public ProductsPage viewSpecificProduct(){
        driver.element().safeClick(viewProductButton);
        return this;
    }

    @Step("Add Product To Cart")
    public ProductsPage addProductToCart(){
        driver.element().safeClick(addProductToCart);
        return this;
    }

    @Step("View Cart")
    public ProductsPage viewCart(){
        driver.element().safeClick(viewCart);
        return this;
    }

    @Step("Click On Proceed Button")
    public ProductsPage clickProceedButton(){
        driver.element().scrollToElement(proceedToCheckoutButton).hoverOnItem(proceedToCheckoutButton).click(proceedToCheckoutButton);
        return this;
    }

    @Step("Click On Place Order Button")
    public ProductsPage clickPlaceOrderButton(){
        driver.element().hoverOnItem(placeOrderButton).click(placeOrderButton);
        return this;
    }

    @Step("Fill Name On Card field")
    public ProductsPage fillNameOnCardField(String nameOnCard) {
        driver.element().fillField(nameOnCardField, nameOnCard);
        return this;
    }
    @Step("Fill Card Number Field")
    public ProductsPage fillCardNumberField(String cardNumber) {
        driver.element().fillField(cardNumberField, cardNumber);
        return this;
    }

    @Step("Fill CVC Field")
    public ProductsPage fillCVCField(String CVCNumber) {
        driver.element().fillField(cvcNumberField, CVCNumber);
        return this;
    }
    @Step("Fill CVC Field")
    public ProductsPage fillExpiryMonthField(String expiryMonth) {
        driver.element().fillField(expiryMonthField, expiryMonth);
        return this;
    }
    @Step("Fill CVC Field")
    public ProductsPage fillExpiryYearField(String expiryYear) {
        driver.element().fillField(expiryYearField, expiryYear);
        return this;
    }

    @Step("Click On Pay And Confirm Order Button")
    public ProductsPage clickPayButton(){
        driver.element().hoverOnItem(payButton).click(payButton);
        return this;
    }

}
