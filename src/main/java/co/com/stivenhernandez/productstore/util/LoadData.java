package co.com.stivenhernandez.productstore.util;

import co.com.stivenhernandez.productstore.models.TestData;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoadData implements Task {

    private static final Logger LOGGER = LogManager.getLogger(LoadData.class.getName());

    private final List<Map<String, Object>> testData;

    public LoadData(List<Map<String, Object>> testData) {
        this.testData = testData;
    }

    public static LoadData withTheFollowing(List<Map<String, Object>> information) {
        return instrumented(LoadData.class, information);
    }

    @Override
    @Step("{0} Loading test data for automation #testData")
    public <T extends Actor> void performAs(T actor) {
        if (!testData.isEmpty()) {
            Set<Map.Entry<String, Object>> setMapaAux = testData.get(0).entrySet();
            Map<String, Object> mapAuxiliar =
                    setMapaAux.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            if (TestData.getMap() == null) {
                TestData.setMap(mapAuxiliar);
            } else {
                TestData.getMap().putAll(mapAuxiliar);
            }
        } else {
            actor.remember("", new HashMap<>());
            LOGGER.info("The list is empty");
        }
    }
}
