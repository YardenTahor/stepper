package step.impl;

import dd.impl.DataDefinitionRegistry;
import step.api.AbstractStepDefinition;
import step.api.DataDefinitionDeclarationImpl;
import step.api.DataNecessity;

public class PropertiesExporter extends AbstractStepDefinition {
    public PropertiesExporter(){
        super("Properties Exporter",true);
        //step input
        addInput(new DataDefinitionDeclarationImpl("SOURCE", DataNecessity.MANDATORY,"Source data", DataDefinitionRegistry.RELATION));
        //step output
        addOutput(new DataDefinitionDeclarationImpl("RESULT",DataNecessity.NA,"Properties export result",DataDefinitionRegistry.STRING));
    }

    @Override
    public StepResult invoke(StepExecutionContext context) {
        return null;
    }
}
