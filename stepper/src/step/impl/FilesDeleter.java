package step.impl;

import dd.impl.DataDefinitionRegistry;
import step.api.AbstractStepDefinition;
import step.api.DataDefinitionDeclarationImpl;
import step.api.DataNecessity;

public class FilesDeleter extends AbstractStepDefinition {
    public FilesDeleter() {
        super("Files Deleter", false);

        //step inputs

        addInput(new DataDefinitionDeclarationImpl("FILES_LIST", DataNecessity.MANDATORY, "Files to delete", DataDefinitionRegistry.LIST));
        //step outputs

        addOutput(new DataDefinitionDeclarationImpl("DELETED_LIST",DataNecessity.NA,"Files failed to be deleted",DataDefinitionRegistry.LIST));
        addOutput(new DataDefinitionDeclarationImpl("DELETION_STATS",DataNecessity.NA,"DELETION_STATS",DataDefinitionRegistry.MAPPING));

    }
}
