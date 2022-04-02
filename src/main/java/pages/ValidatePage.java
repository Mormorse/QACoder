package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidatePage extends BasePage{

    @FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase!')]")
    WebElement title;

    @FindBy(xpath = "//p[@class='lead text-muted ']")
    WebElement purchaseData;

    public ValidatePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getTitle(){
        return getTextFromWebElement(title);
    }

    public String getPurchaseData() {
        return getTextFromWebElement(purchaseData);
    }
}
