package Configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browserSetup {

    /*This is the browser class, we are going to setup all the browsers we will need for our framework*/

    public static String dir = System.getProperty("user.dir"); //getting the user directory
    public static String Chromedriver = dir + "/Drivers/chromedriver.exe"; //creating chromedriver directory
    public static String Firefox = dir + "/Drivers/geckodriver.exe"; //creating Firefox driver directory

    static WebDriver driver;

    public static WebDriver startBrowser (String browserchoice,String url){
        if ("firefox".equalsIgnoreCase(browserchoice)){
            System.setProperty("webdriver.gecko.driver",Firefox);
            driver= new FirefoxDriver();
        }else if ("chrome".equalsIgnoreCase(browserchoice)){
            System.setProperty("webdriver.chrome.driver", Chromedriver);
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;

    }

    public static void main(String[] args){
        startBrowser("chrome", "https://demo.guru99.com/test/newtours/");
    }

}
