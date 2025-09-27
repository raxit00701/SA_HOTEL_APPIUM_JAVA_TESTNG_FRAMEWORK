package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    // Email field: com.myhotels.sa:id/loginEmailId
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.myhotels.sa:id/loginEmailId\")")
    private WebElement emailField;

    // Password field: com.myhotels.sa:id/loginPassword
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.myhotels.sa:id/loginPassword\")")
    private WebElement passwordField;

    // Login button container: com.myhotels.sa:id/rlLogin
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.myhotels.sa:id/rlLogin\")")
    private WebElement loginButton;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public LoginPage enterEmail(String email) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).click();
        Thread.sleep(500);
        emailField.clear();
        emailField.sendKeys(email);
        Thread.sleep(1000);
        return this;
    }

    public LoginPage enterPassword(String password) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).click();
        Thread.sleep(500);
        passwordField.clear();
        passwordField.sendKeys(password);
        Thread.sleep(1000);
        return this;
    }

    public LoginPage tapLogin() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        Thread.sleep(2000);
        return this;
    }

    // Convenience method
    public void login(String email, String password) throws InterruptedException {
        enterEmail(email);
        enterPassword(password);
        tapLogin();
    }
}
