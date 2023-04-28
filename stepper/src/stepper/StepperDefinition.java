package stepper;

import flow.definition.api.FlowDefinitionImpl;

import java.util.List;

public interface StepperDefinition {
    List<FlowDefinitionImpl> getFlows();

}
