package com.codecool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class FilePartReaderTest {

//    @BeforeAll
//    static void setup() {
//        FilePartReader filePartReader = new FilePartReader();
//    }

    @Test
    void testReadWhenFilePathWrong() {
        FilePartReader filePartReader = new FilePartReader();
        Assertions.assertThrows(IOException.class, filePartReader::read);
    }

    @Test
    void testSetupWhenToLineSmallerThanFromLine() {
        FilePartReader filePartReader = new FilePartReader();
        Assertions.assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("src/main/resources/test.txt", 4, 2), "Illegal argument, try again");
    }

    @Test
    void testSetupWhenFromLineSmallerThanZero() {
        FilePartReader filePartReader = new FilePartReader();
        Assertions.assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("src/main/resources/test.txt", -4, 2), "Illegal argument, try again");
    }

//    @Test
//    void readLines() {
//    }
//
//    @Test
//    void getFilePath() {
//    }
//
//    @Test
//    void getFromLine() {
//    }
//
//    @Test
//    void getToLine() {
//    }
}