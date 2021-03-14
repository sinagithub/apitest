package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.models.response.*;
import clients.BaseUrls;
import clients.carsi.CarsiVendorClient;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;

import java.util.List;

public class VendorSteps extends BaseSteps {

    public VendorSteps(TestContext testContext) {
        super(testContext);
    }


    @Then("I list the products")
    public void i_list_the_products() {
        System.out.println("List products");
    }


}
