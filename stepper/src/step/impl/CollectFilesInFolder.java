package step.impl;

import dd.impl.DataDefinitionRegistry;
import step.api.AbstractStepDefinition;
import step.api.DataDefinitionDeclarationImpl;
import step.api.DataNecessity;

public class CollectFilesInFolder extends AbstractStepDefinition {
    public CollectFilesInFolder(){
        super("Collect Files In Folder",true);
        //step inputs

        addInput(new DataDefinitionDeclarationImpl("FOLDER_NAME", DataNecessity.MANDATORY,"Folder name to scan", DataDefinitionRegistry.STRING));
        addInput(new DataDefinitionDeclarationImpl("FILTER",DataNecessity.OPTIONAL,"Filter only these files",DataDefinitionRegistry.STRING));

        //add outputs
        addOutput(new DataDefinitionDeclarationImpl("FILES_LIST",DataNecessity.NA,"Files list",DataDefinitionRegistry.LIST));
        addOutput(new DataDefinitionDeclarationImpl("TOTAL_FOUND",DataNecessity.NA,"Total files found",DataDefinitionRegistry.NUMBER));
    }


    @Override
    public StepResult invoke(StepExecutionContext context) {
        return null;
    }
}
