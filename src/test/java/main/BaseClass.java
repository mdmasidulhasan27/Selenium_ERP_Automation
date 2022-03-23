package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
    //protected static final String officeCode="394";
    protected static final String officeCode="378";
    protected static final String voCode="2015";
    protected static final String userName = "00026728";
    protected static final String userPassword = "abc123$";
    protected static final String url = "https://erpstaging.brac.net";
    protected static final String chromeDriverPath = "E:\\chromedriver.exe";

    protected static WebDriver openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(url);
        webDriver.manage().window().maximize();
        Thread.sleep(1000);
        return webDriver;
    }
}
