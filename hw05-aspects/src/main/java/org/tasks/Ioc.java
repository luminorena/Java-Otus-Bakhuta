package org.tasks;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ioc {
    private static final List<Method> methods = new ArrayList<>();
    private static final Class<?> clazz = PrintLinesInterface.class;
    private Ioc() {}

    static PrintLinesInterface createPrintLines() {
        InvocationHandler handler = new DemoInvocationHandler(new PrintLinesImpl());
        final var declaredAnnotation = clazz.getDeclaredAnnotation(Log.class);
        if (declaredAnnotation != null) {
            methods.addAll(Arrays.asList(clazz.getMethods()));
        }
        else {
            for (Method method: clazz.getDeclaredMethods()) {
                final var annotation = method.getAnnotation(Log.class);
                if (annotation != null) {
                    methods.add(method);
                }
            }
        }
        return (PrintLinesInterface)
                Proxy.newProxyInstance(
                        Ioc.class.getClassLoader(),
                        new Class<?>[] {PrintLinesInterface.class},
                        handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final PrintLinesImpl myClass;

        DemoInvocationHandler(PrintLinesImpl myClass) {
            this.myClass = myClass;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (methods.contains(method)) {
                System.out.println("Method to execute now: " + method);
                System.out.println("Method's params are: ");
                for (Object o: args) {
                    System.out.println(o);
                }
            }
            return method.invoke(myClass, args);
        }

        @Override
        public String toString() {
            return "DemoInvocationHandler{" + "myClass=" + myClass + '}';
        }
    }
}
