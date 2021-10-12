package stepDefinitions;


import apiEngine.Utilies.Utils;
import com.codepine.api.testrail.TestRail;
import cucumber.CustomLogFilter;
import cucumber.ListenerPlugin;
import cucumber.Storage;

import cucumber.TestRail.TestRailApi;
import enums.Context;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
import org.json.simple.JSONObject;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.rules.TestName;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Hooks {
    static MockServer mockServer = new MockServer();


    @Before(order = 1)
    public void getScenario(Scenario scenario) throws InterruptedException {
        Storage.putScenario(scenario);
    }

    @Before
    public void startMock() {
       // mockServer.setup();
    }

    @After
    public void closeMock() {
     //   mockServer.teardown();
    }




}