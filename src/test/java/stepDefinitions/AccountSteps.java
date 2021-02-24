package stepDefinitions;


import apiEngine.Utils;
import apiEngine.models.requests.AuthorizationRequest;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class AccountSteps extends BaseSteps {

    public AccountSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("I am an authorized  with {string} user")
    public void i_am_an_authorized_with_user(String userType) throws IOException {
        String userName = Utils.getGlobalValue("test1_userName");
        String passWord = Utils.getGlobalValue("test1_password");
        getScenarioContext().setContext(Context.USERNAME,userName);
        AuthorizationRequest authRequest = new AuthorizationRequest(userName, passWord);
        getOauthCoreClient().authenticateUser(authRequest, userType.equalsIgnoreCase("Login"));
    }


}
