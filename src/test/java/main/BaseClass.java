package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
    protected static String officeCode="394";
    protected static String userName = "00026728";
    protected static String userPassword = "abc123$";
    protected static String url = "https://erpstaging.brac.net";
    protected static WebDriver openBrowser() {
        System.setProperty("webdriver.gecko.driver", "D:\\ERP\\geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get(url);
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
