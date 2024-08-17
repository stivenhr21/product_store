package co.com.stivenhernandez.productstore.questions.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ValidateMessageAlert implements Question<String> {

    public static Question<String> isPresent() {
        return new ValidateMessageAlert();
    }

    private static final Logger LOGGER = LogManager.getLogger(ValidateMessageAlert.class.getName());

    public static String alertIsPresent() {
        try {
            WebDriver driver = getDriver();
            Alert alert = driver.switchTo().alert();
            var message = alert.getText();
            LOGGER.info(message);
            return message;
        } catch (NoAlertPresentException e) {
            LOGGER.info("No alert present");
            return e.getMessage();
        }
    }

    @Override
    public String answeredBy(Actor actor) {
        return alertIsPresent();
    }
}
