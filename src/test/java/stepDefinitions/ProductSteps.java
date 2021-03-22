package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.models.response.ProductDetail.Product;
import apiEngine.models.response.ProductDetail.ProductDetailResponse;
import clients.carsi.CarsiProductClient;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps extends BaseSteps {

    public ProductSteps(TestContext testContext) {
        super(testContext);
    }

    @When("Product list available")
    public void product_list_available() {
        getScenarioContext().setContext(Context.PRODUCT_LIST, "buraya vendor kesinlesınce bilgi eklenecek");
    }

    @Then("I select a random product")
    public void i_select_a_random_product() {
        String productId = "1";

    }


    @Then("I navigate selected product")
    public void i_navigate_selected_product() {
        String productId = "1";
        CarsiProductClient mockProduct = new CarsiProductClient("http://localhost:3464");
        IRestResponse<ProductDetailResponse> productDetailResponse = mockProduct.getProduct(productId);
        Product product = productDetailResponse.getBody().getData();
        getScenarioContext().setContext(Context.PRODUCT, product);


    }

    @Then("Validate product information is valid")
    public void validate_product_information_is_valid() {
        Product product = (Product) getScenarioContext().getContext(Context.PRODUCT);
        assertNotEmpty(product.getName());
        assertNotEmpty(product.getDescription());
        assertNotEmpty(product.getImageUrl());
        assertNotEmpty(product.getId());
        assertNotEmpty(product.getPrice());
        assertNotEmpty(product.getMaximumSaleAmount());
        assertNotEmpty(product.getDiscountedPrice());
        assertNotEmpty(product.getStock());
        assertNotEmpty(product.getUnitMass());
    }


}
