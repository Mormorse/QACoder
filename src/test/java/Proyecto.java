import utility.DriverFactory;
import utility.PropertiesFile;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import org.openqa.selenium.Alert;



public class Proyecto {
    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverFactory.getDriver();

    @BeforeTest
    public void beforeTest(){
        driver.navigate().to(url);
    }


    @Test
    public void PruebaProyecto() throws InterruptedException {
        driver.manage().window().maximize();
        driver.navigate().to(url);
        String Precio, Laptop;

        BasePage basePage = new BasePage();
        LaptopsPage laptopsPage = new LaptopsPage(driver);
        ProductoInfoPage productoInfoPage = new ProductoInfoPage(driver);
        NavBarPage navBarPage = new NavBarPage(driver);
        CartPage cartPage = new CartPage();
        FormPage formPage = new FormPage();
        ValidatePage validatePage = new ValidatePage();

        // Click Laptop
        basePage.clickLaptopMenu();

        laptopsPage.clickLaptopsFirstProduct(5);


        Laptop = productoInfoPage.getLaptop();
        Precio = productoInfoPage.getPrecio();

        System.out.println(Laptop + " " + Precio);

        productoInfoPage.clickAddToCart();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertmessage = alert.getText();
        alert.accept();

        navBarPage.navToCart();

        Assert.assertEquals(Laptop, cartPage.getTittle());
        Assert.assertEquals(Precio, cartPage.getPrice());

        cartPage.clickOrder();


        formPage.inputName("Matias Anriquez");
        formPage.inputCountry("Argentina");
        formPage.inputCity("Buenos Aires");
        formPage.inputCard("404585747878547");
        formPage.inputMonth("06");
        formPage.inputYear("2025");

        formPage.clickPurchase();


        Assert.assertEquals(validatePage.getTitle(), "Thank you for your purchase!");


        }

    @AfterTest
    public void afterTest(){
        System.out.println("Finalizan las pruebas");
        driver.quit();





    }
}
