package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PomBase {

    public  String getcurrentUrl(){
        return  Hooks.driver.getCurrentUrl();
    }

    public WebElement getPassword(){

        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement getEmail(){

        return Hooks.driver.findElement(By.id("Email"));
    }

}
