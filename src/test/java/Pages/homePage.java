package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class homePage {
    WebDriver driver;
    public homePage(WebDriver driver){this.driver=driver;}

    //all elements here

    ;@FindBy(xpath = "//h3[contains(.,'Login Successfully')]")
    WebElement loginsuccess;

    @FindBy(xpath = "//a[contains(.,'SIGN-OFF')]")
    WebElement logoutButton;

    public void verifyUserIsLoggedIn(){
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(loginsuccess));
        Assert.assertEquals(loginsuccess.getText(),"login successfully");
    }

    public void Signoff() {
        logoutButton.click();
    }
}
