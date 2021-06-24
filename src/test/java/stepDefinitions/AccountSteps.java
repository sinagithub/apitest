package stepDefinitions;


import apiEngine.Utilies.GenerateFakeData;
import apiEngine.Utilies.Utils;
import apiEngine.models.requests.AuthorizationRequest;
import cucumber.TestContext;
import io.cucumber.java.en.Given;

import java.io.IOException;

@SuppressWarnings("unchecked")
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

    @Given("I am an authorized user with {string} {string}")
    public void i_am_an_authorized_user_with_parameters(String userName, String password) {
        AuthorizationRequest authRequest = new AuthorizationRequest(userName, password);
        getOauthCoreClient().authenticateUser(authRequest, true);
    }

    @Given("I am an authorized new user")
    public void i_am_a_new_authorized_user() throws IOException {
        String userName = GenerateFakeData.getFakeEmail();
        String passWord = "test11";
        getOauthCoreClient().registerNewUser(userName, passWord);
        AuthorizationRequest authRequest = new AuthorizationRequest(userName, passWord);
        getOauthCoreClient().authenticateUser(authRequest, true);
    }

}
