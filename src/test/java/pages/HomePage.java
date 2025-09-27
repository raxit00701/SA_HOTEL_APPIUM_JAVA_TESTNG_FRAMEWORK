package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    // More button (content-desc="More")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"More\"]")
    private WebElement moreButton;

    // City search layout (resource-id)
    @AndroidFindBy(id = "com.myhotels.sa:id/citySearchLayout")
    private WebElement citySearchLayout;

    // Start Search button (text="Start Search")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Start Search\")")
    private WebElement startSearchButton;

    // Account entry point (resource-id)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.myhotels.sa:id/accountTextView\")")
    private WebElement accountText;

    // NEW: Find button (resource-id)
    @AndroidFindBy(id = "com.myhotels.sa:id/action_item1")
    private WebElement findButton;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public HomePage tapMore() {
        wait.until(ExpectedConditions.elementToBeClickable(moreButton)).click();
        return this;
    }

    public HomePage tapCitySearchLayout() {
        wait.until(ExpectedConditions.elementToBeClickable(citySearchLayout)).click();
        return this;
    }

    public HomePage tapStartSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(startSearchButton)).click();
        return this;
    }

    // NEW: tap on Account
    public HomePage tapAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(accountText)).click();
        return this;
    }

    // NEW: tap on Find
    public HomePage tapFind() {
        wait.until(ExpectedConditions.elementToBeClickable(findButton)).click();
        return this;
    }

    // Optional: quick visibility checks if you need assertions
    public boolean isMoreVisible() {
        return wait.until(ExpectedConditions.visibilityOf(moreButton)).isDisplayed();
    }
    public boolean isCitySearchVisible() {
        return wait.until(ExpectedConditions.visibilityOf(citySearchLayout)).isDisplayed();
    }
    public boolean isStartSearchVisible() {
        return wait.until(ExpectedConditions.visibilityOf(startSearchButton)).isDisplayed();
    }
    public boolean isAccountVisible() {
        return wait.until(ExpectedConditions.visibilityOf(accountText)).isDisplayed();
    }
    public boolean isFindVisible() {
        return wait.until(ExpectedConditions.visibilityOf(findButton)).isDisplayed();
    }
}
