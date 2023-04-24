package step.impl;

import dd.impl.DataDefinitionRegistry;
import step.api.AbstractStepDefinition;
import step.api.DataDefinitionDeclarationImpl;
import step.api.DataNecessity;

public class CSVExporter extends AbstractStepDefinition {
    public CSVExporter() {
        super("CSV Exporter", true);

        //step inputs

        addInput(new DataDefinitionDeclarationImpl("SOURCE", DataNecessity.MANDATORY, "Source data", DataDefinitionRegistry.RELATION));
        //step outputs

        addOutput(new DataDefinitionDeclarationImpl("Source data", DataNecessity.NA, "CSV export result", DataDefinitionRegistry.STRING));
    }
}