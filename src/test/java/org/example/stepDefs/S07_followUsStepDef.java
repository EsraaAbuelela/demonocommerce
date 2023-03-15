package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;

import java.util.Locale;

public class S07_followUsStepDef {

    P03_homePage home= new P03_homePage();
    @Given("user click on Facebook link")
    public void user_click_on_facebook_link() {
        home.getFbIcon().click();
    }

    @Given("user click on twitter link")
    public void user_click_on_twitter_link() {
        home.getTwitterEle().click();
    }

    @Given("user click on rss link")
    public void user_click_on_rss_link() {
        home.getRssEle().click();
    }

    @Given("user click on youtube link")
    public void user_click_on_youtube_link() {
        home.getYoutubeele().click();
    }

    @Then("{string} link opens on new tab")
    public void link_opens_on_new_tab(String icon) {
        home.navigateToWindow();
        String currentURL= home.getcurrentUrl();
        Assert.assertTrue(currentURL.contains(icon.trim().toLowerCase(Locale.ROOT)));
        home.closeWindow();
    }

}
