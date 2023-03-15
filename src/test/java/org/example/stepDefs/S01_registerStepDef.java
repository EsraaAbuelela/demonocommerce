package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class S01_registerStepDef {

    P01_register register = new P01_register();

    @Given("user go to register page")
    public void test() {

        register.registerlink().click();
    }

    @When("user select gender type")
    public void user_select_gender_type() {
         register.selectGender().click();
    }

    @And("user enter first name {string} and last name {string}")
    public void user_enter_first_name_and_last_name(String firstName, String lastName) {

       register.getFirstName().sendKeys(firstName);
       register.getLastName().sendKeys(lastName);

    }

    @And("user enter date of birth")
    public void user_enter_date_of_birth() {
     register.getDay();
     register.getMonth();
     register.getYear();
    }

    @And("user enter email {string} field")
    public void user_enter_email_field(String email) {
     register.getEmail().sendKeys(email);
    }

    @And("user fills Password fields {string} {string}")
    public void user_fills_password_fields(String password, String confirmPass) {
        register.getPassword().sendKeys(password);
        register.getConfirmPassword().sendKeys(confirmPass);
    }

    @And("user clicks on register button")
    public void user_clicks_on_register_button() {
        register.getRegisterButton().click();
    }

    @Then("success message is displayed")
    public void success_message_is_displayed() {
        String expectedMsg= "Your registration completed";
        String actualMsg= register.getSuccessMsg();
        SoftAssert s= new SoftAssert();

        s.assertEquals(expectedMsg,actualMsg);
        s.assertAll();
    }

}
