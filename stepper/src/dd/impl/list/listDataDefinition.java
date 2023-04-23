package dd.impl.list;

import dd.api.AbstractDataDefinition;

import java.util.List;

public class listDataDefinition extends AbstractDataDefinition {
    public listDataDefinition(){
        super("List",false, List.class);
    }
}
