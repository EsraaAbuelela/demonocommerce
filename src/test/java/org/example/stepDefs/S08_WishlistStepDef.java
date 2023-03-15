package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class S08_WishlistStepDef {

    P03_homePage home= new P03_homePage();

    @Given("user click on wish button for Product")
    public void user_click_on_wish_button_for_product() {
          home.getWishBtn().click();
    }
    @Then("success message will be displayed")
    public void success_message_will_be_displayed() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
      boolean displayed=  wait.until(ExpectedConditions.visibilityOf(home.getSuccessMsg())).isDisplayed();
        Assert.assertTrue(displayed);
    }
    @Then("color of success message will be green")
    public void color_of_success_message_will_be_green() {
      String  expectedColor=  home.getmsgColor();
      String actual="#4bb07a";
      Assert.assertEquals(expectedColor,actual);
    }

    @Given("user opens wishlist page")
    public void user_opens_wishlist_page() {
        home.getWishlistBtn().click();
    }
    @Then("Qty value is increased")
    public void qty_value_is_increased() {

        String qn=  home.getQtValue();
        Assert.assertTrue(Integer.parseInt(qn) >0);
    }


}
