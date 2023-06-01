package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/cucumberjul22/feature/homePage.feature",
glue="cucumberjul22.stepdefinition")
public class Runner {

}
