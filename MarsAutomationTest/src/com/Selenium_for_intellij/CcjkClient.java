package com.Selenium_for_intellij;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.HashMap;

public class CcjkClient extends ClientPlaceOrder {

    CcjkClient()
    {
    }

    CcjkClient(HashMap data) {
    }

    public void placeOrder() throws InterruptedException, IOException {
        super.placeOrder();
        url = this.url;
        SourceLanguage = this.SourceLanguage;
        TargetLanguage = this.TargetLanguage;
        Industry = this.Industry;
        PackageType = this.PackageType;

        WebDriver driver = this.driver;

    }
}