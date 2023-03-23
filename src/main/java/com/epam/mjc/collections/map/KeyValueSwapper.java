package com.epam.mjc.collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyValueSwapper {
    public Map<String, Integer> swap(Map<Integer, String> sourceMap) {
            Map<Integer, String> newSourceMap = new HashMap<>(sourceMap); //создаем копию sourceMap
        HashMap<String, Integer> rev = new HashMap<>(); //создаем новый перевернутый map

        List<String> s = new ArrayList<>(sourceMap.values()); //запопляем List значениями из sourceMap
        String a = "";
        int z = 0;

        //ищем повторяющееся значение в списке s
        for (int i = 0; i < s.size(); i++) {
            for (int j = 1; j < s.size(); j++) {
                if (s.get(i).equals(s.get(j)) && i != j) {
                    a = s.get(i);
                }
            }
        }

        for (Map.Entry<Integer, String> entry : sourceMap.entrySet()) { //перебираем значения sourceMap
            if (entry.getValue().equals(a)) { //ищем найденное из списка s значение в значениях sourceMap
                if (z > 0) { //до нахождения первого совпадения z = 0
                    if (z > entry.getKey()) { //если ключ первого элемента больше ключа второго...
                        newSourceMap.remove(z); //удаляем элемент с ключом равным z
                    } else {
                        newSourceMap.remove(entry.getKey()); //иначе удаляем элемент с ключом entry.getKey()
                    }
                }
                z = entry.getKey(); //после нахождения первого совпадения, присваеваем z ключ найденного значения
            }
        }

        for (Map.Entry<Integer, String> entry : newSourceMap.entrySet()) { //переворачиваем map
            rev.put(entry.getValue(), entry.getKey()); //присваеваем ключам rev значания newSourceMap, а значениям ключи
        }

        return rev;
    }
}
