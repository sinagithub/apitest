package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import stepDefinitions.MockServer;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = "json:target/jsonReports/cucumber-report.json",
        glue = {"stepDefinitions"}
)
public class TestRunner {
    static MockServer mockServer = new MockServer();

    @BeforeClass
    public static void setUp() {
        mockServer.setup();
    }

    @AfterClass
    public static void quit() {
        mockServer.teardown();
    }
}
