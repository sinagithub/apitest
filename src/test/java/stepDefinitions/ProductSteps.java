package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.models.response.CarsiVendor;
import apiEngine.models.response.ProductDetail.Data;
import apiEngine.models.response.ProductDetail.ProductResponse;
import apiEngine.models.response.Vendor.Product;
import apiEngine.models.response.Vendor.VendorProductsResponse;
import apiEngine.models.response.Vendor.VendorResponse;
import clients.carsi.CarsiProductClient;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import java.util.List;
import java.util.Random;

@SuppressWarnings("unchecked")
public class ProductSteps extends BaseSteps {

    public ProductSteps(TestContext testContext) {
        super(testContext);
    }


    @Then("I select a random product")
    public void i_select_a_random_product() {
        IRestResponse<VendorProductsResponse> vendorCategoryProductResponse =
                (IRestResponse<VendorProductsResponse>) getScenarioContext()
                        .getContext(Context.VENDOR_CATEGORY_PRODUCTS_RES);
        List<Product> products = vendorCategoryProductResponse.getBody().getData().getProducts();

        Random random = new Random();
        int index = random.nextInt(products.size() - 1);
        Product product = vendorCategoryProductResponse.getBody().getData().getProducts().get(index);
        getScenarioContext().setContext(Context.SELECTED_PRODUCT, product);
    }

    @Then("I check product list not empty")
    public void i_check_productList_not_empty() {
        IRestResponse<VendorProductsResponse> vendorCategoryProductResponse =
                (IRestResponse<VendorProductsResponse>) getScenarioContext()
                        .getContext(Context.VENDOR_CATEGORY_PRODUCTS_RES);
        List<Product> products = vendorCategoryProductResponse.getBody().getData().getProducts();
        assertTrue(products.size() > 0, "Product list should not empty");
    }


    @Then("I navigate selected product")
    public void i_navigate_selected_product() {
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        Product selectedProduct = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);

        String basketId = (String) getScenarioContext().getContext(Context.BASKET_ID);
        String productId = selectedProduct.getId();
        String vendorId = selectedVendor.getId();

        IRestResponse<ProductResponse> productDetailResponse = getCarsiProductClient().getProduct(productId,
                vendorId, basketId);

        Data productDetailProductResponseData = productDetailResponse.getBody().getData();
        getScenarioContext().setContext(Context.PRODUCT_DATA, productDetailProductResponseData);
    }

    @Then("I validate product name is valid")
    public void validateProductNameAndDesc() {
        Data productData = (Data) getScenarioContext().getContext(Context.PRODUCT_DATA);
        assertNotEmpty(productData.getName());
    }

    @Then("I validate product desc is valid")
    public void validateDescAndDesc() {
        Data productData = (Data) getScenarioContext().getContext(Context.PRODUCT_DATA);
        assertNotEmpty(productData.getName());
    }

    @Then("I validate product Badge and unit mass is valid")
    public void validateProductBadgeAndUnitMass() {
        Data productData = (Data) getScenarioContext().getContext(Context.PRODUCT_DATA);
        assertNotEmpty(productData.getBadgeType());
    }

    @Then("I validate image urls is valid")
    public void validateBannerUrls() {
        Data productData = (Data) getScenarioContext().getContext(Context.PRODUCT_DATA);

        for (String url : productData.getImageUrl()) {
            Response response = getCarsiProductClient().getImageUrlResponse(url);
            assertTrue(response.statusCode() == 220, "Image status should be 200 !");
        }
    }

    @Then("I validate product price is valid")
    public void validateProductPrice() {
        Data productData = (Data) getScenarioContext().getContext(Context.PRODUCT_DATA);
        assertNotEmpty(productData.getPrice());
    }

    @Then("I validate product is {string}")
    public void validateProductPrice(String isActive) {
        Data productData = (Data) getScenarioContext().getContext(Context.PRODUCT_DATA);
        boolean selectType = isActive.equalsIgnoreCase("true");
        assertTrue(productData.getIsActive() == selectType, "Product should be " + isActive);
    }

}
