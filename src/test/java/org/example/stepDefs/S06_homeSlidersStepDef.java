package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class S06_homeSlidersStepDef {

      P03_homePage home = new P03_homePage();
     String expectedFirstUrl="https://demo.nopcommerce.com/nokia-lumia-1020";
     String expectedSecondUrl="https://demo.nopcommerce.com/iphone-6";

    @Given("user clicks on {string} slider on home Page")
    public void user_clicks_on_first_slider_on_home_page(String order) {
        if (order=="first")
               home.getFirstSlider().click();
        else
            home.getSecondSlider().click();

    }
    @Then("{string} slider page should be opened")
    public void first_slider_page_should_be_opened(String sliderOrder) {
        if (sliderOrder=="first"){
        String actualString= home.getcurrentUrl();
        Assert.assertEquals(actualString,expectedFirstUrl);}
        else{
            String actualString= home.getcurrentUrl();
            Assert.assertEquals(actualString,expectedSecondUrl);
        }
    }


}
