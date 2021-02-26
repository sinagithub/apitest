package stepDefinitions;


import apiEngine.Utils;
import apiEngine.models.requests.AuthorizationRequest;
import cucumber.TestContext;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class AccountSteps extends BaseSteps {

    public AccountSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("I am an authorized  user {string}")
    public void i_am_an_authorized_user(String userType) throws IOException {
        String userName = Utils.getGlobalValue("test1_userName");
        String passWord = Utils.getGlobalValue("test1_password");
        AuthorizationRequest authRequest = new AuthorizationRequest(userName, passWord);
        getOauthCoreClient().authenticateUser(authRequest, userType.equalsIgnoreCase("Login"));
    }

    @Given("I have pinned address")
    public void i_have_pinned_address() {

    }



}
