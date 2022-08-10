package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberChangeTest {
    int num = 0;
    List<String> listNumbers = Arrays.asList("912345","51525","1989",
            "994321", "851247", "182366754354673583464392749238647236478523845", "999", "1123213123123124567647593424324234");

    @Test
    public void startingChangeNumbers() {
        for (String listNumber : listNumbers) {
            changeNumbers(listNumber);
        }
    }

    private void changeNumbers(String number) {
        boolean isFound = false;
        int maxNumber = -1;
        int idMaxNumber = -1;
        int idChangeNumber = -1;
        String numberOld = number;
        char[] chars = number.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '9') {
                continue;
            }

            for (int p = i + 1; p < chars.length; p++) {
                if (chars[p] == '9') {
                    chars[p] = chars[i];
                    chars[i] = '9';
                    isFound = true;
                    break;
                }

                if (maxNumber < Character.getNumericValue(chars[p]) &&
                        Character.getNumericValue(chars[i]) < Character.getNumericValue(chars[p])) {
                    maxNumber = Character.getNumericValue(chars[p]);
                    idMaxNumber = p;
                    idChangeNumber = i;
                }

            }
            if (isFound) {
                break;
            }
            if (i == chars.length - 1 && (idChangeNumber != -1 && idMaxNumber != -1)) {
                char z = chars[idMaxNumber];
                chars[idMaxNumber] = chars[idChangeNumber];
                chars[idChangeNumber] = z;
            }
        }
        String numberResult = new String(chars);
        System.out.println("Cтарый результат - " + numberOld);
        System.out.println("Новый результат -  " + numberResult);
    }

    private void changeNumber(String number) {
        List<List<Integer>> streamList = Stream.of(number).
                map(q -> {
                    String[] str = q.split("");
                    List<Integer> list = new ArrayList<>();
                    for (int p = 0; p < str.length; p++) {
                        for (int i = p; i < str.length; i++) {
                            if (Integer.parseInt(str[p]) < Integer.parseInt(str[i])) {
                                str = q.split("");
                                String interResult = str[p];
                                str[p] = str[i];
                                str[i] = interResult;
                                String finishIfResult = Arrays.stream(str)
                                        .map(String::valueOf)
                                        .reduce((x, y) -> x + y)
                                        .get();
                                list.add(Integer.parseInt(finishIfResult));
                            }
                        }
                    }
                    return list;
                }).collect(Collectors.toList());
        System.out.println("Старое значение - " + listNumbers.get(num));
        num++;
        for (List<Integer> list : streamList) {
            Optional<Integer> maxNumber = list.stream().max(Integer::compare);
            System.out.println("Новое значение -  " + maxNumber.get());
        }
    }

    private void changeNumber2(String number) {
        String[] str = number.split("");
        List<Integer> list = new ArrayList<>();
        for (int p = 0; p < str.length; p++) {
            for (int i = p; i < str.length; i++) {
                if (Integer.parseInt(str[p]) < Integer.parseInt(str[i])) {
                    str = number.split("");
                    String interResult = str[p];
                    str[p] = str[i];
                    str[i] = interResult;
                    String finishIfResult = Arrays.stream(str)
                            .map(String::valueOf)
                            .reduce((x, y) -> x + y)
                            .get();
                    list.add(Integer.parseInt(finishIfResult));
                }
            }
        }
        System.out.println("Старое значение - " + listNumbers.get(num));
        num++;
        Optional<Integer> maxNumber = list.stream().max(Integer::compare);
        System.out.println("Новое значение -  " + maxNumber.get());
    }
}
//Старое значение - 12345
//Новое значение -  52341
//Старое значение - 51525
//Новое значение -  55125
//Старое значение - 1989
//Новое значение -  9189
//Старое значение - 991234
//Новое значение -  994231
//Старое значение - 851247
//Новое значение -  871245
