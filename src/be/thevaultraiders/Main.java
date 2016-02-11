package be.thevaultraiders;

import be.thevaultraiders.service.DroneService;
import be.thevaultraiders.terminal.Terminal;

/**
 * Created by Thomas on 11/02/2016.
 */
public class Main
{
    private static Terminal terminal;
    private static DroneService droneService;

    public static void main(String[] args)
    {
        //setup terminal
        terminal = new Terminal();

        //setup droneService
        droneService = new DroneService();

        //

        terminal.activateTerminal();



    }

    /**
     * Read arguments on startup
     * @param args
     */
    private static void argsCommand(String[] args)
    {
        for(int i = 0; i < args.length; i++)
        {
            switch(args[i].toLowerCase())
            {
                default:
                    terminal.printTerminalInfo("Unknown option '" + args[i] + "'");
                    break;
            }
        }
    }

}
