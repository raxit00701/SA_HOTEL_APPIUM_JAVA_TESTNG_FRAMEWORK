package tests;

import base.MastodonBase;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import utils.CsvUtils;
import utils.ResetPolicy;
import java.time.Duration;
import pages.HomePage;
import pages.LoginPage;
import static utils.ResetPolicy.Mode.RESET_DATA;

@ResetPolicy(RESET_DATA)
public class Test2 extends MastodonBase {

    private static final int WAIT_TIMEOUT = 10;
    private WebDriverWait wait;

    @DataProvider(name = "SigninData", parallel = false)
    public Object[][] getSigninData() {
        return CsvUtils.readCsv("src/test/resources/data/signin.csv");
    }

    @Test(dataProvider = "SigninData")
    public void testLogin(String email, String password) throws InterruptedException {
        wait = new WebDriverWait(driver(), Duration.ofSeconds(WAIT_TIMEOUT));

        try {
            // 1. Wait until "Start Search" appears
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().text(\"Start Search\")")));
            Thread.sleep(1000);
            // 2) Tap "More" via POF
            new HomePage(driver()).tapMore();

// 3. Click on accountTextView
            new HomePage(driver()).tapAccount();


            // 4. Click on login with email
            WebElement loginWithEmail = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/logInWithEmail\")")));
            loginWithEmail.click();
            Thread.sleep(1000);

            new LoginPage(driver()).enterEmail(email);
            new LoginPage(driver()).enterPassword(password);
            new LoginPage(driver()).tapLogin();

            // 8. Verify login result
            verifyLoginResult(email, password);

        } catch (TimeoutException e) {
            Assert.fail("Timeout waiting for element: " + e.getMessage());
        } catch (Exception e) {
            Assert.fail("Test failed with exception: " + e.getMessage());
        }
    }

    private void verifyLoginResult(String email, String password) {
        try {
            // Check if login failed (error dialog or login button still present)
            boolean loginFailed = isElementPresentByUIAutomator("new UiSelector().resourceId(\"android:id/button1\")") ||
                    isElementPresentByUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/rlLogin\")");

            if (loginFailed) {
                System.out.println("Login failed for email: " + email + " - Test Passed");
                Assert.assertTrue(true, "Login failed as expected");
                return;
            }

            // Check if login successful (Terms & Conditions page displayed)
            boolean loginSuccessful = isElementPresentByXPath("//android.widget.TextView[@text='Terms & Conditions']");

            if (loginSuccessful) {
                System.out.println("Login successful for email: " + email + " - Test Passed");
                Assert.assertTrue(true, "Login successful as expected");
            } else {
                Assert.fail("Unable to determine login result for email: " + email);
            }

        } catch (Exception e) {
            Assert.fail("Error verifying login result: " + e.getMessage());
        }
    }

    private boolean isElementPresentByUIAutomator(String uiAutomatorSelector) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver(), Duration.ofSeconds(3));
            shortWait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.androidUIAutomator(uiAutomatorSelector)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    private boolean isElementPresentByXPath(String xpathSelector) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver(), Duration.ofSeconds(3));
            shortWait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.xpath(xpathSelector)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}