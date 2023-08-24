package org.tasks;

import org.tasks.annotations.TestRunner;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException,
            IllegalAccessException, NoSuchMethodException {
        Class<?> testClass = ComparatorTests.class;
        TestRunner.testRunner.chooseAnnotation(testClass);
        TestRunner.testRunner.run(testClass);
    }
}
