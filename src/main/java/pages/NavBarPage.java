package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavBarPage {
    @FindBy(xpath = "(//a[normalize-space()='Cart'])[1]")
    WebElement goToCart;

    WebDriver driver;

    public NavBarPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navToCart(){
        goToCart.click();
    }
}
