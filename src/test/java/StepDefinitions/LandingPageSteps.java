package StepDefinitions;

import Utils.TestContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;

public class LandingPageSteps {
    TestContextSetUp testContextSetUp;
    PageObjectManager pageObjectManager;
    public LandingPage landingPage;

    public LandingPageSteps(TestContextSetUp testContextSetUp){
        this.testContextSetUp = testContextSetUp;
        this.landingPage = testContextSetUp.pageObjectManager.getLandingPage();
    }

    @Given("^User is on GreenCart Landing page$")
    public void user_is_on_green_cart_landing_page() {
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
    }
    @When("^User searched with search name (.+) and extracted actual name of product$")
    public void user_searched_with_search_name_and_extracted_actual_name_of_product(String string) throws InterruptedException {
        landingPage.searchText(string);
        Thread.sleep(2000);
        testContextSetUp.homeText = landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetUp.homeText + " is extracted from Home page");
    }

    @And("Added {string} items of the selected product to cart")
    public void added_items_product(String quantity){
        landingPage.increment(Integer.parseInt(quantity));
        landingPage.addToCart();
    }
}
