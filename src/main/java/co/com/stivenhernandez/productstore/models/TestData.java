package co.com.stivenhernandez.productstore.models;

import java.util.Map;

public class TestData {

    private static Map<String, Object> map;

    private TestData() {
    }

    public static Map<String, Object> getMap() {
        return map;
    }

    public static void setMap(Map<String, Object> datosPrueba) {
        map = datosPrueba;
    }

    public static String obtain(String dataObtain) {
        return (String) getMap().get(dataObtain);
    }
}
