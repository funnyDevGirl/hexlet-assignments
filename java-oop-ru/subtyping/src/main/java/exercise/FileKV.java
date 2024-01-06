package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private String path;//"src/test/resources/file"
    private final Map<String, String> data;

    FileKV(String path, Map<String, String> data) {
        this.path = path;
        this.data = new HashMap<>(data);
    }

    @Override
    public void set(String key, String value) {
        data.put(key, value);
    }

    @Override
    public void unset(String key) {
        data.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(data);
    }
}
// END
