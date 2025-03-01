package Configurations;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

    public void takeSnapShot(WebDriver driver, String screenshotName){
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenshot, new File(".//ScreenShots/"+ screenshotName+".png"));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
