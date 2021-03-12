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
        CarsiVendors vendor = (CarsiVendors) getScenarioContext().getContext(Context.VENDOR_BASIC_INFO);
        String catalogName = (String) getScenarioContext().getContext(Context.SELECTED_CATALOG_NAME);

        CarsiVendorClient mockVendorClient = new CarsiVendorClient(BaseUrls.mockBaseUrl());
        IRestResponse<ProductsResponse> vendorProductResponse = mockVendorClient.getProducts(catalogName,
                vendor.getVendorId());
        List<Product> productList =
                vendorProductResponse.getBody().getData().getCategories().get(0).getSubCategories().get(0).getProducts();
        getScenarioContext().setContext(Context.PRODUCT_LIST, productList);
    }


}
