package utilites;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class JsonHandler {

    private final String jsonFilePath;

    public JsonHandler(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }

    public List<Map<String, String>> getTestData(String testDataKey) throws IOException {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, List<Map<String, String>>>>(){}.getType();
        Map<String, List<Map<String, String>>> testDataMap = gson.fromJson(new FileReader(jsonFilePath), type);
        return testDataMap.get(testDataKey);
    }
}
