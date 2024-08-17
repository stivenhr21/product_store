package co.com.stivenhernandez.productstore.userinterfaces.signup;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignUpUserinterface {

    public static final Target BTN_SIGNUP_MENU = Target.the("Menu option to open sign up form").located(By.id("signin2"));
    public static final Target INPUT_USER_SIGNUP = Target.the("Input to enter user to register").located(By.id("sign-username"));
    public static final Target INPUT_PASSWORD_SIGNUP = Target.the("Input to enter password to register").located(By.id("sign-password"));
    public static final Target BTN_SIGNUP = Target.the("button to register user").located(By.xpath("(//button[@class= 'btn btn-primary'])[2]"));

}
