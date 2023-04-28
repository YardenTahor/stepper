package flow.definition.api;

import dd.impl.DataDefinitionRegistry;
import javafx.util.Pair;
import step.api.DataDefinitionDeclaration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FlowDefinitionImpl implements FlowDefinition {

    private final String name;
    private final String description;
    private final List<String> flowOutputs;
    private final List<StepUsageDeclaration> steps;
    private boolean flowReadOnly;
    private final List<String> stepsUsageName;
    private final Map<Pair<StepUsageDeclaration,DataDefinitionDeclaration>,
            Pair<StepUsageDeclaration,DataDefinitionDeclaration>> costumeMapping;


    public FlowDefinitionImpl(String name, String description) {
        this.name = name;
        this.description = description;
        flowOutputs = new ArrayList<>();
        steps = new ArrayList<>();
        stepsUsageName = new ArrayList<>();
        costumeMapping = new LinkedHashMap<>();
    }
    @Override
    public void addFlowOutput(String outputName) {
        flowOutputs.add(outputName);
    }

    @Override
    public void addStepToFlow(StepUsageDeclaration step) {
        steps.add(step);
    }

    @Override
    public void validateFlowStructure() {
        // do some validation logic...
    }
    @Override
    public List<DataDefinitionDeclaration> getFlowFreeInputs() {
        return new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }


    public List<String> getStepsUsageName() {
        return stepsUsageName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<StepUsageDeclaration> getFlowSteps() {
        return steps;
    }

    @Override
    public List<String> getFlowFormalOutputs() {
        return flowOutputs;
    }

    public void isReadOnly(){
        flowReadOnly= !(steps.stream().anyMatch(b->!(b.getStepDefinition().isReadonly())));
    }

    @Override
    public void setStepsUsageNameFromSteps(List<StepUsageDeclaration> stepsU){
        for(StepUsageDeclaration st:stepsU){
            stepsUsageName.add(st.getFinalStepName());
        }

    }
    public Map<Pair<StepUsageDeclaration,DataDefinitionDeclaration>,
            Pair<StepUsageDeclaration,DataDefinitionDeclaration>> getCostumeMapping() {
        return costumeMapping;
    }

    public boolean isFlowReadOnly() {
        return flowReadOnly;
    }
}

