package stepDefinitions;

import apiEngine.JsonUtil;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.core.Options;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;


import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;


public class MockServer {


    public static WireMockServer wireMockServer;

    public void setup() {
        Options options = wireMockConfig()
                .port(3464)
                .notifier(new ConsoleNotifier(false))
                .extensions(new ResponseTemplateTransformer(true));

        wireMockServer = new WireMockServer(options);
        wireMockServer.start();
        setupStub();

    }

    public void teardown() {
        wireMockServer.stop();
    }


    public void setupStub() {
        stubForVendorList("VendorListResponse.json");
        stubForVendorDetail("VendorResponse.json");
        stubForProductsResponse("CategoryProductsResponse.json");
        stubForProductResponse("ProductResponse.json");
        stubForSplashResponseForEnabled("SplashResponseEnabledVendor.json");
        stubForSplashResponseForDisabled("SplashResponseDisabledVendor.json");
        stubForBasketIdResponse("BasketIdResponse.json");
        stubForBasketIdResponseArea2("BasketIdResponseArea3.json");
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
        wireMockServer.stubFor(get(urlPathMatching("/api/v1/vendor/.*"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("YS-Culture", equalToIgnoreCase("tr-TR"))
                .withHeader("YS-Catalog", equalToIgnoreCase("TR_ISTANBUL"))
                .withHeader("Authorization", containing("Bearer"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile(responseFileName)));
    }

    public void stubForProductsResponse(String responseFileName) {
        wireMockServer.stubFor(get(urlPathMatching("/api/v1/vendor/.*/products"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("YS-Culture", equalToIgnoreCase("tr-TR"))
                .withHeader("YS-Catalog", equalToIgnoreCase("TR_ISTANBUL"))
                .withHeader("Accept", equalToIgnoreCase("*/*"))
                .withHeader("Authorization", containing("Bearer"))
                .withQueryParam("categoryId", matching(".*"))
                .withQueryParam("offset", matching(".*"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile(responseFileName)));
    }

    public void stubForProductResponse(String responseFileName) {
        wireMockServer.stubFor(get(urlPathMatching("/api/v1/product/.*"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("YS-Culture", equalToIgnoreCase("tr-TR"))
                .withHeader("YS-Catalog", equalToIgnoreCase("TR_ISTANBUL"))
                .withHeader("Accept", equalToIgnoreCase("*/*"))
                .withHeader("Authorization", containing("Bearer"))
                .withQueryParam("vendorId",matching(".*"))
                .withQueryParam("basketId",matching(".*"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile(responseFileName)));
    }

    public void stubForBasketIdResponse(String responseFileName) {
        wireMockServer.stubFor(get(urlPathMatching("/api/v1/basket/id"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("YS-Culture", equalToIgnoreCase("tr-TR"))
                .withHeader("YS-Catalog", equalToIgnoreCase("TR_ISTANBUL"))
                .withHeader("Accept", equalToIgnoreCase("*/*"))
                .withHeader("Authorization", containing("Bearer"))
                .withQueryParam("addressId",equalTo("{af4c03a9-f84e-4522-aaac-99b9ef81454a}"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile(responseFileName)));
    }

    public void stubForBasketIdResponseArea2(String responseFileName) {
        wireMockServer.stubFor(get(urlPathMatching("/api/v1/basket/id"))
                .withHeader("Content-Type", containing("application/json"))
                .withHeader("YS-Culture", equalToIgnoreCase("tr-TR"))
                .withHeader("YS-Catalog", equalToIgnoreCase("TR_ISTANBUL"))
                .withHeader("Accept", equalToIgnoreCase("*/*"))
                .withHeader("Authorization", containing("Bearer"))
                .withQueryParam("addressId",equalTo("{81cfbad7-36f9-455b-9204-0ea674b2406a}"))
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

    public static void main(String[] args) {
        MockServer mockServer = new MockServer();
        mockServer.setup();

    }
}
