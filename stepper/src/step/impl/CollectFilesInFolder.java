package step.impl;

import dd.impl.DataDefinitionRegistry;
import flow.execution.context.StepExecutionContext;
import step.api.AbstractStepDefinition;
import step.api.DataDefinitionDeclarationImpl;
import step.api.DataNecessity;
import step.api.StepResult;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.optional;
import static jdk.nashorn.internal.objects.NativeArray.map;

public class CollectFilesInFolder extends AbstractStepDefinition {

    private File[] listFiles;

    public CollectFilesInFolder() {
        super("Collect Files In Folder", true);
        //step inputs
        addInput(new DataDefinitionDeclarationImpl("FOLDER_NAME", DataNecessity.MANDATORY, "Folder name to scan", DataDefinitionRegistry.STRING));
        addInput(new DataDefinitionDeclarationImpl("FILTER", DataNecessity.OPTIONAL, "Filter only these files", DataDefinitionRegistry.STRING));

        //add outputs
        addOutput(new DataDefinitionDeclarationImpl("FILES_LIST", DataNecessity.NA, "Files list", DataDefinitionRegistry.LIST));
        addOutput(new DataDefinitionDeclarationImpl("TOTAL_FOUND", DataNecessity.NA, "Total files found", DataDefinitionRegistry.NUMBER));
    }


    @Override
    public StepResult invoke(StepExecutionContext context) {

        /*String folderName=context.getDataValue("FOLDER_NAME",String.class);
        String filter = context.getDataValue("FILTER", String.class);

        File folder = new File(folderName);
        listFiles = folder.listFiles((dir, name) -> {
            if (filter != null && filter.length() > 0) {
                return name.toLowerCase().endsWith("." + filter);
            }
        else{
                    // no extensions specified, include all files
                    return true;
                }
            }).map(File::getName).toArray(String[]::new);
            System.out.println(Arrays.toString(fileList));
        }

        ; String[] fileList = listFiles*/
        return null;
    }
}
