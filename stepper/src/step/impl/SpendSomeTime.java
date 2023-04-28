package step.impl;


import dd.impl.DataDefinitionRegistry;
import flow.execution.context.StepExecutionContext;
import step.api.AbstractStepDefinition;
import step.api.DataDefinitionDeclarationImpl;
import step.api.DataNecessity;
import step.api.StepResult;

public class SpendSomeTime extends AbstractStepDefinition {
    public SpendSomeTime(){
        super("Spend some time",true);
        addInput(new DataDefinitionDeclarationImpl("TIME_TO_SPEND", DataNecessity.MANDATORY,"Total sleeping time (sec)", DataDefinitionRegistry.NUMBER));
    }

    @Override
    public StepResult invoke(StepExecutionContext context) {
    /*    int timeToSpend=context.getDataValue("TIME_TO_SPEND",Integer.class);
        long start = System.currentTimeMillis();

        try {
            Thread.sleep(timeToSpend);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sleep time in ms = " + (System.currentTimeMillis() - start));
*/
        return null;
    }
}
