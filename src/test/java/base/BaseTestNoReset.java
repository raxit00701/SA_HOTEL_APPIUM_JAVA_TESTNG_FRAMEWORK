package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod; // <-- if your IDE flags this, replace with org.testng.annotations.BeforeMethod

import java.io.File;
import java.net.URL;
import java.time.Duration;

public class BaseTestNoReset {

    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;

    @BeforeMethod
    public void setUp() throws Exception {
        // Start Appium server
        File node = new File("C:/Program Files/nodejs/node.exe");
        File appiumMainJs = new File("C:/Users/raxit/AppData/Roaming/npm/node_modules/appium/build/lib/main.js");

        service = new AppiumServiceBuilder()
                .withAppiumJS(appiumMainJs)
                .usingDriverExecutable(node)
                .withIPAddress("127.0.0.1")
                .usingPort(4724)
                .withTimeout(Duration.ofSeconds(30))
                .build();

        service.start();

        // Setup desired capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 2");
        options.setApp("C:/Users/raxit/IdeaProjects/Pets_store_appium/src/main/resources/test.apk");
        options.setAppPackage("com.spoti");
        options.setAppActivity("com.spotify.music.MainActivity");
        options.setCapability("adbExecTimeout", 60000);
        options.setCapability("newCommandTimeout", 300);
        options.setCapability("appWaitActivity", "*");

        // 🚫 No reset (keep app + data)
        options.setCapability("noReset", true);
        options.setCapability("fullReset", false);

        // WebView/driver + QoL
        options.setCapability("chromedriverExecutable", "C:\\chromedriver.exe");
        options.setCapability("automationName", "UiAutomator2");
        options.setCapability("unicodeKeyboard", true);
        options.setCapability("resetKeyboard", true);

        // Start AndroidDriver session
        driver = new AndroidDriver(new URL("http://127.0.0.1:4724"), options);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tearing down Appium session and server...");
        if (driver != null) {
            try { driver.quit(); } catch (Exception ignored) {}
        }
        if (service != null) {
            service.stop();
            System.out.println("Appium server stopped successfully.");
        }
    }
}
