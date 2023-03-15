package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class S03_currenciesStepDef {

    P03_homePage home = new P03_homePage();
    @When("User select Euro currency from HomePage")
    public void user_select_euro_currency() {
        home.getCurrencylist().click();
        home.getEuroBtn().click();

    }
    @Then("All products should be in Euro Currency")
    public void all_products_should_be_in_euro_currency() {
        String expectedTxt="€";
        String actual= home.getProductsText();
        Assert.assertTrue(actual.contains(expectedTxt));
    }
}
