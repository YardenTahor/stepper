package step.impl;


import dd.impl.DataDefinitionRegistry;
import step.api.AbstractStepDefinition;
import step.api.DataDefinitionDeclarationImpl;
import step.api.DataNecessity;

public class SpendSomeTime extends AbstractStepDefinition {
    public SpendSomeTime(){
        super("Spend some time",true);
        addInput(new DataDefinitionDeclarationImpl("TIME_TO_SPEND", DataNecessity.MANDATORY,"Total sleeping time (sec)", DataDefinitionRegistry.NUMBER));
    }

    @Override
    public StepResult invoke(StepExecutionContext context) {
        return null;
    }
}
