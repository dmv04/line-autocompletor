package io.github.dmv04.util;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MapSorter {
    public static String sortMap(Map<String, Integer> unsortedMap) {
        var tempMap = new TreeMap<String, Integer>(unsortedMap);
        var result = tempMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(e -> e.getKey())
                .collect(Collectors.joining("\n"));
        return result;
    }

}
