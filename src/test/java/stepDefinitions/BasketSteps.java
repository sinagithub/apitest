package stepDefinitions;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.models.requests.Basket.AddProductWithoutCampaignToBasketReq;
import apiEngine.models.response.Address;
import apiEngine.models.response.Basket.*;
import apiEngine.models.response.CarsiVendor;
import apiEngine.models.response.DeleteBasketResponse;
import apiEngine.models.response.ProductDetail.Option;
import apiEngine.models.response.ProductDetail.ProductResponse;
import apiEngine.models.response.Vendor.Product;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.awt.image.PackedColorModel;
import java.util.List;

@SuppressWarnings("unchecked")
public class BasketSteps extends BaseSteps {

    public BasketSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("I get unique basket id")
    public void user_get_unique_basket_id() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        String addressId = address.getAddressId();

        IRestResponse<BasketIdResponse> basketIdResponse = getCarsiBasketClient().getBasketId(addressId);
        String basketId = basketIdResponse.getBody().getData().getBasketId();

        getScenarioContext().setContext(Context.BASKET_ID, basketId);
    }

    @Then("I check basket id is same than old basket id")
    public void i_can_get_basket_id_same_old_basket_id() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        String addressId = address.getAddressId();

        String oldBasketId = (String) getScenarioContext().getContext(Context.BASKET_ID);

        IRestResponse<BasketIdResponse> basketIdResponse = getCarsiBasketClient().getBasketId(addressId);
        String newBasketId = basketIdResponse.getBody().getData().getBasketId();

        assertTrue(newBasketId.equals(oldBasketId), "New basket id and old basket id should be equal");

    }

    @Then("I can get new basket id")
    public void i_can_get_new_basket_id() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        String addressId = address.getAddressId();
        String oldBasketId = (String) getScenarioContext().getContext(Context.BASKET_ID);


        IRestResponse<BasketIdResponse> basketIdResponse = getCarsiBasketClient().getBasketId(addressId);
        String basketId = basketIdResponse.getBody().getData().getBasketId();
        assertFalse(oldBasketId.equals(basketId));

        getScenarioContext().setContext(Context.BASKET_ID, basketId);

    }

    private List<Option> getOptionIfHasOptionFromProductDetail() {
        String basketId = (String) getScenarioContext().getContext(Context.BASKET_ID);
        Product product = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);

        String vendorId = selectedVendor.getId();
        String productId = product.getId();
        List<Option> options = null;

        if (product.getHasOptions()) {
            RestResponse<ProductResponse> productResponse =
                    (RestResponse<ProductResponse>) getCarsiProductClient().getProduct(productId, vendorId, basketId);
            options = productResponse.getBody().getData().getOptions();
        }
        return options;
    }

    private String getProductDescFromDetail() {
        String basketId = (String) getScenarioContext().getContext(Context.BASKET_ID);
        Product product = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);

        String vendorId = selectedVendor.getId();
        String productId = product.getId();

        RestResponse<ProductResponse> productResponse =
                (RestResponse<ProductResponse>) getCarsiProductClient().getProduct(productId, vendorId, basketId);

        return productResponse.getBody().getData().getDescription();
    }

    @Then("I can add the selected product to basket quantity is {int}")
    public void i_can_add_the_selected_product_to_basket(int quantity) {
        String basketId = (String) getScenarioContext().getContext(Context.BASKET_ID);
        Product product = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String vendorId = selectedVendor.getId();
        String productId = product.getId();
        List<Option> options = getOptionIfHasOptionFromProductDetail();

        AddProductWithoutCampaignToBasketReq addProductWithoutCampaignToBasketReq =
                new AddProductWithoutCampaignToBasketReq(productId,
                        null,
                        quantity,
                        null,
                        null,
                        null,
                        vendorId, options);
        IRestResponse<AddProductToBasketResponse> addBasketResponse = getCarsiBasketClient().addProduct(basketId,
                addProductWithoutCampaignToBasketReq);
        getScenarioContext().setContext(Context.ADD_BASKET_RESPONSE, addBasketResponse);
    }

    @Then("I check added product exists on add basket response")
    public void i_check_added_product_exists_in_basket() {
        IRestResponse<AddProductToBasketResponse> addProductResponse =
                (IRestResponse<AddProductToBasketResponse>) getScenarioContext().getContext(Context.ADD_BASKET_RESPONSE);
        List<Line> lineList = addProductResponse.getBody().getData().getLightBasket().getLines();
        Product product = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        String productId = product.getId();

        for (Line line : lineList) {
            if (line.getProductId().equalsIgnoreCase(productId)) {
                return;
            }
        }
        Assert.fail("Selected Product id not exist on the basket");
    }

    @Then("I check added vendorId on the basket on add basket response")
    public void i_check_added_vendor_id_on_the_basket() {
        IRestResponse<AddProductToBasketResponse> addProductResponse =
                (IRestResponse<AddProductToBasketResponse>) getScenarioContext().getContext(Context.ADD_BASKET_RESPONSE);
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String addedVendorId = addProductResponse.getBody().getData().getLightBasket().getVendorId();
        assertEqual("Added vendor id should be valid on the basket ", selectedVendor.getId(), addedVendorId);

    }

    @Then("I check TotalLinesItemCount is {int} on add basket response")
    public void i_check_total_lines_item_count_is(Integer lineSize) {
        IRestResponse<AddProductToBasketResponse> addProductResponse =
                (IRestResponse<AddProductToBasketResponse>) getScenarioContext().getContext(Context.ADD_BASKET_RESPONSE);
        int actualLineSize = addProductResponse.getBody().getData().getLightBasket().getLines().size();
        assertTrue(lineSize == actualLineSize,
                "Basket line item size should be " + lineSize + " Not :" + actualLineSize);
    }

    @When("I delete basket")
    public void i_delete_basket() {
        String basketId = (String) getScenarioContext().getContext(Context.BASKET_ID);
        IRestResponse<DeleteBasketResponse> deleteBasketResponse = getCarsiBasketClient().deleteBasket(basketId);
        Boolean deleteBasketStatus = deleteBasketResponse.getBody().getData();
        assertTrue(deleteBasketStatus, "Delete basket status should be true");
    }

    @When("I get the basket")
    public void i_get_the_basket() {
        String basketId = (String) getScenarioContext().getContext(Context.BASKET_ID);
        IRestResponse<BasketResponse> getBasketResponse = getCarsiBasketClient().getBasket(basketId);
        getScenarioContext().setContext(Context.BASKET_RESPONSE, getBasketResponse);
    }

    private BasketLine getLineInfo(Product product) {
        IRestResponse<BasketResponse> basketResponse =
                (IRestResponse<BasketResponse>) getScenarioContext().getContext(Context.BASKET_RESPONSE);
        List<BasketLine> lineList = basketResponse.getBody().getData().getLines();
        String productId = product.getId();
        int index = -1;
        for (BasketLine line : lineList) {
            if (line.getId().equalsIgnoreCase(productId)) {
                index = lineList.indexOf(line);
            }
        }
        return lineList.get(index);
    }

    @Then("I can check product exists in basket")
    public void i_can_check_product_exists_in_basket() {
        Product product = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        BasketLine productLine = getLineInfo(product);
        String productName = product.getName();
        assertTrue(productLine.getProductName().equalsIgnoreCase(productName), "Product should be exist on " +
                "basket");
    }

    @Then("I can check ProductDescription is valid on basket lines")
    public void i_can_check_product_description_is_valid_on_basket_lines() {
        Product product = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        BasketLine productLine = getLineInfo(product);
        String expectedProductDesc = getProductDescFromDetail();
        String actualProductDesc = productLine.getProductDescription();
        assertEqual("Basket line product desc should equal with Product detail desc ", expectedProductDesc,
                actualProductDesc);
    }

    @Then("I can check ProductName is valid on basket lines")
    public void i_can_check_product_name_is_valid_on_basket_lines() {
        Product product = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        BasketLine productLine = getLineInfo(product);
        assertEqual("Added product name and basket line product name  should be equal",
                productLine.getProductName(), product.getName());
    }

    private double getSelectedProductPrice() {
        Product product = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        return product.getPrice();
    }

    private double getSelectedProductListPrice() {
        Product product = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        return product.getDiscountedPrice();
    }

    @Then("I can check ListPrice is valid on basket lines")
    public void i_can_check_list_price_is_valid_on_basket_lines() {


    }

    @Then("I can check DiscountedPrice is valid on basket lines")
    public void i_can_check_discounted_price_is_valid_on_basket_lines() {
        Product product = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        BasketLine productLine = getLineInfo(product);
        double actualPrice = productLine.getDiscountedPrice();
        double discountedPrice = getSelectedProductListPrice();
        assertTrue(discountedPrice == actualPrice, "Product detail discount price and basket line discount price " +
                "should be equal");
    }

    @Then("I can check Quantity is {int} on basket lines")
    public void i_can_check_quantity_is_on_basket_lines(Integer quantity) {
        Product product = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        BasketLine productLine = getLineInfo(product);
        int actualQuantity = productLine.getQuantity();
        assertTrue(quantity == actualQuantity,
                "Quantity should be " + quantity + " not : " + actualQuantity);

    }

    @Then("I check added product {string} error message and status is {int}")
    public void i_check_added_product_error_message_and_status_is(String expectedMessage, Integer expectedStatus) {
        IRestResponse<AddProductToBasketResponse> addProductResponse =
                (IRestResponse<AddProductToBasketResponse>) getScenarioContext().getContext(Context.ADD_BASKET_RESPONSE);

        int actualStatusCode = addProductResponse.getResponse().getStatusCode();
        String actualErrorMessage = addProductResponse.getBody().getInfoList().get(0).getMessage();

        assertEqual("Add basket should give Vendor not matched in basket error", actualErrorMessage, expectedMessage);
        assertTrue(actualStatusCode == expectedStatus, "Add basket Status code should be " + expectedStatus);

    }

}
