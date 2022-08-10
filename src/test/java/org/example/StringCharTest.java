package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StringCharTest {

    List<String> words = Arrays.asList("sso???????ng???r?ng", "asddd", "112345", "??????????????",
            "ssfdsfdsfsdfrr", "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd", "q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q?q");
    //    List<String> words = Arrays.asList("??????????????");
    //    char[] letters = {'q', 'w', 'e', 'r', 't', 'y', 'u',
//            'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h'};
    char[] letters = {'q', 'w', 'e'};
    char letter = 0;


    @Test
    public void startingChangeWord() {
        for (String word : words) {
            newChangeWord(word);
        }
    }


    public void newChangeWord(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                for (int j = 0; j < letters.length; j++) {
                    char letter = letters[j];
                    if ((i == 0 || letter != chars[i - 1]) && (i == chars.length - 1 || letter != chars[i + 1])) {
                        chars[i] = letter;
                        break;
                    }
                }

            }
        }
        System.out.println("1="+word);
        System.out.println("2="+String.valueOf(chars));

    }

    private boolean changeResult(String str) {
        boolean resultChange = str.chars()
                .mapToObj(c -> (char) c).
                allMatch(c -> {
                    if (c == '?' || letter == c) {
                        return false;
                    } else letter = c;
                    return true;
                });
        return resultChange;
    }


//    String result = word.chars()
//            .mapToObj(c -> (char) c).
//            map( let -> {
//                char letter = '0';
//                if (let == '?'){
//                    int idLetter = (int) Math.floor(Math.random() * letters.length);
//                    let = letters[idLetter];
//                    letter = let;
//                    return let;
//                }else if(letter == let){
//                    int idLetter = (int) Math.floor(Math.random() * letters.length);
//                    let = letters[idLetter];
//                    letter = let;
//                    return let;
//                }else letter = let;
//                return let;
//            }).collect(Collector.of(
//                    StringBuilder::new,
//                    StringBuilder::append,
//                    StringBuilder::append,
//                    StringBuilder::toString));
//
//        System.out.println( "Стало -" + result);


//      String str =String.valueOf( Stream.of(word.split("")).
//
//                filter( let -> let.toString().equals('?')).
//                map(let -> {
//                    int idLetter = (int) Math.floor(Math.random() * letters.length);
//                    let = String.valueOf(letters[idLetter]);
//                    return let;
//                }));


//        System.out.println(str);
//              filter(String::equals).map(let -> {
//                  int idLett = (int) Math.floor(Math.random() * letters.length);
//                  let = String.valueOf(letters[idLett]);
//                  return let;
//              }).
//                  int idLet = (int) Math.floor(Math.random() * letters.length);
//                  e = String.valueOf(letters[idLetter]);
//                  return e;


//              sorted((o,p) -> {
//                    if (o == p){
//                        int idLetter = (int) Math.floor(Math.random() * letters.length);
//                        o = String.valueOf(letters[idLetter]);
//                    }
//                    return o;
//                });


//       boolean result = word.chars().allMatch(lets -> lets == '?');
//                forEach(all -> System.out.println());
//        boolean result = word.chars().allMatch()
    //allmaths

//        Stream<char[]> streamOfArray = Arrays.stream(new char[][]{word.toCharArray()});
//                streamOfArray.filter(letter -> letter.equals('?'))
////                map( letterChange -> {
////                    int idLetter = (int) Math.floor(Math.random() * letters.length);
////                    String[] str = String.valueOf(letters[13]);
////                    letterChange = str; );
////                });
//        .forEach(p -> System.out.println(p));

    public void changeWord(String word) {
        char[] symbolVault = word.toCharArray();
        String finalResult = null;
        List<Integer> numbersQuestion = new ArrayList<>();
        List<Integer> numbersBad = new ArrayList<>();
        for (int i = 0; i < symbolVault.length; i++) {
            if (symbolVault[i] == '?') numbersQuestion.add(i);
        }

        changeSymbols(symbolVault, numbersQuestion);

        checkSymbols(symbolVault, numbersBad);

        checkResult(symbolVault, numbersBad);

        finalResult = String.valueOf(symbolVault);
        System.out.println("Стало - " + finalResult);
    }

    private void checkResult(char[] symbolVault, List<Integer> numbersBad) {
        if (numbersBad.size() != 0) {
            changeSymbols(symbolVault, numbersBad);
            numbersBad.clear();
            checkSymbols(symbolVault, numbersBad);

            checkResult(symbolVault, numbersBad);
        }
    }

    private void changeSymbols(char[] symbolVault, List<Integer> numbers) {
        numbers.stream().forEach(c -> {
            int idLetter = (int) Math.floor(Math.random() * letters.length);
            symbolVault[c] = letters[idLetter];
        });
    }

    private void checkSymbols(char[] symbolVault, List<Integer> numbersBad) {
//                        for (int z = 0; z < symbolVault.length; z++) {
//                            if (z == 0 && z + 1 < symbolVault.length) {
//                                variableOne = z + 1;
//                                symbolOne = symbolVault[z];
//                                symbolTwo = symbolVault[variableOne];
//                                if (symbolOne == symbolTwo) numbersBad.add(z);
//
//                            } else if (z + 1 < symbolVault.length) {
//                                variableOne = z - 1;
//                                symbolOne = symbolVault[variableOne];
//                                symbolTwo = symbolVault[z];
//                                variableTwo = z + 1;
//                                symbolThree = symbolVault[variableTwo];
//                                if (symbolOne == symbolTwo || symbolThree == symbolTwo) numbersBad.add(z);
//
//                            } else if (z + 1 <= symbolVault.length) {
//                                variableOne = z - 1;
//                                symbolTwo = symbolVault[z];
//                                symbolOne = symbolVault[variableOne];
//                                if (symbolOne == symbolTwo) numbersBad.add(z);
//                            }
//                        }
    }
}
