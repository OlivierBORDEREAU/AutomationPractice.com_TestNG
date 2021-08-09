package runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



//@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/features"
,glue= {"seleniumgluecode"}
,plugin = { "pretty", "html:target/htmlreports.html" }
,monochrome = true
,publish = false
)

public class TestRunnerTest extends AbstractTestNGCucumberTests {
	 
}