package com.UI_Test.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/default-cucumber-reports"
        },
        glue = "com/stepDefinitions",
        features = "src/test/resources/fetaures/UIfeatures",
        tags = "@rolesCreate",
        dryRun = false

)


public class CukesRunnerUI {

}
