package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.xpath;

public class LaptopsPage extends BasePage {
    @FindBy (xpath = "//a[contains(text(),'Sony vaio i5')]")
    WebElement laptopsPageFirstProduct;

    WebDriver   driver;

    public LaptopsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLaptopsFirstProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(laptopsPageFirstProduct)).click();
    }

}
