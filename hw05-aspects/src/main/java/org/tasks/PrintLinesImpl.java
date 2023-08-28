package org.tasks;

public class PrintLinesImpl implements PrintLinesInterface{

    @Log
    @Override
    public void printInteger(int printValue) {
        System.out.println("print integer line: " + printValue);
    }

    @Log
    @Override
    public void printStrings(String first, String second) {
        System.out.println("print strings: " + "first string " + first +
                " second string " + second);

    }
}
