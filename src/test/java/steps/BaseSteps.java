package steps;

import context.ScenarioContext;

public class BaseSteps {
    protected ScenarioContext context;

    protected ScenarioContext getContext() {
        context = new ScenarioContext();
        return context;
    }
}
