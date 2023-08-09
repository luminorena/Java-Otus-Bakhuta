package org.tasks;


import org.tasks.annotations.After;
import org.tasks.annotations.Before;
import org.tasks.annotations.ErrorGeneration;
import org.tasks.annotations.Test;


public class ComparatorTests {
    private static Comparator comparator;

    @Before
    public static void before() {
        comparator = new Comparator(12, 1);
        if (comparator != null) {
            System.out.println("Comparator exists");
        } else throw new ErrorGeneration("Comparator cannot be created");

    }

    @Test
    public static void greaterTest() {
        int a = 12;
        int b = 10;
        boolean greater = Comparator.isGreater(a, b);
        if (!greater) {
            throw new ErrorGeneration("The number " + a + " is not greater than " + b);
        }
    }

    @Test
    public static void lessTest() {
        int a = 9;
        int b = 16;
        boolean less = Comparator.isLess(a, b);
        if (!less) {
            throw new ErrorGeneration("The number " + a + " is not less than " + b);
        }
    }

    @After
    public static void after() {
        comparator = null;
        System.out.println("Comparator is destroyed");
    }


}
