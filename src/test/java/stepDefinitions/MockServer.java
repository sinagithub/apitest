package stepDefinitions;

import apiEngine.JsonUtil;
import com.github.tomakehurst.wiremock.WireMockServer;


import static com.github.tomakehurst.wiremock.client.WireMock.*;


public class MockServer {
    public WireMockServer wireMockServer;

    public void setup() {
        wireMockServer = new WireMockServer(3464);
        wireMockServer.start();
        setupStub();
    }

    public void teardown() {
        wireMockServer.stop();
    }


    public void setupStub() {
        stubForVendorList("VendorListResponse.json");
        stubForVendorDetail("VendorResponse.json");
        stubForProductsResponse("ProductsResponse.json");
        stubForProductResponse("ProductResponse.json");
        stubForSplashResponseForEnabled("SplashResponseEnabledVendor.json");
        stubForSplashResponseForDisabled("SplashResponseDisabledVendor.json");
    }


    public void stubForVendorList(String responseFileName) {
        wireMockServer.stubFor(get("/api/v1/homepage/carsi?AddressId=%7Bdcb8ffa7-b113-4c05-9045-3b8d238c865b%7D" +
                "&AreaId=f75a5e15-5e67-4ed1-bd60-97f095a9c3d1&Latitude=40.98378&Longitude=28.735218")
                .withHeader("Content-Type", containing("application/json;"))
                .withHeader("YS-Culture", equalToIgnoreCase("tr-TR"))
                .withHeader("YS-Catalog", equalToIgnoreCase("TR_ISTANBUL"))
                .withHeader("Accept", equalToIgnoreCase("*/*"))
                .withHeader("Authorization", containing("Bearer"))
                .withQueryParam("AddressId", equalToIgnoreCase("{dcb8ffa7-b113-4c05-9045-3b8d238c865b}"))
                .withQueryParam("AreaId", equalToIgnoreCase("f75a5e15-5e67-4ed1-bd60-97f095a9c3d1"))
                .withQueryParam("Latitude", equalToIgnoreCase("40.98378"))
                .withQueryParam("Longitude", equalToIgnoreCase("28.735218"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile(responseFileName)));
    }

    public void stubForVendorDetail(String responseFileName) {
        wireMockServer.stubFor(get("/api/v1/vendor/1")
                .withHeader("Content-Type", containing("application/json;"))
                .withHeader("YS-Culture", equalToIgnoreCase("tr-TR"))
                .withHeader("YS-Catalog", equalToIgnoreCase("TR_ISTANBUL"))
                .withHeader("Accept", equalToIgnoreCase("*/*"))
                .withHeader("Authorization", containing("Bearer"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile(responseFileName)));
    }

    public void stubForProductsResponse(String responseFileName) {
        wireMockServer.stubFor(get("/api/v1/vendor/1/products")
                .withHeader("Content-Type", containing("application/json;"))
                .withHeader("YS-Culture", equalToIgnoreCase("tr-TR"))
                .withHeader("YS-Catalog", equalToIgnoreCase("TR_ISTANBUL"))
                .withHeader("Accept", equalToIgnoreCase("*/*"))
                .withHeader("Authorization", containing("Bearer"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile(responseFileName)));
    }

    public void stubForProductResponse(String responseFileName) {
        wireMockServer.stubFor(get("/api/v1/product/1")
                .withHeader("Content-Type", containing("application/json;"))
                .withHeader("YS-Culture", equalToIgnoreCase("tr-TR"))
                .withHeader("YS-Catalog", equalToIgnoreCase("TR_ISTANBUL"))
                .withHeader("Accept", equalToIgnoreCase("*/*"))
                .withHeader("Authorization", containing("Bearer"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile(responseFileName)));
    }

    public void stubForSplashResponseForEnabled(String responseFileName) {
        wireMockServer.stubFor(get("/api/v1/splash")
                .withHeader("Content-Type", containing("application/json;"))
                .withHeader("YS-Culture", equalToIgnoreCase("tr-TR"))
                .withHeader("YS-Catalog", equalToIgnoreCase("TR_ISTANBUL"))
                .withHeader("Accept", equalToIgnoreCase("*/*"))
                .withHeader("Authorization", containing("Bearer"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile(responseFileName)));
    }

    public void stubForSplashResponseForDisabled(String responseFileName) {
        wireMockServer.stubFor(get("/api/v1/splash")
                .withHeader("Content-Type", containing("application/json;"))
                .withHeader("YS-Culture", equalToIgnoreCase("tr-TR"))
                .withHeader("YS-Catalog", equalTo("TR_ANKARA"))
                .withHeader("Accept", equalToIgnoreCase("*/*"))
                .withHeader("Authorization", containing("Bearer"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile(responseFileName)));
    }
}
