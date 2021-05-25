package stepDefinitions;

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
import apiEngine.models.response.Basket.Checkout.BasketCheckoutResponse;
import apiEngine.models.response.Basket.Checkout.PaymentMethod;
import apiEngine.models.response.Basket.Checkout.PutCheckout.BasketPutResponse;
import apiEngine.models.response.Basket.Checkout.TipInfo;
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
import java.text.DecimalFormat;
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
                        null,
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
                RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Then("I can check basket subTotal is valid on basket")
    public void i_can_check_basket_sub_total_is_valid_on_basket() {
        double actualSubTotal = getBasketResponse().getBody().getData().getBasketInfo().getSubTotal();
        double expectedSubTotal = getAddedProductsTotalPrice();
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


    @Then("I can validate basket total is {double}")
    public void i_can_validate_basket_total_is(Double expectedTotalPrice) {
        double actualTotalPrice = getBasketResponse().getBody().getData().getBasketInfo().getTotal();
        assertTrue(actualTotalPrice == expectedTotalPrice, "Basket total price should be " + expectedTotalPrice +
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
        int actualType = option.getTypeId();

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
        assertEqual("Max sale amount warning should be " + warningText, actualMessage, warningText);
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

    @When("I delete the selected product from basket quantity is {int}")
    public void i_delete_the_selected_product_from_basket_quantity_is(Integer expectedQuantity) {
        String basketId = getBasketId();
        Product selectedProduct = getSelectedProduct();
        int quantity = expectedQuantity;
        String productId = selectedProduct.getId();
        DeleteProductRequest deleteProductRequest = new DeleteProductRequest(productId, productId, quantity);
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

    @When("I set paymentMethodId is {string}, PaymentTypeId : {string} , BinNumber: {int} , IsApproved : {string}")
    public void i_set_payment_type_is(String paymentMethodId, String paymentTypeId, int binNumber, String isApproved) {
        boolean approvedSelection = false;
        if (isApproved.equalsIgnoreCase("true")) {
            approvedSelection = true;
        }
        Payment selectedPayment = new Payment(paymentMethodId, paymentTypeId, binNumber, approvedSelection);
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

    private static double roundDouble(double d) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(d));
    }

    @Then("I check tip value is valid {int}")
    public void i_check_tip_value_is_valid(Integer tipTypeId) {
        List<apiEngine.models.response.Basket.Checkout.Option> optionList = getTipInfoListOnBasketCheckout().getOptions();
       if (tipTypeId == 3){
           assertTrue(optionList.get(2).getValue() == 0, "Tip value should be 0");
       }
       else if (tipTypeId == 2){
           assertTrue(optionList.get(0).getValue() == 3, "Tip value should be 3");
       }
       else if (tipTypeId == 1){
           List<apiEngine.models.response.Basket.Checkout.Option> option = getTipInfoListOnBasketCheckout().getOptions();
           double actualValue = option.get(1).getValue();
           double expectedValue = getBasketCheckoutResponse().getBody().getData().getBasketCheckout().getBasketInfo().getTotal()/10;
           int randValue = (int) roundDouble(expectedValue);
           assertTrue(actualValue == randValue, "Tip value should be " + randValue + " not " + actualValue);
       }
    }

    @Then("I check tip option {int} {int} {string} {string}")
    public void i_check_tip_option(int rank, int expectedTypeId, String expectedValueText,
                                   String expectedIsSelected) {
        apiEngine.models.response.Basket.Checkout.Option option =
                getTipInfoListOnBasketCheckout().getOptions().get(rank);
        int actualTypeId = option.getTypeId();
        String actualValueText = option.getValueText();

        assertTrue(actualTypeId== expectedTypeId, "Type ip should be " + expectedTypeId);
        assertEqual("Value text should be " + expectedValueText, actualValueText, expectedValueText);
        if (expectedIsSelected.equalsIgnoreCase("true")) {
            assertTrue(option.getIsSelected(), "IsSelected should be true");
        } else {
            assertTrue(!option.getIsSelected(), "IsSelected should be false");
        }
    }
}
