package tests.Day07_Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class L03_BestBuyTests {

    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void urlTest() {
        // Test that the page URL is exactly https://www.bestbuy.com/
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl, actualUrl, "The URL does not match the expected value.");
    }

    @Test
    public void titleTest() {
        // titleTest => Verify that the page title does NOT contain the word “Rest”
        String actualTitle = driver.getTitle();
        String unwantedTitleKeyword = "Rest";

        Assertions.assertFalse(actualTitle.contains(unwantedTitleKeyword),
                "The title contains the unwanted word 'Rest'.");
    }

    @Test
    public void logoTest() {
        // logoTest => Verify that the BestBuy logo is displayed
        WebElement logoElement = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assertions.assertTrue(logoElement.isDisplayed(), "The BestBuy logo is not visible.");
    }

    @Test
    public void francaisLinkTest() {
        // FrancaisLinkTest => Verify that the French language link is displayed
        WebElement francaisLinkElement = driver.findElement(By.xpath("//*[.='Français']"));

        Assertions.assertTrue(francaisLinkElement.isDisplayed(), "The 'Français' link is not visible.");
    }



}
