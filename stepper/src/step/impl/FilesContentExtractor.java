package step.impl;

import dd.impl.DataDefinitionRegistry;
import step.api.AbstractStepDefinition;
import step.api.DataDefinitionDeclarationImpl;
import step.api.DataNecessity;

public class FilesContentExtractor extends AbstractStepDefinition {
    public FilesContentExtractor(){
        super("Files Content Extractor",true);
        //step inputs
        addInput(new DataDefinitionDeclarationImpl("FILES_LIST", DataNecessity.MANDATORY,"Files to extract", DataDefinitionRegistry.LIST));
        addInput(new DataDefinitionDeclarationImpl("LINE", DataNecessity.MANDATORY,"Line number to extract", DataDefinitionRegistry.NUMBER));
        //step output
        addOutput(new DataDefinitionDeclarationImpl("DATA",DataNecessity.NA,"Data extraction",DataDefinitionRegistry.RELATION));
    }

    @Override
    public StepResult invoke(StepExecutionContext context) {
        return null;
    }
}
