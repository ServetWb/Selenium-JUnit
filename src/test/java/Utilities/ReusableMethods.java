package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void wait(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
// Create a method that takes a list of WebElements,
// iterates through each WebElement,
// extracts the text from each element,
// adds it to a new list,
// and finally returns a list of Strings after processing all elements.

    public static List<String> convertToStringList(List<WebElement> webElementList) {

        List<String> stringList = new ArrayList<>();

        for (WebElement eachElement : webElementList) {
            stringList.add(eachElement.getText());
        }

        return stringList;


    }


    public static void switchToTargetUrlWindow(WebDriver driver, String targetUrl) {
        // Get the set of all currently open window handles
        Set<String> allOpenWindowHandles = driver.getWindowHandles();
        // Iterate through each window handle
        for (String eachHandle : allOpenWindowHandles) {
            // Switch to the current window
            driver.switchTo().window(eachHandle);
            // Get the current URL of the active window
            String currentUrl = driver.getCurrentUrl();
            // If the current URL matches the target URL, stop the loop
            if (targetUrl.equals(currentUrl)) {
                break;
            }
        }
    }

    public static void titleWindowSwitch(WebDriver driver, String targetTitle) {
        // Get the set of all currently open window handles
        Set<String> allOpenWindowHandles = driver.getWindowHandles();

        // Iterate through each window handle
        for (String eachHandle : allOpenWindowHandles) {
            // Switch to the current window using its handle
            driver.switchTo().window(eachHandle);

            // Get the title of the currently active window
            String currentTitle = driver.getTitle();

            // If the current title matches the target title, exit the loop
            if (targetTitle.equals(currentTitle)) {
                break;
            }
        }
    }
}
