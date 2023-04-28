import stepper.StepperDefinitionImpl;
import xml.parsing.ParseXml;

import javax.swing.text.Document;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class Main {
    public static void main(String[] args) throws JAXBException {
        String path ="C:/Users/yarde/Desktop/stepper-design-suggestion-00df8a78d30d9217e738d56ede40cecc20eed59b/stepper-engine/src/mta/course/java/stepper/ex1.xml";
        if(isFileExistAndFromTypeXml(path)) {
            ParseXml parseXml = new ParseXml(path);
            StepperDefinitionImpl stepper = parseXml.convertingGeneratedClasses();
        }

    }

    static boolean isFileExistAndFromTypeXml(String path) {
        File file = new File(path);
        return file.exists() && file.getName().endsWith(".xml");
    }
}
