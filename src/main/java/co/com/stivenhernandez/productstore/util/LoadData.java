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
    @Step("{0} Loading test data for automation #TestData")
    public <T extends Actor> void performAs(T actor) {
        if (testData.isEmpty()) {
            handleEmptyData(actor);
            return;
        }
        Map<String, Object> mapAuxiliar = collectValidData();
        updateDataPrueba(mapAuxiliar);
    }

    private <T extends Actor> void handleEmptyData(T actor) {
        actor.remember("", new HashMap<>());
        LOGGER.info("The test data list is empty");
    }

    private Map<String, Object> collectValidData() {
        Map<String, Object> mapAuxiliar = new HashMap<>();
        for (Map<String, Object> map : testData) {
            if (map == null) {
                LOGGER.info("A null map was found in the test data.");
                continue;
            }
            addValidEntries(map, mapAuxiliar);
        }
        return mapAuxiliar;
    }

    private void addValidEntries(Map<String, Object> map, Map<String, Object> mapAuxiliar) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                LOGGER.info("A null entry was found in the test data.");
                continue;
            }
            mapAuxiliar.put(entry.getKey(), entry.getValue());
        }
    }

    private void updateDataPrueba(Map<String, Object> mapAuxiliar) {
        if (mapAuxiliar.isEmpty()) {
            LOGGER.info("All test data is empty.");
            return;
        }

        if (TestData.getMap() == null) {
            TestData.setMap(mapAuxiliar);
        } else {
            TestData.getMap().putAll(mapAuxiliar);
        }
    }
}
