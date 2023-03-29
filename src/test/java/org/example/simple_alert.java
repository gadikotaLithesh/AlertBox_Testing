package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Scanner;

public class simple_alert {

    public static void main(String args[]){

        int options;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number");
        options = sc.nextInt();

        WebDriver driver;

        WebDriverManager.chromedriver().setup();

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(option);

        driver.manage().window().maximize();

        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");


        switch (options){
            case 1:

                driver.findElement(By.id("alertBox")).click();

                System.out.println(driver.switchTo().alert().getText());


                driver.switchTo().alert().accept();

                System.out.println(driver.findElement(By.id("output")).getText());

                break;

            case 2 :

                driver.findElement(By.id("confirmBox")).click();

                System.out.println(driver.switchTo().alert().getText());

                driver.switchTo().alert().dismiss();

                System.out.println(driver.findElement(By.id("output")).getText());

                break;

            case 3 :

                driver.findElement(By.id("promptBox")).click();
                System.out.println(driver.switchTo().alert().getText());

                driver.switchTo().alert().sendKeys("Lithesh");

                driver.switchTo().alert().accept();

                System.out.println(driver.findElement(By.id("output")).getText());

                break;
            default:
                System.out.println("Enter correct number");
                break;
        }



    }

}
