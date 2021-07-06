package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.models.response.ProductDetail.Data;
import apiEngine.models.response.ProductDetail.Product;
import apiEngine.models.response.ProductDetail.ProductResponse;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import java.text.DecimalFormat;
import java.util.List;

@SuppressWarnings("unchecked")
public class ProductSteps extends BaseSteps {

    public ProductSteps(TestContext testContext) {
        super(testContext);
    }

    private Data getProductData() {
        return (Data) getScenarioContext().getContext(Context.PRODUCT_DETAIL_DATA);
    }


    @Then("I validate product name is valid on product detail")
    public void validateProductNameIsValid() {
        assertNotNull(getProductData().getName(), "Product name must not null");
    }

    @Then("I validate product desc is valid on product detail")
    public void validateDescIsValid() {
        assertNotNull(getProductData().getDescription(), "Product desc must not null");
    }

    @Then("I validate product Badge is valid on product detail")
    public void validateProductBadgeIsValid() {
        assertNotNull(getProductData().getBadgeType(), "Badge type must not null");
    }

    @Then("I validate product unit mass is valid on product detail")
    public void validateProductUnitMassIsValid() {
        assertNotNull(getProductData().getUnitMass());
    }

    @Then("I validate image urls is valid on product detail")
    public void validateImageUrls() {
        List<String> imageUrlList = getProductData().getImageUrl();
        assertTrue(!imageUrlList.isEmpty(), "Image url list can not be empty");
        for (String url : imageUrlList) {
            Response response = getCarsiProductClient().getImageUrlResponse(url);
            assertTrue(response.statusCode() == 200, "Image status should be 200 !");
        }
    }

    @Then("I validate product price is valid on product detail")
    public void validateProductPrice() {
        assertNotNull(getProductData().getPrice(), "Product price must not null");
    }

    @Then("I validate product is {string} on product detail")
    public void validateProductStatus(String isActive) {
        boolean selectType = isActive.equalsIgnoreCase("true");
        assertTrue(getProductData().getIsActive() == selectType, "Product should be " + isActive);
    }

    @Then("I can check product favorite status {string}")
    public void i_can_check_product_favorite_status(String favoriteStatus) {
        IRestResponse<ProductResponse> selectedProductResponse =
                (IRestResponse<ProductResponse>) getScenarioContext().getContext(Context.PRODUCT_DETAIL_RESPONSE);

        if (favoriteStatus.equalsIgnoreCase("True")) {
            assertTrue(selectedProductResponse.getBody().getData().getFavorite(), "Favorite status should be true");
        } else {
            assertTrue(!selectedProductResponse.getBody().getData().getFavorite(), "Favorite status should be false");
        }
    }

    @Then("I validate PriceText is valid on product detail")
    public void i_validate_price_text_is_valid_on_product_detail() {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        double price = getProductData().getPrice();
        String convertedPrice = formatter.format(price);


        String expectedPriceText = convertedPrice.replace(".",",") + " TL";
        String actualPriceText = getProductData().getPriceText();
        assertEqual("PriceText should be " + expectedPriceText, actualPriceText, expectedPriceText);
    }

}
