package zizheng.simpleapi;

import java.util.ArrayList;

/**
 * @author: billwang
 * @create: 10/5/20
 */
public class Wordcount {

    ArrayList<String[]> keywordFrequencies;

    public Wordcount(ArrayList<String[]> keywordFrequencies) {
        this.keywordFrequencies = keywordFrequencies;
    }

    public ArrayList<String[]> getKeywordFrequencies() {
        return keywordFrequencies;
    }
}
