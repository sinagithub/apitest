package clients;

import apiEngine.ApiClient;

import io.restassured.response.Response;

public class CarsiClient extends ApiClient {
    public CarsiClient() {
        super("carsibaseurl");
    }

}
