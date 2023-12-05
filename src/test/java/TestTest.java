import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.math.BigDecimal;
import java.util.List;

public class TestTest extends Foundation {

    @BeforeClass
    public void setUp(){
        initialize();
    }

    @Test
    public void test(){
        List<WebElement> headings = driver.findElements(By.xpath("//div[contains(@class, 'navbar-collapse')]//a | //div[contains(@class, 'navbar-collapse')]//button"));
        List<String> words = List.of("Locations", "Ingredient Outlines", "Static Items", "Custom Items", "Shop", "Cart", "Orders",
                "Gift Cards","admin@burgerburger.com's Account", "Account Balance: ", "Logout");

        for (int i = 0; i < words.size(); i++){
            if (headings.get(i).getText().contains("$")){
                String x = headings.get(i).getText().trim();
                Assert.assertEquals(x.substring(0, x.indexOf("$")), words.get(i), "Heading does not match.");
            }
            else {
                Assert.assertEquals(headings.get(i).getText().trim(), words.get(i), "Heading does not match.");
            }
        }

        driver.findElement(By.xpath("//a[@href='/Locations']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://burgerburger.azurewebsites.net/Locations", "Url does not match.");

        headings = driver.findElements(By.xpath("//thead/tr/th"));
        words = List.of("Name", "Store Location", "Inventory");
        for (int i = 0; i < words.size(); i++){
            Assert.assertEquals(headings.get(i).getText().trim(), words.get(i), "Heading does not match.");
        }

        driver.findElement(By.xpath("//a[contains(@href, '/Inventories?locationId=1')]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://burgerburger.azurewebsites.net/Inventories?locationId=1", "Url does not match.");

        headings = driver.findElements(By.xpath("//thead/tr/th"));
        words = List.of("Category", "Name", "Quantity", "Calories", "Shelf Life(days)", "Delivery Date", "Expiry", "Expire Check");
        for (int i = 0; i < words.size(); i++){
            Assert.assertEquals(headings.get(i).getText().trim(), words.get(i), "Heading does not match.");
        }

        driver.findElement(By.xpath("//a[@href='/InventoryOutlines']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://burgerburger.azurewebsites.net/InventoryOutlines", "Url does not match.");

        headings = driver.findElements(By.xpath("//thead/tr/th"));
        words = List.of("Category", "Name", "Description", "Calories", "Shelf Life(days)", "Item Cost");
        for (int i = 0; i < words.size(); i++){
            Assert.assertEquals(headings.get(i).getText().trim(), words.get(i), "Heading does not match.");
        }

        driver.findElement(By.xpath("//a[@href='/StaticItems']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://burgerburger.azurewebsites.net/StaticItems", "Url does not match.");

        headings = driver.findElements(By.xpath("//thead/tr/th"));
        words = List.of("Name", "Type", "Description", "Price", "Promotion", "Total Calories", "Photo");
        for (int i = 0; i < words.size(); i++){
            Assert.assertEquals(headings.get(i).getText().trim(), words.get(i), "Heading does not match.");
        }

        driver.findElement(By.xpath("//a[@href='/CustomItems']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://burgerburger.azurewebsites.net/CustomItems", "Url does not match.");

        headings = driver.findElements(By.xpath("//thead/tr/th"));
        words = List.of("Name", "Total Calories", "", "Purchase");
        for (int i = 0; i < words.size(); i++){
            Assert.assertEquals(headings.get(i).getText().trim(), words.get(i), "Heading does not match.");
        }

        driver.findElement(By.xpath("//a[@href='/Shop']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://burgerburger.azurewebsites.net/Shop", "Url does not match.");

        headings = driver.findElements(By.xpath("//*[@role='main']//a"));
        words = List.of("Custom Burger", "Premade", "Side", "Drink");
        for (int i = 0; i < words.size(); i++){
            Assert.assertEquals(headings.get(i).getText().trim(), words.get(i), "Button text does not match.");
        }

        driver.findElement(By.xpath("//a[@href='/Shop/Cart']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://burgerburger.azurewebsites.net/Shop/Cart", "Url does not match.");

        headings = driver.findElements(By.xpath("//thead/tr/th"));
        words = List.of("", "Name", "Quantity", "Price");
        for (int i = 0; i < words.size(); i++){
            Assert.assertEquals(headings.get(i).getText().trim(), words.get(i), "Heading does not match.");
        }

        WebElement totalPrice = driver.findElement(By.xpath("//tbody//*[contains(text(), '$')]"));
        Assert.assertEquals(totalPrice.getText().trim(), "$0.00", "An empty car should have no money allotted to it.");

        driver.findElement(By.xpath("//a[@href='/Orders']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://burgerburger.azurewebsites.net/Orders", "Url does not match.");

        headings = driver.findElements(By.xpath("//thead/tr/th"));
        words = List.of("Customer Email", "Order Date", "Order Total", "Status");
        for (int i = 0; i < words.size(); i++){
            Assert.assertEquals(headings.get(i).getText().trim(), words.get(i), "Heading text does not match.");
        }

        driver.findElement(By.xpath("//a[@href='/GiftCards']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://burgerburger.azurewebsites.net/GiftCards", "Url does not match.");

        headings = driver.findElements(By.xpath("//thead/tr/th"));
        words = List.of("Dollar Amount", "Redeemed");
        for (int i = 0; i < words.size(); i++){
            Assert.assertEquals(headings.get(i).getText().trim(), words.get(i), "Heading does not match.");
        }

        driver.findElement(By.xpath("//a[@href='/Home/Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://burgerburger.azurewebsites.net/Home/Account", "Url does not match.");

        headings = driver.findElements(By.xpath("//main//a"));
        words = List.of("Manage Account", "Add Funds to Balance", "Purchase Gift Card", "Redeem Gift Card", "Manage Users");
        for (int i = 0; i < words.size(); i++){
            Assert.assertEquals(headings.get(i).getText().trim(), words.get(i), "Heading text does not match.");
        }

        driver.findElement(By.xpath("//a[@href='/BalanceAdditions']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://burgerburger.azurewebsites.net/BalanceAdditions", "Url does not match.");

        headings = driver.findElements(By.xpath("//thead/tr/th"));
        words = List.of("Amount", "Payment Date", "Balance After Purchase");
        for (int i = 0; i < words.size(); i++){
            Assert.assertEquals(headings.get(i).getText().trim(), words.get(i), "Heading text does not match.");
        }

        driver.findElement(By.xpath("//button[text()='Logout']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://burgerburger.azurewebsites.net/", "Url does not match.");

        headings = driver.findElements(By.xpath("//div[contains(@class, 'navbar-collapse')]//a | //div[contains(@class, 'navbar-collapse')]//button"));
        words = List.of("Shop", "Cart", "Register", "Login");
        for (int i = 0; i < words.size(); i++){
            Assert.assertEquals(headings.get(i).getText().trim(), words.get(i), "Heading text does not match.");
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
