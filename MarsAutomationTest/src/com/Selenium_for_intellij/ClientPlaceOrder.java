package com.Selenium_for_intellij;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.util.Password;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;

public class ClientPlaceOrder
{

    public String CoId;
    public String url;
    public String SourceLanguage;
    public String TargetLanguage;
    public String Industry;
    public String PackageType;
    public String Client_email;
    public String Client_password;
    public String PaymentType;
    public WebDriver driver;
    public WebDriverWait wait;

    ClientPlaceOrder()
    {
    }

    ClientPlaceOrder(HashMap data)
    {
        this.url = data.get("url").toString();
        this.SourceLanguage = data.get("source_language").toString();
        this.TargetLanguage = data.get("target_language").toString();
        this.Industry = data.get("industry").toString();
        this.PackageType = data.get("package_type").toString();
        this.Client_email = data.get("Client_email").toString();
        this.Client_password = data.get("Client_password").toString();
        this.CoId = data.get("CoId").toString();
        this.PaymentType=data.get("payment_type").toString();

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium_java\\chromedriver_win32_4\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.get(url);

        driver.findElement(By.id("menu-place-order")).click();
        this.wait = new WebDriverWait(driver, 10);
    }

    public void placeOrder() throws InterruptedException, IOException {
        url = this.url;
        SourceLanguage = this.SourceLanguage;
        TargetLanguage = this.TargetLanguage;
        Industry = this.Industry;
        PackageType = this.PackageType;
        Client_email=this.Client_email;
        Client_password=this.Client_password;
        CoId=this.CoId;
        PaymentType=this.PaymentType;


        //       Use Given above Values for Selected Package Type
        //                                 Package Type        =       Value
        //                                 MTPE Package         =      MTPE
        //                                 STANDARD Package     =      standard
        //                                 PROFESSIONAL Package =      standardPlus
        //                                 PUBLISHING Package   =      professionalPlus


//------------------------------------------End of Add Place Order Data Assignment----------------------------------------//

        WebDriverWait wait = this.wait;
        WebDriver driver = this.driver;
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("heading"), "LANGUAGES AND EXPERT"));
        } catch (Exception e) {
            throw e;
        }

        driver.findElement(By.cssSelector("#sourceLanguageId_chosen")).click();
        driver.findElement(By.xpath("//*[@id='sourceLanguageId_chosen']/div/ul/li[contains(., '" + SourceLanguage + "')]")).click();
        driver.findElement(By.cssSelector("#targetLanguageId_chosen")).click();
        driver.findElement(By.xpath("//*[@id='targetLanguageId_chosen']/div/ul/li[contains(., '" + TargetLanguage + "')]")).click();
        driver.findElement(By.cssSelector("#industryId[value='" + Industry + "']")).click();

        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("update_certificates_info")));
        } catch (ElementNotVisibleException e) {
            throw e;
        }
        driver.findElement(By.id("update_certificates_info")).click();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("minWCBox")));
        } catch (ElementNotVisibleException e) {
            throw e;
        }
        String CertificateText;
        CertificateText = driver.findElement(By.id("minWCBox")).getText();
        System.out.print(CertificateText);
        driver.findElement(By.id("orderLogin")).click();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginFromIframe")));
        } catch (ElementNotVisibleException e) {
            throw e;
        }
        WebElement iframe;
        iframe = driver.findElement(By.tagName("iframe"));
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        } catch (ElementNotVisibleException e) {
            throw e;
        }

        Thread.sleep(1000);
        driver.findElement(By.id("username")).sendKeys("testclient2@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("_submit")).click();
        driver.switchTo().defaultContent();
    }
}
