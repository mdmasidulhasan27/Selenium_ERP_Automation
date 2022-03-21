package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
    protected static String officeCode="394";
    protected static String userName = "00026728";
    protected static String userPassword = "abc123$";
    protected static String url = "https://erpstaging.brac.net";

    protected static WebDriver openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(url);
        webDriver.manage().window().maximize();
        Thread.sleep(1000);
        return webDriver;
    }
}
