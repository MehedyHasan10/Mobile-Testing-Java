package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public abstract class BaseTest {
    protected AppiumDriver driver;
    protected AppiumFluentWait<AppiumDriver> wait; 
    protected static final String SERVER_URL = "http://127.0.0.1:4723/";
    protected static final int MAX_WAIT = 10;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("appium:udid", "emulator-5554");
        cap.setCapability("appium:platformVersion", "10");
        cap.setCapability("appium:automationName", "UiAutomator2");
        cap.setCapability("appium:appPackage", "com.wdiodemoapp");
        cap.setCapability("appium:appActivity", "com.wdiodemoapp.MainActivity");
        driver = new AppiumDriver(new URL(SERVER_URL), cap);
        wait = new AppiumFluentWait<>(driver).withPollDelay(Duration.ofSeconds(MAX_WAIT));
    }

    @AfterMethod
    public void teardown() {
            driver.quit();
        }
}
