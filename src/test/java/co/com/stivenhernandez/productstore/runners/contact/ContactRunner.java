package co.com.stivenhernandez.productstore.runners.contact;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/contact/contact.feature",
        tags = "@SendMessage",
        glue = "co.com.stivenhernandez.productstore.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ContactRunner {
}
