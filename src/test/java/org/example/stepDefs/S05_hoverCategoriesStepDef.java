package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import javax.swing.*;
import java.util.Locale;

public class S05_hoverCategoriesStepDef {
    P03_homePage home= new P03_homePage();

    @Given("user hover on {string} category")
    public void user_hover_on_category(String Category) throws InterruptedException {
            home.hoverOnCategory(Category);
            Thread.sleep(2000);
    }
    @When("Category contains sub categories")
    public void category_contains_sub_categories() {
        boolean hasSubCat= home.checkIfContainsSubCategory();
        Assert.assertTrue(hasSubCat);
    }
    @And("user select {string} as sub Category")
    public void user_select_as_sub_category(String subCat) {
       home.clickonSubCategory(subCat);
    }
    @Then("sub-category {string} page opened")
    public void sub_category_page_opened(String subact) {

        String currentUrl= home.getSubCategURL();
        Assert.assertTrue(currentUrl.contains(subact.trim().toLowerCase(Locale.ROOT)));
    }
}
