package com.codecool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FileWordAnalyzerTest {
    public static FilePartReader filePartReader;
    public static FileWordAnalyzer fileWordAnalyzer;


    @BeforeAll
    public static void setup(){
        filePartReader = new FilePartReader();
        filePartReader.setup("/home/ozukyo/Dokumenty/web/assignments/filepartreader-testing-with-junit-Ozukyo/src/main/resources/sample.txt", 1, 1);
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }


    @Test
    public void testGetWordsOrderedAlphabeticallyWhenListCorrect() throws IOException {
        List<String> expected = new ArrayList<>(Arrays.asList("a", "and", "anna", "checking", "dreary", "i", "madam", "midnight", "omo", "once", "palindrome", "pondered", "upon", "weak", "weary", "while"));
        Assertions.assertEquals(expected, fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void testgetWordsContainingSubstring() throws IOException {
        List<String> expected = new ArrayList<>(Arrays.asList("once", "upon", "pondered"));
        Assertions.assertEquals(expected, fileWordAnalyzer.getWordsContainingSubstring("on"));
    }

    @Test
    void testgetStringsWhichPalindromes() throws IOException {
        List<String> expected = new ArrayList<>(Arrays.asList("madam", "anna", "omo"));
        Assertions.assertEquals(expected, fileWordAnalyzer.getStringsWhichPalindromes());
    }


}