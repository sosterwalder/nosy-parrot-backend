package ch.bbv.nosyparrot.backend.interactor.step_definitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features"
)
public class InteractorsCucumberTestRunner {}

