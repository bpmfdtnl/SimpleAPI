package zizheng.simpleapi;

import java.util.List;

/**
 * @author: billwang
 * @create: 10/5/20
 */

//This class represent a search criteria, type is the field
// and values is the list they must fall into.
public class Condition {
    String type;
    List<String> values;

    public Condition(String type, List<String> values) {
        this.type = type;
        this.values = values;
    }

    public String getType() {
        return type;
    }

    public List<String> getValue() {
        return values;
    }

}
