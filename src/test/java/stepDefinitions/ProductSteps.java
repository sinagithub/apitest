package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.models.response.ProductDetail.Data;
import apiEngine.models.response.ProductDetail.Product;
import apiEngine.models.response.ProductDetail.ProductResponse;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

@SuppressWarnings("unchecked")
public class ProductSteps extends BaseSteps {

    public ProductSteps(TestContext testContext) {
        super(testContext);
    }


    @Then("I validate product name is valid on product detail")
    public void validateProductNameIsValid() {
        Data productData = (Data) getScenarioContext().getContext(Context.PRODUCT_DETAIL_DATA);
        assertNotNull(productData.getName(), "Product name must not null");
    }

    @Then("I validate product desc is valid on product detail")
    public void validateDescIsValid() {
        Data productData = (Data) getScenarioContext().getContext(Context.PRODUCT_DETAIL_DATA);
        assertNotNull(productData.getDescription(), "Product desc must not null");
    }

    @Then("I validate product Badge is valid on product detail")
    public void validateProductBadgeIsValid() {
        Data productData = (Data) getScenarioContext().getContext(Context.PRODUCT_DETAIL_DATA);
        assertNotNull(productData.getBadgeType(), "Badge type must not null");
    }

    @Then("I validate product unit mass is valid on product detail")
    public void validateProductUnitMassIsValid() {
        Data productData = (Data) getScenarioContext().getContext(Context.PRODUCT_DETAIL_DATA);
        assertNotNull(productData.getUnitMass());
    }

    @Then("I validate image urls is valid on product detail")
    public void validateImageUrls() {
        Data productData = (Data) getScenarioContext().getContext(Context.PRODUCT_DETAIL_DATA);

        for (String url : productData.getImageUrl()) {
            Response response = getCarsiProductClient().getImageUrlResponse(url);
            assertTrue(response.statusCode() == 200, "Image status should be 200 !");
        }
    }

    @Then("I validate product price is valid on product detail")
    public void validateProductPrice() {
        Data productData = (Data) getScenarioContext().getContext(Context.PRODUCT_DETAIL_DATA);
        assertNotNull(productData.getPrice(), "Product price must not null");
    }

    @Then("I validate product is {string} on product detail")
    public void validateProductStatus(String isActive) {
        Data productData = (Data) getScenarioContext().getContext(Context.PRODUCT_DETAIL_DATA);
        boolean selectType = isActive.equalsIgnoreCase("true");
        assertTrue(productData.getIsActive() == selectType, "Product should be " + isActive);
    }

    @Then("I can check product favorite status {string}")
    public void i_can_check_product_favorite_status(String favoriteStatus) {
        IRestResponse<ProductResponse> selectedProductResponse =
                (IRestResponse<ProductResponse>) getScenarioContext().getContext(Context.PRODUCT_DETAIL_RESPONSE);

        if (favoriteStatus.equalsIgnoreCase("True")) {
            assertTrue(selectedProductResponse.getBody().getData().getFavorite(),"Favorite status should be true");
        }
        else {
            assertTrue(!selectedProductResponse.getBody().getData().getFavorite(),"Favorite status should be false");
        }
    }
}
