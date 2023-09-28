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

    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger warningLogger = new WarningLogger(AbstractLogger.WARNING);
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(warningLogger);
        warningLogger.setNextLogger(infoLogger);

        return errorLogger;
    }

    private static AbstractLogger getDatabaseLoggerChain() {
        AbstractLogger databaseLogger = new DatabaseLogger(AbstractLogger.WARNING);
        return databaseLogger;
    }

    public static void main(String[] args) {
        // Create the console logger chain
        AbstractLogger consoleLoggerChain = getChainOfLoggers();

        // Create the database logger chain
        AbstractLogger databaseLoggerChain = getDatabaseLoggerChain();

        // Log messages using the console logger chain
        consoleLoggerChain.logMessage(AbstractLogger.INFO,
                "This is an information.");
        consoleLoggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information.");
        consoleLoggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
        consoleLoggerChain.logMessage(AbstractLogger.WARNING,
                "This is a warning information.");

        // Log messages using the database logger chain
        databaseLoggerChain.logMessage(AbstractLogger.INFO,
                "This is an information.");
        databaseLoggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information.");
        databaseLoggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
        databaseLoggerChain.logMessage(AbstractLogger.WARNING,
                "This is a warning information.");
    }
}

