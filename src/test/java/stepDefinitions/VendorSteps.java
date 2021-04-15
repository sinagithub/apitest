package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.models.response.*;
import apiEngine.models.response.Vendor.Category;
import apiEngine.models.response.Vendor.SubCategory;
import apiEngine.models.response.Vendor.VendorProductsResponse;
import apiEngine.models.response.Vendor.VendorResponse;
import clients.carsi.CarsiVendorClient;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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


    @Then("I list the products")
    public void i_list_the_products() {


    }


}
