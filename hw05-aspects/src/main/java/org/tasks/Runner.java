package org.tasks;

public class Runner {
    public static void main(String[] args) {
        var dataHelper = new DataHelper();
        PrintLinesInterface printLinesInterface = Ioc.createPrintLines();
        printLinesInterface.printInteger(dataHelper.rndInt);
        printLinesInterface.printStrings(dataHelper.name, dataHelper.email);
    }
}
