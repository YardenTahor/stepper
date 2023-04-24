package step.impl;

import dd.impl.DataDefinitionRegistry;
import step.api.AbstractStepDefinition;
import step.api.DataDefinitionDeclarationImpl;
import step.api.DataNecessity;

public class FilesRenamer extends AbstractStepDefinition {
    public FilesRenamer(){
        super("Files Renamer",false);
        //step inputs
        addInput(new DataDefinitionDeclarationImpl("FILES_TO_RENAME", DataNecessity.MANDATORY,"Files to rename", DataDefinitionRegistry.LIST));
        addInput(new DataDefinitionDeclarationImpl("PREFIX", DataNecessity.OPTIONAL,"Add this prefix", DataDefinitionRegistry.STRING));
        addInput(new DataDefinitionDeclarationImpl("SUFFIX", DataNecessity.OPTIONAL,"Append this suffix", DataDefinitionRegistry.STRING));
        //step output
        addOutput(new DataDefinitionDeclarationImpl("RENAME_RESULT",DataNecessity.NA,"Rename operation summary",DataDefinitionRegistry.RELATION));
    }

    @Override
    public StepResult invoke(StepExecutionContext context) {
        return null;
    }
}
