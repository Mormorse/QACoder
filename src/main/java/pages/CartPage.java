package pages;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utility.DriverFactory;


public class CartPage extends BasePage {

    public static WebDriverWait wait;
    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[2]")
    WebElement cartTittleProduct;

    @FindBy(xpath ="/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[3]" )
    WebElement cartPriceProduct;

    @FindBy(xpath = "//button[contains(text(),'Place Order')]")
    WebElement placeOrderButton;

    public CartPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
        this.wait = DriverFactory.getWait();
    }

    public String getTittle() {
        return getTextFromWebElement(cartTittleProduct);
    }
    //chequear como traer solo el monto precio--ProductoInfoPage
    public String getPrice() {
        return "$" + getTextFromWebElement(cartPriceProduct)  + " *includes tax";
    }

    public void clickOrder() {
        clickOnWebElement(placeOrderButton);
    }

    public String priceNumber(){ return getTextFromWebElement((cartPriceProduct));}


}

