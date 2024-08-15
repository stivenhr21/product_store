package co.com.stivenhernandez.productstore.questions.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.stivenhernandez.productstore.userinterfaces.login.LoginUserinterface.NAME_USER_LOGGED;

public class ValidateLogin implements Question<Boolean> {

    public static ValidateLogin successful() {
        return new ValidateLogin();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return NAME_USER_LOGGED.resolveFor(actor).isVisible();
    }
}
