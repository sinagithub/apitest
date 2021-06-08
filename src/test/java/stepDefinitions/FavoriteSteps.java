package stepDefinitions;


import apiEngine.IRestResponse;
import apiEngine.PlatformTypeHelper;
import apiEngine.models.requests.Favorite.AddFavoriteProductRequest;
import apiEngine.models.requests.Favorite.AddFavoriteVendorRequest;
import apiEngine.models.response.CarsiVendor;
import apiEngine.models.response.Favorite.GetFavoritesResponse;
import apiEngine.models.response.Favorite.Vendor;
import apiEngine.models.response.Favorite.VendorFavoriteResponse;
import apiEngine.models.response.Favorite.VendorPutFavoriteResponse;
import apiEngine.models.response.Vendor.Product;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class FavoriteSteps extends BaseSteps {
    List<String> addedVendorIdList = new ArrayList<>();
    List<String> productIdList = new ArrayList<>();

    public FavoriteSteps(TestContext testContext) {
        super(testContext);
    }

    private String getSelectedVendorId() {
        CarsiVendor selectedVendor = (CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR);
        return selectedVendor.getId();
    }

    private Product getSelectedProduct() {
        return (Product) getScenarioContext().getContext(Context.SELECTED_PRODUCT);
    }

    private CarsiVendor getSelectedVendor() {
        return ((CarsiVendor) getScenarioContext().getContext(Context.SELECTED_VENDOR));
    }

    private IRestResponse<GetFavoritesResponse> getFavoritesResponse() {
        return (IRestResponse<GetFavoritesResponse>) getScenarioContext().getContext(Context.GET_FAVORITE_VENDORS_RESPONSE);
    }

    private List<Vendor> getFavoriteVendorList() {
        return getFavoritesResponse().getBody().getData().getVendors();
    }

    @When("I get all favorite vendor list")
    public void i_get_all_favorite_vendors() {
        IRestResponse<GetFavoritesResponse> geFavoriteListResponse =
                getCarsiFavoriteClient().getFavoriteList();
        List<Vendor> vendorList = geFavoriteListResponse.getBody().getData().getVendors();
        getScenarioContext().setContext(Context.FAVORITE_VENDOR_LIST, vendorList);

    }

    @When("I get vendor favorite list")
    public void i_get_favorite_vendor_product_list() {
        String vendorId = getSelectedVendorId();
        IRestResponse<GetFavoritesResponse> geFavoriteListResponse =
                getCarsiFavoriteClient().getFavoriteList();
        List<Vendor> vendorList = geFavoriteListResponse.getBody().getData().getVendors();

        for (Vendor vendor : vendorList) {
            if (vendor.getId().equalsIgnoreCase(vendorId)) {
                String platformType = vendor.getPlatformType();
                PlatformTypeHelper.getInstance().setPlatformType(platformType);
                IRestResponse<VendorFavoriteResponse> getVendorFavoriteListResponse =
                        getCarsiFavoriteClient().getFavoriteVendorDetail(vendorId);
                getScenarioContext().setContext(Context.GET_VENDOR_FAVORITE_PRODUCTS_RESPONSE,
                        getVendorFavoriteListResponse);
            }
        }
    }

    @When("I get Favorite list")
    public void i_get_favorite_list() {
        IRestResponse<GetFavoritesResponse> getFavoriteListResponse = getCarsiFavoriteClient().getFavoriteList();
        getScenarioContext().setContext(Context.GET_FAVORITE_VENDORS_RESPONSE, getFavoriteListResponse);
        getScenarioContext().setContext(Context.GET_FAVORITE_VENDORS_LIST,
                getFavoriteListResponse.getBody().getData().getVendors());
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
        List<Vendor> vendorList = getFavoritesResponse().getBody().getData().getVendors();
        int vendorListSize = vendorList.size();
        assertTrue(vendorListSize == size, "Favorite Vendor list size should be " + size + " not " +
                vendorListSize);

    }

    @Then("I can validate favorite vendor product size is {int} on favorite list")
    public void i_can_validate_favorite_product_size_is_on_favorite_list(Integer size) {
        IRestResponse<GetFavoritesResponse> getFavoritesResponse =
                (IRestResponse<GetFavoritesResponse>) getScenarioContext().getContext(Context.GET_FAVORITE_VENDORS_RESPONSE);
        List<Vendor> vendorList = getFavoritesResponse.getBody().getData().getVendors();
        String vendorId = getSelectedVendorId();

        for (Vendor vendor : vendorList) {
            if (vendor.getId().equalsIgnoreCase(vendorId)) {
                int productSize = vendor.getProducts().size();
                assertTrue(productSize == size, "Product size should be " + size + " not " + productSize);
            }
        }
    }

    @Then("I validate vendor favorite product size is {int} on vendor favorites list")
    public void i_can_validate_vendor_favorite_products_size_is(Integer size) {
        String vendorId = getSelectedVendorId();
        IRestResponse<VendorFavoriteResponse> vendorFavoriteResponseResponse =
                getCarsiFavoriteClient().getFavoriteVendorDetail(vendorId);
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
        String vendorId = getSelectedVendorId();
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
        List<Vendor> vendorList = getFavoriteVendorList();
        for (Vendor vendor : vendorList) {
            if (vendor.getId().equals(vendorId)) {

                return true;
            }
        }
        return false;

    }

    private boolean isBanabiOnTheFavoriteList(String vendorName) {
        List<Vendor> vendorList = getFavoriteVendorList();
        for (Vendor vendor : vendorList) {
            if (vendor.getName().equals(vendorName)) {

                return true;
            }
        }
        return false;

    }


    @Then("I can see the added vendor on the favorite list")
    public void i_can_see_the_added_vendor_on_the_favorite_list() {
        String addedVendorId = getSelectedVendorId();
        assertTrue(isVendorOnTheFavoriteList(addedVendorId), "Vendor not on the favorite list !");
    }

    @Then("I can see the added banabi vendor on the favorite list")
    public void i_can_see_the_added_banabi_vendor_on_the_favorite_list() {
        String addedVendorName = getSelectedVendor().getName();
        assertTrue(isBanabiOnTheFavoriteList(addedVendorName), "Banabi Vendor not on the favorite list !");
    }

    private void setVendorPlatformType(String vendorId) {
        List<Vendor> vendorList = getCarsiFavoriteClient().getFavoriteList().getBody().getData().getVendors();
        for (Vendor vendor : vendorList) {
            if (vendor.getId().equalsIgnoreCase(vendorId)) {
                if (vendor.getPlatformType().equalsIgnoreCase("1")) {
                    PlatformTypeHelper.getInstance().setPlatformType("Carsi");
                } else if (vendor.getPlatformType().equalsIgnoreCase("2")) {
                    PlatformTypeHelper.getInstance().setPlatformType("Banabi");
                }

            }
        }
    }

    @When("I remove the added vendor from favorite list")
    public void i_remove_the_added_vendor_from_favorite_list() {
        String vendorId = getSelectedVendorId();
        setVendorPlatformType(vendorId);
        getCarsiFavoriteClient().deleteFavoriteVendor(vendorId);
    }

    @Then("I can validate the vendor is removed on the favorite list")
    public void i_can_validate_the_vendor_is_removed_on_the_favorite_list() {
        String vendorId = getSelectedVendorId();
        assertFalse(isVendorOnTheFavoriteList(vendorId));
    }

    @Then("I can add the selected product to favorites")
    public void i_can_add_the_selected_product_to_favorites() {
        Product selectedProduct = getSelectedProduct();
        String productId = selectedProduct.getId();
        String vendorId = getSelectedVendorId();
        AddFavoriteProductRequest addFavoriteProductRequest = new AddFavoriteProductRequest(productId);
        getCarsiFavoriteClient().addProductToFavorite(vendorId, addFavoriteProductRequest);
        productIdList.add(productId);
    }

    @Then("I can add all selected product to favorites")
    public void i_can_add_all_selected_product_to_favorites() {
        List<String> productIdList = (List<String>) getScenarioContext().getContext(Context.SELECTED_PRODUCT_ID_LIST);
        String vendorId = getSelectedVendorId();
        for (int i = 0; i < productIdList.size(); i++) {
            String productId = productIdList.get(i);
            AddFavoriteProductRequest addFavoriteProductRequest = new AddFavoriteProductRequest(productId);
            getCarsiFavoriteClient().addProductToFavorite(vendorId, addFavoriteProductRequest);
        }
    }

    private boolean isProductOnTheFavoriteList(String vendorId, String productId) {
        List<Vendor> vendorList = getFavoriteVendorList();

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
        Product selectedProduct = getSelectedProduct();
        String productId = selectedProduct.getId();
        String vendorId = getSelectedVendorId();
        assertTrue(isProductOnTheFavoriteList(vendorId, productId), "Added favorite product should be on list");
    }

    private boolean isProductOnTheVendorDetailList(String vendorId, String productId) {
        List<apiEngine.models.response.Favorite.Product> productList =
                getCarsiFavoriteClient().getFavoriteVendorDetail(vendorId).getBody().getData().getProducts();

        for (apiEngine.models.response.Favorite.Product product : productList) {
            if (product.getId().equalsIgnoreCase(productId)) {
                return true;
            }

        }
        return false;
    }

    @Then("I can see the product is favorite on vendor detail")
    public void i_can_see_the_product_is_favorite_on_vendor_detail() {
        String vendorId = getSelectedVendorId();
        Product selectedProduct = getSelectedProduct();
        String productId = selectedProduct.getId();
        assertTrue(isProductOnTheVendorDetailList(vendorId, productId), "Product should be on the vendor " +
                "favorite list");
    }

    @When("I remove added product on favorite list")
    public void i_remove_added_product_on_favorite_list() {
        String vendorId = getSelectedVendorId();
        Product selectedProduct = getSelectedProduct();
        String productId = selectedProduct.getId();
        getCarsiFavoriteClient().deleteFavoriteProduct(productId, vendorId);
    }

    @Then("I can validate product is deleted vendor detail favorite")
    public void i_can_validate_product_is_deleted_vendor_detail_favorite() {
        i_get_favorite_list();
        String vendorId = getSelectedVendorId();
        Product selectedProduct = getSelectedProduct();
        String productId = selectedProduct.getId();
        assertFalse(isProductOnTheVendorDetailList(vendorId, productId));

    }


    @Then("I delete all added favorite products")
    public void i_delete_all_added_favorite_products() {
        String basePlatformType = PlatformTypeHelper.getInstance().getPlatformType();

        List<Vendor> vendorList = (List<Vendor>) getScenarioContext().getContext(Context.FAVORITE_VENDOR_LIST);

        for (Vendor vendor : vendorList) {
            String vendorId = vendor.getId();

            setVendorPlatformType(vendorId);

            IRestResponse<VendorFavoriteResponse> getVendorFavoriteListResponse =
                    getCarsiFavoriteClient().getFavoriteVendorDetail(vendorId);

            List<apiEngine.models.response.Favorite.Product> productList =
                    getVendorFavoriteListResponse.getBody().getData().getProducts();

            for (apiEngine.models.response.Favorite.Product product : productList) {
                String productId = product.getId();
                getCarsiFavoriteClient().deleteFavoriteProduct(productId, vendorId);
            }

        }
        setCurrentPlatformType(basePlatformType);
    }

    @Then("I delete all vendor")
    public void i_delete_all_added_vendor() {
        List<Vendor> vendorList = getFavoriteVendorList();
        for (Vendor vendor : vendorList) {
            String vendorId = vendor.getId();
            setVendorPlatformType(vendorId);
            getCarsiFavoriteClient().deleteFavoriteVendor(vendorId);
        }

    }

    private Vendor getSelectedVendorDetailsFromFavoriteList(String vendorId) {
        List<Vendor> favoriteVendorList =
                (List<Vendor>) getScenarioContext().getContext(Context.GET_FAVORITE_VENDORS_LIST);
        int index = -1;
        for (Vendor vendor : favoriteVendorList) {
            if (vendor.getId().equalsIgnoreCase(vendorId)) {
                index = favoriteVendorList.indexOf(vendor);
                break;
            }
        }
        return favoriteVendorList.get(index);
    }

    private Vendor getAddedProductFromVendorFavorite(String productId) {
        List<Vendor> favoriteVendorList =
                (List<Vendor>) getScenarioContext().getContext(Context.GET_FAVORITE_VENDORS_LIST);
        int index = -1;
        for (Vendor vendor : favoriteVendorList) {
            String selectedVendorId = vendor.getId();
            if (vendor.getId().equalsIgnoreCase(selectedVendorId)) {
                index = favoriteVendorList.indexOf(vendor);
                break;
            }
        }
        return favoriteVendorList.get(index);
    }

    @Then("I check added favorite vendor id is valid on favorite list")
    public void i_check_added_favorite_vendor_id_is_valid() {
        CarsiVendor selectedVendor = getSelectedVendor();
        Vendor favoriteVendor = getSelectedVendorDetailsFromFavoriteList(selectedVendor.getId());
        assertTrue(!favoriteVendor.getId().isEmpty(), "Vendor id must not be null");
        assertEqual("Vendor id not equal from selected", selectedVendor.getId(), favoriteVendor.getId());
    }

    @Then("I check added favorite vendor name is valid on favorite list")
    public void i_check_added_favorite_vendor_name_is_valid() {
        CarsiVendor selectedVendor = getSelectedVendor();
        Vendor favoriteVendor = getSelectedVendorDetailsFromFavoriteList(selectedVendor.getId());
        assertTrue(!favoriteVendor.getName().isEmpty(), "Vendor name must not be null");
        assertEqual("Vendor name not equal from selected", selectedVendor.getName(), favoriteVendor.getName());
    }

    @Then("I check added favorite vendor LogoUrl status is {int} on favorite list")
    public void i_check_added_favorite_vendor_logo_url_is_valid(int statusCode) {
        CarsiVendor selectedVendor = getSelectedVendor();
        Vendor favoriteVendor = getSelectedVendorDetailsFromFavoriteList(selectedVendor.getId());
        int imageStatus = getCarsiFavoriteClient().getImageUrlResponse(favoriteVendor.getLogoUrl()).getStatusCode();

        assertTrue(imageStatus == statusCode, "Vendor logo status should be " + statusCode
                + " not " + imageStatus);
    }

    @Then("I check added favorite vendor DeliveryTimeInfo is valid on favorite list")
    public void i_check_added_favorite_vendor_delivery_time_info_is_valid() {
        CarsiVendor selectedVendor = getSelectedVendor();
        Vendor favoriteVendor = getSelectedVendorDetailsFromFavoriteList(selectedVendor.getId());
        String actualDeliveryTime = favoriteVendor.getDeliveryTimeInfo();
        String expectedDeliveryTime = selectedVendor.getDeliveryTimeInfo();
        assertTrue(!actualDeliveryTime.isEmpty(), "Delivery time must not null");
        assertEqual("Selected vendor and favorite vendor delivery time info should be equal",
                actualDeliveryTime, expectedDeliveryTime);
    }

    @Then("I check added favorite vendor  MinBasketPriceInfo is valid on favorite list")
    public void i_check_added_favorite_vendor_min_basket_price_info_is_valid() {
        CarsiVendor selectedVendor = getSelectedVendor();
        Vendor favoriteVendor = getSelectedVendorDetailsFromFavoriteList(selectedVendor.getId());
        String minBasketPrice = favoriteVendor.getMinBasketPriceInfo();
        String expectedMinBasketPrice = selectedVendor.getMinBasketPriceInfo();
        assertTrue(!minBasketPrice.isEmpty(), "MinBasketPriceInfo must not null");
        assertEqual("Selected vendor and favorite vendor MinBasketPriceInfo should be equal",
                minBasketPrice, expectedMinBasketPrice);
    }

    @Then("I check added favorite vendor  DeliveryFeeInfo is valid on favorite list")
    public void i_check_added_favorite_vendor_delivery_fee_info_is_valid() {
        CarsiVendor selectedVendor = getSelectedVendor();
        Vendor favoriteVendor = getSelectedVendorDetailsFromFavoriteList(selectedVendor.getId());
        String actualDeliveryFeeInfo = favoriteVendor.getDeliveryFeeInfo();
        String expectedDeliveryFeeInfo = selectedVendor.getDeliveryFeeInfo();
        assertTrue(!actualDeliveryFeeInfo.isEmpty(), "DeliveryFeeInfo must not null");
        assertEqual("Selected vendor and favorite vendor DeliveryFeeInfo should be equal",
                actualDeliveryFeeInfo, expectedDeliveryFeeInfo);
    }

    @Then("I check added favorite vendor  IsOpen is valid on favorite list")
    public void i_check_added_favorite_vendor_is_open_is_valid() {
        CarsiVendor selectedVendor = getSelectedVendor();
        Vendor favoriteVendor = getSelectedVendorDetailsFromFavoriteList(selectedVendor.getId());
        boolean actualIsOpen = favoriteVendor.getIsVendorAvailable();
        boolean expectedIsOpen = selectedVendor.getIsOpen();

        if (expectedIsOpen) {
            assertTrue(actualIsOpen,
                    "Vendor IsVendorAvailable status should be " + expectedIsOpen + " not " + actualIsOpen);
        } else {
            assertFalse(actualIsOpen);
        }
    }

    @Then("I check added favorite vendor  Products is valid on favorite list")
    public void i_check_added_favorite_vendor_products_is_valid() {
        Product selectedProduct = getSelectedProduct();
        String vendorId = getSelectedVendorId();
        Vendor favoriteVendor = getSelectedVendorDetailsFromFavoriteList(vendorId);
        List<apiEngine.models.response.Favorite.Product> productList = favoriteVendor.getProducts();
        int addedProductIndex = -1;
        for (apiEngine.models.response.Favorite.Product product : productList) {
            if (product.getId().equalsIgnoreCase(selectedProduct.getId())) {
                addedProductIndex = productList.indexOf(product);
                break;
            }
        }

        apiEngine.models.response.Favorite.Product addedProduct = productList.get(addedProductIndex);
        checkAddedProductId(addedProduct);
        checkAddedProductPrice(addedProduct);
        checkAddedProductDesc(addedProduct);
        checkAddedProductName(addedProduct);
        checkAddedUnitMass(addedProduct);
    }

    private void checkAddedProductId(apiEngine.models.response.Favorite.Product addedProduct) {
        Product selectedProduct = getSelectedProduct();
        String actualProductId = addedProduct.getId();
        String expectedProductId = selectedProduct.getId();
        assertNotNull(actualProductId, "Added product id should not be empty");
        assertEqual("Selected product id and added product id should be equal", actualProductId, expectedProductId);
    }

    private void checkAddedProductDesc(apiEngine.models.response.Favorite.Product addedProduct) {
        String productDesc = addedProduct.getDescription();
        assertNotNull(productDesc, "Added product desc should not be empty");
    }

    private void checkAddedProductName(apiEngine.models.response.Favorite.Product addedProduct) {
        Product selectedProduct = getSelectedProduct();
        String actualProductName = addedProduct.getName();
        String expectedProductName = selectedProduct.getName();
        assertTrue(!actualProductName.isEmpty(), "Added product name should not be empty");
        assertEqual("Selected product name and added product name should be equal", actualProductName,
                expectedProductName);
    }

    private void checkAddedProductPrice(apiEngine.models.response.Favorite.Product addedProduct) {
        Product selectedProduct = getSelectedProduct();
        double actualProductPrice = addedProduct.getPrice();
        double expectedProductPrice = selectedProduct.getPrice();
        assertNotNull((int) actualProductPrice, "Added product price should not null");
        assertTrue(actualProductPrice == expectedProductPrice, "Selected product price " +
                "and added product price should be equal ");
    }

    private void checkAddedUnitMass(apiEngine.models.response.Favorite.Product addedProduct) {
        Product selectedProduct = getSelectedProduct();
        String actualProductUnitMass = addedProduct.getUnitMass();
        String expectedUnitMass = selectedProduct.getUnitMass();
        assertNotNull(actualProductUnitMass, "Added product unit mass should not null");
        assertTrue(actualProductUnitMass == expectedUnitMass, "Selected unit mass " +
                "and added unit mass should be equal ");
    }


    private apiEngine.models.response.Favorite.Product getFavoriteProductDetailOnVendorFavoriteProducts(String addedProductId) {
        IRestResponse<VendorFavoriteResponse> vendorFavoriteProductResponse =
                (IRestResponse<VendorFavoriteResponse>) getScenarioContext()
                        .getContext(Context.GET_VENDOR_FAVORITE_PRODUCTS_RESPONSE);
        List<apiEngine.models.response.Favorite.Product> productList =
                vendorFavoriteProductResponse.getBody().getData().getProducts();
        int favoriteProductIndex = -1;
        for (apiEngine.models.response.Favorite.Product product : productList) {
            if (product.getId().equalsIgnoreCase(addedProductId)) {
                favoriteProductIndex = productList.indexOf(product);
            }
        }
        return productList.get(favoriteProductIndex);
    }

    @Then("I check added product id is valid on favorite product list")
    public void i_check_added_product_id_is_valid() {
        String selectedProductId = getSelectedProduct().getId();
        String actualProductId = getFavoriteProductDetailOnVendorFavoriteProducts(selectedProductId).getId();
        assertNotNull(actualProductId);
        assertEqual("Selected product id should be equal with vendor product id", actualProductId, selectedProductId);
    }

    @Then("I check added product Name is valid on favorite product list")
    public void i_check_added_product_name_is_valid() {
        Product selectedProduct = getSelectedProduct();
        String selectedProductId = selectedProduct.getId();
        String selectedProductName = selectedProduct.getName();
        String actualProductName = getFavoriteProductDetailOnVendorFavoriteProducts(selectedProductId).getName();
        assertNotNull(actualProductName);
        assertEqual("Selected product name should be equal with vendor product name", actualProductName,
                selectedProductName);
    }

    @Then("I check added product UnitMass is valid on favorite product list")
    public void i_check_added_product_unit_mass_is_valid() {
        Product selectedProduct = getSelectedProduct();
        String selectedProductId = selectedProduct.getId();
        String selectedProductUnitMass = selectedProduct.getUnitMass();
        String actualProductUnitMass =
                getFavoriteProductDetailOnVendorFavoriteProducts(selectedProductId).getUnitMass();
        assertNotNull(actualProductUnitMass);
        assertEqual("Selected product UnitMass should be equal with vendor product UnitMass", actualProductUnitMass,
                selectedProductUnitMass);

    }

    @Then("I check added product Price is valid on favorite product list")
    public void i_check_added_product_price_is_valid() {
        Product selectedProduct = getSelectedProduct();
        String selectedProductId = selectedProduct.getId();
        double selectedProductPrice = selectedProduct.getPrice();
        double actualProductPrice = getFavoriteProductDetailOnVendorFavoriteProducts(selectedProductId).getPrice();
        assertNotNull(actualProductPrice,"Product price should empty");
        assertTrue(selectedProductPrice == actualProductPrice, "Selected product + " + selectedProductPrice + " price" +
                " should be equal with vendor product price " + actualProductPrice);
    }

    @Then("I check added product ImageUrl status is {int} on favorite product list")
    public void i_check_added_product_image_url_status_is(Integer statusCode) {
        Product selectedProduct = getSelectedProduct();
        String selectedProductId = selectedProduct.getId();
        String imageUrl = getFavoriteProductDetailOnVendorFavoriteProducts(selectedProductId).getImageUrl();
        assertNotNull(imageUrl, "Product image url should not null !");
        int imageStatus = getCarsiFavoriteClient().getImageUrlResponse(imageUrl).getStatusCode();
        assertTrue(imageStatus == statusCode, "Product image status should be " + statusCode
                + " not " + imageStatus);
    }

    @When("I check first vendor is {string} on favorite vendor list")
    public void i_check_first_vendor_is_on_favorite_vendor_list(String vendorType) {
        Vendor firstVendor = getFavoriteVendorList().get(0);
        String expectedVendorType = firstVendor.getPlatformType();

        if (vendorType.equalsIgnoreCase("Banabi")) {
            assertTrue(expectedVendorType.equalsIgnoreCase("2"),
                    "First vendor type should be banabi on vendor list");

        }
        if (vendorType.equalsIgnoreCase("çarşi")) {
            assertTrue(expectedVendorType.equalsIgnoreCase("1"),
                    "First vendor type should be carsi on vendor list");
        }
    }

}