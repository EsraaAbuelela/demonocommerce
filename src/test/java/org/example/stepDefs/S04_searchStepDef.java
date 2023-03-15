package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class S04_searchStepDef {

    P03_homePage home= new P03_homePage();
    @Given("user click on search textbox")
    public void clickonSearchtextbox(){
     home.getSearchTextbx().click();
    }

    @When("user enter productName as {string}")
    public void user_enter_product_name_as(String name) {
     home.getSearchTextbx().sendKeys(name);
    }

    @And("user click on search button")
    public void user_click_on_search_button() {
        home.getSearchBtn().click();
    }
    @Then("search shows relevant results")
    public void search_shows_relevant_results()  {
        SoftAssert s = new SoftAssert();
        String currentURL=  home.getcurrentUrl();
        s.assertTrue(currentURL.contains("https://demo.nopcommerce.com/search?q="));


        String actualTitle= home.getProductTitle();
        String searchWord= home.getSeacrhWord();
        s.assertTrue(actualTitle.contains(searchWord));
        s.assertAll();

    }

    @When("user click on product displayed")
    public void user_click_on_product_displayed() {
       home.getProductItem().click();
    }
    @Then("product contains same {string}")
    public void product_contains_same(String skuSearchValue) {
        String actualSku= home.getSkuActualValue();

        Assert.assertEquals(actualSku,skuSearchValue);
    }

}
