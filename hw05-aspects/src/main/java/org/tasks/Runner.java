package org.tasks;

public class Runner {

    final static PrintLinesInterface printLinesInterface;

    static {
        printLinesInterface = Ioc.createPrintLines();
    }

    public static void main(String[] args) {
        var dataHelper = new DataHelper();
        printLinesInterface.printInteger(dataHelper.rndInt);
        printLinesInterface.printStrings(dataHelper.name, dataHelper.email);
    }

}
