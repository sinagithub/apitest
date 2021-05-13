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
import apiEngine.models.response.Vendor.VendorResponse;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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
        List<Product> userBasketProductList = new ArrayList<>();
        getScenarioContext().setContext(Context.ADDED_PRODUCT_LIST, userBasketProductList);
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

    private void saveAddedProductToList(Product product) {
        List<Product> productList = (List<Product>) getScenarioContext().getContext(Context.ADDED_PRODUCT_LIST);
        productList.add(product);
        getScenarioContext().setContext(Context.ADDED_PRODUCT_LIST, productList);
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

        if (addBasketResponse.isSuccessful()) {
            saveAddedProductToList(product);
        }
        getScenarioContext().setContext(Context.ADD_BASKET_RESPONSE, addBasketResponse);
    }

    private double getSelectedVendorDeliveryFee() {
        IRestResponse<VendorResponse> vendorResponse =
                (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
        String deliveryFeeInfo = vendorResponse.getBody().getData().getDeliveryFeeInfo()
                .replace(",", ".")
                .replace(" TL", "");
        return Double.parseDouble(deliveryFeeInfo);
    }

    private double getAddedProductsTotalPrice() {
        List<Product> addedProductList = (List<Product>) getScenarioContext().getContext(Context.ADDED_PRODUCT_LIST);
        double subTotalPrice = 0.0;
        for (Product product : addedProductList) {
            subTotalPrice += product.getPrice();
        }
        return subTotalPrice;
    }

    private double getExpectedBasketTotalPrice() {
        BigDecimal bd = BigDecimal.valueOf(getAddedProductsTotalPrice() + getSelectedVendorDeliveryFee()).setScale(2,
                RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Then("I can check basket subTotal is valid on basket")
    public void i_can_check_basket_sub_total_is_valid_on_basket() {
        IRestResponse<BasketResponse> basketResponse =
                (IRestResponse<BasketResponse>) getScenarioContext().getContext(Context.BASKET_RESPONSE);
        double actualSubTotal = basketResponse.getBody().getData().getBasketInfo().getSubTotal();
        double expectedSubTotal = getAddedProductsTotalPrice();
        assertTrue(actualSubTotal == expectedSubTotal,
                "Product sub total should be " + expectedSubTotal + " not " + actualSubTotal);
    }

    @Then("I can check basket total is valid")
    public void i_can_check_basket_total_is_valid() {
        IRestResponse<BasketResponse> basketResponse =
                (IRestResponse<BasketResponse>) getScenarioContext().getContext(Context.BASKET_RESPONSE);

        double expectedPrice = getExpectedBasketTotalPrice();
        double actualTotalPrice = basketResponse.getBody().getData().getBasketInfo().getTotal();

        assertTrue(actualTotalPrice == expectedPrice,
                "Basket total price should be " + expectedPrice + " not " + actualTotalPrice);

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
        assertTrue(deleteBasketResponse.isSuccessful(), "Delete basket status should be true");
    }

    @When("I get the basket")
    public void i_get_the_basket() {
        String basketId = (String) getScenarioContext().getContext(Context.BASKET_ID);
        IRestResponse<BasketResponse> getBasketResponse = getCarsiBasketClient().getBasket(basketId);
        getScenarioContext().setContext(Context.BASKET_RESPONSE, getBasketResponse);
    }

    private BasketLine getBasketLineInfo(Product product) {
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

    private Line getBasketLiteLineInfo(Product product) {
        IRestResponse<LiteBasketResponse> liteBasketResponse =
                (IRestResponse<LiteBasketResponse>) getScenarioContext().getContext(Context.LITE_BASKET_RESPONSE);
        List<Line> lineList = liteBasketResponse.getBody().getData().getLines();
        String productId = product.getId();
        int index = -1;
        for (Line line : lineList) {
            if (line.getId().equalsIgnoreCase(productId)) {
                index = lineList.indexOf(line);
            }
        }
        return lineList.get(index);
    }

    @Then("I can check product exists in basket")
    public void i_can_check_product_exists_in_basket() {
        Product product = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        BasketLine productLine = getBasketLineInfo(product);
        String productName = product.getName();
        assertTrue(productLine.getProductName().equalsIgnoreCase(productName), "Product should be exist on " +
                "basket");
    }

    @Then("I can check ProductDescription is valid on basket lines")
    public void i_can_check_product_description_is_valid_on_basket_lines() {
        Product product = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        BasketLine productLine = getBasketLineInfo(product);
        String expectedProductDesc = getProductDescFromDetail();
        String actualProductDesc = productLine.getProductDescription();
        assertEqual("Basket line product desc should equal with Product detail desc ", expectedProductDesc,
                actualProductDesc);
    }

    @Then("I can check ProductName is valid on basket lines")
    public void i_can_check_product_name_is_valid_on_basket_lines() {
        Product product = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        BasketLine productLine = getBasketLineInfo(product);
        assertEqual("Added product name and basket line product name  should be equal",
                productLine.getProductName(), product.getName());

    }

    @Then("I can check ListPrice is valid on basket lines")
    public void i_can_check_list_price_is_valid_on_basket_lines() {
        List<Product> addedProductList = (List<Product>) getScenarioContext().getContext(Context.ADDED_PRODUCT_LIST);
        for (Product product : addedProductList) {
            BasketLine productLine = getBasketLineInfo(product);
            double actualPrice = productLine.getListPrice();
            double expectedListPrice = product.getPrice();
            assertTrue(expectedListPrice == actualPrice, "Product detail List price and basket line discount price " +
                    "should be equal");
        }

    }

    @Then("I can check DiscountedPrice is valid on basket lines")
    public void i_can_check_discounted_price_is_valid_on_basket_lines() {
        List<Product> addedProductList = (List<Product>) getScenarioContext().getContext(Context.ADDED_PRODUCT_LIST);
        for (Product product : addedProductList) {
            BasketLine productLine = getBasketLineInfo(product);
            double actualPrice = productLine.getDiscountedPrice();
            double discountedPrice = product.getDiscountedPrice();
            assertTrue(discountedPrice == actualPrice, "Product detail discount price and basket line discount price " +
                    "should be equal");
        }

    }

    @Then("I can check Quantity is {int} on basket lines")
    public void i_can_check_quantity_is_on_basket_lines(Integer quantity) {
        Product product = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        BasketLine productLine = getBasketLineInfo(product);
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

    @When("I get basket line counts with lite basket")
    public void i_get_basket_line_counts_with_lite_basket() {
        String basketId = (String) getScenarioContext().getContext(Context.BASKET_ID);
        IRestResponse<LiteBasketResponse> liteBasketResponse = getCarsiBasketClient().getLiteBasket(basketId);
        getScenarioContext().setContext(Context.LITE_BASKET_RESPONSE, liteBasketResponse);
    }

    @Then("I can see the product quantity is {int} product index {int} in lite basket")
    public void i_can_see_the_product_quantity_is_product_index(Integer expectedQuantity, Integer productIndex) {
        IRestResponse<LiteBasketResponse> liteBasketResponse =
                (IRestResponse<LiteBasketResponse>) getScenarioContext().getContext(Context.LITE_BASKET_RESPONSE);
        Line line = liteBasketResponse.getBody().getData().getLines().get(productIndex);
        int actualQuantity = line.getQuantity();
        assertTrue(expectedQuantity == actualQuantity, "Product quantity should "
                + expectedQuantity + " not " + actualQuantity);
    }

    @Then("I check TotalLinesItemCount is {int} on lite basket response")
    public void i_check_total_lines_item_count_is_on_lite_basket(Integer lineSize) {
        IRestResponse<LiteBasketResponse> liteBasketResponse =
                (IRestResponse<LiteBasketResponse>) getScenarioContext().getContext(Context.LITE_BASKET_RESPONSE);
        int actualLineSize = liteBasketResponse.getBody().getData().getTotalLinesItemCount();
        assertTrue(lineSize == actualLineSize,
                "Lite Basket line item size should be " + lineSize + " Not :" + actualLineSize);
    }

    @Then("I check line products is valid on lite basket response")
    public void i_check_line_products_is_valid_on_lite_basket_response() {
        List<Product> addedProductList = (List<Product>) getScenarioContext().getContext(Context.ADDED_PRODUCT_LIST);
        for (Product product : addedProductList) {
            Line productLine = getBasketLiteLineInfo(product);
            String productId = productLine.getProductId();
            String expectedLineProductId = product.getId();
            assertTrue(expectedLineProductId.contains(productId), "Product id should be " + expectedLineProductId +
                    " not " + productId);
        }
    }

    @Then("I can validate basket is empty")
    public void i_can_validate_basket_is_empty() {
        IRestResponse<BasketResponse> basketResponse =
                (IRestResponse<BasketResponse>) getScenarioContext().getContext(Context.BASKET_RESPONSE);
        List<BasketLine> basketLines = basketResponse.getBody().getData().getLines();
        assertTrue(basketLines.isEmpty(), "Basket lines should be empty");
    }

    @When("I get alternate product options")
    public void i_get_alternate_product_options() {
        String basketId = (String) getScenarioContext().getContext(Context.BASKET_ID);
        IRestResponse<AlternateProductResponse> alternateProductResponse =
                getCarsiBasketClient().getAlternateOptions(basketId);

        getScenarioContext().setContext(Context.ALTERNATE_PRODUCTS_RESPONSE, alternateProductResponse);
    }

    @Then("I can validate alternate product text {string} is exist and rank is {int} type is {int}")
    public void i_can_validate_alternate_product_text_is_exist_and_rank_is_type_is(String optionText,
                                                                                   Integer optionRank, Integer type) {
        IRestResponse<AlternateProductResponse> alternateProductResponse =
                (IRestResponse<AlternateProductResponse>) getScenarioContext().getContext(Context.ALTERNATE_PRODUCTS_RESPONSE);
       AlternateOption option =  alternateProductResponse.getBody().getData().getAlternateOptions().get(optionRank -1);
       int actualOptionRank = option.getRank();
       String actualOptionText = option.getText();
       int actualType = option.getTypeId();

       assertTrue(actualOptionRank == optionRank, "Option rank should be " + optionRank + " not " + actualOptionRank );
       assertTrue(actualType == type, "Option type should be " + type + " not " + actualType );
       assertEqual("Option text should be " + optionText + " not " + actualOptionText,actualOptionText,optionText);
    }

}
