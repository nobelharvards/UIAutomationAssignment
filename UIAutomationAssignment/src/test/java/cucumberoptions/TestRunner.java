package cucumberoptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/featurefiles", glue = "stepdefinitions")
public class TestRunner extends AbstractTestNGCucumberTests
{

}
