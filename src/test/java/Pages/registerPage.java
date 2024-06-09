package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class registerPage {

    /** This is where we are going to store login elements and login methods*/

    WebDriver driver;
    public registerPage(WebDriver driver){
        this.driver=driver;
    }

    //Below we will have all the elements ;

    @FindBy(xpath = "//input[contains(@name,'firstName')]")
    WebElement firstname;

    @FindBy(xpath = "//input[contains(@name,'lastName')]")
    WebElement lastname;

    @FindBy(xpath = "//input[contains(@name,'phone')]")
    WebElement phone;

    @FindBy(xpath = "//input[contains(@id,'userName')]")
    WebElement userName;

    @FindBy(xpath = "//input[contains(@name,'address1')]")
    WebElement address;

    @FindBy(xpath = "//input[contains(@name,'city')]")
    WebElement city;

    @FindBy(xpath = "//input[contains(@name,'state')]")
    WebElement state;

    @FindBy(xpath = "//input[contains(@name,'postalCode')]")
    WebElement postalCode;

    @FindBy(xpath = "//select[contains(@name,'country')]")
    WebElement country;

    @FindBy(xpath = "//input[contains(@name,'email')]")
    WebElement email;

    @FindBy(xpath = "//input[contains(@name,'password')]")
    WebElement password;

    @FindBy(xpath = "//input[contains(@name,'confirmPassword')]")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[contains(@name,'submit')]")
    WebElement submit;

    //Below we will put all the action methods
    WebElement register;

    public void registerUser(){
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(register));
        register.click();
    }

    public void enterFirstname() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(firstname));
        firstname.sendKeys("Masekolg");
    }

    public void enterLastname(){
        lastname.sendKeys("Maseko");
}

    public void enterPhone() {
        phone.sendKeys("0734257495");
    }

    public void enterUsername() {
        userName.sendKeys("Test");
    }

    public void enterAddress1() {
        address.sendKeys("1751 Uhuru Peak Road");

    }

    public void enterCity() {
        city.sendKeys("Benoni");
    }

    public void enterState() {
        state.sendKeys("Gauteng");
    }

    public void enterPostalcode() {
        postalCode.sendKeys("1501");

    }

    public void enterCountry() {
        country.sendKeys("Austria");
    }

    public void enterEmail() throws InterruptedException {
        Thread.sleep(2000);
        email.sendKeys("Masekolg@gmail.com");
    }

    public void enterPassword() {
        password.sendKeys("Test");
    }

    public void enterConfirmpassword() {
        confirmPassword.sendKeys("Test");

    }

    public void clickSubmit(){
    submit.click();}
}




