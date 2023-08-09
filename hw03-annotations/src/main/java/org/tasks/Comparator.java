package org.tasks;

import org.tasks.annotations.ErrorGeneration;
import org.tasks.annotations.Test;

public class Comparator {
    int a;
    int b;

    public Comparator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public static boolean isGreater(int a, int b) {
        return a > b;
    }

    public static boolean isLess(int a, int b) {
        return a < b;
    }


}
