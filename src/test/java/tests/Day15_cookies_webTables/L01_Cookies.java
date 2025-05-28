package tests.Day15_cookies_webTables;

import Utilities.ReusableMethods;
import Utilities.TestBase_Each;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class L01_Cookies extends TestBase_Each {

    @Test
    public void test01() {

        // 1- Go to Google's homepage
        driver.get("https://www.google.com");
        ReusableMethods.wait(1);

        // 2- Accept cookies if prompted
        driver.findElement(By.xpath("//div[.='Accept all']"))
                .click();
        ReusableMethods.wait(1);

        // 3- Verify that the number of cookies on the page is 3 or more
        Set<Cookie> cookieSet = driver.manage().getCookies();

        int expectedMinCookieCount = 3;
        int actualCookieCount = cookieSet.size();

        Assertions.assertTrue(actualCookieCount >= expectedMinCookieCount);

        // 4- Print all the cookies on the page
        System.out.println(cookieSet);

    /*
        Example output:
        [
          NID=524=...; expires=Sun, 23 Nov 2025 17:56:43 GMT; path=/; domain=.google.com;secure;; sameSite=None,
          SOCS=...; expires=Tue, 23 Jun 2026 17:56:43 GMT; path=/; domain=.google.com;secure;; sameSite=Lax,
          EUULE=...; expires=Sat, 24 May 2025 18:06:42 GMT; path=/; domain=www.google.com;secure;; sameSite=Lax,
          AEC=...; expires=Thu, 20 Nov 2025 17:56:41 GMT; path=/; domain=.google.com;secure;; sameSite=Lax
        ]
    */

        // Let's use a loop to print the cookies in a more organized way
        // Since Set doesn't support indexing, we must use a for-each loop

        int orderNo = 1;

        for (Cookie eachCookie : cookieSet) {
            System.out.println(orderNo + ". cookie: \n" + eachCookie);
            orderNo++;
        }

    /*
        Example output:
        1. cookie:
        NID=524=...; expires=Sun, 23 Nov 2025 18:00:00 GMT; path=/; domain=.google.com;secure;; sameSite=None
        2. cookie:
        SOCS=...; expires=Tue, 23 Jun 2026 18:00:00 GMT; path=/; domain=.google.com;secure;; sameSite=Lax
        3. cookie:
        EUULE=...; expires=Sat, 24 May 2025 18:09:59 GMT; path=/; domain=www.google.com;secure;; sameSite=Lax
        4. cookie:
        AEC=...; expires=Thu, 20 Nov 2025 17:59:58 GMT; path=/; domain=.google.com;secure;; sameSite=Lax
    */

        // 5- Print only the names of the cookies

        orderNo = 1;

        for (Cookie eachCookie : cookieSet) {
            System.out.println(orderNo + ". cookie name: " + eachCookie.getName());
            orderNo++;
        }

    /*
        Example output:
        1. cookie name: NID
        2. cookie name: SOCS
        3. cookie name: EUULE
        4. cookie name: AEC
    */

        // 6- Create a cookie named "my favorite cookie" with the value "chocolate"
        // and add it to the page

        Cookie cookieObject = new Cookie("my favorite cookie", "chocolate");
        driver.manage().addCookie(cookieObject);

        // 7- Verify that the cookie has been successfully added

        // Alternative methods:
        // A- Save all cookies, create a list with their names, and check if it contains "my favorite cookie"
        // B- Check directly if the value of "my favorite cookie" is "chocolate"

        // Method B (might throw NullPointerException if cookie is not found)
        Cookie actualCookie = driver.manage().getCookieNamed("my favorite cookie");
        String expectedCookieValue = "chocolate";
        String actualCookieValue = actualCookie.getValue();

        Assertions.assertEquals(expectedCookieValue, actualCookieValue);

        // Method A
        cookieSet = driver.manage().getCookies();

        // Add the names of all cookies to a list
        List<String> cookieNameList = new ArrayList<>();

        for (Cookie eachCookie : cookieSet) {
            cookieNameList.add(eachCookie.getName());
        }

        // Verify that the list contains "my favorite cookie"
        Assertions.assertTrue(cookieNameList.contains("my favorite cookie"));

        // 8- Delete the cookie named "SOCS" and verify it is deleted

        driver.manage().deleteCookieNamed("SOCS");

        cookieSet = driver.manage().getCookies();
        cookieNameList = new ArrayList<>();

        for (Cookie eachCookie : cookieSet) {
            cookieNameList.add(eachCookie.getName());
        }

        Assertions.assertFalse(cookieNameList.contains("SOCS"));

        // 9- Delete all cookies
        driver.manage().deleteAllCookies();

        // And verify they are all deleted
        cookieSet = driver.manage().getCookies();

        Assertions.assertTrue(cookieSet.isEmpty());

    }
}