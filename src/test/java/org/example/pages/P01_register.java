package org.example.pages;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P01_register extends PomBase {


    public WebElement registerlink()
    {
        return Hooks.driver.findElement(By.className("ico-register"));
    }

    public WebElement selectGender(){

        return Hooks.driver.findElement(By.id("gender-female"));
    }

    public WebElement getFirstName(){

        return Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement getLastName(){

        return Hooks.driver.findElement(By.id("LastName"));
    }

    public void getDay(){
        WebElement list = Hooks.driver.findElement(By.name("DateOfBirthDay"));
        Select S = new Select(list);
         S.selectByValue("14");
    }

    public void getMonth(){
        WebElement list = Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        Select S = new Select(list);
        S.selectByValue("5");
    }

    public void getYear(){
        WebElement list = Hooks.driver.findElement(By.name("DateOfBirthYear"));
        Select S = new Select(list);
        S.selectByValue("1995");
    }


    public WebElement getConfirmPassword(){

        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement getRegisterButton(){

        return Hooks.driver.findElement(By.id("register-button"));
    }

    public String getSuccessMsg(){

        return Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).getText();

    }
}
