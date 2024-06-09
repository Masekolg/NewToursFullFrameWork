package Configurations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ExtentReport<htmlReporter> {

    /**
     * This is the extent report class that will generate the report on executions
     */

    private ExtentHtmlReporter htmlReporter;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void reportSetup() {

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/ExecutionReport.html");
        htmlReporter.config().setDocumentTitle("New Tours Automation Report");
        htmlReporter.config().setReportName("Functional Html Report");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Automator", "Londy");

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed is" + result.getName());
        test.log(Status.FAIL, "Test Case Failed is" + result.getThrowable());

        }else if(result.getStatus() == ITestResult.SKIP){
            test.log(Status.SKIP, "Test Case Skipped is" + result.getTestName());
        }else if (result.getStatus() == ITestResult.SUCCESS){
            test.log(Status.PASS, "Test Case Skipped is" + result.getName());
        }

    }
    @AfterSuite
    public void reportTearDown(){
    extent.flush();
    }
}