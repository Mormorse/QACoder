package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductoInfoPage extends BasePage {

    @FindBy(xpath = "//h2[normalize-space()='Sony vaio i5']")
    WebElement laptop;

    @FindBy(xpath = "//h3[@class='price-container']")
    WebElement precio;

    @FindBy(linkText = "Add to cart")
    WebElement addToCart;

    WebDriver driver;

    public ProductoInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPrecio() {

        return (precio.getText());
    }


    public String getLaptop(){
        return laptop.getText();
    }

    public void clickAddToCart(){
        addToCart.click();
    }
}
