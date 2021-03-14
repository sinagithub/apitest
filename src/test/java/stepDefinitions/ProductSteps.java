package stepDefinitions;


import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps extends BaseSteps {

    public ProductSteps(TestContext testContext) {
        super(testContext);
    }

    @When("I navigate a product")
    public void i_navigate_a_product() {
        System.out.println("Select product on vendor products and set navigated product");
    }

    @Then("I should get product base information")
    public void i_should_get_product_base_information() {
        System.out.println("Get product info");
    }

    @When("I add favorite the product")
    public void i_add_favorite_the_product() {
        System.out.println("Add favorite");
    }

    @Then("I should see product added  message")
    public void i_should_see_product_added_message() {
        System.out.println("Validate add favorites success message ");

    }

}
