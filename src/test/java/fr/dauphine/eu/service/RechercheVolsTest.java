package fr.dauphine.eu.service;

import io.quarkiverse.cucumber.CucumberOptions;
import io.quarkiverse.cucumber.CucumberQuarkusTest;

@CucumberOptions(
        features = "src/test/resources/features/pricing.feature",
        glue = "ssp.flight"
)
public class RechercheVolsTest extends CucumberQuarkusTest {
}