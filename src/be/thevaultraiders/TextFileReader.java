package be.thevaultraiders;

/**
 * Created by Arthur on 11/02/2016.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {

    public static void main(String[] args){
        new TextFileReader();
    }

    private BufferedReader reader;
    private String sCurrentLine;
    private int line;

    public TextFileReader(String fileName){

        line = 1;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            sCurrentLine = reader.readLine();
            line++;
            //Read First Line
            String sCurrLineSplit[] = sCurrentLine.split();
            while ((sCurrentLine != null && !sCurrentLine.contains("]"))) {

                switch(sCurrentLine){
                    case "OBJECTS[":{
                        System.out.println("\"OBJECTS\" detected, parsing...");
                        readObjects();
                        break;
                    }
                }
                sCurrentLine = reader.readLine();
                line++;
            }

        }catch(StringIndexOutOfBoundsException e){
            System.err.println("Error occured at line " + line);
        }
        catch (IOException e) {
            System.err.println("Error occured at line " + line);
        } catch (NumberFormatException e) {
            System.err.println("Number parsing error occured at line " + line);
        } finally {
            try {
                if (reader != null)reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
