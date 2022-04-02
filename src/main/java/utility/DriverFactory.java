package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.PropertiesFile;

import java.util.concurrent.TimeUnit;


public class DriverFactory {
    public static WebDriver driver;
    private static WebDriverWait wait;
    public static String driverPath = "./src/main/resources/drivers/";
    private static String browser;


    public static WebDriver getDriver() {

        if(driver == null) {
            browser = PropertiesFile.getProperty("browser");
            if( browser.equals("chrome")) {
                        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
                        driver = new ChromeDriver();
                    } else if(browser.equals("firefox")) {
                        System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
                        driver = new FirefoxDriver();
                    } else if(browser.equals("edge")) {
                        System.setProperty("webdriver.edge.driver", driverPath + "msedgedriver.exe");
                        driver = new EdgeDriver();
                    }

            // Implicit wait
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            // Explicit wait
            wait = new WebDriverWait(driver, 10);


        }
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }



    public static void quit() {
        driver.quit();
        driver = null;
    }
 }