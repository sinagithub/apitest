package cucumber;

import cucumber.TestRail.TestRailApi;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;

import java.text.ParseException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"json:target/jsonReports/cucumber-report.json", "cucumber.ListenerPlugin", "cucumber.StepDetails"},
        glue = {"stepDefinitions"},
        publish = true)
public class TestRunner {


}
