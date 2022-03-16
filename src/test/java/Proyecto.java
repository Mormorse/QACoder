import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.IndexPage;
import pages.LaptopsPage;
import pages.NavBarPage;
import pages.ProductoInfoPage;
import org.openqa.selenium.Alert;


public class Proyecto {
    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverFactory.getDriver();


    @Test
    public void PruebaProyecto() throws InterruptedException {
        driver.manage().window().maximize();
        driver.navigate().to(url);
        String Precio, Laptop;

        IndexPage indexPage = new IndexPage(driver);
        LaptopsPage laptopsPage = new LaptopsPage(driver);
        ProductoInfoPage productoInfoPage = new ProductoInfoPage(driver);
        NavBarPage navBarPage = new NavBarPage(driver);

        // Click Laptop
        indexPage.clickLaptopMenu();

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











    /*
        driver.findElement(By.linkText("Laptops")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Sony vaio i5')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Sony vaio i5')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Sony vaio i5']")));
        Laptop = driver.findElement(By.xpath("//h2[normalize-space()='Sony vaio i5']")).getText();
        Precio = driver.findElement(By.xpath("//h3[@class='price-container']")).getText();
        System.out.println(Laptop + " " + Precio);

        driver.findElement(By.linkText("Add to cart")).click();
    */

        driver.quit();

    }
}
