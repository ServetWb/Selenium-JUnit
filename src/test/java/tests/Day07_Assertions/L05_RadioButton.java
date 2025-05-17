package tests.Day07_Assertions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class L05_RadioButton {

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
    public void selectByLabelTest() {
        // a. Navigate to the given web page
        driver.get("https://testotomasyonu.com/form");

        // b. Locate the gender radio button elements
        WebElement femaleRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement maleRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement otherRadioButton = driver.findElement(By.id("inlineRadio3"));

        WebElement maleRadioLabelElement = driver.findElement(By.xpath("//*[@for='inlineRadio2']"));

        // c. Click the appropriate option using the label
        maleRadioLabelElement.click();

        // d. Verify that the selected radio button is selected, and others are not
        Assertions.assertTrue(maleRadioButton.isSelected(), "Male radio button is not selected");
        Assertions.assertFalse(femaleRadioButton.isSelected(), "Female radio button is selected");
        Assertions.assertFalse(otherRadioButton.isSelected(), "Other radio button is selected");
    }

    @Test
    public void selectByButtonTest() {
        // a. Navigate to the given web page
        driver.get("https://testotomasyonu.com/form");

        // b. Locate the gender radio button elements
        WebElement femaleRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement maleRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement otherRadioButton = driver.findElement(By.id("inlineRadio3"));

        // c. Click the appropriate radio button directly
        maleRadioButton.click();

        // d. Verify that the selected radio button is selected, and others are not
        Assertions.assertTrue(maleRadioButton.isSelected(), "Male radio button is not selected");
        Assertions.assertFalse(femaleRadioButton.isSelected(), "Female radio button is selected");
        Assertions.assertFalse(otherRadioButton.isSelected(), "Other radio button is selected");


    }
}