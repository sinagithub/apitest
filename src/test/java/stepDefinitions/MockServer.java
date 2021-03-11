package stepDefinitions;

import apiEngine.JsonUtil;
import com.github.tomakehurst.wiremock.WireMockServer;


import static com.github.tomakehurst.wiremock.client.WireMock.*;


public class MockServer {
    public WireMockServer wireMockServer;

    public void setup () {
        wireMockServer = new WireMockServer(3464);
        wireMockServer.start();
        setupStub();
    }

    public void teardown () {
        wireMockServer.stop();
    }


    public void setupStub() {
        stubForAddProduct("AddProductRequest.json","AddProductResponse.json");
        stubForCreateCart("CreateCartSuccessResponse.json");
    }

    public void stubForCreateCart(String responseFileName) {
        wireMockServer.stubFor(post("/carts")
            .withHeader("Content-Type", equalToIgnoreCase("application/json"))
            .withHeader("Accept", equalToIgnoreCase("application/json"))
            .withHeader("Version", equalToIgnoreCase("v1"))
            .withHeader("Client", equalToIgnoreCase("Android"))
            .withHeader("Authorization", equalToIgnoreCase("Bearer SWTestAcademyShopSecretToken"))
            .withRequestBody(matchingJsonPath("$.customer.firstName", equalTo("Onur")))
            .withRequestBody(matchingJsonPath("$.customer.lastName", equalTo("Baskirt")))
            .willReturn(aResponse()
                .withStatus(201)
                .withHeader("Content-Type", "application/json")
                .withBodyFile(responseFileName)));
    }

    public void stubForAddProduct(String requestFileName, String responseFileName) {

        String jsonString = JsonUtil.getJsonString(requestFileName);
        wireMockServer.stubFor(post("/carts/klms2f4c-8129-4a4b-b32d-550b7fc3cfb2")
            .withRequestBody(equalToJson(jsonString, true, true))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBodyFile(responseFileName)));
    }
}
