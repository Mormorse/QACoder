package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    @FindBy (linkText = "Laptops")
    WebElement laptopMenu;

    WebDriver driver;

    public IndexPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLaptopMenu(){
        laptopMenu.click();
    }
}
