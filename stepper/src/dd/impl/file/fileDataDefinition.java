package dd.impl.file;

import dd.api.AbstractDataDefinition;

import java.io.File;

public class fileDataDefinition extends AbstractDataDefinition {
    public fileDataDefinition(){
        super("File",false, File.class);
    }
}
