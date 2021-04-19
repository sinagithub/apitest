package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.models.response.*;
import apiEngine.models.response.Vendor.Category;
import apiEngine.models.response.Vendor.SubCategory;
import apiEngine.models.response.Vendor.VendorProductsResponse;
import apiEngine.models.response.Vendor.VendorResponse;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

@SuppressWarnings("unchecked")
public class VendorSteps extends BaseSteps {

    public VendorSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("I navigate selected vendor")
    public void i_navigate_selected_vendor() {
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String vendorId = selectedVendor.getId();
        IRestResponse<VendorResponse> vendorResponse = getCarsiVendorClient().getVendor(vendorId);
        getScenarioContext().setContext(Context.VENDOR_DETAIL_RESPONSE, vendorResponse);
    }

    @Then("I navigate vendor with {string}")
    public void i_navigate_vendor_with_id(String vendorId) {
        IRestResponse<VendorResponse> vendorResponse = getCarsiVendorClient().getVendor(vendorId);
        getScenarioContext().setContext(Context.VENDOR_DETAIL_RESPONSE, vendorResponse);
    }


    @Then("I choose {string} product category from category list")
    public void i_choose_product_category_from_list(String categoryName) {
        IRestResponse<VendorResponse> vendorResponse =
                (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);

        List<Category> vendorCategories = vendorResponse.getBody().getData().getCategories();
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

    @Then("I choose {string} sub category from sub category")
    public void i_choose_sub_category_from_main_category(String subCategoryName) {
        Category selectedCategory = (Category) getScenarioContext().getContext(Context.SELECTED_PRODUCT_CATEGORY);
        List<SubCategory> subCategoryList = selectedCategory.getSubCategories();
        SubCategory selectedSubCategory = null;

        for (SubCategory subCategory : subCategoryList) {
            if (subCategory.getName().equalsIgnoreCase(subCategoryName)) {
                selectedSubCategory = subCategory;
            }
            break;
        }

        if (selectedCategory != null) {
            getScenarioContext().setContext(Context.SELECTED_SUB_PRODUCT_CATEGORY, selectedSubCategory);
        } else {
            Assert.fail(subCategoryName + " not found on the selected sub category");
        }
    }

    @When("I list the products from selected sub category")
    public void i_list_the_products_from_selected_sub_category() {
        Category selectedCategory = (Category) getScenarioContext().getContext(Context.SELECTED_PRODUCT_CATEGORY);
        SubCategory selectedSubCategory =
                (SubCategory) getScenarioContext().getContext(Context.SELECTED_SUB_PRODUCT_CATEGORY);
        String categoryId = selectedCategory.getId();
        Integer offSet = selectedSubCategory.getOffset();

        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String vendorId = selectedVendor.getId();
        IRestResponse<VendorProductsResponse> vendorProductResponse = getCarsiVendorClient().getProducts(vendorId,
                categoryId
                , offSet);
        getScenarioContext().setContext(Context.VENDOR_CATEGORY_PRODUCTS_RES, vendorProductResponse);
    }

    @Then("I check vendor name is valid")
    public void i_check_vendor_name_is_valid() {
        IRestResponse<VendorResponse> vendorDetailResponse =
                (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String expectedVendorName = selectedVendor.getName();
        String actualVendorName = vendorDetailResponse.getBody().getData().getName();
        assertTrue(!actualVendorName.isEmpty(), "Vendor VendorCategoryName should not null");
        assertTrue(expectedVendorName.equalsIgnoreCase(actualVendorName), "Vendor name not equal with selected vendor");

    }

    @Then("I check vendor category name is not empty")
    public void i_check_category_name_is_valid() {
        IRestResponse<VendorResponse> vendorDetailResponse =
                (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String expectedVendorCategoryName = selectedVendor.getCategoryName();
        String actualCategoryName = vendorDetailResponse.getBody().getData().getCategoryName();
        assertTrue(!actualCategoryName.isEmpty(), "Vendor VendorCategoryName should not null");
        assertTrue(expectedVendorCategoryName.equalsIgnoreCase(actualCategoryName), "Vendor category name not equal " +
                "with selected vendor");

    }

    @Then("I check vendor logo url is valid")
    public void i_check_logo_url_is_valid() {
        IRestResponse<VendorResponse> vendorDetailResponse =
                (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String expectedVendorLogoUrl = selectedVendor.getLogoUrl();
        String actualVendorLogoUrl = vendorDetailResponse.getBody().getData().getLogoUrl();

        assertTrue(expectedVendorLogoUrl.equalsIgnoreCase(actualVendorLogoUrl), "Vendor logo url not equal with " +
                "selected vendor");
    }

    @Then("I check vendor logo url is 200")
    public void i_check_logo_url_is_StatusOk() {
        IRestResponse<VendorResponse> vendorDetailResponse =
                (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
        String vendorLogoUrl = vendorDetailResponse.getBody().getData().getLogoUrl();
        int statusCode = getCarsiVendorClient().getImageUrlResponse(vendorLogoUrl).statusCode();
        assertTrue(statusCode == 200, "Vendor logo url should be 200 \n"
                + "Status : " + statusCode
                + "\n"
                + "Url : " + vendorLogoUrl);
    }

    @Then("I check vendor DeliveryTimeInfo is valid")
    public void i_check_DeliveryTimeInfo_is_valid() {
        IRestResponse<VendorResponse> vendorDetailResponse =
                (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String expectedVendorDeliveryTimeInfo = selectedVendor.getDeliveryTimeInfo();
        String actualVendorDeliveryTimeInfo = vendorDetailResponse.getBody().getData().getDeliveryTimeInfo();
        assertTrue(!actualVendorDeliveryTimeInfo.isEmpty(), "Vendor Delivery Time should not null");
        assertTrue(expectedVendorDeliveryTimeInfo.equalsIgnoreCase(actualVendorDeliveryTimeInfo),
                "Vendor DeliveryTimeInfo not equal with selected vendor(Home) "
                        + expectedVendorDeliveryTimeInfo
                        + " -- "
                        + actualVendorDeliveryTimeInfo);
    }

    @Then("I check vendor MinBasketPriceInfo is valid")
    public void i_check_MinBasketPriceInfo_is_valid() {
        IRestResponse<VendorResponse> vendorDetailResponse =
                (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String expectedVendorMinBasketPrice = selectedVendor.getMinBasketPriceInfo();
        String actualVendorMinBasketPrice = vendorDetailResponse.getBody().getData().getMinBasketPriceInfo();

        assertTrue(expectedVendorMinBasketPrice.equalsIgnoreCase(actualVendorMinBasketPrice),
                "Vendor MinBasketPriceInfo not equal with selected vendor(Home) "
                        + expectedVendorMinBasketPrice
                        + " -- "
                        + actualVendorMinBasketPrice);
    }

    @Then("I check vendor DeliveryFeeInfo is valid")
    public void i_check_DeliveryFeeInfo_is_valid() {
        IRestResponse<VendorResponse> vendorDetailResponse =
                (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String expectedVendorDeliveryFeeInfo = selectedVendor.getDeliveryFeeInfo();
        String actualVendorDeliveryFeeInfo = vendorDetailResponse.getBody().getData().getDeliveryFeeInfo();

        assertTrue(expectedVendorDeliveryFeeInfo.equalsIgnoreCase(actualVendorDeliveryFeeInfo),
                "Vendor DeliveryFeeInfo not equal with selected vendor(Home) "
                        + expectedVendorDeliveryFeeInfo
                        + " -- "
                        + actualVendorDeliveryFeeInfo);
    }

    @Then("I check vendor category list is valid")
    public void i_check_vendor_category_list_is_valid() {
        IRestResponse<VendorResponse> vendorDetailResponse =
                (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
        List<Category> categoryList = vendorDetailResponse.getBody().getData().getCategories();
        assertTrue(categoryList.size() > 1, "Category listesi 1 den küçük olamaz");
    }

    @Then("I check category names  are valid")
    public void i_check_categoryNames_are_valid() {
        IRestResponse<VendorResponse> vendorDetailResponse =
                (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
        List<Category> categoryList = vendorDetailResponse.getBody().getData().getCategories();

        for (Category category : categoryList) {
            assertTrue(!category.getName().isEmpty(), "Category name should not empty");
        }

    }

    @Then("I check banner url is valid")
    public void i_check_bannerUrl_is_valid() {
        IRestResponse<VendorResponse> vendorDetailResponse =
                (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
        List<Banner> bannerList = vendorDetailResponse.getBody().getData().getBanners();

        for (Banner banner : bannerList) {
            Response response = getCarsiVendorClient().getImageUrlResponse(banner.getImageUrl());
            assertTrue(response.statusCode() == 200,
                    "Banner image urls should be 200 not " + response.getStatusCode());
        }
    }

    @Then("I check banner seo urls are valid")
    public void i_check_seoUrl_are_valid() {
        IRestResponse<VendorResponse> vendorDetailResponse =
                (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
        List<Banner> bannerList = vendorDetailResponse.getBody().getData().getBanners();

        for (Banner banner : bannerList) {
            String bannerSeoUrl = banner.getSeoUrl();
            assertTrue(bannerSeoUrl.isEmpty(), "Banner seo Url should not be empty");
        }
    }

    @ParameterType(value = "true|True|TRUE|false|False|FALSE")
    public Boolean booleanValue(String value) {
        return Boolean.valueOf(value);
    }

    @Then("I check vendor status should be {booleanValue}")
    public void i_check_vendor_status(boolean vendorStatus) {
        IRestResponse<VendorResponse> vendorDetailResponse =
                (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
        boolean actualVendorStatus = vendorDetailResponse.getBody().getData().getOpen();

        assertTrue(actualVendorStatus == vendorStatus,"Vendor status should be "
                + vendorStatus + " not " + actualVendorStatus);
    }

    @Then("I should get {int} error on vendor detail")
    public void i_should_get_error(Integer error) {
        IRestResponse<VendorResponse> vendorDetailResponse =
                (IRestResponse<VendorResponse>) getScenarioContext().getContext(Context.VENDOR_DETAIL_RESPONSE);
        int status = vendorDetailResponse.getStatusCode();
        assertTrue(status == error, "Vendor detail response status code should be "
                + error + " not " + status);
    }


}