package tests;

import io.appium.java_client.MobileCommand;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTest extends BaseTest{
    private final By homePage = By.xpath("//android.widget.TextView[@text=\"WEBDRIVER\"]");
    private final By formIlable = By.xpath("//android.view.View[@content-desc=\"Forms\"]");
    private final By formPage = By.xpath("//android.widget.TextView[@text=\"Input field:\"]");
    private final By inputField = By.xpath("//android.widget.EditText[@content-desc=\"text-input\"]");
    private final By inputFieldResultHeader = By.xpath("//android.widget.EditText[@content-desc=\"text-input\"]");
    private final By switchButton = By.xpath("//android.widget.Switch[@content-desc=\"switch\"]");
    private final By switchBtnResultHeader =  By.xpath("//android.widget.TextView[@content-desc=\"switch-text\"]");
    private final By dropDownButton = By.xpath("//android.widget.EditText[@resource-id=\"text_input\"]");
    private final By activeButton = By.xpath("//android.view.ViewGroup[@content-desc=\"button-Active\"]");
    private final By iFrame = By.xpath("/hierarchy/android.widget.FrameLayout");
    private final By dropDownText = By.xpath("//android.widget.TextView[@text=\"webdriver.io is awesome\"]");
    private String inputFieldText = "test input";
    private String switchBtnText = "Click to turn the switch OFF";

    private final String scrollScript = "arguments[0].scrollIntoView(true);";
    
    @Test
    public void formTest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage));
        driver.findElement(formIlable).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(formPage));
        
        driver.findElement(inputField).sendKeys(inputFieldText);
        String actualInputResult = driver.findElement(inputFieldResultHeader).getText();
        Assert.assertEquals(actualInputResult,inputFieldText,"Does not match");

        driver.findElement(switchButton).click();
        String actualSwitchResult = driver.findElement(switchBtnResultHeader).getText();
        Assert.assertEquals(actualSwitchResult,switchBtnText,"Does not match");

        driver.findElement(dropDownButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(iFrame));
        driver.findElement(iFrame).click();
        driver.findElement(dropDownText).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(scrollScript, driver.findElement(activeButton));

        driver.findElement(activeButton).click();

    
      

    }


}
