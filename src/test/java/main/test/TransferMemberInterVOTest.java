package main.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sun.awt.windows.ThemeReader;

public class TransferMemberInterVOTest {
    public static String officeCode="394";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "D:\\ERP\\geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://erpstaging.brac.net");
        System.out.println(webDriver.getTitle());
        webDriver.manage().window().maximize();
        webDriver.findElement(By.id("username_txt")).sendKeys("00026728");
        webDriver.findElement(By.id("password")).sendKeys("abc123$");
        webDriver.findElement(By.xpath("//button[@class='submit btn btn-primary']")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.id("officeIdDiv_arrow")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//div [@id='394'][@class='row']")).click();
        webDriver.findElement(By.xpath("//div [@id='394'][@class='row']")).click();

        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//input[@class='ui-button ui-widget ui-state-default ui-corner-all'][@type='button']")).click();

    }
}
