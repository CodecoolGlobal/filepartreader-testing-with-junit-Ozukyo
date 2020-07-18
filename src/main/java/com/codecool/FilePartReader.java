package com.codecool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;


    public FilePartReader() {
        this.filePath = "invalid/path/text.txt";
        this.fromLine = 0;
        this.toLine = -1;

    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;

        if(toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException("Illegal argument, try again") ;
        }

    }

    public String read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;

        while((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }
        reader.close();

        return stringBuilder.toString().trim();

    }

    public String readLines() throws IOException {
        String [] textSplitted = read().split("\n");
        StringBuilder sb = new StringBuilder();

        for(int i = fromLine; i <=toLine; i++) {
            sb.append(textSplitted[i-1]);
            sb.append("\n");
        }
        return sb.toString().trim();
    }


}
