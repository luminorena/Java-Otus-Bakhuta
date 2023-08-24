package org.tasks.annotations;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class TestRunner {
    public ArrayList<Method> beforeEachList = new ArrayList<>();
    public ArrayList<Method> afterEachList = new ArrayList<>();
    public ArrayList<Method> testsList = new ArrayList<>();
    public int tests = 0;
    public int passed = 0;
    public static TestRunner testRunner = new TestRunner();


    public void chooseAnnotation(Class testClass) {
        final var declaredMethods = testClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            for (Annotation annotation :
                    method.getDeclaredAnnotations()) {
                switch (annotation.annotationType().getSimpleName()) {
                    case "BeforeEach" -> beforeEachList.add(method);
                    case "Test" -> testRunner.testsList.add(method);
                    case "AfterEach" -> testRunner.afterEachList.add(method);
                }
            }
        }

    }


    public void run(Class testRunner) throws InvocationTargetException,
            InstantiationException, IllegalAccessException, NoSuchMethodException {
        final var constructor = testRunner.getConstructor();
        for (Method test : testsList) {
            try {
                final var newInstance = constructor.newInstance();
                tests++;
                for (Method before : beforeEachList) {
                    try {
                        before.invoke(newInstance);
                    } catch (InvocationTargetException error) {
                        error.getTargetException().printStackTrace();
                    }
                }
                System.out.println("Test to invoke now: " + test.getName());
                test.invoke(newInstance);
                passed++;
                for (Method after : afterEachList) {
                    try {
                        after.invoke(newInstance);
                    } catch (InvocationTargetException error) {
                        error.getTargetException().printStackTrace();
                    }
                }
            } catch (InvocationTargetException error) {
                error.getTargetException().printStackTrace();
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n",
                passed, tests - passed);

    }

}