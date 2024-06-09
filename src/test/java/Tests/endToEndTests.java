package Tests;

import Configurations.ExtentReport;
import Configurations.browserSetup;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class endToEndTests extends ExtentReport {
    public static String dir = System.getProperty("user.dir");
    public static final  String excel_location = dir+"/TestData/DataSheet.xlsx";
    FileInPutStream fis = new FileInputStream(excel_location);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);

    WebDriver driver= browserSetup.startBrowser("chrome","https://demo.guru99.com/test/newtours/login.php");

    Pages.loginPage loginPage = PageFactory.initElements(driver, Pages.loginPage.class);

    Pages.homePage homePage = PageFactory.initElements(driver, Pages.homePage.class);

    @Test
    public void Login() throws FileNotFoundException {

        //reading data from excell and inputting in the system
        XSSFSheet sheet = workbook.getSheet();
        String username = sheet.getRow(1).getCell(0).getStringCellValue();
        String password = sheet.getRow(1).getCell(1).getStringCellValue();

        test= extent.createTest("Login","Login and Logout to new tours website");
        test.log(Status.INFO,"Login and Logout started");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password)
        takescreenshot.takeSnapshot(driver,"Login","PasswordScreenshot");

        takeScreenshot.takeSnapShot(driver,"Login");
        loginPage.clickSubmit();
        test.log(Status.INFO,"Login and Logout completed");


    @Test(priority = 1)
    public void verifyandLogout(){
        test=extent.createTest("Verify And Logout","Login and Logout to new tours website");
        test.log(Status.INFO,"Login and Logout Test Started");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        takeScreenshot.takeSnapshot(driver,"Login");
        loginPage.clickSubmit();
        test.log(Status.INFO,"Login and logout Test Completed");
    }


    @AfterMethod
    public void VerifyAndLogout(){
        driver.close();
    }
}
