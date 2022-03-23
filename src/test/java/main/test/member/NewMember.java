package main.test.member;

import main.RandomDatas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static main.LoginToErp.login;

public class NewMember{
    String voCode = "5094";
    WebDriver webDriver;
    @BeforeMethod
    public void commonTaskStart() throws InterruptedException {
        webDriver = login();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//a [@href='/node/mfDashboard']")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//div [contains(text(), 'Member')]")).click();
        webDriver.findElement(By.xpath("//span [@class='menuTxtSpan'][contains(text(), 'Member')]")).click();
        webDriver.findElement(By.xpath("//span [@class='menuTxtSpan'][contains(text(), 'Member Setup')]")).click();

        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//input [@name='personalInfoDomain.nationalId' and @id='nationalId']")).sendKeys(RandomDatas.getNationalId());
        webDriver.findElement(By.xpath("// select [@name='project_info_id' and @id='project_info_id']")).click();
        webDriver.findElement(By.xpath("// option [contains(text(),'[15]')]")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("// select [@name='memberClassificationId' and @id='memberClassificationId']")).click();
        webDriver.findElement(By.xpath("// option [contains(text(),'General Member')]")).click();

        webDriver.findElement(By.xpath("// input [@name='group_number' and @id='group_number']")).sendKeys(voCode);
        webDriver.findElement(By.xpath("// div [@class='element-title'] [contains(text(),'VO Code')]")).click();
        Thread.sleep(2000);

        //webDriver.findElement(By.xpath("// div [@class = 'element-input']")).click();
        //webDriver.findElement(By.id("personalInfoDomain.salutationId")).click();
        //webDriver.findElement(By.xpath("//select [@name='personalInfoDomain.salutationId']")).click();
        //webDriver.findElement(By.xpath("// option [contains(text(),'Mr.')]")).click();

        webDriver.findElement(By.xpath("//input [@name='fName' and @id='fName']")).sendKeys("Hello");
        webDriver.findElement(By.xpath("//input [@name='mName' and @id='mName']")).sendKeys("Hello");
        webDriver.findElement(By.xpath("//input [@name='lName' and @id='lName']")).sendKeys("Hello");

        webDriver.findElement(By.xpath("//select [@name='personalInfoDomain.genderId']")).click();
        webDriver.findElement(By.xpath("// option [contains(text(),'Male')]")).click();

        webDriver.findElement(By.xpath("//select [@name='personalInfoDomain.maritalStatusId']")).click();
        webDriver.findElement(By.xpath("// option [contains(text(),'Single')]")).click();

        webDriver.findElement(By.xpath("//input [@name='personalInfoDomain.dateOfBirth']")).click();
        webDriver.findElement(By.xpath("//input [@name='personalInfoDomain.dateOfBirth']")).sendKeys("01-01-1998");
        webDriver.findElement(By.xpath("// div [@class='element-title'] [contains(text(),'Date of Birth')]")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.xpath("//select [@name='personalInfoDomain.occupationId']")).click();
        webDriver.findElement(By.xpath("// option [contains(text(),'Others')]")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.xpath("//input [@name='personalInfoDomain.fatherName' and @id='memberFatherName']")).sendKeys("Father Name");
        webDriver.findElement(By.xpath("//input [@name='personalInfoDomain.motherName' and @id='memberMotherName']")).sendKeys("Mother Name");
        webDriver.findElement(By.xpath("//input [@name='contactInfoDomain.contactNo' and @id='contactNo']")).sendKeys(RandomDatas.getMobileNo());
        webDriver.findElement(By.xpath("//textarea [@name='nAddresses.address[0].address' and @id='address_0']")).sendKeys("This is address of member");

        webDriver.findElement(By.xpath("//input [@type='button' and @name='save' and @id='saveButtonId']")).click();

    }

    @AfterMethod
    public void commonTaskEnd() throws InterruptedException {
        //webDriver.findElement(By.xpath("// input [@name='group_number1' and @id='group_number1']")).sendKeys("2");
        //webDriver.findElement(By.xpath("// div [contains(text(),'VO Code')]")).click();
        //webDriver.findElement(By.xpath("// div [contains(text(),'Member Code')]")).click();
        //Thread.sleep(2000);
        //webDriver.findElement(By.xpath("//input [@type='button' and @name='transfer']")).click();
    }

    @Test()
    public void createNewMember() throws InterruptedException {
        //webDriver.findElement(By.xpath("// input [@name='membershipNumber' and @id='membershipNumber']")).sendKeys("62");
        //webDriver.findElement(By.xpath("// div [contains(text(),'Member Code')]")).click();
        //Thread.sleep(1000);

        //webDriver.findElement(By.xpath("//input [@type='button' and @name='Add to Grid']")).click();
        //Thread.sleep(100);
    }
}
