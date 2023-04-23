package dd.impl.mapping;

import dd.api.AbstractDataDefinition;

import java.util.Map;

public class mappingDataDefinition extends AbstractDataDefinition {
    public mappingDataDefinition(){
        super("Mapping",false, Map.class);
    }
}
