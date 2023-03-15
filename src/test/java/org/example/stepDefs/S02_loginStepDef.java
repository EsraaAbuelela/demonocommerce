package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.testng.asserts.SoftAssert;

public class S02_loginStepDef {

    P02_login login= new P02_login();

    @Given("user go to login page")
    public void user_go_to_login_page() {
        login.getLoginLink().click();
    }
    @When("user login with {string} {string} and {string}")
    public void user_login_with_and(String type, String email, String password) {
        if (type=="valid"){
            login.getEmail().clear();
            login.getEmail().sendKeys(email);
            login.getPassword().sendKeys(password);
        }
        else{
            login.getEmail().sendKeys(email);
            login.getPassword().sendKeys(password);
        }

    }
    @When("user press on login button")
    public void user_press_on_login_button() {
      login.getLoginBtn().click();
    }
    @Then("user login to the system successfully")
    public void user_login_to_the_system_successfully() {
        String url ="https://demo.nopcommerce.com/";
        String actualUrl= login.getcurrentUrl();
        login.accountTabdisplayed();
        SoftAssert s = new SoftAssert();
        s.assertEquals(url,actualUrl);
        s.assertTrue(login.accountTabdisplayed());
        s.assertAll();
    }


    @Then("user could not login to the system")
    public void user_could_not_login_to_the_system() {
        String actualMsg= login.getErrorMsg();
        String color= login.getMsgColor();
        SoftAssert s = new SoftAssert();
        s.assertTrue(actualMsg.contains("Login was unsuccessful."));
        s.assertEquals(color,"#e4434b");
        s.assertAll();
    }

}
