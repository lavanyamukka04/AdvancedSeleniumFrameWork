package org.firstproject.pages.POM.VWO;

import org.firstproject.Utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {


    //Page driver
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // page locators
    private By username=By.id("login-username");
    private By password=By.id("login-password");
    private By signButton=By.id("js-login-btn");
    private By error_Message=By.id("js-notification-box");

    // page actions
    public String loginToVWOInvalidCreds(String usr, String pwd){
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
        WaitHelpers.checkVisibility(driver,error_Message,20);
        String error_message_text= driver.findElement(error_Message).getText();
        return error_message_text;

    }

    public void loginToVWOValidCreds(String usr, String pwd){
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();


    }
}
