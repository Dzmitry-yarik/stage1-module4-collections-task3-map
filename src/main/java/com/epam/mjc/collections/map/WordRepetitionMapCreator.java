package com.epam.mjc.collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordRepetitionMapCreator {
    public Map<String, Integer> createWordRepetitionMap(String sentence) {
        String w = " " + sentence;
        Map<String, Integer> word_map = new HashMap<>();
        String s = w.toLowerCase();
        String[] words = s.split("\\W");

        for (int i = 0; i < words.length - 1; i++) {
            int q = 1;
            for (int j = 1; j < words.length; j++) {

                if (words[i].equals(words[j]) && i != j) {
                    q++;
                }
            }
            if (!words[i].equals("")) {
                word_map.put(words[i], q);
            }
        }

        return word_map;
    }
}
