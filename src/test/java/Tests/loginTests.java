package Tests;

import Configurations.ExtentReport;
import Configurations.browserSetup;
import Pages.loginPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class loginTests extends ExtentReport {

    //TODO this is where we are going to put our test code for login

    WebDriver driver= browserSetup.startBrowser("chrome","https://demo.guru99.com/test/newtours/login.php");

    Pages.loginPage loginPage = PageFactory.initElements(driver, Pages.loginPage.class);

    @Test
    public void loginToNewToursWebsite(){

        test= extent.createTest("Login","Login to new tours website");
        test.log(Status.INFO,"Login test started");
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickSubmit();
        test.log(Status.INFO,"Login test completed");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
