package helper;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions extends TestBase{
    public static WebDriverWait wait = new WebDriverWait(driver, 15);

    public static void seleniumClick(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public static void seleniumTypeText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public static String seleniumGetText(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        String text = element.getText();
        return text;
    }

    public static void seleniumScrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void seleniumSelectDDLByValue(WebElement element, String value){
        seleniumScrollToElement(element);
        wait.until(ExpectedConditions.visibilityOf(element));
        Select ddl = new Select(element);
        ddl.selectByValue(value);
    }

    public static boolean imagePresence(WebElement element){
        Boolean imagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
        if (!imagePresent)
        {
            imagePresent = false;
            System.out.println("Image not displayed.");
        }
        else
        {
            imagePresent = true;
            System.out.println("Image displayed.");
        }
        return imagePresent;
    }

    public static void seleniumUploadFile(WebElement element, String path){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(path);
    }


}
