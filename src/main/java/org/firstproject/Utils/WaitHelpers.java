package org.firstproject.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelpers {

    public ChromeDriver driver;

    public void OpenBrowser(WebDriver driver, String Url){

        driver.get(Url);
        driver.manage().window().maximize();
    }

    public void CloseBrowser(WebDriver driver){
        driver.quit();
    }

    public void WaitForTextTobePresent(WebDriver driver, int Time_in_Seconds, String XPath, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Time_in_Seconds));
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath(XPath)),text));
    }

    public static void checkVisibility(WebDriver driver, By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

//    public static void checkVisibility(WebDriver driver, By locator) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }

    public void WaitForAlert(WebDriver driver, int Time_in_Seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Time_in_Seconds));
        wait.until(ExpectedConditions.alertIsPresent());

    }

    public void WaitForVisibility(WebDriver driver, int Time_in_Seconds,String Xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Time_in_Seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
    }

    public static void waitJVM(int Time) throws InterruptedException {
        try{
            Thread.sleep(Time);
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public void  clickElementFound(String xpath){
        WebElement element= driver.findElement(By.xpath(xpath));
        element.click();
    }
}
