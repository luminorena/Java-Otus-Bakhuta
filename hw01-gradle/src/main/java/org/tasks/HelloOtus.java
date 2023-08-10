package org.tasks;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;

/*
Remove null values from the list
 */
public class HelloOtus {
    public static void main(String[] args) {
        List<String> names = Lists.newArrayList("Hello", null, "Otus");
        Iterables.removeIf(names, Objects::isNull);
        System.out.println(names);
    }
}
