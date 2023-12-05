import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Foundation {

    public static WebDriver driver;
    public static WebDriverWait waiter;

    public static void initialize(){
        System.setProperty("webdriver.chrome.driver", "C:\\year3fall\\burgerBurgerTests\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        waiter = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get("https://burgerburger.azurewebsites.net");
        driver.findElement(By.xpath("//a[@href='/Identity/Account/Login']")).click();
        waiter.until(ExpectedConditions.titleContains("Log in"));
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@burgerBurger.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Burger1234!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

}
