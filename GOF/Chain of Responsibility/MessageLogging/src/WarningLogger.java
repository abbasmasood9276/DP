/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fa20-bse-001
 */
public class WarningLogger extends AbstractLogger {
    public WarningLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {		
        System.out.println("Warning Console::Logger: " + message);
    }
}