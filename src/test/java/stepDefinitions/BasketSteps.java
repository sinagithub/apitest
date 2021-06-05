package stepDefinitions;

import apiEngine.GenerateFakeData;
import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.models.requests.Basket.AddProductWithoutCampaignToBasketReq;
import apiEngine.models.requests.Basket.Checkout.BasketCheckOutRequest;
import apiEngine.models.requests.Basket.Checkout.Donation;
import apiEngine.models.requests.Basket.Checkout.Payment;
import apiEngine.models.requests.Basket.Checkout.Tip;
import apiEngine.models.requests.Basket.DeleteProductRequest;
import apiEngine.models.response.*;
import apiEngine.models.response.Basket.*;
import apiEngine.models.response.Basket.Checkout.*;
import apiEngine.models.response.Basket.Checkout.PutCheckout.BasketPutResponse;
import apiEngine.models.response.Basket.Upsell.BasketUpsellResponse;
import apiEngine.models.response.Order.WriteOrderNoteResponse;
import apiEngine.models.response.ProductDetail.Option;
import apiEngine.models.response.ProductDetail.ProductResponse;
import apiEngine.models.response.Vendor.Product;
import apiEngine.models.response.Vendor.VendorData;
import apiEngine.models.response.Vendor.VendorResponse;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class BasketSteps extends BaseSteps {

    public BasketSteps(TestContext testContext) {
        super(testContext);
    }

    private String getBasketId() {
        return (String) getScenarioContext().getContext(Context.BASKET_ID);
    }

    private IRestResponse<BasketResponse> getBasketResponse() {
        return (IRestResponse<BasketResponse>) getScenarioContext().getContext(Context.BASKET_RESPONSE);
    }

    private apiEngine.models.response.Basket.BasketInfo getBasketInfo() {
        return getBasketResponse().getBody().getData().getBasketInfo();
    }

    private IRestResponse<AddProductToBasketResponse> getAddProductResponse() {
        return (IRestResponse<AddProductToBasketResponse>) getScenarioContext().getContext(Context.ADD_BASKET_RESPONSE);
    }

    private Product getSelectedProduct() {
        return (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
    }

    private IRestResponse<BasketPutResponse> getPutBasketCheckoutResponse() {
        return (IRestResponse<BasketPutResponse>) getScenarioContext().getContext(Context.PUT_BASKET_CHECKOUT_RESPONSE);
    }

    private IRestResponse<AlternateProductResponse> getAlternateProductResponse() {
        return (IRestResponse<AlternateProductResponse>) getScenarioContext().getContext(Context.ALTERNATE_PRODUCTS_RESPONSE);
    }

    private IRestResponse<BasketCheckoutResponse> getBasketCheckoutResponse() {
        return (IRestResponse<BasketCheckoutResponse>) getScenarioContext().getContext(Context.BASKET_CHECKOUT_RESPONSE);
    }

    private boolean getSelectedContactlessDeliveryStatus() {
        return (boolean) getScenarioContext().getContext(Context.CONTACTLESS_DELIVERY_SELECTION);
    }

    private Payment getSelectedPaymentId() {
        return (Payment) getScenarioContext().getContext(Context.PAYMENT_TYPE_SELECTION);
    }

    private Tip getSelectedTip() {
        return (Tip) getScenarioContext().getContext(Context.TIP_SELECTION);
    }

    private Donation getSelectedDonation() {
        return (Donation) getScenarioContext().getContext(Context.DONATION_SELECTION);
    }

    private TipInfo getTipInfoListOnBasketCheckout() {
        return getBasketCheckoutResponse().getBody().getData().getBasketCheckout().getTipInfo();
    }

    private IRestResponse<WriteOrderNoteResponse> writeOrderNote(String note) {
        return getCarsiOrderClient().writeOrderNote(note);
    }

    private List<SavedNote> getSavedNoteDataList() {
        return (List<SavedNote>) getScenarioContext().getContext(Context.ORDER_NOTE_LIST);
    }

    private CarsiVendor getSelectedVendor() {
        return (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
    }

    private VendorData getSelectedVendorDetailData() {
        return (VendorData) getScenarioContext().getContext(Context.SELECTED_VENDOR_DETAIL_DATA);
    }

    @Then("I get unique basket id")
    public void user_get_unique_basket_id() {
        BanabiAddress banabiAddress = (BanabiAddress) getScenarioContext().getContext(Context.ADDRESS);
        String addressId = banabiAddress.getAddressId();

        IRestResponse<BasketIdResponse> basketIdResponse = getCarsiBasketClient().getBasketId(addressId);
        String basketId = basketIdResponse.getBody().getData().getBasketId();

        getScenarioContext().setContext(Context.BASKET_ID, basketId);
        List<Product> userBasketProductList = new ArrayList<>();
        getScenarioContext().setContext(Context.ADDED_PRODUCT_LIST, userBasketProductList);
    }

    @Then("I check basket id is same than old basket id")
    public void i_can_get_basket_id_same_old_basket_id() {
        BanabiAddress banabiAddress = (BanabiAddress) getScenarioContext().getContext(Context.ADDRESS);
        String addressId = banabiAddress.getAddressId();

        String oldBasketId = getBasketId();

        IRestResponse<BasketIdResponse> basketIdResponse = getCarsiBasketClient().getBasketId(addressId);
        String newBasketId = basketIdResponse.getBody().getData().getBasketId();

        assertTrue(newBasketId.equals(oldBasketId), "New basket id and old basket id should be equal");

    }

    @Then("I can get new basket id")
    public void i_can_get_new_basket_id() {
        BanabiAddress banabiAddress = (BanabiAddress) getScenarioContext().getContext(Context.ADDRESS);
        String addressId = banabiAddress.getAddressId();
        String oldBasketId = getBasketId();


        IRestResponse<BasketIdResponse> basketIdResponse = getCarsiBasketClient().getBasketId(addressId);
        String basketId = basketIdResponse.getBody().getData().getBasketId();
        assertFalse(oldBasketId.equals(basketId));

        getScenarioContext().setContext(Context.BASKET_ID, basketId);

    }

    private List<Option> getOptionIfHasOptionFromProductDetail() {
        String basketId = getBasketId();
        Product product = getSelectedProduct();
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
        String basketId = getBasketId();
        Product product = getSelectedProduct();
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);

        String vendorId = selectedVendor.getId();
        String productId = product.getId();

        RestResponse<ProductResponse> productResponse =
                (RestResponse<ProductResponse>) getCarsiProductClient().getProduct(productId, vendorId, basketId);

        return productResponse.getBody().getData().getDescription();
    }

    private void saveAddedProductToList(Product product, int quantity) {
        List<Product> productList = (List<Product>) getScenarioContext().getContext(Context.ADDED_PRODUCT_LIST);
        for (int i = 0; i < quantity; i++) {
            productList.add(product);
        }

        getScenarioContext().setContext(Context.ADDED_PRODUCT_LIST, productList);
    }

    @Then("I can add the selected product to basket quantity is {int}")
    public void i_can_add_the_selected_product_to_basket(int quantity) {
        String basketId = getBasketId();
        Product product = getSelectedProduct();
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String vendorId = selectedVendor.getId();
        String productId = product.getId();
        List<Option> options = getOptionIfHasOptionFromProductDetail();
        AddProductWithoutCampaignToBasketReq addProductWithoutCampaignToBasketReq =
                new AddProductWithoutCampaignToBasketReq(productId,
                        productId,
                        quantity,
                        null,
                        null,
                        null,
                        vendorId, options);

        IRestResponse<AddProductToBasketResponse> addBasketResponse = getCarsiBasketClient().addProduct(basketId,
                addProductWithoutCampaignToBasketReq);

        if (addBasketResponse.isSuccessful()) {
            saveAddedProductToList(product, quantity);
        }
        getScenarioContext().setContext(Context.ADDED_PRODUCT_REQ, addProductWithoutCampaignToBasketReq);
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
                RoundingMode.UP);
        return bd.doubleValue();
    }

    @Then("I can check basket subTotal is valid on basket")
    public void i_can_check_basket_sub_total_is_valid_on_basket() {
        double actualSubTotal = getBasketResponse().getBody().getData().getBasketInfo().getSubTotal();
        BigDecimal bd = BigDecimal.valueOf(getAddedProductsTotalPrice()).setScale(2,
                RoundingMode.HALF_UP);

        double expectedSubTotal = bd.doubleValue();
        assertTrue(actualSubTotal == expectedSubTotal,
                "Product sub total should be " + expectedSubTotal + " not " + actualSubTotal);
    }

    @Then("I can check basket total is valid")
    public void i_can_check_basket_total_is_valid() {
        double expectedPrice = getExpectedBasketTotalPrice();
        double actualTotalPrice = getBasketResponse().getBody().getData().getBasketInfo().getTotal();
        assertTrue(actualTotalPrice == expectedPrice,
                "Basket total price should be " + expectedPrice + " not " + actualTotalPrice);

    }

    @Then("I check added product exists on add basket response")
    public void i_check_added_product_exists_in_basket() {
        List<Line> lineList = getAddProductResponse().getBody().getData().getLightBasket().getLines();
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
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String addedVendorId = getAddProductResponse().getBody().getData().getLightBasket().getVendorId();
        assertEqual("Added vendor id should be valid on the basket ", selectedVendor.getId(), addedVendorId);

    }

    @Then("I check TotalLinesItemCount is {int} on add basket response")
    public void i_check_total_lines_item_count_is(Integer lineSize) {
        int actualLineSize = getAddProductResponse().getBody().getData().getLightBasket().getLines().size();
        assertTrue(lineSize == actualLineSize,
                "Basket line item size should be " + lineSize + " Not :" + actualLineSize);
    }

    @When("I delete basket")
    public void i_delete_basket() {
        String basketId = getBasketId();
        IRestResponse<DeleteBasketResponse> deleteBasketResponse = getCarsiBasketClient().deleteBasket(basketId);
        assertTrue(deleteBasketResponse.isSuccessful(), "Delete basket status should be true");
    }

    @When("I get the basket")
    public void i_get_the_basket() {
        String basketId = getBasketId();
        IRestResponse<BasketResponse> getBasketResponse = getCarsiBasketClient().getBasket(basketId);
        getScenarioContext().setContext(Context.BASKET_RESPONSE, getBasketResponse);
    }

    private BasketLine getBasketLineInfo(Product product) {
        List<BasketLine> lineList = getBasketResponse().getBody().getData().getLines();
        String productId = product.getId();
        int index = -1;
        for (BasketLine line : lineList) {
            if (line.getProductId().equalsIgnoreCase(productId)) {
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
        Product product = getSelectedProduct();
        BasketLine productLine = getBasketLineInfo(product);
        String productName = product.getName();
        assertTrue(productLine.getProductName().equalsIgnoreCase(productName), "Product should be exist on " +
                "basket");
    }

    @Then("I can check ProductDescription is valid on basket lines")
    public void i_can_check_product_description_is_valid_on_basket_lines() {
        Product product = getSelectedProduct();
        BasketLine productLine = getBasketLineInfo(product);
        String expectedProductDesc = getProductDescFromDetail();
        String actualProductDesc = productLine.getProductDescription();
        assertEqual("Basket line product desc should equal with Product detail desc ", expectedProductDesc,
                actualProductDesc);
    }

    @Then("I can check ProductName is valid on basket lines")
    public void i_can_check_product_name_is_valid_on_basket_lines() {
        Product product = getSelectedProduct();
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

    @Then("I can check Product Quantity is {int} on basket lines")
    public void i_can_check_quantity_is_on_basket_lines(Integer quantity) {
        Product product = getSelectedProduct();
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
        String basketId = getBasketId();
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
        List<BasketLine> basketLines = getBasketResponse().getBody().getData().getLines();
        assertTrue(basketLines.isEmpty(), "Basket lines should be empty");
    }


    @Then("I can validate basket sub total is {double}")
    public void i_can_validate_basket_total_is(Double expectedTotalPrice) {
        double actualTotalPrice = getBasketResponse().getBody().getData().getBasketInfo().getSubTotal();
        assertTrue(actualTotalPrice == expectedTotalPrice, "Basket sub total price should be " + expectedTotalPrice +
                " Not :" + actualTotalPrice);
    }

    @When("I get alternate product options")
    public void i_get_alternate_product_options() {
        String basketId = getBasketId();
        IRestResponse<AlternateProductResponse> alternateProductResponse =
                getCarsiBasketClient().getAlternateOptions(basketId);

        getScenarioContext().setContext(Context.ALTERNATE_PRODUCTS_RESPONSE, alternateProductResponse);
    }

    @Then("I can validate alternate product text {string} is exist and rank is {int} type is {int}")
    public void i_can_validate_alternate_product_text_is_exist_and_rank_is_type_is(String optionText,
                                                                                   Integer optionRank, Integer type) {
        IRestResponse<AlternateProductResponse> alternateProductResponse =
                (IRestResponse<AlternateProductResponse>) getScenarioContext().getContext(Context.ALTERNATE_PRODUCTS_RESPONSE);
        AlternateOption option = alternateProductResponse.getBody().getData().getAlternateOptions().get(optionRank - 1);
        int actualOptionRank = option.getRank();
        String actualOptionText = option.getText();
        int actualType = option.getId();

        assertTrue(actualOptionRank == optionRank, "Option rank should be " + optionRank + " not " + actualOptionRank);
        assertTrue(actualType == type, "Option type should be " + type + " not " + actualType);
        assertEqual("Option text should be " + optionText + " not " + actualOptionText, actualOptionText, optionText);
    }

    @When("I want add product more than stock")
    public void i_want_add_product_more_than_stock() {
        IRestResponse<ProductResponse> selectedProductResponse =
                (IRestResponse<ProductResponse>) getScenarioContext().getContext(Context.PRODUCT_DETAIL_RESPONSE);

        int maxSaleAmount = selectedProductResponse.getBody().getData().getMaximumSaleAmount();
        i_can_add_the_selected_product_to_basket(maxSaleAmount + 1);
    }

    @Then("I can see {string} warning on add basket response")
    public void i_can_see_warning_on_add_basket_response(String warningText) {
        IRestResponse<AddProductToBasketResponse> addProductResponse =
                (IRestResponse<AddProductToBasketResponse>) getScenarioContext().getContext(Context.ADD_BASKET_RESPONSE);
        List<Info> infoList = addProductResponse.getBody().getInfoList();
        assertTrue(infoList.size() > 0, "Info liste should not empty");
        String actualMessage = infoList.get(0).getMessage();
        assertTrue(actualMessage.contains(warningText), "Max sale amount warning should contain " + warningText);
    }

    @Then("I can valid add basket response is {int}")
    public void i_can_valid_add_basket_response_is(Integer expectedStatus) {
        IRestResponse<AddProductToBasketResponse> addProductResponse =
                (IRestResponse<AddProductToBasketResponse>) getScenarioContext().getContext(Context.ADD_BASKET_RESPONSE);
        int actualStatus = addProductResponse.getStatusCode();
        assertTrue(expectedStatus == actualStatus, "Add basket response status code should be " + expectedStatus);
    }

    @When("I add products as many as the max stock quantity")
    public void i_add_products_as_many_as_the_max_stock_quantity() {
        IRestResponse<ProductResponse> selectedProductResponse =
                (IRestResponse<ProductResponse>) getScenarioContext().getContext(Context.PRODUCT_DETAIL_RESPONSE);


        int maxSaleAmount = selectedProductResponse.getBody().getData().getMaximumSaleAmount();
        i_can_add_the_selected_product_to_basket(maxSaleAmount);
    }

    @Then("I can check Quantity is valid on basket lines")
    public void i_can_check_quantity_is_valid_on_basket_lines() {
        AddProductWithoutCampaignToBasketReq addedProductRequest =
                (AddProductWithoutCampaignToBasketReq) getScenarioContext().getContext(Context.ADDED_PRODUCT_REQ);

        IRestResponse<AddProductToBasketResponse> addProductResponse =
                (IRestResponse<AddProductToBasketResponse>) getScenarioContext().getContext(Context.ADD_BASKET_RESPONSE);
        String addedProductId = addedProductRequest.getProductId();

        List<Line> basketLines = addProductResponse.getBody().getData().getLightBasket().getLines();
        int addedProductIndex = -1;
        for (Line line : basketLines) {
            if (line.getProductId().equalsIgnoreCase(addedProductId)) {
                addedProductIndex = basketLines.indexOf(line);
            }
        }
        int expectedQuantity =
                addProductResponse.getBody().getData().getLightBasket().getLines().get(addedProductIndex).getQuantity();
        int actualQuantity = basketLines.get(addedProductIndex).getQuantity();

        assertTrue(expectedQuantity == actualQuantity, "Added quantity and basket product quantity should be equal");

    }

    private String getProductLineItemIdFromGetBasket(Product product) {
        List<BasketLine> lines = getBasketResponse().getBody().getData().getLines();
        String expectedProductId = product.getId();
        for (BasketLine line : lines) {
            String lineProductId = line.getProductId();
            if (lineProductId.equalsIgnoreCase(expectedProductId)) {
                return line.getId();
            }
        }
        return "Line item id bulunamadı";
    }

    @When("I delete the selected product from basket quantity is {int}")
    public void i_delete_the_selected_product_from_basket_quantity_is(Integer expectedQuantity) {
        String basketId = getBasketId();
        Product selectedProduct = getSelectedProduct();
        int quantity = expectedQuantity;
        String productId = selectedProduct.getId();
        String productLineItemId = getProductLineItemIdFromGetBasket(selectedProduct);
        DeleteProductRequest deleteProductRequest = new DeleteProductRequest(productId, productLineItemId, quantity);
        IRestResponse<DeleteProductResponse> deleteProductResponse =
                getCarsiBasketClient().deleteProduct(basketId, deleteProductRequest);
        getScenarioContext().setContext(Context.DELETE_PRODUCT_RESPONSE, deleteProductResponse);
    }

    @Then("I can validate alternate product option list is null")
    public void i_can_validate_alternate_product_option_list_is_empty() {
        List<AlternateOption> alternateProductOptionList =
                getAlternateProductResponse().getBody().getData().getAlternateOptions();
        assertTrue(alternateProductOptionList == null, "Alternate product options should be empty on the banabi");
    }

    @When("I get checkout options")
    public void i_get_checkout_options() {
        String basketId = getBasketId();
        IRestResponse<BasketCheckoutResponse> getBasketResponse = getCarsiBasketClient().getCheckout(basketId);
        getScenarioContext().setContext(Context.BASKET_CHECKOUT_RESPONSE, getBasketResponse);
    }

    @Then("I check Contactless Delivery Option is showed {string} on basket checkout response")
    public void i_check_contactless_delivery_option_is_showed_on_basket_checkout_response(String contactlessDeliveryOptionStatus) {
        boolean actualContactlessDeliveryOption =
                getBasketCheckoutResponse().getBody().getData().getBasketCheckout().getShowContactlessDeliveryOption();
        if (contactlessDeliveryOptionStatus.equalsIgnoreCase("True")) {
            assertTrue(actualContactlessDeliveryOption, "Contactless Delivery Option should be true ");
        } else {
            assertTrue(!actualContactlessDeliveryOption, "Contactless Delivery Option should be false ");
        }
    }

    @Then("I set ContactlessDelivery is {string}")
    public void i_set_contactless_delivery_is(String contactLessDelivery) {
        if (contactLessDelivery.equalsIgnoreCase("True")) {
            getScenarioContext().setContext(Context.CONTACTLESS_DELIVERY_SELECTION, true);
        } else {
            getScenarioContext().setContext(Context.CONTACTLESS_DELIVERY_SELECTION, false);
        }
    }

    @Then("I check ContactlessDelivery is {string} on put basket checkout response")
    public void i_check_contactless_delivery_is_on_put_basket_checkout_response(String expectedContactlessDelivery) {
        boolean actualContactlessDelivery =
                getPutBasketCheckoutResponse().getBody().getData().getBasketCheckout().getContactlessDelivery();
        if (expectedContactlessDelivery.equalsIgnoreCase("true")) {
            assertTrue(actualContactlessDelivery, "Actual contactless delivery should be true");
        } else {
            assertTrue(!actualContactlessDelivery, "Actual contactless delivery should be false");
        }
    }

    @When("I set paymentMethodId is {string}, PaymentType : {int} , BinNumber: {int} , IsApproved : {string}")
    public void i_set_payment_type_is(String paymentMethodId, Integer paymentType, int binNumber, String isApproved) {
        boolean approvedSelection = false;
        if (isApproved.equalsIgnoreCase("true")) {
            approvedSelection = true;
        }
        Payment selectedPayment = new Payment(paymentMethodId, paymentType, binNumber, approvedSelection);
        getScenarioContext().setContext(Context.PAYMENT_TYPE_SELECTION, selectedPayment);
    }

    @When("I set paymentMethodId is {string}, PaymentType : {int}, IsApproved : {string} without binNumber")
    public void i_set_payment_type_is_without_bin(String paymentMethodId, Integer paymentType, String isApproved) {
        boolean approvedSelection = false;
        if (isApproved.equalsIgnoreCase("true")) {
            approvedSelection = true;
        }
        Payment selectedPayment = new Payment(paymentMethodId, paymentType, null, approvedSelection);
        getScenarioContext().setContext(Context.PAYMENT_TYPE_SELECTION, selectedPayment);
    }

    @When("I set paymentMethodId is {string}, PaymentType : {int} , BinNumber: {int} , IsApproved : {string} for " +
            "Banabi")
    public void i_set_payment_type_is_for_banabi(String paymentMethodId, Integer paymentType, String isApproved) {
        boolean approvedSelection = false;
        if (isApproved.equalsIgnoreCase("true")) {
            approvedSelection = true;
        }
        Payment selectedPayment = new Payment(paymentMethodId, paymentType, null, approvedSelection);
        getScenarioContext().setContext(Context.PAYMENT_TYPE_SELECTION, selectedPayment);
    }

    @When("I put basket to checkout LastChangedProperty is {int}")
    public void i_put_basket_to_checkout_last_changed_property_is(Integer lastChangedProp) {
        String basketId = getBasketId();
        boolean contactlessDeliverySelection = getSelectedContactlessDeliveryStatus();
        Payment selectedPaymentMethodId = getSelectedPaymentId();
        Tip selectedTip = getSelectedTip();
        Donation selectedDonation = getSelectedDonation();
        BasketCheckOutRequest basketPutCheckOutRequest = new BasketCheckOutRequest(lastChangedProp,
                contactlessDeliverySelection,
                selectedTip,
                selectedDonation,
                selectedPaymentMethodId);
        IRestResponse<BasketPutResponse> putBasketCheckOutResponse = getCarsiBasketClient().putCheckout(basketId,
                basketPutCheckOutRequest);
        getScenarioContext().setContext(Context.PUT_BASKET_CHECKOUT_RESPONSE, putBasketCheckOutResponse);
    }

    @Then("I check selected payment MethodId is {string} on put basket checkout response")
    public void i_check_selected_payment_method_id_is_on_put_basket_checkout_response(String expectedPaymentMethodId) {
        String actualPaymentMethodId =
                getPutBasketCheckoutResponse().getBody().getData().getBasketCheckout().getPaymentInfo().getMethodId();
        assertEqual("Payment method id should be " + expectedPaymentMethodId, actualPaymentMethodId,
                expectedPaymentMethodId);
    }

    private List<PaymentMethod> getOnlinePaymentMethods() {
        return getBasketCheckoutResponse().getBody().getData().getBasketCheckout().getPaymentTypes().get(0).getPaymentMethods();
    }

    private List<PaymentMethod> getOfflinePaymentMethods() {
        return getBasketCheckoutResponse().getBody().getData().getBasketCheckout().getPaymentTypes().get(1).getPaymentMethods();
    }

    @Then("I check tip info is {string} on basket checkout response")
    public void i_check_tip_info_is_on_basket_checkout_response(String expectedTipStatus) {
        boolean actualTipStatus = getTipInfoListOnBasketCheckout().getEnabled();
        if (expectedTipStatus.equalsIgnoreCase("true")) {
            assertTrue(actualTipStatus, "Tip status shoul be true");
        } else {
            assertTrue(!actualTipStatus, "Tip status shoul be false");
        }
    }

    @Then("I check tip value is valid {int}")
    public void i_check_tip_value_is_valid(Integer tipTypeId) {
        List<apiEngine.models.response.Basket.Checkout.Option> optionList =
                getTipInfoListOnBasketCheckout().getOptions();
        if (tipTypeId == 3) {
            assertTrue(optionList.get(2).getValue() == 0, "Tip value should be 0");
        } else if (tipTypeId == 2) {
            assertTrue(optionList.get(0).getValue() == 3, "Tip value should be 3");
        } else if (tipTypeId == 1) {
            List<apiEngine.models.response.Basket.Checkout.Option> option =
                    getTipInfoListOnBasketCheckout().getOptions();
            double actualValue = option.get(1).getValue();
            double expectedValue =
                    getBasketCheckoutResponse().getBody().getData().getBasketCheckout().getBasketInfo().getTotal() / 10;
            int roundValue = (int) roundDouble(expectedValue, "#.##");
            assertTrue(actualValue == roundValue, "Tip value should be " + roundValue + " not " + actualValue);
        }
    }

    @Then("I check tip option {int} {int} {string} {string} on get basket checkout")
    public void i_check_tip_option(int rank, int expectedTypeId, String expectedValueText,
                                   String expectedIsSelected) {
        apiEngine.models.response.Basket.Checkout.Option option =
                getTipInfoListOnBasketCheckout().getOptions().get(rank);
        int actualTypeId = option.getTypeId();
        String actualValueText = option.getValueText();

        assertTrue(actualTypeId == expectedTypeId, "Type ip should be " + expectedTypeId);
        assertEqual("Value text should be " + expectedValueText, actualValueText, expectedValueText);
        if (expectedIsSelected.equalsIgnoreCase("true")) {
            assertTrue(option.getIsSelected(), "IsSelected should be true");
        } else {
            assertTrue(!option.getIsSelected(), "IsSelected should be false");
        }
    }

    private apiEngine.models.response.Basket.Checkout.Option getTipOption(int rank) {
        return getTipInfoListOnBasketCheckout().getOptions().get(rank);
    }

    @Then("I check tip {int} {int} on get basket checkout")
    public void i_check_tip_on_get_basket_checkout(Integer expectedTypeId, Integer rank) {
        int actualTypeId = getTipOption(rank).getTypeId();
        assertTrue(actualTypeId == expectedTypeId, "Type id should be " + expectedTypeId + " not " + actualTypeId);
    }

    @Then("I check tip {string} {int} on get basket checkout")
    public void i_check_tip_on_get_basket_checkout(String expectedValueText, Integer rank) {
        String actualValueText = getTipOption(rank).getValueText();
        assertEqual("Value text should be valid ", actualValueText, expectedValueText);
    }

    @Then("I check tip status {string} {int} on get basket checkout")
    public void i_check_tip_status_on_get_basket_checkout(String expectedIsSelected, Integer rank) {
        boolean actualIsSelected = getTipOption(rank).getIsSelected();
        if (expectedIsSelected.equalsIgnoreCase("True")) {
            assertTrue(actualIsSelected, "IsSelected should be true");
        } else {
            assertTrue(!actualIsSelected, "IsSelected should be false");
        }
    }


    @When("I set tip to {int} tl option type is {int}")
    public void i_set_tip_with_default_option(int tipValue, int optionType) {
        Tip selectedTip = new Tip(optionType, tipValue);
        getScenarioContext().setContext(Context.TIP_SELECTION, selectedTip);
    }

    @Then("I check Tip is selected with {int} on put basket checkout response")
    public void i_check_tip_is_selected_with(int expectedTipValue) {
        int actualTip =
                getPutBasketCheckoutResponse().getBody().getData().getBasketCheckout().getBasketInfo().getTipTotal();
        assertTrue(actualTip == expectedTipValue, "Total Tip should be " + expectedTipValue + " not " + actualTip);
    }

    private int getSelectedTipIndex(List<apiEngine.models.response.Basket.Checkout.Option> optionList, int typeId) {
        int selectedOptionIndex = -1;
        for (apiEngine.models.response.Basket.Checkout.Option option : optionList) {
            if (option.getTypeId() == typeId) {
                selectedOptionIndex = optionList.indexOf(option);
                break;
            }
        }
        return selectedOptionIndex;
    }

    @Then("I check tip isEnabled is {string} tip type is {int} on put basket checkout response")
    public void i_check_tip_isEnabled_is_valid_on_put_basket(String expectedIsEnabledStatus, int typeId) {
        apiEngine.models.response.Basket.Checkout.PutCheckout.TipInfo tipInfo =
                getPutBasketCheckoutResponse().getBody().getData().getBasketCheckout().getTipInfo();
        List<apiEngine.models.response.Basket.Checkout.Option> options = tipInfo.getOptions();
        int selectedOptionIndex = getSelectedTipIndex(options, typeId);

        boolean actualTipStatus = options.get(selectedOptionIndex).getIsSelected();
        if (expectedIsEnabledStatus.equalsIgnoreCase("true")) {
            assertTrue(actualTipStatus, "Tip status should be true");
        } else {
            assertTrue(!actualTipStatus, "Tip status should be false");
        }
    }

    private IRestResponse<BasketUpsellResponse> getBasketUpsellResponse() {
        return (IRestResponse<BasketUpsellResponse>) getScenarioContext().getContext(Context.BASKET_UPSELL_RESPONSE);
    }

    @Then("I get upsell products")
    public void i_get_upsell_products() {
        String basketId = getBasketId();
        IRestResponse<BasketUpsellResponse> upsellResponse = getCarsiBasketClient().getUpsell(basketId);
        assertTrue(upsellResponse.isSuccessful(), "Upsell response should be OK");
        getScenarioContext().setContext(Context.BASKET_UPSELL_RESPONSE, upsellResponse);
    }

    @Then("I validate upsell type is {int}")
    public void i_validate_upsell_type_is(int upsellType) {
        assertTrue(getBasketUpsellResponse().getBody().getData().getUpsellType() == upsellType,
                "Basket upsell type should be 0");
    }

    @Then("I check total is valid for tip amount {int} on put basket checkout response")
    public void i_check_total_is_valid_for_tip_amount_on_put_basket_checkout_response(Integer tipAmount) {
        apiEngine.models.response.Basket.Checkout.PutCheckout.BasketInfo basketInfo =
                getPutBasketCheckoutResponse().getBody().getData().
                        getBasketCheckout().getBasketInfo();

        double actualTotal = basketInfo.getTotal();
        double deliveryFee = basketInfo.getDeliveryFree();
        double lineItemsTotal = basketInfo.getLineItemsTotal();

        double expectedTotal = tipAmount + deliveryFee + lineItemsTotal;
        assertTrue(actualTotal == expectedTotal,
                "Total amount should be " + expectedTotal + " not " + actualTotal);
    }

    @Then("I get order notes on checkout")
    public void i_get_order_notes_on_checkout() {
        List<SavedNote> savedNotes =
                getBasketCheckoutResponse().getBody().getData().getBasketCheckout().getSavedNotes();
        getScenarioContext().setContext(Context.ORDER_NOTE_LIST, savedNotes);
        getScenarioContext().setContext(Context.ORDER_NOTE_SIZE, savedNotes.size());
    }

    @Then("I validate order notes is empty on checkout")
    public void i_validate_order_notes_is_empty_on_checkout() {
        assertTrue(getSavedNoteDataList().isEmpty(), "User saved notes should be empty ");
    }

    @When("I can write order note with character count {int} on checkout")
    public void i_can_write_order_note_with_character_count_on_checkout(Integer maxCharacterSize) throws IOException {
        String note = GenerateFakeData.getFakeLorem(maxCharacterSize);
        getScenarioContext().setContext(Context.WRITED_NOTE_TEXT, note);
        IRestResponse<WriteOrderNoteResponse> writeOrderNoteResponse = writeOrderNote(note);
        getScenarioContext().setContext(Context.WRITE_ORDER_NOTE_RESPONSE, writeOrderNoteResponse);
    }

    private String orderNoteFirstXCharacterFromNote(int characterSize) {
        String note = (String) getScenarioContext().getContext(Context.WRITED_NOTE_TEXT);
        String expectedTitle;
        if (note.length() > characterSize) {
            expectedTitle = note.substring(0, characterSize);
        } else {
            expectedTitle = note;
        }

        return expectedTitle;

    }

    private SavedNote getAddedOrderNoteData() {
        String expectedTitle = orderNoteFirstXCharacterFromNote(20);
        int index = -1;
        for (SavedNote savedNote : getSavedNoteDataList()) {
            if (savedNote.getTitle().equalsIgnoreCase(expectedTitle)) {
                index = getSavedNoteDataList().indexOf(savedNote);
            }
        }
        return getSavedNoteDataList().get(index);
    }

    @Then("I validate order note title is saved with first {int} character on checkout")
    public void i_validate_order_title_is_saved_with_first_character_on_checkout(Integer firstCharacterSize) {
        String actualTitle = getAddedOrderNoteData().getTitle();
        String expectedTitle = orderNoteFirstXCharacterFromNote(firstCharacterSize);
        assertEqual("Expected title should be equal first " + firstCharacterSize, actualTitle, expectedTitle);
    }

    @Then("I validate order note desc listed in checkout saved notes")
    public void i_validate_not_desc_listed_in_checkout() {
        String actualNote = getAddedOrderNoteData().getNote();
        String lastAddedNote = (String) getScenarioContext().getContext(Context.WRITED_NOTE_TEXT);
        assertEqual("Added note should be in saved note list ", actualNote, lastAddedNote);
    }

    @Then("I validate order note response status code is {int}")
    public void i_can_validate_order_note_response_is(Integer statusCode) {
        IRestResponse<WriteOrderNoteResponse> writeOrderNoteResponse =
                (IRestResponse<WriteOrderNoteResponse>) getScenarioContext().getContext(Context.WRITE_ORDER_NOTE_RESPONSE);

        int actualStatus = writeOrderNoteResponse.getStatusCode();
        assertTrue(actualStatus == statusCode,
                "Assert status code should be "
                        + statusCode + "not " + actualStatus);
    }

    @Then("I validate VendorName is valid in basket info")
    public void i_validate_vendor_name_is_valid_in_basket_info() {
        String expectedVendorName = getSelectedVendorDetailData().getName();
        String actualVendorName = getBasketInfo().getVendorName();
        assertEqual("Vendor name should valid", expectedVendorName, actualVendorName);
    }

    @Then("I validate VendorId is valid in basket info")
    public void i_validate_vendor_id_is_valid_in_basket_info() {
        String expectedVendorId = getSelectedVendor().getId();
        String actualVendorId = getBasketInfo().getVendorId();
        assertEqual("Vendor id should valid", expectedVendorId, actualVendorId);
    }

    @Then("I validate IsFreeOrder is {string} in basket info")
    public void i_validate_is_free_order_is_in_basket_info(String expectedIsFreeOrder) {
        boolean actualIsFreeOrder = getBasketInfo().getIsFreeOrder();
        if (expectedIsFreeOrder.equalsIgnoreCase("True")) {
            assertTrue(actualIsFreeOrder, "IsFreeOrder should be true");
        } else {
            assertTrue(!actualIsFreeOrder, "IsFreeOrder should be false");
        }
    }

    @Then("I validate MinimumDeliveryTotal is valid in basket info")
    public void i_validate_minimum_delivery_total_is_valid_in_basket_info() {
        Double actualMinimumDeliveryTotal = getBasketInfo().getDeliveryFree();
        assertNotNull(actualMinimumDeliveryTotal, "MinimumDeliveryTotal should not null");
    }

    @Then("I validate VendorCategory is valid in basket info")
    public void i_validate_vendor_category_is_valid_in_basket_info() {
        String expectedCategoryName = getSelectedVendorDetailData().getCategoryName();
        String actualVendorCategory = getBasketInfo().getVendorCategory();
        assertEqual("VendorCategory name should be valid ", expectedCategoryName, actualVendorCategory);
    }

    @Then("I validate VendorLogo is valid in basket info")
    public void i_validate_vendor_logo_is_valid_in_basket_info() {
        String expectedVendorLogo = getSelectedVendorDetailData().getLogoUrl();
        String actualVendorLogo = getBasketInfo().getVendorLogo();
        assertEqual("VendorLogo url should be valid ", actualVendorLogo, expectedVendorLogo);
        int imageStatus = getCarsiBasketClient().getImageUrlResponse(actualVendorLogo).getStatusCode();
        assertTrue(imageStatus == 200, "Vendor logo status not ok " + imageStatus);
    }

    @Then("I validate BasketStatus is {int} in basket info")
    public void i_validate_basket_status_is_in_basket_info(Integer expectedStatus) {
        int actualBasketStatus = getBasketInfo().getBasketStatus();
        assertTrue(actualBasketStatus == expectedStatus,
                "Basket status should be " + expectedStatus + " not" + actualBasketStatus);
    }

    @Then("I validate BasketId is valid in basket info")
    public void i_validate_basket_id_is_valid_in_basket_info() {
        String actualBasketId = getBasketInfo().getBasketId();
        String expectedBasketId = getBasketId();
        assertEqual("Basket ıd should be valid ", actualBasketId, expectedBasketId);
    }

    private List<PaymentType> getBasketCheckOutPaymentTypes() {
        return getBasketCheckoutResponse().getBody().getData().getBasketCheckout().getPaymentTypes();
    }

    @Then("I list PaymentTypes in basket checkout response")
    public void i_list_payment_types_in_basket_checkout_response() {
        getScenarioContext().setContext(Context.BASKET_CHECKOUT_PAYMENT_METHODS, getBasketCheckOutPaymentTypes());
    }

    private boolean paymentTypeTitleIsExistOnGetCheckOut(String expectedTitle) {
        List<PaymentType> paymentMethodTypes = getBasketCheckOutPaymentTypes();
        for (PaymentType paymentType : paymentMethodTypes) {
            if (paymentType.getTitle().equalsIgnoreCase(expectedTitle)) {
                return true;
            }
        }
        return false;
    }

    private boolean paymentTypeIdIsExistOnGetCheckOut(String expectedId) {
        List<PaymentType> paymentMethodTypes = getBasketCheckOutPaymentTypes();
        for (PaymentType paymentType : paymentMethodTypes) {
            if (paymentType.getId().equalsIgnoreCase(expectedId)) {
                return true;
            }
        }
        return false;
    }

    private boolean paymentTypeIconIsExistOnGetCheckOut(String expectedIcon) {
        List<PaymentType> paymentMethodTypes = getBasketCheckOutPaymentTypes();
        for (PaymentType paymentType : paymentMethodTypes) {
            if (paymentType.getIconUrl().equalsIgnoreCase(expectedIcon)) {
                return true;
            }
        }
        return false;
    }

    @Then("I check PaymentTypeTitle {string} is exist in basket checkout response")
    public void i_check_payment_type_title_in_basket_checkout_response(String expectedPaymentTypeTitle) {
        assertTrue(paymentTypeTitleIsExistOnGetCheckOut(expectedPaymentTypeTitle), expectedPaymentTypeTitle + " " +
                "Payment type title should be listed ");
    }

    @Then("I check PaymentTypeId {string} is exist in basket checkout response")
    public void i_check_payment_type_id_in_basket_checkout_response(String expectedPaymentTypeId) {
        assertTrue(paymentTypeIdIsExistOnGetCheckOut(expectedPaymentTypeId), expectedPaymentTypeId + " " +
                "Payment type id should be listed ");
    }

    @Then("I check payment type IconUrl {string} is exist in basket checkout response")
    public void i_check_payment_type_icon_url_in_basket_checkout_response(String expectedIconUrl) {
        assertTrue(paymentTypeIconIsExistOnGetCheckOut(expectedIconUrl), expectedIconUrl + " " +
                "Payment type icon should be listed ");
    }

    private PaymentType getSelectedPaymentType() {
        return (PaymentType) getScenarioContext().getContext(Context.SELECTED_PAYMENT_TYPE);
    }

    private PaymentMethod getSelectedPaymentMethod() {
        return (PaymentMethod) getScenarioContext().getContext(Context.SELECTED_PAYMENT_METHOD);
    }

    private SubMethod getSelectedSubMethod() {
        return (SubMethod) getScenarioContext().getContext(Context.SELECTED_PAYMENT_SUB);
    }

    @Then("I select payment type with {string} in basket checkout response")
    public void i_select_payment_type_id_in_basket_checkout_response(String typeId) {
        List<PaymentType> paymentTypeList = getBasketCheckOutPaymentTypes();
        for (PaymentType paymentType : paymentTypeList) {
            if (paymentType.getId().equalsIgnoreCase(typeId)) {
                getScenarioContext().setContext(Context.SELECTED_PAYMENT_TYPE, paymentType);
                return;
            }
        }
        Assert.fail("Payment type can not find");
    }

    @Then("I select payment method id {string} in selected payment method")
    public void i_select_payment_type_method_id_in_basket_checkout_response(String methodId) {
        List<PaymentMethod> paymentMethodList = getSelectedPaymentType().getPaymentMethods();

        for (PaymentMethod paymentMethod : paymentMethodList) {
            if (paymentMethod.getId().equalsIgnoreCase(methodId)) {
                getScenarioContext().setContext(Context.SELECTED_PAYMENT_METHOD, paymentMethod);
                return;
            }
        }
        Assert.fail("Payment Method can not find");
    }


    @Then("I select sub method with {string} in selected payment method")
    public void i_select_sub_method_with_in_selected_payment_method(String subId) {
        List<SubMethod> subMethodList = getSelectedPaymentMethod().getSubMethods();

        for (SubMethod subMethod : subMethodList) {
            if (subMethod.getId().equalsIgnoreCase(subId)) {
                getScenarioContext().setContext(Context.SELECTED_PAYMENT_SUB, subMethod);
                return;
            }
        }
        Assert.fail("Payment sub can not find");
    }

    @Then("I check sub Name is {string} is exist in selected payment sub method")
    public void i_check_sub_name_is_is_exist(String expectedSubName) {
        String actualSubName = getSelectedSubMethod().getName();
        assertEqual("Payment sub name should be valid", actualSubName, expectedSubName);
    }

    @Then("I check sub ImageUrl is {string} is exist in selected payment sub method")
    public void i_check_sub_image_url_is_is_exist(String expectedIconUrl) {
        String actualSubImageUrl = getSelectedSubMethod().getImageUrl();
        assertEqual("Payment sub ImageUrl should be valid", actualSubImageUrl, expectedIconUrl);
    }

    @Then("I check sub Pan is {string} is exist in selected payment sub method")
    public void i_check_sub_pan_is_is_exist(String expectedPan) {
        String actualSubPan = getSelectedSubMethod().getPan();
        assertEqual("Payment sub ImageUrl should be valid", actualSubPan, expectedPan);
    }

    @Then("I check sub BinNumber is {int} is exist in selected payment sub method")
    public void i_check_sub_bin_number_is_is_exist(Integer expectedBin) {
        int actualBinNumber = getSelectedSubMethod().getBinNumber();
        assertTrue(actualBinNumber == expectedBin, "Bin number should be " + expectedBin + " Not " + actualBinNumber);
    }

    @Then("I check sub PointAmount is {int} is exist in selected payment sub method")
    public void i_check_sub_point_amount_is_is_exist(Integer expectedPointAmount) {
        int actualPoint = getSelectedSubMethod().getPointAmount();
        assertTrue(actualPoint == expectedPointAmount, "Point should be " + expectedPointAmount + " Not " + actualPoint
        );
    }

    @Then("I check sub IsSelected is {string} is exist in selected payment sub method")
    public void i_check_sub_is_selected_is_is_exist(String expectedIsSelected) {
        boolean actualIsSelected = getSelectedSubMethod().getIsSelected();
        if (expectedIsSelected.equalsIgnoreCase("True")) {
            assertTrue(actualIsSelected, "Sub payment should be true");
        } else {
            assertTrue(!actualIsSelected, "Sub payment should be false");
        }
    }

    @Then("I check sub CheckoutTypeId is {int} is exist in selected payment sub method")
    public void i_check_sub_checkout_type_id_is_is_exist(Integer expectedCheckoutTypeId) {
        int actualTypeId = getSelectedSubMethod().getCheckoutTypeId();
        assertTrue(actualTypeId == expectedCheckoutTypeId, "CheckoutTypeIdshould be " + expectedCheckoutTypeId + " Not " + actualTypeId);

    }


}
