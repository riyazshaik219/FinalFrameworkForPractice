package parallel;

import io.cucumber.junit.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.DataProvider;


@CucumberOptions(
        features={"src/test/resources/parallel"},
        glue = {"parallel"},
        dryRun = false,
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"}

)
public class ParallelRun extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
