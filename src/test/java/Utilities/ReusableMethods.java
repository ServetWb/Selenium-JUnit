package Utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public  class ReusableMethods {

    public static void wait(int min) {
        try {
            Thread.sleep(min * 1000);
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
}