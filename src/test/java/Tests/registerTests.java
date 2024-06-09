package Tests;

import Configurations.ExtentReport;
import Configurations.browserSetup;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class registerTests extends ExtentReport{

    //TODO this is where we are going to put our test code for login

    WebDriver driver= browserSetup.startBrowser("firefox","https://demo.guru99.com/test/newtours/register.php");

    Pages.registerPage registerPage = PageFactory.initElements(driver, Pages.registerPage.class);

    @Test
    public void registerToNewToursWebsite() throws InterruptedException {

        test = extent.createTest("Register", "Register to new tours website");
        test.log(Status.INFO, "Login test started");
        registerPage.enterFirstname();
        registerPage.enterLastname();
        registerPage.enterPhone();
        registerPage.enterAddress1();
        registerPage.enterCity();
        registerPage.enterState();
        registerPage.enterPostalcode();
        registerPage.enterCountry();
        registerPage.enterEmail();
        registerPage.enterPassword();
        registerPage.enterConfirmpassword();
        registerPage.clickSubmit();
        test.log(Status.INFO, "Register test completed");
    }
}


