package steps;

import context.ScenarioContext;

public class BaseSteps {

    public ScenarioContext context() {
        return ScenarioContext.getInstance();
    }
}
