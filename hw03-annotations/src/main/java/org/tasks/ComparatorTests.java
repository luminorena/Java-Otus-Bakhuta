package org.tasks;


import org.tasks.annotations.AfterEach;
import org.tasks.annotations.BeforeEach;
import org.tasks.annotations.ErrorGeneration;
import org.tasks.annotations.Test;


public class ComparatorTests {
    private Comparator comparator;

    @BeforeEach
    public void before() {
        comparator = new Comparator(12, 1);
        if (comparator != null) {
            System.out.println("Comparator exists");
        } else throw new ErrorGeneration("Comparator cannot be created");

    }

    @Test
    public void greaterTest() {
        int a = 12;
        int b = 10;
        boolean greater = comparator.isGreater(a, b);
        if (!greater) {
            throw new ErrorGeneration("The number " + a + " is not greater than " + b);
        }
    }

    @Test
    public void lessTest() {
        int a = 9;
        int b = 16;
        boolean less = comparator.isLess(a, b);
        if (!less) {
            throw new ErrorGeneration("The number " + a + " is not less than " + b);
        }
    }

    @AfterEach
    public void after() {
        comparator = null;
        System.out.println("Comparator is destroyed");
    }


}
