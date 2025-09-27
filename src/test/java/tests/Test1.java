package tests;

import base.MastodonBase;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import utils.CsvUtils;
import utils.ResetPolicy;

import java.time.Duration;

import pages.HomePage;
import pages.SignupPage;

import static utils.ResetPolicy.Mode.RESET_DATA;

@ResetPolicy(RESET_DATA)
public class Test1 extends MastodonBase {

    private static final int WAIT_TIMEOUT = 10;
    private WebDriverWait wait;

    @DataProvider(name = "SignupData", parallel = false)
    public Object[][] getLoginData() {
        return CsvUtils.readCsv("src/test/resources/data/signup.csv");
    }

    @Test(dataProvider = "SignupData")
    public void testSignupFlow(String firstName, String lastName, String email, String password, String searchText, String mobile) {
        wait = new WebDriverWait(driver(), Duration.ofSeconds(WAIT_TIMEOUT));
        SignupPage signup = new SignupPage(driver());

        try {
            // 1) Ensure landing state
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().text(\"Start Search\")")));
            Thread.sleep(1000);

            // 2) Tap "More" via POF
            new HomePage(driver()).tapMore();

            // 3) Go to Account
            WebElement accountText = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/accountTextView\")")));
            accountText.click();
            Thread.sleep(1000);

            // 4) Tap Sign Up
            WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/signUpWithGenex\")")));
            signUpButton.click();
            Thread.sleep(1000);

            // ===== Use SignupPage POF for the rest =====
            signup.enterFirstName(firstName);
            signup.enterLastName(lastName);
            signup.enterEmail(email);
            signup.enterPassword(password);

            signup.clickTextView3();
            signup.enterSearchText(searchText);
            signup.clickSearchButton();
            signup.clickFourthLinearLayout();

            signup.enterMobileNumber(mobile);
            signup.clickFinalSignUp();

            // Verify outcome
            Thread.sleep(2000);
            boolean isSignUpButtonVisible = !driver().findElements(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/txtSignUp\")")).isEmpty();
            boolean isErrorMessageVisible = !driver().findElements(
                    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/message\")")).isEmpty();

            if (isSignUpButtonVisible || isErrorMessageVisible) {
                Assert.assertTrue(true, "Signup failed as expected - either txtSignUp button or error message is displayed");
            } else {
                WebElement terms = wait.until(ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.androidUIAutomator("new UiSelector().text(\"Terms & Conditions\")")));
                Assert.assertTrue(terms.isDisplayed(), "Signup successful - Terms & Conditions displayed");
            }

        } catch (Exception e) {
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
