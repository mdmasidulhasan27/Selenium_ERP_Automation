package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class LoginToErp extends BaseClass{

    public static WebDriver login() throws InterruptedException {
        WebDriver webDriver = openBrowser();
        System.out.println(webDriver.getTitle());

        webDriver.findElement(By.id("username_txt")).sendKeys(userName);
        webDriver.findElement(By.id("password")).sendKeys(userPassword);
        webDriver.findElement(By.xpath("//button[@class='submit btn btn-primary']")).click();
        webDriver.findElement(By.id("officeIdDiv_arrow")).click();
        Thread.sleep(1000);
        //webDriver.findElement(By.xpath("//div [@id='394'][@class='row']")).click();
        webDriver.findElement(By.xpath("//div [@id='"+officeCode+"']")).click();
        webDriver.findElement(By.xpath("//input[@class='ui-button ui-widget ui-state-default ui-corner-all'][@type='button']")).click();
        Thread.sleep(2000);
        //webDriver.navigate().refresh();
        webDriver.findElement(By.xpath("//button [@class='close-button']")).click();
        return webDriver;
    }

}
