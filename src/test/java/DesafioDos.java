import org.junit.Assert;
import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class DesafioDos {
    private String url = PropertiesFile.getProperty("url");
    private WebDriver driver = DriverFactory.getDriver();


    @Test
    public void DesafioClaseDos() throws InterruptedException {
        driver.manage().window().maximize();
        driver.navigate().to(url);
        String Precio, Laptop;


        driver.findElement(By.linkText("Laptops")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Sony vaio i5')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Sony vaio i5')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Sony vaio i5']")));
        Laptop = driver.findElement(By.xpath("//h2[normalize-space()='Sony vaio i5']")).getText();
        Precio = driver.findElement(By.xpath("//h3[@class='price-container']")).getText();
        System.out.println(Laptop + " " + Precio);

        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);


        driver.quit();

    }
}
