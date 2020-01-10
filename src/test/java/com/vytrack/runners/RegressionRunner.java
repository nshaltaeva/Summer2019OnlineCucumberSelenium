package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/activities", //path to features
                    "src/test/resources/features/fleet"},
        //     features = "src/test/resources/features/activities/CalendarEvents.feature", //path to features
        glue = "com/vytrack/step_definitions",    //path to step definitions
        dryRun = false, //by default it is false
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        }
)

public class RegressionRunner {
}
