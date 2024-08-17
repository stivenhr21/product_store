package co.com.stivenhernandez.productstore.tasks.contact;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.stivenhernandez.productstore.models.TestData.obtain;
import static co.com.stivenhernandez.productstore.userinterfaces.contact.ContactUserinterface.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SendMessage implements Task {

    public static SendMessage contact() {
        return instrumented(SendMessage.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CONTACT_MENU),
                Enter.theValue(obtain("email")).into(INPUT_EMAIL_CONTACT),
                Enter.theValue(obtain("name")).into(INPUT_NAME_CONTACT),
                Enter.theValue(obtain("message")).into(TEXT_AREA_MESSAGE),
                Click.on(BTN_SEND_MESSAGE)
        );
    }
}
