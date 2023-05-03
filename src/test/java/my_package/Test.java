package my_package;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		         features="use_case",
                 glue = "my_package"

		
		
		)

public class Test {


}
