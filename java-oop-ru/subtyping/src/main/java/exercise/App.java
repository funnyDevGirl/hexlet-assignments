package exercise;

import java.util.Map;
// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage data) {

        Map<String,String> data2 = data.toMap();

        for (Map.Entry<String,String> entry : data2.entrySet()) {
            data.set(entry.getValue(), entry.getKey());
            data.unset(entry.getKey());
        }
    }
}
// END
