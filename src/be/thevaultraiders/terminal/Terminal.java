package be.thevaultraiders.terminal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Thomas on 11/02/2016.
 */
public class Terminal
{
    private TerminalReader terminalReader;

    /**
     * Creates the Terminal Object.
     */
    public Terminal()
    {
        //Setup terminal reader
        terminalReader = new TerminalReader();

        terminalReader.getObserver().addObserver(new Observer()
        {
            public void update(Observable source, Object object)
            {
                executeCommand((String) object);
            }
        });

        printStartup();
    }

    /**
     * Prints a message to the Terminal.
     * @param message   String
     */
    public void printTerminal(String message)
    {
        System.out.println(message);
    }

    /**
     * Prints info message to the Terminal.
     * @param message   String
     */
    public void printTerminalInfo(String message)
    {
        Calendar calender = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        System.out.println("[INFO - " + timeFormat.format(calender.getTime()) + "] " + message);
    }

    /**
     * Prints error message to the Terminal.
     * @param message   String
     */
    public void printTerminalError(String message)
    {
        Calendar calender = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        System.out.println("[ERROR - " + timeFormat.format(calender.getTime()) + "] " + message);
    }

    /**
     * Activates the terminal.
     */
    public void activateTerminal()
    {
        new Thread(terminalReader).start();
    }

    /**
     * Executes a command
     * @param commandString Command to be executed in String format
     */
    private void executeCommand(String commandString)
    {
        commandString = commandString.trim();

        if(commandString != null && !commandString.equals(""))
        {
            String command  = commandString.split(" ", 2)[0].toLowerCase();

            switch(command)
            {
                case "help":
                case "?":
                    help();
                    break;
                default:
                    printTerminalInfo("Command: '" + command + "' is not recognized. Type 'help' for available commands.");
                    break;
            }
        }
        activateTerminal();
    }

    /**
     * Prints startup info on the Terminal.
     */
    private void printStartup()
    {
        //Logo hashcode
        System.out.println("" +
                "        (((((    (((((                                                                                                                                         \n" +
                "        (((((   (((((                                                                                                                                          \n" +
                "        ((((    (((((                                                                                                                                          \n" +
                "       (((((    (((((                                                           ####                                                         ####              \n" +
                "       (((((   (((((              ####        ####                              ####                    ##########                           ####              \n" +
                " ((((((((((((((((((((((((         ####        ####                              ####                  ####     #####                         ####              \n" +
                " ((((((((((((((((((((((((         ####        ####     ######        ######     #### ###              ####      ####       ####          ### ####      ######  \n" +
                "      (((((   (((((               ####        ####   ##########    ##########   ############         ####              ##########      ##########    ##########\n" +
                "      (((((   (((((               ################  ####    ####  ####    ####  ####    ####         ####             ####     ####  ####    ####   ####    ###\n" +
                "     (((((    (((((               ################     #########   ########     ####    ####         ####             ####     #### ####     ####  ############\n" +
                "((((((((((((((((((((((((          ####        ####   ####   ####       ######   ####    ####         ####       ####  ####     #### ####     ####  ####        \n" +
                "((((((((((((((((((((((((          ####        ####  ####    ####  ####    ####  ####    ####          ####     #####  ####    ####   ####    ####   ####       \n" +
                "    (((((    (((((                ####        ####   ###########   ##########   ####    ####           ###########     ##########     ###########    ##########\n" +
                "    (((((   (((((                 ####        ####     ######         ####      ####    ####               ###             ###           #####          ####   \n" +
                "    (((((   (((((                                                                                                                                              \n" +
                "   (((((    (((((");

        //Group info
        System.out.println("\n\nGoogle Hash Code - 02/11/2016");
        System.out.println("Created by: The Vault Raiders");
        System.out.println("-----------------------------");
    }

    /**
     * Prints help for Terminal commands on the Terminal.
     */
    private void help()
    {
        printTerminal("Available commands:");
        printTerminal("-------------------");
        printTerminal("'help' / '?' : show all available commands.\n");
    }
}
