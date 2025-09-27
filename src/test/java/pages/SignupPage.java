package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.myhotels.sa:id/contactInfoFirstName\")")
    private WebElement firstNameField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.myhotels.sa:id/contactInfoLastName\")")
    private WebElement lastNameField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.myhotels.sa:id/contactInfoEmail\")")
    private WebElement emailField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.myhotels.sa:id/password\")")
    private WebElement passwordField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.myhotels.sa:id/textView3\")")
    private WebElement textView3;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.myhotels.sa:id/editTextSearch\")")
    private WebElement searchField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.myhotels.sa:id/imageViewSearch\")")
    private WebElement searchButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.LinearLayout\").instance(3)")
    private WebElement linearLayout;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.myhotels.sa:id/contactInfoMobile\")")
    private WebElement mobileField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.myhotels.sa:id/txtSignUp\")")
    private WebElement finalSignUp;

    public SignupPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterFirstName(String firstName) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(firstNameField)).click();
        firstNameField.sendKeys(firstName);
        Thread.sleep(1000);
    }

    public void enterLastName(String lastName) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(lastNameField)).click();
        lastNameField.sendKeys(lastName);
        Thread.sleep(1000);
    }

    public void enterEmail(String email) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).click();
        emailField.sendKeys(email);
        Thread.sleep(1000);
    }

    public void enterPassword(String password) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).click();
        passwordField.sendKeys(password);
        Thread.sleep(1000);
    }

    public void clickTextView3() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(textView3)).click();
        Thread.sleep(1000);
    }

    public void enterSearchText(String searchText) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(searchField)).click();
        searchField.sendKeys(searchText);
        Thread.sleep(1000);
    }

    public void clickSearchButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        Thread.sleep(1000);
    }

    public void clickFourthLinearLayout() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(linearLayout)).click();
        Thread.sleep(1000);
    }

    public void enterMobileNumber(String mobile) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(mobileField)).click();
        mobileField.sendKeys(mobile);
        Thread.sleep(1000);
    }

    public void clickFinalSignUp() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(finalSignUp)).click();
        Thread.sleep(2000);
    }
}