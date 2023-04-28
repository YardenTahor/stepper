package step.impl;

import dd.impl.DataDefinitionRegistry;
import flow.execution.context.StepExecutionContext;
import step.api.AbstractStepDefinition;
import step.api.DataDefinitionDeclarationImpl;
import step.api.DataNecessity;
import step.api.StepResult;

public class CSVExporter extends AbstractStepDefinition {
    public CSVExporter() {
        super("CSV Exporter", true);

        //step inputs

        addInput(new DataDefinitionDeclarationImpl("SOURCE", DataNecessity.MANDATORY, "Source data", DataDefinitionRegistry.RELATION));
        //step outputs

        addOutput(new DataDefinitionDeclarationImpl("Source data", DataNecessity.NA, "CSV export result", DataDefinitionRegistry.STRING));
    }
    public StepResult invoke(StepExecutionContext context) {
        return null;
    }


    }