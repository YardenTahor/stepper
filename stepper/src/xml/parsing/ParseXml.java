package xml.parsing;

import dd.impl.DataDefinitionRegistry;
import flow.definition.api.FlowDefinitionImpl;
import flow.definition.api.StepUsageDeclaration;
import flow.definition.api.StepUsageDeclarationImpl;
import javafx.util.Pair;
import jdk.nashorn.internal.parser.JSONParser;
import step.StepDefinitionRegistry;
import step.api.DataDefinitionDeclaration;
import step.api.StepDefinition;
import stepper.StepperDefinition;
import stepper.StepperDefinitionImpl;
import xml.generated.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class ParseXml {
    private STStepper stStepper;

    public ParseXml(String xmlPath) throws JAXBException {
        STStepper stStepper = getXmlStepperObjFromJaxBClasses(xmlPath);
    }

    public STStepper getXmlStepperObjFromJaxBClasses(String xmlPath) {
        try {
            InputStream inputStream = new FileInputStream(new File(xmlPath));
            JAXBContext jaxbContext = JAXBContext.newInstance(STStepper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            stStepper = (STStepper) jaxbUnmarshaller.unmarshal(inputStream);
            return stStepper;

        } catch (JAXBException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public StepperDefinitionImpl convertingGeneratedClasses() {
        StepperDefinitionImpl stepper = new StepperDefinitionImpl();
        List<STFlow> stFlows = stStepper.getSTFlows().getSTFlow();
        List<StepUsageDeclaration> stepsInFlow;
        List<String> StepsNameUsage;

        for (STFlow flow : stFlows) {
            //set flow name and description and formal output of one flow
            FlowDefinitionImpl flowToAdd = new FlowDefinitionImpl(flow.getName(), flow.getSTFlowDescription());
            List<String> CurrentFlowOutputs = Arrays.asList(flow.getSTFlowOutput().split(","));
            flowToAdd.getFlowFormalOutputs().addAll(CurrentFlowOutputs);

            //set steps to one flow
            stepsInFlow = getStStepsInFlow(flow);
            flowToAdd.getFlowSteps().addAll(stepsInFlow);
            flowToAdd.setStepsUsageNameFromSteps(stepsInFlow);
            StepsNameUsage=flowToAdd.getStepsUsageName();

            //set custom mapping to one flow
            flowToAdd.getCostumeMapping().putAll(getStCostumeMapping(flow,StepsNameUsage));


            //set custom mapping to flow

            stepper.addFlow(flowToAdd);
        }
        return stepper;
    }

    public List<StepUsageDeclaration> getStStepsInFlow(STFlow flow) {
        List<StepUsageDeclaration> result = new ArrayList<StepUsageDeclaration>();
        List<STStepInFlow> stepsInFlow = flow.getSTStepsInFlow().getSTStepInFlow();
        String nameToSearch;

        StepDefinition CurrentStepDefinition;
        for (STStepInFlow step : stepsInFlow) {
            nameToSearch = step.getName().toUpperCase().replace(" ", "_");
            CurrentStepDefinition = StepDefinitionRegistry.valueOf(nameToSearch).getStepDefinition();
            StepUsageDeclaration CurrentStepToAdd = new StepUsageDeclarationImpl(CurrentStepDefinition, step.getName());
            result.add(CurrentStepToAdd);
        }
        return result;
    }

    public Map<Pair<StepUsageDeclaration, DataDefinitionDeclaration>, Pair<StepUsageDeclaration,DataDefinitionDeclaration>>
    getStCostumeMapping(STFlow flow,List<String> steps) {
        Map<Pair<StepUsageDeclaration, DataDefinitionDeclaration>, Pair<StepUsageDeclaration,DataDefinitionDeclaration>> result = new LinkedHashMap<>();
        List<STCustomMapping> CustomMapping = flow.getSTCustomMappings().getSTCustomMapping();
        Pair<StepUsageDeclaration,DataDefinitionDeclaration> source;
        Pair<StepUsageDeclaration,DataDefinitionDeclaration> target;
        StepDefinition sourceStepDefinition,targetStepDefinition;
        String sourceName,taretName;

        for(STCustomMapping CM:CustomMapping)
        {

             try {

                //set source
                 sourceName = CM.getSourceStep().toUpperCase().replace(" ", "_");
                 sourceStepDefinition = StepDefinitionRegistry.valueOf(sourceName).getStepDefinition();
                 StepUsageDeclaration sourceStepUsageDeclaration = new StepUsageDeclarationImpl(sourceStepDefinition, sourceName);
                 DataDefinitionDeclaration sourceDataDefinitionDeclaration = sourceStepUsageDeclaration.getStepDefinition().OutputbyName(CM.getSourceData());
                 source = new Pair<>(sourceStepUsageDeclaration, sourceDataDefinitionDeclaration);
                 //set target
                 taretName = CM.getTargetStep().toUpperCase().replace(" ", "_");
                 targetStepDefinition = StepDefinitionRegistry.valueOf(taretName).getStepDefinition();
                 StepUsageDeclaration targetStepUsageDeclaration = new StepUsageDeclarationImpl(targetStepDefinition, taretName);
                 DataDefinitionDeclaration targetDataDefinitionDeclaration = targetStepUsageDeclaration.getStepDefinition().InputbyName(CM.getTargetData());
                 target = new Pair<>(targetStepUsageDeclaration, targetDataDefinitionDeclaration);

                 result.put(source, target);
             }
            catch (IllegalArgumentException | NullPointerException e) {
            // Handle the exception here
             System.out.println(e.toString());
        }

        }
        return result;






















       /* List<STCustomMapping> StListCustomMapping = flow.getSTCustomMappings().getSTCustomMapping();
        Map<Pair<StepUsageDeclaration,DataDefinitionDeclaration>,
                Pair<StepUsageDeclaration,DataDefinitionDeclaration>> result = new LinkedHashMap<>();

        for(STCustomMapping customMapping : StListCustomMapping)
        {

            Pair<StepUsageDeclaration,DataDefinitionDeclaration> source = new Pair<>(customMapping.getSourceStep(),customMapping.getSourceData());
            Pair<String,String> target = new Pair<>(customMapping.getTargetStep(),customMapping.getTargetData());
            if(checkValidation(source,target,steps))
            {
                //connect between source and target
            }


            result.put(source,target);
        }
        return result;*/
    }

    private boolean checkValidation(Pair<String, String> source, Pair<String, String> target,List<String> steps) {
        int targetInd , sourceInd;
        sourceInd = steps.indexOf(source.getKey());
        targetInd = steps.indexOf(target.getKey());
        return (targetInd > sourceInd);
    }
}





