package org.example.pages;

import org.apache.hc.core5.util.Timeout;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class P03_homePage extends PomBase {

    ArrayList<String> tabs;

    public WebElement getCurrencylist() {

        return Hooks.driver.findElement(By.cssSelector("div[class=\"currency-selector\"]"));
    }

    public WebElement getEuroBtn() {

        return Hooks.driver.findElements(By.xpath("//select[@id='customerCurrency']//option")).get(1);
    }

    public String getProductsText() {
        String actualTxt = "null";
        List<WebElement> products = Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
        for (int i = 0; i < products.size(); i++)
            actualTxt = products.get(i).getText();
        return actualTxt;
    }

    public WebElement getSearchTextbx() {
        return Hooks.driver.findElement(By.name("q"));
    }

    public WebElement getSearchBtn() {
        return Hooks.driver.findElement(By.cssSelector("button[type=\"submit\"]"));
    }

    public String getProductTitle() {
        String actualTitle = "null";
        String search = getSeacrhWord();
        List<WebElement> titles = Hooks.driver.findElements(By.xpath("//h2[@class='product-title']//a[contains(text(),'" + search + "')]"));
        for (int i = 0; i < titles.size(); i++)
            actualTitle = titles.get(i).getText();
        return actualTitle;
    }


    public String getSeacrhWord() {
        return Hooks.driver.findElement(By.cssSelector("input[class=\"search-text\"]")).getAttribute("value");
    }

    public WebElement getProductItem() {

        return Hooks.driver.findElement(By.cssSelector("div[class=\"product-item\"]"));
    }

    public String getSkuActualValue() {

        return Hooks.driver.findElement(By.cssSelector("div[class=\"sku\"] span[class=\"value\"]")).getText();

    }


    public WebElement getCategoryele(String e) {
        return Hooks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/" + e.trim().toLowerCase(Locale.ROOT) + "\"]"));
    }

    public void hoverOnCategory(String Category) {

        WebElement category = getCategoryele(Category);
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(category).perform();
    }

    public List<WebElement> checkComputerSubCategorylist() {

        List<WebElement> subCategory
                = Hooks.driver.findElements(By.xpath("(//ul[@class=\"top-menu notmobile\"]//ul[@class=\"sublist first-level\"])[1]//li"));

        return subCategory;
    }

    public boolean checkIfContainsSubCategory() {
        boolean hasSubCategories = false;
        List<WebElement> subCat = checkComputerSubCategorylist();
        if (subCat.size() > 0) {
            hasSubCategories = true;
        }
        return hasSubCategories;
    }

    public void clickonSubCategory(String subcat) {

        if (checkIfContainsSubCategory() == true) {


            WebElement subCateg = Hooks.driver.findElement
                    (By.xpath("(//ul[@class=\"top-menu notmobile\"]//ul[@class=\"sublist first-level\"])[1]//a[@href=\"/" + subcat.trim().toLowerCase(Locale.ROOT) + "\"]"));
            Actions action = new Actions(Hooks.driver);
            action.moveToElement(subCateg).perform();
            subCateg.click();

        } else {
            getCategoryele("Computers").click();

        }

    }

    public String getSubCategURL() {

        String currentUrl = getcurrentUrl();
        return currentUrl;
    }


    public List<WebElement> getSliders() {
       List<WebElement> Sliders= Hooks.driver.findElements(By.cssSelector("a[class=\"nivo-imageLink\"]"));

       return Sliders;
    }

    public  WebElement getFirstSlider(){
        WebElement firstSlider= getSliders().get(0);
        return  firstSlider;
    }

    public  WebElement getSecondSlider(){
        WebElement firstSlider= getSliders().get(1);
        return  firstSlider;
    }

    public WebElement getFbIcon(){

        WebElement fb= Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]"));
        return fb;
    }

    public WebElement getTwitterEle(){
        WebElement twitter= Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]"));
        return twitter;
    }

    public WebElement getRssEle(){
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]"));
    }

    public WebElement getYoutubeele(){
        return  Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]"));
    }

    public void navigateToWindow(){
        tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Hooks.driver.switchTo().window(tabs.get(1));
    }

    public void closeWindow(){
      Hooks.driver.close();
      Hooks.driver.switchTo().window(tabs.get(0));

    }

    public WebElement getWishBtn(){
        return Hooks.driver.findElement(By.xpath("(//button[@title=\"Add to wishlist\"])[3]"));
    }

    public WebElement getSuccessMsg(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }
    public String getmsgColor(){
    String color= Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]")).getCssValue("background-color");
      return   Color.fromString(color).asHex();
    }

    public WebElement getWishlistBtn(){
        return  Hooks.driver.findElement(By.cssSelector("div[class=\"header-links\"] a[href=\"/wishlist\"]"));

    }

    public String getQtValue(){
        return Hooks.driver.findElement(By.xpath("//td[@class=\"quantity\"]//input")).getAttribute("value");
    }

}
