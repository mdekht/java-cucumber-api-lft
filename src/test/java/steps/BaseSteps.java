package steps;

import context.ScenarioContext;

public class BaseSteps {
    protected ScenarioContext context;

    public BaseSteps() {
        context = new ScenarioContext();
    }

    protected ScenarioContext context() {
        return context;
    }
}
