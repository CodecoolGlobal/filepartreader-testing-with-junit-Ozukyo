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
    public void testReadWhenFilePathWrong() {
        FilePartReader filePartReader = new FilePartReader();
        Assertions.assertThrows(IOException.class, filePartReader::read);
    }

    @Test
    public void testSetupWhenToLineSmallerThanFromLine() {
        FilePartReader filePartReader = new FilePartReader();
        Assertions.assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("src/main/resources/test.txt", 4, 2), "Illegal argument, try again");
    }

    @Test
    void testSetupWhenFromLineSmallerThanZero() {
        FilePartReader filePartReader = new FilePartReader();
        Assertions.assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("src/main/resources/test.txt", -4, 2), "Illegal argument, try again");
    }

    @Test
    public void testReadLinesWhenFilePathNull() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("", 2, 3);
        Assertions.assertThrows(IOException.class, filePartReader::readLines);
    }

    @Test
    public void testReadLinesWhenFilePathCorrect() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("/home/ozukyo/Dokumenty/web/assignments/filepartreader-testing-with-junit-Ozukyo/src/main/resources/test.txt",2,3);
        String actual = filePartReader.readLines();
        String expected = "Test Test Test\n" +
                "Tests are rather boring";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testReadLinesWhenFromLineAndToLineEqual() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("/home/ozukyo/Dokumenty/web/assignments/filepartreader-testing-with-junit-Ozukyo/src/main/resources/test.txt",1,1);

        String actual = filePartReader.readLines();
        String expected = "This is made for testing";
        Assertions.assertEquals(expected, actual);
    }

}