package co.com.stivenhernandez.productstore.runners.signup;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/signup/sign_up.feature",
        tags = "@validateMessageEnterUsernameAndPassword",
        glue = "co.com.stivenhernandez.productstore.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class SignUpRunner {
}
