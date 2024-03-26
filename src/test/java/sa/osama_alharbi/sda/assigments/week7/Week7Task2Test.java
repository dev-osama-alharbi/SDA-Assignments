package sa.osama_alharbi.sda.assigments.week7;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("sa.osama_alharbi.sda.assigments.week7")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class Week7Task2Test {
}
