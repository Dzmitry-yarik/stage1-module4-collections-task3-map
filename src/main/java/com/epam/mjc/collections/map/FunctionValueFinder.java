package com.epam.mjc.collections.map;

import java.util.List;
import java.util.Map;

public class FunctionValueFinder {
    public boolean isFunctionValuePresent(List<Integer> sourceList, int requiredValue) {
           Map<Integer, Integer> functionMap = calculateFunctionMap(sourceList);

        for (Map.Entry<Integer, Integer> entry : functionMap.entrySet()) {
            if (entry.getValue().equals(requiredValue)) {
                return true;
            }
        }

        return false;
    }

    private Map<Integer, Integer> calculateFunctionMap(List<Integer> sourceList) {
     Map<Integer, Integer> functionMap = new HashMap<>();
        Integer k;

        for (int i = 0; i < sourceList.size(); i++) {
            k = 5 * sourceList.get(i) + 2;
            functionMap.put(sourceList.get(i), k);

        }
        return functionMap;
    }
}
