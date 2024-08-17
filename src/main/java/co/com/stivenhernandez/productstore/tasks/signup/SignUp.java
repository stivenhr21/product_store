package co.com.stivenhernandez.productstore.tasks.signup;

import co.com.stivenhernandez.productstore.util.LoadData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.com.stivenhernandez.productstore.models.TestData.obtain;
import static co.com.stivenhernandez.productstore.userinterfaces.signup.SignUpUserinterface.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SignUp implements Task {

    public static SignUp user() {
        return instrumented(SignUp.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_SIGNUP_MENU),
                Enter.theValue(obtain("user")).into(INPUT_USER_SIGNUP),
                Enter.theValue(obtain("password")).into(INPUT_PASSWORD_SIGNUP),
                Click.on(BTN_SIGNUP)
        );
    }
}
