package stepDefinitions;


import apiEngine.Utils;
import apiEngine.models.requests.AuthorizationRequest;
import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class VendorSteps extends BaseSteps {

    public VendorSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("A list of Vendor are available")
    public void a_list_of_Vendor_are_available() {
        System.out.println("Vendor listing");
    }

    @When("I navigate a vendor")
    public void i_navigate_a_vendor() {
    }

    @Then("I should get Vendor information \\(product tree, category, sub category, vendor main info)")
    public void i_should_get_Vendor_information_product_tree_category_sub_category_vendor_main_info() {

    }


}
