package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private final By homePage = By.xpath("//android.widget.TextView[@text=\"WEBDRIVER\"]");
    private final By loginIlable =By.xpath("//android.view.View[@content-desc=\"Login\"]");
    private final By loginPage = By.xpath("//android.widget.TextView[@text=\"LOGIN\"]");
    private final By emailInput = By.xpath("//android.widget.EditText[@content-desc=\"input-email\"]");
    private final By passwordInput = By.xpath("//android.widget.EditText[@content-desc=\"input-password\"]");
    private final By loginButton = By.xpath("//android.widget.TextView[@text=\"LOGIN\"]");
    private final By iFrame = By.xpath("/hierarchy/android.widget.FrameLayout");
    private final By resultHeader = By.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]");
    private final By okButton = By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
    private final String userEmail= "mehedisiam@gmail.com";
    private final String userPassword = "12345678";
    private final String expectedResult = "Success";
    
    
    @Test
    public void successLoginTest() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage));
        Assert.assertTrue(driver.findElement(homePage).isDisplayed(), "Main page is not displayed.");
        driver.findElement(loginIlable).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage));
        
        driver.findElement(emailInput).sendKeys(userEmail);
        driver.findElement(passwordInput).sendKeys(userPassword);
        driver.findElement(loginButton).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(iFrame));
        driver.findElement(iFrame).click();
        String actualResult = driver.findElement(resultHeader).getText();
        Assert.assertEquals(actualResult, expectedResult, "Success message is not displayed.");
        driver.findElement(okButton).click();
    }
}
