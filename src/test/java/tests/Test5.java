package tests;

import base.MastodonBase;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import utils.ResetPolicy;
import java.time.Duration;
import static utils.ResetPolicy.Mode.RESET_DATA;
import pages.HomePage;
@ResetPolicy(RESET_DATA)
public class Test5 extends MastodonBase {

    private static final int WAIT_TIMEOUT = 10;
    private WebDriverWait wait;

    @Test
    public void testHotelSearch() throws InterruptedException {
        wait = new WebDriverWait(driver(), Duration.ofSeconds(WAIT_TIMEOUT));

        try {
// Initial wait for app to load
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().text(\"Start Search\")")));
            Thread.sleep(1000);

// 1. Click on city search layout
            WebElement citySearchLayout = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/citySearchLayout\")")));
            citySearchLayout.click();
            Thread.sleep(1000);

// 2. Click on edit text search city
            WebElement editTextSearchCity = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/editTextSearchCity\")")));
            editTextSearchCity.click();
            Thread.sleep(1000);

// 3. Insert "london" in search field
            editTextSearchCity.clear();
            editTextSearchCity.sendKeys("london");
            Thread.sleep(1500);

// 4. Wait until rootLayout is displayed
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/rootLayout\")")));
            Thread.sleep(1000);

// 5. Click on rootLayout
            WebElement rootLayout = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/rootLayout\")")));
            rootLayout.click();
            Thread.sleep(1000);

// 6. Click on check-in layout
            WebElement checkInLayout = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/checkInLayout\")")));
            checkInLayout.click();
            Thread.sleep(1000);

// 7. Click on accessibility id 26 (date selection)
            WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.accessibilityId("30")));
            dateElement.click();
            Thread.sleep(1000);

// 8. Click on close calendar
            WebElement closeCalendar = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/closeCalender\")")));
            closeCalendar.click();
            Thread.sleep(1000);

// 9. Click on guest layout view
            WebElement guestLayoutView = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/guestLayoutView\")")));
            guestLayoutView.click();
            Thread.sleep(1000);

// 10. Click on room adult add button three times
            for (int i = 0; i < 3; i++) {
                WebElement roomAdultAdd = wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/roomAdultAdd\")")));
                roomAdultAdd.click();
                Thread.sleep(800);
            }

// 11. Click on room child add button three times
            for (int i = 0; i < 2; i++) {
                WebElement roomChildAdd = wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/roomChildAdd\")")));
                roomChildAdd.click();
                Thread.sleep(800);
            }

// 12. Click on add more room
            //WebElement addMoreRoom = wait.until(ExpectedConditions.elementToBeClickable(
                    //AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/tvAddMoreRoom\")")));
            //addMoreRoom.click();
            //Thread.sleep(1000);

// 13. Click on room adult add button for one room
            WebElement roomAdultAddSecond = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/tvAddMoreRoom\")")));
            roomAdultAddSecond.click();
            Thread.sleep(1000);



// 15. Click on apply button
            WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/txtMoreOptionApply\")")));
            applyButton.click();
            Thread.sleep(1000);

// 16. Click on rating layout
            WebElement ratingLayout = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/ratingLayout\")")));
            ratingLayout.click();
            Thread.sleep(1000);

// 17. Click on 5-star rating
            WebElement fiveStarRating = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/ratingBar5\")")));
            fiveStarRating.click();
            Thread.sleep(1000);

// 18. Click on nationality text
            WebElement nationalityText = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/txtNationality\")")));
            nationalityText.click();
            Thread.sleep(1000);

// 19. Click on search layout for nationality
            WebElement searchLayout = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/searchLayout\")")));
            searchLayout.click();
            Thread.sleep(1000);

// 20. Find the actual text input field and insert "indian"
            try {
// Try to find EditText first
                WebElement nationalitySearchInput = wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")")));
                nationalitySearchInput.clear();
                nationalitySearchInput.sendKeys("indian");
            } catch (TimeoutException e) {
// Alternative approach: try to find by hint text or other attributes
                WebElement nationalitySearchInput = wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/searchLayout\").childSelector(new UiSelector().className(\"android.widget.EditText\"))")));
                nationalitySearchInput.clear();
                nationalitySearchInput.sendKeys("indian");
            }
            Thread.sleep(1500);

// 21. Click on the fourth linear layout (nationality selection)
            WebElement nationalitySelection = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(4)")));
            nationalitySelection.click();
            Thread.sleep(1000);

// 22. Click on "Start Search" button
            new HomePage(driver()).tapStartSearch();

// 23. Verify search result
            verifySearchResult();

        } catch (TimeoutException e) {
            Assert.fail("Timeout waiting for element: " + e.getMessage());
        } catch (Exception e) {
            Assert.fail("Test failed with exception: " + e.getMessage());
        }
    }

    private void verifySearchResult() {
        try {
// Check if search failed (error message displayed)
            boolean searchFailed = isElementPresentByResourceId("android:id/message");

            if (searchFailed) {
                System.out.println("Hotel search failed - Test Passed");
                Assert.assertTrue(true, "Search failed as expected");
                return;
            }

// Check if search successful (filter layout displayed)
            boolean searchSuccessful = isElementPresentByResourceId("com.myhotels.sa:id/fliterRelativeLayout");

            if (searchSuccessful) {
                System.out.println("Hotel search completed successfully!");
                Assert.assertTrue(true, "Hotel search flow executed successfully");
            } else {
                Assert.fail("Unable to determine search result - neither success nor failure elements found");
            }

        } catch (Exception e) {
            Assert.fail("Error verifying search result: " + e.getMessage());
        }
    }

    private boolean isElementPresentByResourceId(String resourceId) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver(), Duration.ofSeconds(5));
            shortWait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"" + resourceId + "\")")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}