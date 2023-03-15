package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class P02_login  extends  PomBase{


    public WebElement getLoginLink(){

        return Hooks.driver.findElement(By.cssSelector("a[href=\"/login?returnUrl=%2F\"]"));
    }

    public WebElement getLoginBtn(){
        return  Hooks.driver.findElement(By.cssSelector("div[class=\"buttons\"] button[type=\"submit\"]"));
    }


    public boolean accountTabdisplayed(){

       return Hooks.driver.findElement(By.cssSelector("div[class=\"header-links\"] a[href=\"/customer/info\"]")).isDisplayed();
    }

    public String getErrorMsg(){

        return Hooks.driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]")).getText();
    }

    public String getMsgColor(){

        String color= Hooks.driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]")).getCssValue("color");
      return   Color.fromString(color).asHex();
}}
