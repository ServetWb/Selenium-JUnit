package tests.Day07_Assertions;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class L04_CheckBoxUsage {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkBoxTest() {
        // a. Navigate to the given web page:
        //    https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        // b. Select the "Back Pain" and "Palpitation" checkboxes
        WebElement backPainCheckbox = driver.findElement(By.id("gridCheck5"));
        WebElement palpitationCheckbox = driver.findElement(By.id("gridCheck4"));

        backPainCheckbox.click();
        palpitationCheckbox.click();

        // c. Verify that "Back Pain" and "Palpitation" checkboxes are selected
        Assertions.assertTrue(backPainCheckbox.isSelected(), "Back Pain checkbox is not selected");
        Assertions.assertTrue(palpitationCheckbox.isSelected(), "Palpitation checkbox is not selected");

        // d. Verify that "Diabetes" and "Epilepsy" checkboxes are NOT selected
        WebElement diabetesCheckbox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsyCheckbox = driver.findElement(By.id("hastalikCheck7"));

        Assertions.assertFalse(diabetesCheckbox.isSelected(), "Diabetes checkbox is selected");
        Assertions.assertFalse(epilepsyCheckbox.isSelected(), "Epilepsy checkbox is selected");
    }
}