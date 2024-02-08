package context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static final ScenarioContext INSTANCE = new ScenarioContext();
    private final ThreadLocal<Map<String, Object>> testContexts = ThreadLocal.withInitial(HashMap::new);

    private ScenarioContext() {
        // Private constructor
    }

    public static ScenarioContext getInstance() {
        return INSTANCE;
    }

    public <T> T getContext(String name) {
        return (T) testContexts.get().get(name);
    }

    public <T> T setContext(String name, T object) {
        testContexts.get().put(name, object);
        return object;
    }
}
