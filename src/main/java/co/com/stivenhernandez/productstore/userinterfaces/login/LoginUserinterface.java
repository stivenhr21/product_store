package co.com.stivenhernandez.productstore.userinterfaces.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUserinterface {

    public static final Target BTN_LOGIN_MENU = Target.the("Menu option to open log in form").located(By.id("login2"));

    public static final Target INPUT_USER_LOGIN = Target.the("Input for the user to complete when logging in").located(By.id("loginusername"));

    public static final Target INPUT_PASSWORD_LOGIN = Target.the("Input to fill in the key to log in").located(By.id("loginpassword"));

    public static final Target BTN_LOGIN = Target.the("Button to log in").located(By.xpath("(//button[@class= 'btn btn-primary'])[3]"));

    public static final Target NAME_USER_LOGGED = Target.the("logged in user name").located(By.id("nameofuser"));
}
