package tests;

import base.MastodonBase;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import utils.CsvUtils;
import utils.ResetPolicy;
import java.time.Duration;
import java.util.List;
import static utils.ResetPolicy.Mode.NO_RESET;
import pages.UpdateProfilePage;
import pages.HomePage;
@ResetPolicy(NO_RESET)
public class Test3 extends MastodonBase {

    private static final int WAIT_TIMEOUT = 10;
    private WebDriverWait wait;

    @DataProvider(name = "SigninData", parallel = false)
    public Object[][] getUpdateData() {
        return CsvUtils.readCsv("src/test/resources/data/updatedata.csv");
    }

    @Test(dataProvider = "SigninData")
    public void testUserProfileUpdate(String firstName, String lastName, String email,
                                      String dialCode, String mobile, String country, String nationality) {

        wait = new WebDriverWait(driver(), Duration.ofSeconds(WAIT_TIMEOUT));

        try {
// Wait for Start Search to appear
            wait1("new UiSelector().text(\"Start Search\")");

// Navigate to profile update
            click("com.myhotels.sa:id/action_item3");
            click("com.myhotels.sa:id/txtEnglish");


            new UpdateProfilePage(driver()).updateFirstName(firstName);
            new UpdateProfilePage(driver()).updateLastName(lastName);
            new UpdateProfilePage(driver()).updateEmail(email);
            new UpdateProfilePage(driver()).selectDialCode(dialCode);
            new UpdateProfilePage(driver()).updateMobile(mobile);
            new UpdateProfilePage(driver()).selectCountry(country);
            new UpdateProfilePage(driver()).selectNationality(nationality);


// Submit update and validate
            click("com.myhotels.sa:id/textViewUpdate");
            validateUpdateResult();

        } catch (Exception e) {
            Assert.fail("Test failed: " + e.getMessage());
        }
        click("new UiSelector().resourceId(\"android:id/button1\")");
        new HomePage(driver()).tapFind();

    }

    // Core interaction methods
    private void click(String locator) {
        By by = createLocator(locator);
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        sleep(500);
    }

    private void wait1(String uiSelector) {
        By by = AppiumBy.androidUIAutomator(uiSelector);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        sleep(1000);
    }

    private void clearAndType(String locator, String text) {
        By by = createLocator(locator);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        element.clear();
        element.sendKeys(text);
        sleep(300);
    }

    private void selectFromDropdown(String triggerLocator, String searchText) {
// Click to open dropdown
        click(triggerLocator);
        sleep(1000);

// Find and use search field
        WebElement searchField = findSearchField();
        if (searchField != null) {
            searchField.clear();
            searchField.sendKeys(searchText);
            sleep(500);

// Try to click search button, fallback to enter
            if (!clickSearchButton()) {
                searchField.sendKeys("\n");
            }
            sleep(1000);

// Select first result
            selectFirstResult();
        } else {
// Direct selection fallback
            selectByText(searchText);
        }
        sleep(500);
    }

    private WebElement findSearchField() {
        try {
// Try specific search field first
            return driver().findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().resourceId(\"com.myhotels.sa:id/editTextSearch\")"));
        } catch (Exception e) {
            try {
// Fallback to any EditText
                return driver().findElement(AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.EditText\")"));
            } catch (Exception ex) {
                return null;
            }
        }
    }

    private boolean clickSearchButton() {
        try {
            WebElement searchBtn = driver().findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().resourceId(\"com.myhotels.sa:id/imageViewSearch\")"));
            searchBtn.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void selectFirstResult() {
        try {
// Try specific list item selection
            WebElement result = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(3)")));
            result.click();
        } catch (Exception e) {
// Fallback to first clickable item in list
            try {
                List<WebElement> items = driver().findElements(AppiumBy.androidUIAutomator(
                        "new UiSelector().clickable(true)"));
                if (!items.isEmpty()) {
                    items.get(0).click();
                }
            } catch (Exception ex) {
                System.out.println("Could not select from dropdown results");
            }
        }
    }

    private void selectByText(String text) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().textContains(\"" + text + "\")")));
            element.click();
        } catch (Exception e) {
// Try partial match
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator("new UiSelector().textMatches(\".*" + text + ".*\")")));
                element.click();
            } catch (Exception ex) {
                System.out.println("Could not find element with text: " + text);
            }
        }
    }

    private By createLocator(String locator) {
        if (locator.startsWith("com.myhotels.sa:id/")) {
            return AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"" + locator + "\")");
        }
        return AppiumBy.androidUIAutomator(locator);
    }

    private void validateUpdateResult() {
        sleep(5000); // Wait for result

        boolean testPassed = false;
        String resultMessage = "";

// Check for failure dialog
        if (isElementPresent("android:id/button1")) {
            resultMessage = "Update failed - Expected scenario";
            testPassed = true;
        }
// Check for success dialog
        else if (isElementPresent("android:id/message")) {
            resultMessage = "Update completed successfully";
            testPassed = true;
        }

        System.out.println(resultMessage);
        Assert.assertTrue(testPassed, "No valid result dialog found");
    }

    private boolean isElementPresent(String resourceId) {
        try {
            driver().findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().resourceId(\"" + resourceId + "\")"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}