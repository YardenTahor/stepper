package step.impl;


import step.api.AbstractStepDefinition;

public class SpendSomeTime extends AbstractStepDefinition {
    public SpendSomeTime(){
        super("Spend some time",true);
    }

    @Override
    public StepResult invoke(StepExecutionContext context) {
        return null;
    }
}
