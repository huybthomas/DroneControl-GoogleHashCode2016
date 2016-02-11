package be.thevaultraiders.service;

import be.thevaultraiders.models.Simulation;
import be.thevaultraiders.terminal.Terminal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Thomas on 11/02/2016.
 */
public class TextFileWriter
{
    private BufferedWriter writer;
    private Terminal terminal;
    private String fileName;

    public TextFileWriter(String fileName, Terminal terminal)
    {
        this.fileName = fileName;
        this.terminal = terminal;
    }

    public void createOutputFile(Simulation simulation)
    {
        try
        {
            writer = new BufferedWriter(new FileWriter(fileName));

            //Write first line (Q: number of drone commands, D: number of drones, T: simulation time)


        }
        catch(IOException e)
        {
            terminal.printTerminalError("Error while writing to output file: '" + fileName);
        }
    }
}
