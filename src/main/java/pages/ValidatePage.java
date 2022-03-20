package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidatePage extends IndexPage{

    @FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase!')]")
    WebElement title;

    public ValidatePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getTitle(){
        return getTextFromWebElement(title);
    }
}
