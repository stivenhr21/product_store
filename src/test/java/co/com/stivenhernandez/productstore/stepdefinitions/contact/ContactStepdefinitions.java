package co.com.stivenhernandez.productstore.stepdefinitions.contact;

import co.com.stivenhernandez.productstore.questions.common.ValidateMessageAlert;
import co.com.stivenhernandez.productstore.tasks.contact.SendMessage;
import co.com.stivenhernandez.productstore.util.LoadData;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ContactStepdefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("The user fills out the contact form")
    public void theUserFillsOutTheContactForm(List<Map<String, Object>> information) {
        theActorInTheSpotlight().attemptsTo(
                LoadData.withTheFollowing(information),
                SendMessage.contact()
        );
    }

    @Then("The user will see a thank you message")
    public void theUserWillSeeAThankYouMessage() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                ValidateMessageAlert.isPresent(), Matchers.equalTo("Thanks for the message!!")
        ));
    }
}
