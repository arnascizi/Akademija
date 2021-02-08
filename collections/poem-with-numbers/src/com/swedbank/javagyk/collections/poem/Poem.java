package com.swedbank.javagyk.collections.poem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Poem {

    private List<PoemLine> poemLines;

    public Poem(List<PoemLine> lines) {
        poemLines = lines;
    }

    public static void main(String[] args) throws IOException {

        Poem poem;

        File poemFile = Paths.get(System.getProperty("user.dir"), "poem.txt").toFile();
        if (!poemFile.exists()) {
            // Depending on workspace config, we might need to be more clear with filepath
            poemFile = Paths.get(System.getProperty("user.dir"), "poem-with-numbers", "poem.txt").toFile();
        }
        Reader reader = new Reader(poemFile);
        poem = new Poem(reader.read());

        poem.print();

        System.out.println("\nAnd now in reverse:\n");

        poem.sortLines();
        poem.print();

    }

    public void print() {
        for (PoemLine line : poemLines) {
            System.out.println(line.getNumber() + " " + line.getText());
        }
    }

    private void sortLines() {
        Comparator<PoemLine> reverseLineComparator = new PoemLineReverseComparator();
        Collections.sort(poemLines, reverseLineComparator);
    }
}
