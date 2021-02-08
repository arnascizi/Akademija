package com.swedbank.javagyk.collections.poem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private File poemFile;

    public Reader(File poemFile) {
        this.poemFile = poemFile;
    }

    public BufferedReader getReaderFromFileName() throws FileNotFoundException {
        return new BufferedReader(new FileReader(poemFile));
    }

    public List<String> read() throws IOException {
        List<String> fileLines = new ArrayList<>();
        BufferedReader fileReader = getReaderFromFileName();
        String s;
        while ((s = fileReader.readLine()) != null) {
            fileLines.add(s);
        }

        return fileLines;
    }



}
