package tests;

import base.MastodonBase;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ResetPolicy;

import java.time.Duration;

import static utils.ResetPolicy.Mode.RESET_DATA;

@ResetPolicy(RESET_DATA)
public class Test4 extends MastodonBase {

    private static final int WAIT_TIMEOUT = 10;
    private WebDriverWait wait;

    private void step(String msg) {
        System.out.println("STEP: " + msg);
        try { Allure.step(msg); } catch (Throwable ignored) {}
    }

    @Test
    public void testHotelSearch() throws InterruptedException {
        wait = new WebDriverWait(driver(), Duration.ofSeconds(WAIT_TIMEOUT));

        step("Initial wait for 'Start Search' button to be present");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Start Search\")")));
        Thread.sleep(1000);

        step("Tap 'More' via HomePage POF");
        new HomePage(driver()).tapMore();

        step("Tap 'Account' via HomePage POF");
        new HomePage(driver()).tapAccount();

        step("Tap 'Login with Email'");
        WebElement loginWithEmail = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/logInWithEmail\")")));
        loginWithEmail.click();
        Thread.sleep(1000);

        step("Enter email");
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/loginEmailId\")")));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("figeta5193@camjoint.com");
        Thread.sleep(1000);

        step("Enter password");
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/loginPassword\")")));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("tony2406");
        Thread.sleep(1000);

        step("Tap 'Login' button");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/rlLogin\")")));
        loginButton.click();
        Thread.sleep(2000);

        step("Tap 'Search' (accessibility id)");
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Search")));
        searchButton.click();
        Thread.sleep(1000);

        step("Open city search layout");
        WebElement citySearchLayout = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/citySearchLayout\")")));
        citySearchLayout.click();
        Thread.sleep(1000);

        step("Focus city search input");
        WebElement editTextSearchCity = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/editTextSearchCity\")")));
        editTextSearchCity.click();
        Thread.sleep(1000);

        step("Type city name 'mumbai'");
        editTextSearchCity.clear();
        editTextSearchCity.sendKeys("mumbai");
        Thread.sleep(1500);

        step("Wait for search results root layout");
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/rootLayout\")")));
        Thread.sleep(1000);

        step("Select first result (rootLayout)");
        WebElement rootLayout = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/rootLayout\")")));
        rootLayout.click();
        Thread.sleep(1000);

        step("Tap 'Start Search' via HomePage POF");
        new HomePage(driver()).tapStartSearch();
        Thread.sleep(20000);

        step("Open Sort panel");
        WebElement sortRelativeLayout = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/sortRelativeLayout\")")));
        sortRelativeLayout.click();
        Thread.sleep(1000);

        step("Pick 5th sort option (content instance 4)");
        WebElement contentInstance4 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/content\").instance(4)")));
        contentInstance4.click();
        Thread.sleep(10000);

        step("Open Filter panel");
        WebElement filterRelativeLayout = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/fliterRelativeLayout\")")));
        filterRelativeLayout.click();
        Thread.sleep(1000);

        step("Tick a filter 1 checkbox (checkBox1 instance 2)");
        WebElement checkBox1Instance2 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/checkBox1\").instance(2)")));
        checkBox1Instance2.click();


        step("Tick a filter 2 checkbox (checkBox1 instance 5)");
        WebElement checkBox1Instance0 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/checkBox1\").instance(5)")));
        checkBox1Instance0.click();



        step("Apply filters");
        WebElement textViewApply = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/textViewApply\")")));
        textViewApply.click();
        Thread.sleep(1000);

        step("Open first hotel card (middleLayout instance 0)");
        WebElement middleLayoutInstance0 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/middleLayout\").instance(0)")));
        middleLayoutInstance0.click();
        Thread.sleep(1000);
        Thread.sleep(1000);
        step("Fast scroll and bring target element into view");
        driver().findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".setAsVerticalList()" +
                                ".flingToEnd(2);" +
                                "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".setAsVerticalList()" +
                                ".scrollIntoView(new UiSelector().resourceId(\"com.myhotels.sa:id/middleLayout\").instance(0))"
                )
        );

        step("Tap first 'button1'");
        WebElement button1 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("(//android.widget.Button[@resource-id=\"com.myhotels.sa:id/button1\"])[1]")));
        button1.click();
        Thread.sleep(1000);

        step("Tick 'checkBox1' on booking screen");
        WebElement checkBox1 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/checkBox1\")")));
        checkBox1.click();
        Thread.sleep(1000);

        step("Tap 'Book Now' container");
        WebElement linearLayoutBookNow = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.myhotels.sa:id/linearLayoutBookNow\")")));
        linearLayoutBookNow.click();
        Thread.sleep(1000);

        step("Focus 'Last Name' field");
        driver().findElement(AppiumBy.androidUIAutomator(
                        "new UiSelector().resourceId(\"com.myhotels.sa:id/contactInfoLastName\")"))
                .click();

        step("Tap 'Book Now' to proceed");
        driver().findElement(AppiumBy.androidUIAutomator(
                        "new UiSelector().resourceId(\"com.myhotels.sa:id/linearLayoutBookNow\")"))
                .click();

        step("Test flow completed");
    }
}
