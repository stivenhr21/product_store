package co.com.stivenhernandez.productstore.stepdefinitions.login;

import co.com.stivenhernandez.productstore.questions.login.ValidateLogin;
import co.com.stivenhernandez.productstore.questions.common.ValidateMessageAlert;
import co.com.stivenhernandez.productstore.tasks.common.OpenUrl;
import co.com.stivenhernandez.productstore.tasks.login.Login;
import co.com.stivenhernandez.productstore.util.LoadData;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepdefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that the user is on the login page")
    public void thatTheUserIsOnTheLoginPage() {
        OnStage.theActorCalled("The user").wasAbleTo(OpenUrl.thePage());
    }

    @When("The user fills in his credentials")
    public void theUserFillsInHisCredentials(List<Map<String, Object>> information) {
        theActorInTheSpotlight().attemptsTo(
                LoadData.withTheFollowing(information),
                Login.user()
        );
    }

    @Then("The user will be logged into the website")
    public void theUserWillBeLoggedIntoTheWebsite() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                ValidateLogin.successful(), Matchers.equalTo(true)
        ));
    }

    @Then("The user will see an alert enter the username and password")
    public void theUserWillSeeAnAlertEnterTheUsernameAndPassword() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                ValidateMessageAlert.isPresent(), Matchers.equalTo("Please fill out Username and Password.")
        ));
    }

    @Then("The user will see an alert user does no exist")
    public void theUserWillSeeAnAlertUserDoesNoExist() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                ValidateMessageAlert.isPresent(), Matchers.equalTo("User does not exist.")
        ));
    }
}
