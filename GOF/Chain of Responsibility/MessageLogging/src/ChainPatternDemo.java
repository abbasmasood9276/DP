/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fa20-bse-001
 */
public class ChainPatternDemo {

    private static AbstractLogger getChainOfLoggersForError() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    private static AbstractLogger getChainOfLoggersForAllLevels() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        AbstractLogger databaseLogger = new DatabaseLogger(AbstractLogger.WARNING);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        consoleLogger.setNextLogger(databaseLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        // Create separate chains for ERROR, DEBUG, INFO, and WARNING
        AbstractLogger errorChain = getChainOfLoggersForError();
        AbstractLogger allLevelsChain = getChainOfLoggersForAllLevels();

        // Log messages using the ERROR chain
        errorChain.logMessage(AbstractLogger.ERROR, "This is an error message.");
        errorChain.logMessage(AbstractLogger.DEBUG, "This is a debug message (not logged)....");
        errorChain.logMessage(AbstractLogger.INFO, "This is an info message (not logged).");

        System.out.println("----------------------");

        // Log messages using the INFO, DEBUG, WARNING, ERROR chain
        allLevelsChain.logMessage(AbstractLogger.ERROR, "This is an error message.");
        allLevelsChain.logMessage(AbstractLogger.DEBUG, "This is a debug message.");
        allLevelsChain.logMessage(AbstractLogger.INFO, "This is an info message.");
        allLevelsChain.logMessage(AbstractLogger.WARNING, "This is a warning message.");
    }
}