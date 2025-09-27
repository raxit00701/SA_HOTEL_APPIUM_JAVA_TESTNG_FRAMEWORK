package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateProfilePage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    // ---------- Basic info ----------
    @AndroidFindBy(id = "com.myhotels.sa:id/upFirstName")
    private WebElement firstNameInput;

    @AndroidFindBy(id = "com.myhotels.sa:id/upLastName")
    private WebElement lastNameInput;

    @AndroidFindBy(id = "com.myhotels.sa:id/upEmailId")
    private WebElement emailInput;

    @AndroidFindBy(id = "com.myhotels.sa:id/upMobile")
    private WebElement mobileInput;

    // ---------- Dropdown entry points ----------
    @AndroidFindBy(id = "com.myhotels.sa:id/txtDialCode")
    private WebElement dialCodeDropdown;

    @AndroidFindBy(id = "com.myhotels.sa:id/upCountry")
    private WebElement countryDropdown;

    @AndroidFindBy(id = "com.myhotels.sa:id/tvNationality")
    private WebElement nationalityDropdown;

    public UpdateProfilePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ===== Helpers =====
    private void clearAndType(WebElement el, String text) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        Thread.sleep(300);
        el.clear();
        el.sendKeys(text);
        Thread.sleep(500);
    }

    /**
     * Taps a dropdown element, then selects an item by exact text.
     * Falls back to textContains and a UiScrollable search.
     */
    private void selectFromDropdown(WebElement dropdownEl, String visibleText) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(dropdownEl)).click();
        Thread.sleep(500);

        // Try exact text first
        try {
            wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().text(\"" + visibleText + "\")")
            )).click();
            Thread.sleep(300);
            return;
        } catch (TimeoutException ignored) {}

        // Fallback: contains
        try {
            wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().textContains(\"" + visibleText + "\")")
            )).click();
            Thread.sleep(300);
            return;
        } catch (TimeoutException ignored) {}

        // Final fallback: scroll to it and click
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"" + visibleText + "\"))"
            ));
            wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().text(\"" + visibleText + "\")")
            )).click();
            Thread.sleep(300);
        } catch (Exception e) {
            throw new TimeoutException("Unable to select dropdown value: " + visibleText, e);
        }
    }

    // ===== Public actions matching your snippet =====

    public UpdateProfilePage updateFirstName(String firstName) throws InterruptedException {
        clearAndType(firstNameInput, firstName);
        return this;
    }

    public UpdateProfilePage updateLastName(String lastName) throws InterruptedException {
        clearAndType(lastNameInput, lastName);
        return this;
    }

    public UpdateProfilePage updateEmail(String email) throws InterruptedException {
        clearAndType(emailInput, email);
        return this;
    }

    public UpdateProfilePage updateMobile(String mobile) throws InterruptedException {
        clearAndType(mobileInput, mobile);
        return this;
    }

    public UpdateProfilePage selectDialCode(String dialCode) throws InterruptedException {
        selectFromDropdown(dialCodeDropdown, dialCode);
        return this;
    }

    public UpdateProfilePage selectCountry(String country) throws InterruptedException {
        selectFromDropdown(countryDropdown, country);
        return this;
    }

    public UpdateProfilePage selectNationality(String nationality) throws InterruptedException {
        selectFromDropdown(nationalityDropdown, nationality);
        return this;
    }

    // ===== Convenience flow =====
    public UpdateProfilePage updateBasicInfo(String firstName, String lastName, String email) throws InterruptedException {
        return updateFirstName(firstName)
                .updateLastName(lastName)
                .updateEmail(email);
    }

    public UpdateProfilePage completeProfile(String firstName, String lastName, String email,
                                             String dialCode, String mobile, String country, String nationality)
            throws InterruptedException {
        return updateBasicInfo(firstName, lastName, email)
                .selectDialCode(dialCode)
                .updateMobile(mobile)
                .selectCountry(country)
                .selectNationality(nationality);
    }
}
