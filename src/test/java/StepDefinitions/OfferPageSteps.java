package StepDefinitions;

import Utils.TestContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;

import java.util.Iterator;
import java.util.Set;

public class OfferPageSteps {
    public String offerPageProductName;
    TestContextSetUp testContextSetUp;
    PageObjectManager pageObjectManager;

    public OfferPageSteps(TestContextSetUp testContextSetUp){
        this.testContextSetUp = testContextSetUp;
    }

    @Then("^User searched for same shortname (.+) in offers page$")
    public void user_searched_for_same_shortname_in_offers_page(String name) throws InterruptedException {
        switchToOffersPage();
        OffersPage offer = testContextSetUp.pageObjectManager.getOffersPage();
        offer.search(name);
        Thread.sleep(2000);
        offerPageProductName = offer.getProductName();
    }

    public void switchToOffersPage(){
        LandingPage landingPage = testContextSetUp.pageObjectManager.getLandingPage();
        landingPage.topDealsClick();
        testContextSetUp.genericUtils.switchWindowToChild();
    }

    @And("Validate offers page product name matches with product in Home page")
    public void validateOffersPageProductNameMatchesWithProductInHomePage() {
        Assert.assertEquals(offerPageProductName,testContextSetUp.homeText);
    }
}