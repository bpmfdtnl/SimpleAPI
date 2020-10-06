package zizheng.simpleapi;

import java.util.ArrayList;

/**
 * @author: billwang
 * @create: 10/5/20
 */

public class Request {
    String type;
    String prefix;
    ArrayList<Condition> conditions;
    ArrayList<String> keywords;

    public Request(String type, String prefix) {
        this.type = type;
        this.prefix = prefix;
    }

    public String getType() {
        return type;
    }


    public String getPrefix() {
        return prefix;
    }

    public ArrayList<Condition> getConditions() { return conditions; };

    public ArrayList<String> getKeywords() {
        return keywords;
    }
}
