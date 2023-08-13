package org.tasks.annotations;

import org.tasks.ComparatorTests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class TestRunner {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Class<?> testClass = ComparatorTests.class;
        run(testClass);
    }

    public static void run(Class testClass) throws
            NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        int tests = 0;
        int passed = 0;
        for (Method m : testClass.getDeclaredMethods()) {
            final var constructor = testClass.getConstructor();
            final var newInstance = constructor.newInstance();
            if (m.isAnnotationPresent(Test.class) || m.isAnnotationPresent(Before.class) || m.isAnnotationPresent(After.class)) {
                tests++;
                try {
                    m.invoke(newInstance);
                    passed++;
                } catch (InvocationTargetException targetException) {
                    Throwable e = targetException.getCause();
                    System.out.println(m + " failed: " + e);
                } catch (IllegalAccessException exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }

        }
        System.out.printf("Passed: %d, Failed: %d%n",
                passed, tests - passed);

    }
}
