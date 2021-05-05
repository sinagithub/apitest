package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.PlatformTypeHelper;
import apiEngine.models.requests.Favorite.AddFavoriteProductRequest;
import apiEngine.models.requests.Favorite.AddFavoriteVendorRequest;
import apiEngine.models.response.Address;
import apiEngine.models.response.Basket.AddProductResponse;
import apiEngine.models.response.CarsiVendor;
import apiEngine.models.response.Favorite.GetFavoritesResponse;
import apiEngine.models.response.Favorite.Vendor;
import apiEngine.models.response.Favorite.VendorFavoriteResponse;
import apiEngine.models.response.Favorite.VendorPutFavoriteResponse;
import apiEngine.models.response.Vendor.Product;
import apiEngine.models.response.Vendor.VendorProductSearchResponse;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.tr.Ve;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class FavoriteSteps extends BaseSteps {
    List<String> addedVendorIdList = new ArrayList<>();
    List<String> productIdList = new ArrayList<>();

    public FavoriteSteps(TestContext testContext) {
        super(testContext);
    }


    @When("I get all favorite vendor list")
    public void i_get_all_favorite_vendors() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        double lat = address.getLatitude();
        double lng = address.getLongitude();

        IRestResponse<GetFavoritesResponse> geFavoriteListResponse =
                getCarsiFavoriteClient().getFavoriteList(lat, lng);
        List<Vendor> vendorList = geFavoriteListResponse.getBody().getData().getVendors();
        getScenarioContext().setContext(Context.FAVORITE_VENDOR_LIST, vendorList);

    }

    @When("I get vendor favorite list")
    public void i_get_favorite_vendor_product_list() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        double lat = address.getLatitude();
        double lng = address.getLongitude();

        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String vendorId = selectedVendor.getId();


        IRestResponse<GetFavoritesResponse> geFavoriteListResponse =
                getCarsiFavoriteClient().getFavoriteList(lat, lng);
        List<Vendor> vendorList = geFavoriteListResponse.getBody().getData().getVendors();

        for (Vendor vendor : vendorList) {
            if (vendor.getId().equalsIgnoreCase(vendorId)) {
                String platformType = vendor.getPlatformType();
                PlatformTypeHelper.getInstance().setPlatformType(platformType);
                IRestResponse<VendorFavoriteResponse> getVendorFavoriteListResponse =
                        getCarsiFavoriteClient().getFavoriteVendorDetail(vendorId, lat, lng);
                getScenarioContext().setContext(Context.GET_VENDOR_FAVORITE_PRODUCTS_RESPONSE,
                        getVendorFavoriteListResponse);
            }


        }


    }

    @When("I get Favorite list")
    public void i_get_favorite_list() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        double lat = address.getLatitude();
        double lng = address.getLongitude();

        IRestResponse<GetFavoritesResponse> getFavoriteListResponse = getCarsiFavoriteClient().getFavoriteList(lat,
                lng);
        getScenarioContext().setContext(Context.GET_FAVORITE_VENDORS_RESPONSE, getFavoriteListResponse);
    }

    @Then("I can see the favorite list is empty")
    public void user_can_see_the_favorite_list_is_empty() {
        IRestResponse<GetFavoritesResponse> getFavoritesResponse =
                (IRestResponse<GetFavoritesResponse>) getScenarioContext().getContext(Context.GET_FAVORITE_VENDORS_RESPONSE);
        List<Vendor> vendorList = getFavoritesResponse.getBody().getData().getVendors();
        int vendorListSize = vendorList.size();
        assertTrue(vendorListSize == 0, "Favorite Vendor list should be empty not " + vendorListSize);

    }

    @Then("I can validate favorite vendor  size is {int} on favorite list")
    public void i_can_validate_favorite_product_size_is(Integer size) {
        IRestResponse<GetFavoritesResponse> getFavoritesResponse =
                (IRestResponse<GetFavoritesResponse>) getScenarioContext().getContext(Context.GET_FAVORITE_VENDORS_RESPONSE);
        List<Vendor> vendorList = getFavoritesResponse.getBody().getData().getVendors();
        int vendorListSize = vendorList.size();
        assertTrue(vendorListSize == size, "Favorite Vendor list size should be " + size + " not " +
                vendorListSize);

    }

    @Then("I can validate vendor favorite product size is {int} on vendor vendor favorites list")
    public void i_can_validate_vendor_favorite_products_size_is(Integer size) {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        double lat = address.getLatitude();
        double lng = address.getLatitude();
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String vendorId = selectedVendor.getId();


        IRestResponse<VendorFavoriteResponse> vendorFavoriteResponseResponse =
                getCarsiFavoriteClient().getFavoriteVendorDetail(vendorId, lat, lng);
        List<apiEngine.models.response.Favorite.Product> productList =
                vendorFavoriteResponseResponse.getBody().getData().getProducts();
        int productListSize = productList.size();
        assertTrue(productListSize == size, "Vendor Favorite list size should be " + size + " not " +
                productListSize);

    }

    private void addFavoriteListOnTheStorage(String addedVendorId) {
        addedVendorIdList.add(addedVendorId);
        getScenarioContext().setContext(Context.ADDED_FAVORITE_VENDOR_ID_LIST, addedVendorIdList);
    }

    @Then("I add selected vendor to favorite list")
    public void i_add_selected_vendor_to_favorite_list() {
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String vendorId = selectedVendor.getId();
        AddFavoriteVendorRequest addFavoriteVendorRequest = new AddFavoriteVendorRequest(vendorId);
        IRestResponse<VendorPutFavoriteResponse> addFavoriteVendor =
                getCarsiFavoriteClient().addVendorToFavorite(addFavoriteVendorRequest);

        boolean resultStatus = addFavoriteVendor.getBody().getData();
        if (resultStatus) {
            addFavoriteListOnTheStorage(vendorId);
        }
        assertTrue(resultStatus, "Add favorite status should be true");
    }

    private boolean isVendorOnTheFavoriteList(String vendorId) {
        IRestResponse<GetFavoritesResponse> getFavoritesResponse =
                (IRestResponse<GetFavoritesResponse>) getScenarioContext().getContext(Context.GET_FAVORITE_VENDORS_RESPONSE);
        List<Vendor> vendorList = getFavoritesResponse.getBody().getData().getVendors();

        for (Vendor vendor : vendorList) {
            if (vendor.getId().equals(vendorId)) {
                return true;
            }
        }
        return false;

    }


    @Then("I can see the added vendor on the favorite list")
    public void i_can_see_the_added_vendor_on_the_favorite_list() {
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String addedVendorId = selectedVendor.getId();
        assertTrue(isVendorOnTheFavoriteList(addedVendorId), "Vendor not on the favorite list !");
    }

    @When("I remove the added vendor from favorite list")
    public void i_remove_the_added_vendor_from_favorite_list() {
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        double lat = address.getLatitude();
        double lng = address.getLongitude();
        String vendorId = selectedVendor.getId();
        getCarsiFavoriteClient().deleteFavoriteVendor(vendorId, lat, lng);
    }

    @Then("I can validate the vendor is removed on the favorite list")
    public void i_can_validate_the_vendor_is_removed_on_the_favorite_list() {
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String vendorId = selectedVendor.getId();
        assertFalse(isVendorOnTheFavoriteList(vendorId));
    }

    @Then("I can add the selected product to favorites")
    public void i_can_add_the_selected_product_to_favorites() {
        Product selectedProduct = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String productId = selectedProduct.getId();
        String vendorId = selectedVendor.getId();

        AddFavoriteProductRequest addFavoriteProductRequest = new AddFavoriteProductRequest(productId);
        getCarsiFavoriteClient().addProductToFavorite(vendorId, addFavoriteProductRequest);
        productIdList.add(productId);
    }

    @Then("I can add all selected product to favorites")
    public void i_can_add_all_selected_product_to_favorites() {
        List<String> productIdList = (List<String>) getScenarioContext().getContext(Context.SELECTED_PRODUCT_ID_LIST);
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String vendorId = selectedVendor.getId();

        for (int i = 0; i < productIdList.size(); i++) {
            String productId = productIdList.get(i);
            AddFavoriteProductRequest addFavoriteProductRequest = new AddFavoriteProductRequest(productId);
            getCarsiFavoriteClient().addProductToFavorite(vendorId, addFavoriteProductRequest);
        }
    }

    private boolean isProductOnTheFavoriteList(String vendorId, String productId) {
        IRestResponse<GetFavoritesResponse> getFavoritesResponse =
                (IRestResponse<GetFavoritesResponse>) getScenarioContext().getContext(Context.GET_FAVORITE_VENDORS_RESPONSE);
        List<Vendor> vendorList = getFavoritesResponse.getBody().getData().getVendors();

        int index = -1;
        for (Vendor vendor : vendorList) {
            if (vendor.getId().equals(vendorId)) {
                index = vendorList.indexOf(vendor);
            }
        }
        List<apiEngine.models.response.Favorite.Product> productList = vendorList.get(index).getProducts();

        for (apiEngine.models.response.Favorite.Product product : productList) {
            if (product.getId().equalsIgnoreCase(productId)) {
                return true;
            }
        }
        return false;
    }

    @Then("I can see the product on the favorite list")
    public void i_can_see_the_product_on_the_favorite_list() {
        Product selectedProduct = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String productId = selectedProduct.getId();
        String vendorId = selectedVendor.getId();
        assertTrue(isProductOnTheFavoriteList(vendorId, productId), "Added favorite product should be on list");
    }

    private boolean isProductOnTheVendorDetailList(String vendorId, double lat, double lng, String productId) {
        List<apiEngine.models.response.Favorite.Product> productList =
                getCarsiFavoriteClient().getFavoriteVendorDetail(vendorId, lat, lng).getBody().getData().getProducts();

        for (apiEngine.models.response.Favorite.Product product : productList) {
            if (product.getId().equalsIgnoreCase(productId)) {
                return true;
            }

        }
        return false;
    }

    @Then("I can see the product is favorite on vendor detail")
    public void i_can_see_the_product_is_favorite_on_vendor_detail() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        double lat = address.getLatitude();
        double lng = address.getLatitude();
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String vendorId = selectedVendor.getId();
        Product selectedProduct = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        String productId = selectedProduct.getId();

        assertTrue(isProductOnTheVendorDetailList(vendorId, lat, lng, productId), "Product should be on the vendor " +
                "favorite list");

    }

    @When("I remove added product on favorite list")
    public void i_remove_added_product_on_favorite_list() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        double lat = address.getLatitude();
        double lng = address.getLongitude();
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String vendorId = selectedVendor.getId();
        Product selectedProduct = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        String productId = selectedProduct.getId();
        String platformType = PlatformTypeHelper.getInstance().getPlatformType();
        getCarsiFavoriteClient().deleteFavoriteProduct(productId, vendorId, platformType, lat, lng);
    }

    @Then("I can validate product is deleted vendor detail favorite")
    public void i_can_validate_product_is_deleted_vendor_detail_favorite() {
        i_get_favorite_list();
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        double lat = address.getLatitude();
        double lng = address.getLatitude();
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        String vendorId = selectedVendor.getId();
        Product selectedProduct = (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
        String productId = selectedProduct.getId();
        assertFalse(isProductOnTheVendorDetailList(vendorId, lat, lng, productId));

    }


    @Then("I delete all added favorite products")
    public void i_delete_all_added_favorite_products() {
        String basePlatformType = PlatformTypeHelper.getInstance().getPlatformType();
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        double lat = address.getLatitude();
        double lng = address.getLongitude();


        List<Vendor> vendorList = (List<Vendor>) getScenarioContext().getContext(Context.FAVORITE_VENDOR_LIST);

        for (Vendor vendor : vendorList) {
            String vendorId = vendor.getId();
            String vendorType = vendor.getPlatformType();


            if (vendorType.equalsIgnoreCase("1")) {
                PlatformTypeHelper.getInstance().setPlatformType("Carsi");
            } else {
                PlatformTypeHelper.getInstance().setPlatformType("Banabi");
            }

            IRestResponse<VendorFavoriteResponse> getVendorFavoriteListResponse =
                    getCarsiFavoriteClient().getFavoriteVendorDetail(vendorId, lat,
                            lng);

            List<apiEngine.models.response.Favorite.Product> productList =
                    getVendorFavoriteListResponse.getBody().getData().getProducts();

            for (apiEngine.models.response.Favorite.Product product : productList) {
                String productId = product.getId();
//adsad
                getCarsiFavoriteClient().deleteFavoriteProduct(productId, vendorId, vendorType, lat, lng);
            }

        }
        setCurrentPlatformType(basePlatformType);
    }

    @Then("I delete all vendor")
    public void i_delete_all_added_vendor() {
        Address address = (Address) getScenarioContext().getContext(Context.ADDRESS);
        double lat = address.getLatitude();
        double lng = address.getLongitude();
        IRestResponse<GetFavoritesResponse> getFavoritesResponse =
                (IRestResponse<GetFavoritesResponse>) getScenarioContext().getContext(Context.GET_FAVORITE_VENDORS_RESPONSE);
        List<Vendor> vendorList = getFavoritesResponse.getBody().getData().getVendors();

        for (Vendor vendor : vendorList) {
            String vendorId = vendor.getId();
            getCarsiFavoriteClient().deleteFavoriteVendor(vendorId, lat, lng);
        }

    }
}