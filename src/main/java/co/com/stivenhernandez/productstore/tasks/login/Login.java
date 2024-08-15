package co.com.stivenhernandez.productstore.tasks.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.stivenhernandez.productstore.models.TestData.obtain;
import static co.com.stivenhernandez.productstore.userinterfaces.login.LoginUserinterface.*;

public class Login implements Task {

    public static Login user() {
        return Tasks.instrumented(Login.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_LOGIN_MENU),
                Enter.theValue(obtain("user")).into(INPUT_USER_LOGIN),
                Enter.theValue(obtain("password")).into(INPUT_PASSWORD_LOGIN),
                Click.on(BTN_LOGIN)
        );
    }
}
