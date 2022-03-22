package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends BasePage{

    @FindBy(id = "name")
    WebElement formName;

    @FindBy(id = "country")
    WebElement formCountry;

    @FindBy(id = "city")
    WebElement formCity;

    @FindBy(id = "card")
    WebElement formCard;

    @FindBy(id = "month")
    WebElement formMonth;

    @FindBy(id = "year")
    WebElement formYear;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[3]/button[2]")
    WebElement formPurchase;

    public void FormPage(){
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void inputName(String name){
        sendKeysToWebElement(formName, name);
    }

    public void inputCountry(String country) {
        sendKeysToWebElement(formCountry, country);
    }

    public void inputCity(String city) {
        sendKeysToWebElement(formCity, city);
    }

    public void inputCard(String card) {
        sendKeysToWebElement(formCard, card);
    }

    public void inputMonth(String month) {
        sendKeysToWebElement(formMonth, month);
    }

    public void inputYear(String year) {
        sendKeysToWebElement(formYear, year);
    }

    public void clickPurchase() {
        clickOnWebElement(formPurchase);
    }

}
