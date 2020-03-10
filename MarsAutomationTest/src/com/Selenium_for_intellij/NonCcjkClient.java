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
import java.util.HashMap;

public class NonCcjkClient extends ClientPlaceOrder {
    NonCcjkClient() {
    }
    NonCcjkClient(HashMap data) {
        super(data);
    }

    public void placeOrder() throws InterruptedException, IOException {

        super.placeOrder();
//-------------------------------------------Add Place Order Data Assignment here----------------------------------------------//
        url = this.url;
        SourceLanguage = this.SourceLanguage;
        TargetLanguage = this.TargetLanguage;
        Industry = this.Industry;
        PackageType = this.PackageType;
        Client_email=this.Client_email;
        Client_password=this.Client_password;
        CoId=this.CoId;


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
            wait.until(ExpectedConditions.elementToBeClickable(By.id("btnTopPickSourceFiles")));
        } catch (ElementNotVisibleException e) {
            throw e;
        }
        driver.findElement(By.id("btnTopPickSourceFiles")).click();
        Thread.sleep(5000);
        Runtime.getRuntime().exec("C:\\Selenium_java\\MarsAutomationTest\\FileUpload.exe");
        try {
            String totalWords;
            totalWords = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".output_total_words"))).getText();
            System.out.println(totalWords);

//            System.exit(0);
            int WordCount = Integer.parseInt(totalWords);
            if (!(WordCount >= 300)) {
                System.out.println("Word Count must b 300");
                System.exit(0);
            } else {
                Thread.sleep(5000);
                driver.findElement(By.cssSelector("a[href*='#step3']")).click();
            }
        } catch (ElementNotVisibleException e) {
            throw e;
        }
        driver.findElement(By.cssSelector("div[data-type='" + PackageType + "']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".step_payment")).click();
    }
}
