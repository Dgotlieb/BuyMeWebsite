import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static java.nio.file.Files.getAttribute;

public class FirstScreen {
    private static WebDriver driver;
    private static WebDriverWait wait;


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/irinabulochkin/Downloads/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://buyme.co.il/"); //landing page//


        driver.findElement(By.xpath("//*[@data-ember-action=\"990\"]")).click(); //EnterRegistrationButton //
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-ember-action=\"1666\"]")));

        driver.findElement(By.xpath("//*[@data-ember-action=\"1666\"]")).click(); //registration button//


        WebElement elementName = driver.findElement(By.xpath("//*[@id=\"ember1698\"]")); //field 'First Name'//
        elementName.sendKeys("Test");
        String name = elementName.getAttribute("value");
        Assert.assertEquals("Test",name);


        driver.findElement(By.xpath("//*[@placeholder=\"מייל\"]")).sendKeys("test1001@gmail.com"); //
        elementName.sendKeys();
        String mail = elementName.getAttribute("value");
        Assert.assertEquals("test1001@gmail.com",name);


        driver.findElement(By.xpath("//*[@id=\"valPass\"]")).sendKeys("Welcome1!"); //'Password' field//
//        elementName.sendKeys();
//        String password = elementName.getAttribute("value");
//        Assert.assertEquals("Welcome1!",name);

//        driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[3]/label/input")).sendKeys("Welcome1!"); //'Confirm password' field//

//        driver.findElement(By.xpath("//*[@gtm=\"הרשמה ל-BUYME\"]")).click(); //'Registration to BUYME' button//
//        wait.until(Exception)



//        Extra
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/button")));
//        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/button")).click();

//        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/button")).sendKeys("test@t.com");



    }


    public static void tearDown() {
         driver.quit();
    }
}
