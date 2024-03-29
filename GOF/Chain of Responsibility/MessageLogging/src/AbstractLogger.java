/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fa20-bse-001
 */
public abstract class AbstractLogger {
   public static int INFO = 1;
    public static int DEBUG = 2;
    public static int WARNING = 3; // Add WARNING level
    public static int ERROR = 4;
    
    protected int level;
    
    // Next logger in the chain
    protected AbstractLogger nextLogger;
    
    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }
    
    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }
    
    protected abstract void write(String message);
}

