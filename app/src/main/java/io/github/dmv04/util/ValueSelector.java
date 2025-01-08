package io.github.dmv04.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ValueSelector {

    public static ArrayList<Map<String, Integer>> select(String[] sortingSet, HashMap<String, Integer> inputSet) {
        
        var completionsList = new ArrayList<Map<String, Integer>>();

        for (int i = 0; i < sortingSet.length; i++) {
            var tempMap = new LinkedHashMap<String, Integer>();
            for (Map.Entry<String, Integer> entry : inputSet.entrySet()) {
                if (entry.getKey().toString().startsWith(sortingSet[i])) {
                    tempMap.put(entry.getKey(), entry.getValue());
                }
            }
            completionsList.add(tempMap);
        }
        return completionsList;

    }
}
