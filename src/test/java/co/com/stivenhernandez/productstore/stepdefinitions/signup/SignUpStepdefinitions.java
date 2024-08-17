package co.com.stivenhernandez.productstore.stepdefinitions.signup;

import co.com.stivenhernandez.productstore.questions.common.ValidateMessageAlert;
import co.com.stivenhernandez.productstore.tasks.signup.SignUp;
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

public class SignUpStepdefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("The user fills out the registration form")
    public void theUserFillsOutTheRegistrationForm(List<Map<String, Object>> information) {
        theActorInTheSpotlight().attemptsTo(
                LoadData.withTheFollowing(information),
                SignUp.user()
        );
    }

    @Then("The user will see a successful registration alert")
    public void theUserWillSeeASuccessfulRegistrationAlert() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                ValidateMessageAlert.isPresent(), Matchers.equalTo("Sign up successful.")
        ));
    }

    @Then("The user will see an existing user alert")
    public void theUserWillSeeAnExistingUserAlert() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                ValidateMessageAlert.isPresent(), Matchers.equalTo("This user already exist.")
        ));
    }

    @Then("An alert will be displayed enter the username and password")
    public void anAlertWillBeDisplayedEnterTheUsernameAndPassword() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                ValidateMessageAlert.isPresent(), Matchers.equalTo("Please fill out Username and Password.")
        ));
    }
}
