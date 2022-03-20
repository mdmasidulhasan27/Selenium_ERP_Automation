package main.test;

import main.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import sun.awt.windows.ThemeReader;

public class TransferMemberInterVOTest extends BaseClass {

    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = openBrowser();
        System.out.println(webDriver.getTitle());
        webDriver.findElement(By.id("username_txt")).sendKeys(userName);
        webDriver.findElement(By.id("password")).sendKeys(userPassword);
        webDriver.findElement(By.xpath("//button[@class='submit btn btn-primary']")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.id("officeIdDiv_arrow")).click();
        Thread.sleep(1000);
        //webDriver.findElement(By.xpath("//div [@id='394'][@class='row']")).click();
        webDriver.findElement(By.xpath("//div [@id='394']")).click();
        webDriver.findElement(By.xpath("//input[@class='ui-button ui-widget ui-state-default ui-corner-all'][@type='button']")).click();
        Thread.sleep(1000);
        webDriver.navigate().refresh();
        Thread.sleep(1000);
        //webDriver.switchTo().window(webDriver.getWindowHandle());
        //webDriver.findElement(By.className("close-button")).click();
        //webDriver.switchTo().alert().dismiss();
        //webDriver.findElement(By.xpath("//button [@class='close-button']")).click();
        ///##########MICROFINANCE#############
        webDriver.findElement(By.xpath("//a [@href='/node/mfDashboard']")).click();

        webDriver.findElement(By.xpath("//div [contains(text(), 'Member')]")).click();
        webDriver.findElement(By.xpath("//span [@class='menuTxtSpan'][contains(text(), 'Member Transfer')]")).click();
        webDriver.findElement(By.xpath("//span [@class='menuTxtSpan'][contains(text(), 'Transfer Member (Inter VO)')]")).click();
        //webDriver.findElement(By.xpath("//span [@class='menuTxtSpan'][contains(text(), 'Member Transfer')]")).click();
        //webDriver.findElement(By.xpath("//span [@class='menuTxtSpan'][contains(text(), 'Member Transfer')]")).click();

    }
}
