package StepDefinitions;

import Utils.TestContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckOutPage;

public class CheckOutPageSteps {
    TestContextSetUp testContextSetUp;
    public CheckOutPage checkOutPage;


    public CheckOutPageSteps(TestContextSetUp testContextSetUp){
        this.testContextSetUp = testContextSetUp;
        this.checkOutPage = testContextSetUp.pageObjectManager.getCheckOutPage();
    }

    @Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_Checkout(String name) {
            checkOutPage.checkOutItems();
    }

    @And("^Verify user has ability to enter promo code and place the order$")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order(){
        Assert.assertTrue(checkOutPage.verifyPromoButton());
        Assert.assertTrue(checkOutPage.verifyPlaceOrderButton());
    }
}
