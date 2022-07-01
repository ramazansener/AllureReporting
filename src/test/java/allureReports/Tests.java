package allureReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tests {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();


    }

    @Test(priority = 1)
    public void logoPresence(){
        boolean disstatus =driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img")).isDisplayed();
        Assert.assertEquals(disstatus,true);

    }

    @Test(priority = 2)
    public void loginTest(){
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("ramazan.sener6507@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Test123");
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

        Assert.assertEquals(driver.getTitle(),"nopCommerce demo store. Login");

    }

    @Test(priority = 3)
    public void registrationTest(){

        throw new SkipException("Skipping this test .");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
