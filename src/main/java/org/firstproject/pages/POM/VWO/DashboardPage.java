package org.firstproject.pages.POM.VWO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.firstproject.Utils.WaitHelpers;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameOnDashboard = By.xpath("//span[@data-qa='lufexuloga']");

    public String loggedInUserName() throws InterruptedException {
        WaitHelpers.waitJVM(10000);
        driver.get("https://app.vwo.com/#/dashboard?accountId=1207845");
        WaitHelpers.waitJVM(3000);
        return driver.findElement(userNameOnDashboard).getText();
    }

}
