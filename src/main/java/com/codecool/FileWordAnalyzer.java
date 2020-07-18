package com.codecool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader fpr;

    public FileWordAnalyzer(FilePartReader fpr) {
        this.fpr = fpr;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        String[] arrayOfWords = getArrayOfWords();

        List<String> list = Arrays.asList(arrayOfWords);
        Collections.sort(list);


        return list;
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        String[] arrayOfWords = getArrayOfWords();
        List<String> listOfSubstrings = new ArrayList<>();

        for (String s : arrayOfWords) {
            if (s.contains(subString)) {
                listOfSubstrings.add(s);
            }
        }
        return listOfSubstrings;
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        String[] arrayOfWords = getArrayOfWords();
        List<String> listOfPalindromes = new ArrayList<>();

        for(String s: arrayOfWords) {
            char[] wordInChars= s.toCharArray();
            int firstIndex = 0;
            int lastIndex = wordInChars.length-1;

            while(lastIndex > firstIndex) {
                if(wordInChars[firstIndex] != wordInChars[lastIndex]) {
                    break;
                }
                ++firstIndex;
                --lastIndex;
            }

            if(lastIndex!=wordInChars.length-1) {
                listOfPalindromes.add(s);
            }

        }
        return listOfPalindromes;

    }

    public String[] getArrayOfWords() throws IOException {
        String str = fpr.readLines().replaceAll("[^a-zA-Z]+", " ");
        return str.toLowerCase().split(" ");
    }

}
