package flow.definition.api;

import step.api.DataDefinitionDeclaration;

import java.util.List;

public interface FlowDefinition {
    String getName();
    String getDescription();
    List<StepUsageDeclaration> getFlowSteps();
    List<String> getFlowFormalOutputs();
    void validateFlowStructure();
    List<DataDefinitionDeclaration> getFlowFreeInputs();
    void addFlowOutput(String outputName);
    void addStepToFlow(StepUsageDeclaration step);

}