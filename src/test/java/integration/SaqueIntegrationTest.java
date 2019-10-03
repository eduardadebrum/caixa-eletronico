package integration;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:report"},
        features = "src/test/resources/saque.feature")
public class SaqueIntegrationTest {
}