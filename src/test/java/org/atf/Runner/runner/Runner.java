package org.atf.Runner.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.endava.qa.intership.niva.steps",
                "com.endava.qa.intership.niva.hooks"
        },
        features = {"src/test/resources/features"},
        tags = "not @Bug and not @ManualOnly"
)

public class Runner {

}