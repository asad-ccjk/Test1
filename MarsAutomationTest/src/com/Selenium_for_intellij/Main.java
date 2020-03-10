package com.Selenium_for_intellij;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException
    {

        /* Geting PlaceOrder Data from user */
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter URL of the site");
        String URL=scn.nextLine();
        System.out.println("Enter Email Address of Client");
        String Client_email=scn.nextLine();
        System.out.println("Enter Password");
        String Client_password=scn.nextLine();
        int CoId=0;
        System.out.println("Enter Source Language");
        String SourceLanguage=scn.nextLine();
        System.out.println("Enter Targer Language");
        String TargetLanguage=scn.nextLine();
        System.out.println("Enter Industry Type");
        String Industry=scn.nextLine();
        System.out.println("Enter Package Type");
        String PackageType=scn.nextLine();
        System.out.println("Enter Package Type");
        String PaymentType=scn.nextLine();

        /* Creating and Declare HashMap */
        HashMap<String, String> hmap = new HashMap<String, String>();

        /*Adding elements to HashMap*/
        hmap.put("url", URL);
        hmap.put("source_language", SourceLanguage);
        hmap.put("target_language", TargetLanguage);
        hmap.put("industry", Industry);
        hmap.put("package_type", PackageType);
        hmap.put("Client_email", Client_email);
        hmap.put("payment_type", PaymentType);
        hmap.put("CoId", String.valueOf(CoId));
        hmap.put("Client_password", Client_password);

        if (Client_email.contains("@ccjk.com")) {
            System.out.println("Enter CO ID");
            CoId=scn.nextInt();

            CcjkClient clien2 = new CcjkClient(hmap);
            clien2.placeOrder();
        } else {
            NonCcjkClient client1 = new NonCcjkClient(hmap);
            client1.placeOrder();
        }

    }
}