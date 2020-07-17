package com.codecool;

import java.io.IOException;


public class App {

    public static void main(String[] args) throws IOException {
       FilePartReader filePartReader = new FilePartReader();
////       URL url = App.class.getResource("/sample.txt");
//        File file = new File("resources/sample.txt");
       filePartReader.setup("/home/ozukyo/Dokumenty/web/assignments/filepartreader-testing-with-junit-Ozukyo/src/main/resources/sample.txt", 1, 1);
       FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
       System.out.println(fileWordAnalyzer.getStringsWhichPalindromes());

    }
}
