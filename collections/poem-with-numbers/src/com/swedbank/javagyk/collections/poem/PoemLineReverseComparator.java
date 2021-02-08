package com.swedbank.javagyk.collections.poem;

import java.util.Comparator;

public class PoemLineReverseComparator implements Comparator<PoemLine> {

    // Implement this
    @Override
    public int compare(PoemLine o1, PoemLine o2) {
        if (o1.getNumber() > o2.getNumber()) {
            return -1;
        } else if (o1.getNumber() < o2.getNumber()) {
            return 1;
        } else {
            return 0;
        }
    }
}
