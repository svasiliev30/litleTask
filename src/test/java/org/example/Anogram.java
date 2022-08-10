package org.example;

import java.util.HashMap;
import java.util.Map;

public class Anogram {

    static String[] dict = {"evil", "ivel", "vell", "dwdsd", "ddde", "eddd",
            "wwwwwwwwwwwffwwwwwwwwwwwwwwwwwggwwwwwwwwww", "wwwwwwfwwwwwwwwwwwwwwwfwwwwwwwgwwwwwwwgwww",
            "listen", "hello", "silent", "world", "tinsel"};

    public static void main(String[] args) {
        for (int i = 0; i < dict.length; i++) {
            Map<Character, Integer> mapCharsMainWord = new HashMap<>();
            Map<Character, Integer> mapCharsMinorWord = new HashMap<>();
            String mainWord = dict[i];
            String minorWord = null;
            char[] charsMainWord = mainWord.toCharArray();
            for (int j = i + 1; j < dict.length; j++) {
                minorWord = dict[j];

                addCharsInToMap(mapCharsMainWord, mapCharsMinorWord, mainWord, charsMainWord, j);
                finalCheck(mapCharsMainWord, mapCharsMinorWord, mainWord, minorWord, charsMainWord);
            }
        }
    }

    private static void addCharsInToMap(Map<Character, Integer> mapCharsMainWord, Map<Character, Integer> mapCharsMinorWord,
                                        String mainWord, char[] charsMainWord, int j) {
        if (mainWord.length() == dict[j].length()) {
            char[] charsMinorWord = dict[j].toCharArray();

            for (int g = 0; g < charsMainWord.length; g++) {
                int resultMainWord = -1;
                int resultMinorWord = -1;

                try {
                    resultMainWord = mapCharsMainWord.get(charsMainWord[g]);
                }catch (NullPointerException ignored){}
                try {
                    resultMinorWord = mapCharsMinorWord.get(charsMinorWord[g]);
                }catch (NullPointerException ignored){}

                if (resultMainWord != -1) {
                    resultMainWord++;
                    mapCharsMainWord.put(charsMainWord[g], resultMainWord);
                } else {
                    mapCharsMainWord.put(charsMainWord[g], 1);
                }

                if (resultMinorWord != -1) {
                    resultMinorWord++;
                    mapCharsMinorWord.put(charsMinorWord[g], resultMinorWord);
                } else {
                    mapCharsMinorWord.put(charsMinorWord[g], 1);
                }
            }
        }
    }

    private static void finalCheck(Map<Character, Integer> mapCharsMainWord, Map<Character,
            Integer> mapCharsMinorWord, String mainWord, String minorWord, char[] charsMainWord) {
        int coincidences = -1;
        for (int w = 0; w < mainWord.length(); w++) {
            char getWalueByKey = charsMainWord[w];
            if (mainWord.length() == minorWord.length()) {
                    if (mapCharsMainWord.get(getWalueByKey).equals(mapCharsMinorWord.get(getWalueByKey))) {
                        coincidences++;
                    }
                    if (coincidences == mainWord.length() - 1) {
                        System.out.println("В слове " + mainWord + " и " + minorWord +
                                " одинаковое количество букв и их количество");
                    }
            } else {
                break;
            }
        }
    }
}
