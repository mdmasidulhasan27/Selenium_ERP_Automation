package main.test;

import main.BaseClass;
import main.LoginToErp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import sun.awt.windows.ThemeReader;

public class TransferMemberInterVOTest extends LoginToErp {
    WebDriver webDriver;
    @BeforeMethod
    public void commonTaskStart() throws InterruptedException {
        webDriver = login();
        webDriver.findElement(By.xpath("//a [@href='/node/mfDashboard']")).click();
        webDriver.findElement(By.xpath("//div [contains(text(), 'Member')]")).click();
        webDriver.findElement(By.xpath("//span [@class='menuTxtSpan'][contains(text(), 'Member Transfer')]")).click();
        webDriver.findElement(By.xpath("//span [@class='menuTxtSpan'][contains(text(), 'Transfer Member (Inter VO)')]")).click();

        Thread.sleep(1000);
        webDriver.findElement(By.xpath("// select [@name='project_info_id' and @id='project_info_id']")).click();
        Thread.sleep(500);
        webDriver.findElement(By.xpath("// option [contains(text(),'[15]')]")).click();
        Thread.sleep(500);
        webDriver.findElement(By.xpath("// input [@name='group_number' and @id='group_number']")).sendKeys("2015");
        webDriver.findElement(By.xpath("// div [contains(text(),'Member Code')]")).click();
        //webDriver.findElement(By.xpath("// div [contains(text(),'VO Code')]")).click();
        Thread.sleep(1000);
    }

    @AfterMethod
    public void commonTaskEnd() throws InterruptedException {
        webDriver.findElement(By.xpath("// input [@name='group_number1' and @id='group_number1']")).sendKeys("2");
        //webDriver.findElement(By.xpath("// div [contains(text(),'VO Code')]")).click();
        webDriver.findElement(By.xpath("// div [contains(text(),'Member Code')]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//input [@type='button' and @name='transfer']")).click();
    }

    @Test(priority = 1, enabled = true, description = "check that, member with no loan or no savings can be transfer inter vo whan day is open")
    public void transferMemberWithNoLoanOrNoSavingsInterVoWhenDayIsOpenShouldSucceed() throws InterruptedException {
        webDriver.findElement(By.xpath("// input [@name='membershipNumber' and @id='membershipNumber']")).sendKeys("62");
        webDriver.findElement(By.xpath("// div [contains(text(),'Member Code')]")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.xpath("//input [@type='button' and @name='Add to Grid']")).click();
        Thread.sleep(100);
    }

    @Test(priority = 2, enabled = true, description = "check that, members with no loan or no savings can be transfer inter vo whan day is open")
    public void transferMoreThanOneMemberWithNoLoanOrNoSavingsInterVoWhenDayIsOpenShouldSucceed() throws InterruptedException {
        webDriver.findElement(By.xpath("// input [@name='membershipNumber' and @id='membershipNumber']")).sendKeys("62");
        webDriver.findElement(By.xpath("// div [contains(text(),'Member Code')]")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.xpath("//input [@type='button' and @name='Add to Grid']")).click();
        Thread.sleep(100);
    }


    @Test(priority = 3, enabled = true, description = "check that, member with no loan or no savings can be transfer inter vo whan day is close")
    public void transferMemberWithNoLoanOrNoSavingsInterVoWhenDayIsClosedShouldFail() {

    }

    @Test(priority = 4, enabled = true, description = "check that, members with no loan or no savings can be transfer inter vo whan day is close")
    public void transferMoreThanOneMemberWithNoLoanOrNoSavingsInterVoWhenDayIsClosedShouldFail() {

    }

}
