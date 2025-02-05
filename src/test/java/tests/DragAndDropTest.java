package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest{
    private final By homePage = By.xpath("//android.widget.TextView[@text=\"WEBDRIVER\"]");
    private final By dragIlable = By.xpath("//android.view.View[@content-desc=\"Drag\"]");
    private final By dragPage = By.xpath("//android.widget.TextView[@text=\"Input field:\"]");
    private final By selectItem = By.xpath("//android.view.ViewGroup[@content-desc=\"drag-c1\"]/android.widget.ImageView");
    private final By targetItem = By.xpath("");
    
    
    @Test
    public void dragAndDropTest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage));
        driver.findElement(dragIlable).click();
        

        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(selectItem))
                .moveToElement(driver.findElement(targetItem))
                .release()
                .perform();

        System.out.println("Drag-and-Drop Test Passed!");
        
    }
}
