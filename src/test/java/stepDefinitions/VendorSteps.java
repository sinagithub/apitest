package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.Utilies.GuidHelper;
import apiEngine.models.response.*;
import apiEngine.models.response.ProductDetail.Data;
import apiEngine.models.response.ProductDetail.ProductResponse;
import apiEngine.models.response.Vendor.*;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("unchecked")
public class VendorSteps extends BaseSteps {

    public VendorSteps(TestContext testContext) {
        super(testContext);
    }

    @ParameterType(value = "true|True|TRUE|false|False|FALSE")
    public Boolean booleanValue(String value) {
        return Boolean.valueOf(value);
    }

    private MahalleVendor getSelectedVendor() {
        return (MahalleVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
    }

    private IRestResponse<VendorResponse> getSelectedVendorResponse() {
        return (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
    }

    private Category getSelectedCategory() {
        return (Category) getScenarioContext().getContext(Context.SELECTED_PRODUCT_CATEGORY);
    }

    private SubCategory getSelectedSubCategory() {
        return (SubCategory) getScenarioContext().getContext(Context.SELECTED_SUB_PRODUCT_CATEGORY);
    }

    private IRestResponse<VendorProductsResponse> getSelectedVendorCategoryProductsResponse() {
        return (IRestResponse<VendorProductsResponse>) getScenarioContext()
                .getContext(Context.VENDOR_CATEGORY_PRODUCTS_RES);
    }

    private List<Product> getSelectedVendorProductList() {
        IRestResponse<VendorProductsResponse> vendorCategoryProductResponse =
                (IRestResponse<VendorProductsResponse>) getScenarioContext()
                        .getContext(Context.VENDOR_CATEGORY_PRODUCTS_RES);
        return vendorCategoryProductResponse.getBody().getData().getProducts();
    }

    private Product getSelectedProduct() {
        return (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
    }

    private IRestResponse<VendorResponse> getSelectedVendorDetailResponse() {
        return (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
    }

    private IRestResponse<VendorProductSearchResponse> getVendorProductSearchRes() {
        return (IRestResponse<VendorProductSearchResponse>) getScenarioContext().getContext(Context.VENDOR_PRODUCT_SEARCH_RESPONSE);
    }

    @Then("I navigate selected vendor")
    public void i_navigate_selected_vendor() {
        MahalleVendor selectedVendor = getSelectedVendor();
        String vendorId = selectedVendor.getId();
        IRestResponse<VendorResponse> vendorResponse = getCarsiVendorClient().getVendor(vendorId);
        getScenarioContext().setContext(Context.VENDOR_DETAIL_RESPONSE, vendorResponse);
        getScenarioContext().setContext(Context.SELECTED_VENDOR_DETAIL_DATA, vendorResponse.getBody().getData());
    }

    @Then("I navigate vendor with {string}")
    public void i_navigate_vendor_with_id(String vendorId) {
        String sessionId = GuidHelper.getInstance().getGuid();
        IRestResponse<VendorResponse> vendorResponse = getCarsiVendorClient().getVendor(vendorId);
        getScenarioContext().setContext(Context.VENDOR_DETAIL_RESPONSE, vendorResponse);
    }


    @Then("I choose {string} product category from category list")
    public void i_choose_product_category_from_list(String categoryName) {

        List<Category> vendorCategories = getSelectedVendorResponse().getBody().getData().getCategories();
        Category selectedCategory = null;

        for (Category category : vendorCategories) {
            if (category.getName().equalsIgnoreCase(categoryName)) {
                selectedCategory = category;
                break;
            }
        }
        if (selectedCategory != null) {
            getScenarioContext().setContext(Context.SELECTED_PRODUCT_CATEGORY, selectedCategory);
        } else {
            Assert.fail(categoryName + " not found on the vendor categories");
        }
    }

    @Then("I choose a category with more than {int} products")
    public void i_choose_product_category_from_list_with_min_product_count(int productCount) {
        List<Category> vendorCategories = getSelectedVendorResponse().getBody().getData().getCategories();
        Category selectedCategory = null;

        for (Category category : vendorCategories) {
            if (category.getProductCount() >= productCount) {
                selectedCategory = category;
                break;
            }
        }
        getScenarioContext().setContext(Context.SELECTED_PRODUCT_CATEGORY, selectedCategory);
    }

    @Then("I choose {string} sub category from sub category")
    public void i_choose_sub_category_from_main_category(String subCategoryName) {
        Category selectedCategory = getSelectedCategory();
        List<SubCategory> subCategoryList = selectedCategory.getSubCategories();
        SubCategory selectedSubCategory = null;

        for (SubCategory subCategory : subCategoryList) {
            if (subCategory.getName().equalsIgnoreCase(subCategoryName)) {
                selectedSubCategory = subCategory;
            }
            break;
        }

        getScenarioContext().setContext(Context.SELECTED_SUB_PRODUCT_CATEGORY, selectedSubCategory);
    }

    @Then("I choose random available sub category from sub category")
    public void i_choose_random_available_sub_category() {
        List<SubCategory> subCategoryList = getSelectedCategory().getSubCategories();
        SubCategory selectedSubCategory = null;
        for (SubCategory subCategory : subCategoryList) {
            if (subCategory.getProductCount() >= 1) {
                selectedSubCategory = subCategory;
            }
            break;
        }
        getScenarioContext().setContext(Context.SELECTED_SUB_PRODUCT_CATEGORY, selectedSubCategory);
    }


    @Then("I choose a sub category with more than {int} products")
    public void i_choose_sub_category_from_main_category(int productCount) {
        List<SubCategory> subCategoryList = getSelectedCategory().getSubCategories();
        SubCategory selectedSubCategory = null;

        for (SubCategory subCategory : subCategoryList) {
            if (subCategory.getProductCount() >= productCount) {
                selectedSubCategory = subCategory;
                break;
            }

        }

        getScenarioContext().setContext(Context.SELECTED_SUB_PRODUCT_CATEGORY, selectedSubCategory);
    }

    @When("I list the products from selected sub category")
    public void i_list_the_products_from_selected_sub_category() {
        Category selectedCategory = (Category) getScenarioContext().getContext(Context.SELECTED_PRODUCT_CATEGORY);
        String categoryId = selectedCategory.getId();
        Integer offSet = getSelectedSubCategory().getOffset();
        String vendorId = getSelectedVendor().getId();
        IRestResponse<VendorProductsResponse> vendorProductResponse = getCarsiVendorClient().getProducts(vendorId,
                categoryId
                , offSet);
        getScenarioContext().setContext(Context.VENDOR_CATEGORY_PRODUCTS_RES, vendorProductResponse);
    }

    @Then("I check vendor name is valid")
    public void i_check_vendor_name_is_valid() {
        String expectedVendorName = getSelectedVendor().getName();
        String actualVendorName = getSelectedVendorDetailResponse().getBody().getData().getName();
        assertTrue(!actualVendorName.isEmpty(), "Vendor VendorCategoryName should not null");
        assertTrue(expectedVendorName.equalsIgnoreCase(actualVendorName), "Vendor name not equal with selected vendor");

    }

    @Then("I check vendor category name should be valid")
    public void i_check_category_name_is_valid() {
        String expectedVendorCategoryName = getSelectedVendor().getCategoryName();
        String actualCategoryName = getSelectedVendorDetailResponse().getBody().getData().getCategoryName();
        assertTrue(!actualCategoryName.isEmpty(), "Vendor VendorCategoryName should not null");
        assertEqual("Vendor category name not equal " +
                "with selected vendor", expectedVendorCategoryName, actualCategoryName);
    }

    @Then("I check vendor category name should be {string}")
    public void i_check_category_name_is_valid(String expectedVendorCategory) {
        String actualCategoryName = getSelectedVendorDetailResponse().getBody().getData().getCategoryName();
        assertTrue(!actualCategoryName.isEmpty(), "Vendor VendorCategoryName is not valid");
        assertEqual("Vendor category name not equal " + expectedVendorCategory, expectedVendorCategory,
                actualCategoryName);
    }

    @Then("I select product with order {int}")
    public void i_select_a_random_product(Integer index) {
        List<Product> products = getSelectedVendorCategoryProductsResponse().getBody().getData().getProducts();
        Product selectedProduct = products.get(index);
        getScenarioContext().setContext(Context.SELECTED_PRODUCT, selectedProduct);
    }

    @Then("I select a random available product from selected category")
    public void i_select_a_random_product() {
        List<Product> products = getSelectedVendorCategoryProductsResponse().getBody().getData().getProducts();
        int index = -1;
        Product selectedProduct;
        Random random = new Random();

        for (int i = 0; i <= products.size(); i++) {
            index = random.nextInt(products.size() - 1);
            selectedProduct = getSelectedVendorCategoryProductsResponse().getBody().getData().getProducts().get(index);
            if (selectedProduct.getIsActive() && selectedProduct.getMaximumSaleAmount() != 0) {
                break;
            }
        }

        Product product = getSelectedVendorCategoryProductsResponse().getBody().getData().getProducts().get(index);
        System.out.println(product.getName());
        getScenarioContext().setContext(Context.SELECTED_PRODUCT, product);
    }


    @Then("I select random available product for max stock")
    public void i_select_a_random_product_for_max_stock() {
        List<Product> products = getSelectedVendorProductList();
        int index = 0;
        for (Product product : products) {
            if (product.getMaximumSaleAmount() < 2147483647) {
                index = products.indexOf(product);
                break;
            }
        }
        Product product = products.get(index);
        getScenarioContext().setContext(Context.SELECTED_PRODUCT, product);

    }

    @Then("I select a random available product from selected category with price upper than is {double}")
    public void i_select_a_random_product_upper_than(double priceValue) {
        List<Product> products = getSelectedVendorProductList();

        int index = 0;
        for (Product product : products) {
            if (product.getPrice() > priceValue) {
                index = products.indexOf(product);
                break;
            }
        }

        Product product = products.get(index);
        getScenarioContext().setContext(Context.SELECTED_PRODUCT, product);
    }

    @Then("I select random {int} products")
    public void i_select_random_products(int size) {
        List<Product> products = getSelectedVendorProductList();
        List<String> selectedProductIdList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            selectedProductIdList.add(products.get(i).getId());
        }

        getScenarioContext().setContext(Context.SELECTED_PRODUCT_ID_LIST, selectedProductIdList);
    }

    @Then("I select product with name {string}")
    public void i_select_product_with_name(String productName) {
        List<Product> products = getSelectedVendorProductList();
        Product selectedProduct = null;

        for (Product product : products) {
            if (product.getName().contains(productName)) {
                selectedProduct = product;
                break;
            }
        }
        getScenarioContext().setContext(Context.SELECTED_PRODUCT, selectedProduct);
    }

    @Then("I check product list not empty")
    public void i_check_productList_not_empty() {
        List<Product> products = getSelectedVendorProductList();
        assertTrue(products.size() > 0, "Product list should not empty");
    }


    @Then("I navigate selected product")
    public void i_navigate_selected_product() {
        String basketId = (String) getScenarioContext().getContext(Context.BASKET_ID);
        String productId = getSelectedProduct().getId();
        String vendorId = getSelectedVendor().getId();

        IRestResponse<ProductResponse> productDetailResponse = getCarsiProductClient().getProduct(productId,
                vendorId, basketId);
        assertTrue(productDetailResponse.isSuccessful(), "Product detail response status should be Ok" + " not " + productDetailResponse.getStatusCode());
        Data productDetailProductResponseData = productDetailResponse.getBody().getData();
        getScenarioContext().setContext(Context.PRODUCT_DETAIL_DATA, productDetailProductResponseData);
        getScenarioContext().setContext(Context.PRODUCT_DETAIL_RESPONSE, productDetailResponse);
    }


    @Then("I check vendor logo url is valid")
    public void i_check_logo_url_is_valid() {
        IRestResponse<VendorResponse> vendorDetailResponse = getSelectedVendorDetailResponse();
        String expectedVendorLogoUrl = getSelectedVendor().getLogoUrl();
        String actualVendorLogoUrl = vendorDetailResponse.getBody().getData().getLogoUrl();
        assertTrue(expectedVendorLogoUrl.equalsIgnoreCase(actualVendorLogoUrl),
                "Vendor logo url not equal with selected vendor");
    }

    @Then("I check vendor logo url is {int}")
    public void i_check_logo_url_is_Status(int status) {
        IRestResponse<VendorResponse> vendorDetailResponse = getSelectedVendorDetailResponse();
        String vendorLogoUrl = vendorDetailResponse.getBody().getData().getLogoUrl();
        int statusCode = getCarsiVendorClient().getImageUrlResponse(vendorLogoUrl).statusCode();
        assertTrue(statusCode == status, "Vendor logo url should be " + status + "\n"
                + "Status : " + statusCode
                + "\n"
                + "Url : " + vendorLogoUrl);
    }

    @Then("I check vendor DeliveryTimeInfo is valid")
    public void i_check_DeliveryTimeInfo_is_valid() {
        String expectedVendorDeliveryTimeInfo = getSelectedVendor().getDeliveryTimeInfo();
        String actualVendorDeliveryTimeInfo = getSelectedVendorDetailResponse().getBody().getData().getDeliveryTimeInfo();
        assertNotNull(actualVendorDeliveryTimeInfo);
        assertEqual("Vendor DeliveryTimeInfo not equal with selected vendor(Home)",
                expectedVendorDeliveryTimeInfo, actualVendorDeliveryTimeInfo);
    }

    @Then("I check vendor MinBasketPriceInfo is valid")
    public void i_check_MinBasketPriceInfo_is_valid() {
        String expectedVendorMinBasketPrice = getSelectedVendor().getMinBasketPriceInfo();
        String actualVendorMinBasketPrice = getSelectedVendorDetailResponse().getBody().getData().getMinBasketPriceInfo();
        assertEqual("Vendor MinBasketPriceInfo not equal with selected vendor(Home)",
                expectedVendorMinBasketPrice, actualVendorMinBasketPrice);
    }

    @Then("I check vendor DeliveryFeeInfo is valid")
    public void i_check_DeliveryFeeInfo_is_valid() {
        String expectedVendorDeliveryFeeInfo = getSelectedVendor().getDeliveryFeeInfo();
        String actualVendorDeliveryFeeInfo = getSelectedVendorDetailResponse().getBody().getData().getDeliveryFeeInfo();

        assertEqual("Delivery fee should be equal selected vendor from home vendor list",
                expectedVendorDeliveryFeeInfo, actualVendorDeliveryFeeInfo);
    }

    @Then("I check vendor category list is valid")
    public void i_check_vendor_category_list_is_valid() {
        List<Category> categoryList = getSelectedVendorDetailResponse().getBody().getData().getCategories();
        assertTrue(categoryList.size() > 1, "Category listesi 1 den k??????k olamaz");
    }

    @Then("I check category names  are valid")
    public void i_check_categoryNames_are_valid() {
        List<Category> categoryList = getSelectedVendorDetailResponse().getBody().getData().getCategories();

        for (Category category : categoryList) {
            assertTrue(!category.getName().isEmpty(), "Category name should not empty");
        }

    }

    @Then("I check banner url is valid")
    public void i_check_bannerUrl_is_valid() {
        List<Banner> bannerList = getSelectedVendorDetailResponse().getBody().getData().getBanners();

        for (Banner banner : bannerList) {
            Response response = getCarsiVendorClient().getImageUrlResponse(banner.getImageUrl());
            assertTrue(response.statusCode() == 200,
                    "Banner image urls should be 200 not " + response.getStatusCode());
        }
    }

    @Then("I check banner seo urls are valid")
    public void i_check_seoUrl_are_valid() {
        List<Banner> bannerList = getSelectedVendorDetailResponse().getBody().getData().getBanners();

        for (Banner banner : bannerList) {
            String bannerDeeplinkUrl = banner.getDeeplinkUrl();
            assertTrue(!bannerDeeplinkUrl.isEmpty(), "Banner seo Url should not be empty");
        }
    }


    @Then("I should get {int} error on vendor detail")
    public void i_should_get_error(Integer error) {
        int status = getSelectedVendorDetailResponse().getStatusCode();
        assertTrue(status == error, "Vendor detail response status code should be "
                + error + " not " + status);
    }

    @Then("I should see selected product's id is not empty on vendor detail")
    public void i_should_see_selected_product_s_id_is_not_empty() {
        String id = getSelectedProduct().getId();
        assertNotNull(id, "Product id must not null");
    }

    @Then("I should see selected product's id is not empty on vendor product search")
    public void i_should_see_selected_product_s_id_is_not_empty_search() {
        Product selectedProduct = (Product) getScenarioContext().getContext(Context.SELECTED_SEARCHED_PRODUCT);
        String id = selectedProduct.getId();
        assertNotNull(id, "Product id must not null");
    }

    @Then("I check selected product's image url is {int} on vendor detail")
    public void i_check_selected_product_s_image_url_is(Integer status) {
        String imageUrl = getSelectedProduct().getImageUrl().get(0);
        assertNotNull(imageUrl, "Image url must not null");
        Response response = getCarsiVendorClient().getImageUrlResponse(imageUrl);

        int actualStatus = response.statusCode();
        assertTrue(actualStatus == status, "Vendor image url status should be " + status
                + "\n Not " + actualStatus);
    }

    @Then("I  check selected product's Price is valid on vendor detail")
    public void i_check_selected_product_s_price_is_valid() {
        double price = getSelectedProduct().getPrice();
        assertNotNull(price, "Product Price should not empty");
    }

    @Then("I  check selected product's Price is valid on vendor product search")
    public void i_check_selected_product_s_price_is_valid_product_search() {
        Product selectedProduct = (Product) getScenarioContext().getContext(Context.SELECTED_SEARCHED_PRODUCT);
        double price = selectedProduct.getPrice();
        assertNotNull(price, "Product Price should not empty");
    }

    @Then("I check selected product's MaximumSaleAmount is valid on vendor detail")
    public void i_check_selected_product_s_maximum_sale_amount_is_valid() {
        int maximumSaleAmount = getSelectedProduct().getMaximumSaleAmount();
        assertNotNull(maximumSaleAmount, "MaximumSaleAmount should not empty");
    }

    @Then("I check selected product's MaximumSaleAmount is valid on vendor product search")
    public void i_check_selected_product_s_maximum_sale_amount_is_valid_product_search() {
        Product selectedProduct = (Product) getScenarioContext().getContext(Context.SELECTED_SEARCHED_PRODUCT);
        int maximumSaleAmount = selectedProduct.getMaximumSaleAmount();
        assertNotNull(maximumSaleAmount, "MaximumSaleAmount should not empty");
    }

    @Then("I check selected product's IsActive is {string}")
    public void i_check_selected_product_s_maximum_sale_amount_is_valid(String productStatus) {
        boolean isActive = getSelectedProduct().getIsActive();
        if (productStatus.equalsIgnoreCase("True")) {
            assertTrue(isActive, "Poduct is active should be true");
        } else {
            assertFalse(isActive);
        }
    }

    @Then("I check selected product's HasOptions should be {string} on vendor detail")
    public void i_check_selected_product_s_has_options_is_valid(String hasOption) {
        Product selectedProduct = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        boolean expectedStatus = booleanValue(hasOption);
        boolean actualStatus = selectedProduct.getHasOptions();
        if (expectedStatus) {
            assertTrue(actualStatus, "Product HasOption should be true");
        } else {
            assertFalse(getSelectedProduct().getHasOptions());
        }
    }

    @Then("I check selected product's HasOptions should be {string} on vendor product search")
    public void i_check_selected_product_s_has_options_is_valid_product_search(String hasOption) {
        Product selectedProduct = (Product) getScenarioContext().getContext(Context.SELECTED_SEARCHED_PRODUCT);
        boolean expectedStatus = booleanValue(hasOption);
        boolean actualStatus = selectedProduct.getHasOptions();
        if (expectedStatus) {
            assertTrue(actualStatus, "Product HasOption should be true");
        } else {
            assertFalse(selectedProduct.getHasOptions());
        }
    }

    @When("I search an existing product and validate search results")
    public void i_search_an_existing_product() {
        i_choose_product_category_from_list_with_min_product_count(1);
        i_choose_random_available_sub_category();
        i_list_the_products_from_selected_sub_category();
        List<Product> productList = getSelectedVendorCategoryProductsResponse().getBody().getData().getProducts();
        Random rand = new Random();
        String randomProductName = productList.get(rand.nextInt(productList.size())).getName();
        i_search_on_vendor_product_search(randomProductName, 1);
        i_validate_related_search_result_is_valid_on_the_product_list_search_text_is(randomProductName);
    }

    @Then("I search {string} on vendor product search pageIndex {int}")
    public void i_search_on_vendor_product_search(String searchText, int pageIndex) {
        String vendorId = getSelectedVendor().getId();
        IRestResponse<VendorProductSearchResponse> vendorProductSearchResponse =
                getCarsiVendorClient().searchProduct(vendorId, searchText, pageIndex);

        getScenarioContext().setContext(Context.VENDOR_PRODUCT_SEARCH_RESPONSE, vendorProductSearchResponse);
    }

    @Then("I validate related search result is valid  on the product list  searchText is {string}")
    public void i_validate_related_search_result_is_valid_on_the_product_list_search_text_is(String searchText) {
        List<Product> searchResultProducts = getVendorProductSearchRes().getBody().getData();
        assertTrue(searchResultProducts.get(0).getName().contains(searchText), "Search result product's name not contain "
                + searchText);

    }

    @Then("I validate product search result is empty")
    public void i_validate_product_search_result_is_empty() {
        boolean productListIsEmpty = getVendorProductSearchRes().getBody().getData().isEmpty();
        assertTrue(productListIsEmpty, "Vendor product search result must empty");
    }

    @Then("I validate HasNext is {string}")
    public void i_validate_has_next_is(String hasNext) {
        boolean actualStatus = getVendorProductSearchRes().getBody().getHasNext();
        boolean expectedStatus = booleanValue(hasNext);
        if (expectedStatus) {
            assertTrue(actualStatus, "HasNext must be " + hasNext);
        } else {
            assertFalse(actualStatus);
        }

    }

    @Then("I validate HasPrev is {string}")
    public void i_validate_has_prev_is(String hasPrev) {
        boolean actualStatus = getVendorProductSearchRes().getBody().getHasPrev();
        boolean expectedStatus = booleanValue(hasPrev);
        if (expectedStatus) {
            assertTrue(actualStatus, "hasPrev must be " + hasPrev);
        } else {
            assertFalse(actualStatus);
        }
    }

    @Then("I validate Total count is {int}")
    public void i_validate_total_count_is_valid(int totaCount) {
        int actualTotalCount = getVendorProductSearchRes().getBody().getTotalCount();
        assertTrue(actualTotalCount == totaCount, "Total page count should be " + totaCount +
                " not " + actualTotalCount);
    }

    @Then("I validate search result Total count is valid")
    public void i_validate_total_count_is_not_empty() {
        int actualTotalCount = getVendorProductSearchRes().getBody().getTotalCount();
        assertTrue(actualTotalCount != 0, "Total product count greater than 0" +
                " not " + actualTotalCount);
    }

    @Then("I select a random available product from selected category on product search results")
    public void i_select_a_random_product_on_product_search() {
        List<Product> products = getVendorProductSearchRes().getBody().getData();

        Random random = new Random();
        int index = random.nextInt(products.size());
        Product product = products.get(index);
        getScenarioContext().setContext(Context.SELECTED_SEARCHED_PRODUCT, product);
    }

    @Then("I validate category product is listed with {int} products")
    public void i_validate_category_product_is_listed_with_products(Integer expectedProductSize) {
        List<Product> productList = getSelectedVendorCategoryProductsResponse().getBody().getData().getProducts();
        int actualProductSize = productList.size();
        assertTrue(actualProductSize == expectedProductSize,
                "Product list size should be " + expectedProductSize + " not " + actualProductSize);
    }

    @Then("I validate category HasNextPage is {string}")
    public void i_validate_category_has_next_page_is(String hasNextPageStatus) {
        boolean actualHasNextPage = getSelectedVendorCategoryProductsResponse().getBody().getData().getHasNextPage();

        if (hasNextPageStatus.equalsIgnoreCase("true")) {
            assertTrue(actualHasNextPage, "Has next page should be true");

        } else {
            assertTrue(!actualHasNextPage, "Has next page should be false");
        }
    }

    @Then("I validate category HasPrevPage {string}")
    public void i_validate_category_has_prev_page(String hasPrevPageStatus) {
        boolean actualHasPrevPage = getSelectedVendorCategoryProductsResponse().getBody().getData().getHasPrevPage();

        if (hasPrevPageStatus.equalsIgnoreCase("true")) {
            assertTrue(actualHasPrevPage, "HasPrevPage should be true");
        } else {
            assertTrue(!actualHasPrevPage, "HasPrevPage should be false");
        }
    }

    @Then("I validate category NextOffset is {int}")
    public void i_validate_category_next_offset_is(Integer expectedOffset) {
        int actualNextOffset = getSelectedVendorCategoryProductsResponse().getBody().getData().getNextOffset();
        assertTrue(actualNextOffset == expectedOffset,
                "NextOffset should be " + expectedOffset + " not " + actualNextOffset);
    }

    @When("I list sub category products with offset {int}")
    public void i_list_next_sub_category_page_offset(Integer offset) {
        String categoryId = getSelectedCategory().getId();
        String vendorId = getSelectedVendor().getId();
        IRestResponse<VendorProductsResponse> vendorProductResponse = getCarsiVendorClient().getProducts(vendorId,
                categoryId
                , offset);

        getScenarioContext().setContext(Context.VENDOR_CATEGORY_PRODUCTS_RES, vendorProductResponse);
    }

    @Then("I can validate PrevOffset is {int}")
    public void i_can_validate_prev_offset_is(Integer expectedPrevOffset) {
        int actualPrevOffset = getSelectedVendorCategoryProductsResponse().getBody().getData().getPrevOffset();
        assertTrue(actualPrevOffset == expectedPrevOffset,
                "PrevOffset should be " + expectedPrevOffset + " not " + actualPrevOffset);
    }

    @Then("I can validate CurrentOffset is {int}")
    public void i_can_validate_current_offset_is(Integer expectedCurrentOffset) {
        int actualCurrentOffset = getSelectedVendorCategoryProductsResponse().getBody().getData().getCurrentOffset();
        assertTrue(actualCurrentOffset == expectedCurrentOffset,
                "CurrentOffset should be " + expectedCurrentOffset + " not " + actualCurrentOffset);
    }


}