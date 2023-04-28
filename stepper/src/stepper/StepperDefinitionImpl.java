package stepper;

import flow.definition.api.FlowDefinitionImpl;

import java.util.ArrayList;
import java.util.List;

public class StepperDefinitionImpl {
    private List<FlowDefinitionImpl> flows;

    public StepperDefinitionImpl(){
        flows = new ArrayList<>();
    }

    public void addFlow(FlowDefinitionImpl flowToAdd) {
        flows.add(flowToAdd);
    }
}
