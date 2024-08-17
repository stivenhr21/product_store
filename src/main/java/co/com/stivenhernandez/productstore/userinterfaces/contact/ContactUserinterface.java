package co.com.stivenhernandez.productstore.userinterfaces.contact;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ContactUserinterface {

    public static final Target BTN_CONTACT_MENU = Target.the("Menu option to open contact form").located(By.xpath("//a[contains(text(), 'Contact')]"));

    public static final Target INPUT_EMAIL_CONTACT = Target.the("Input to fill out the email").located(By.id("recipient-email"));

    public static final Target INPUT_NAME_CONTACT = Target.the("Input to fill out the name").located(By.id("recipient-name"));

    public static final Target TEXT_AREA_MESSAGE = Target.the("Input to fill out the message").located(By.id("message-text"));

    public static final Target BTN_SEND_MESSAGE = Target.the("Button for send message").located(By.xpath("//button[contains(text(), 'Send message')]"));
}
