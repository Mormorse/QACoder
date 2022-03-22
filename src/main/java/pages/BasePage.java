package pages;

import utility.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    public static WebDriver driver;
    public final WebDriverWait wait;
    @FindBy (xpath = "(//a[normalize-space()='Laptops'])[1]")
    WebElement laptopMenu;


    public BasePage(){
        this.driver = utility.DriverFactory.getDriver();
        this.wait = DriverFactory.getWait();
        PageFactory.initElements(driver, this);

    }

    public WebDriver getDriver(){
        return driver;
    }


    public void clickLaptopMenu(){
       clickOnWebElement(laptopMenu);
    }

    public String getTextFromWebElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public void sendKeysToWebElement(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        (element).sendKeys(text);
    }

    public void clickOnWebElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

}
