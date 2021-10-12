package cucumber.TestRail;

import java.util.HashMap;

public class TestRailLogHelper {
    private static final HashMap<String, String> logs = new HashMap<>();
    private static TestRailLogHelper instance = null;

    private TestRailLogHelper() {
    }

    public static TestRailLogHelper getInstance() {
        if (instance == null) {
            instance = new TestRailLogHelper();
        }
        return instance;
    }

    public HashMap<String, String> getLog() {
        return logs;
    }

    public void setLog(String key, String apiLog) {
        logs.put(key,apiLog);
    }

    public void refreshInstance() {
        logs.clear();
    }
}
