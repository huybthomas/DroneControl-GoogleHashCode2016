package be.thevaultraiders;

/**
 * Created by Arthur on 11/02/2016.
 */

import be.thevaultraiders.models.Product;
import be.thevaultraiders.models.Warehouse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {

    public static void main(String[] args){
        new TextFileReader("files/busy_day.in");
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
            String sCurrLineSplit[] = sCurrentLine.split(" ");
            System.out.println(sCurrLineSplit[0]);
            System.out.println(sCurrLineSplit[1]);
            System.out.println(sCurrLineSplit.length);

            int nRows = Integer.parseInt(sCurrLineSplit[0]);
            int nCols = Integer.parseInt(sCurrLineSplit[1]);
            int nDrones = Integer.parseInt(sCurrLineSplit[2]);
            int tDeadline = Integer.parseInt(sCurrLineSplit[3]);
            int maxLoad = Integer.parseInt(sCurrLineSplit[4]);

            int[] weights = parseWeights();

            sCurrentLine = reader.readLine();
            line++;
            int nWarehouses = Integer.parseInt(sCurrentLine);
            Warehouse[] warehouses = parseWarehouses(nWarehouses, weights);
            System.out.println("End Parse");
            /*
            while ((sCurrentLine != null && !sCurrentLine.contains("]"))) {

                switch(sCurrentLine){
                    case "OBJECTS[":{
                        System.out.println("\"OBJECTS\" detected, parsing...");
                        break;
                    }
                }
                sCurrentLine = reader.readLine();
                line++;
            }
            */

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

    private int[] parseWeights() {
        String[] sCurrLineSplit;
        try {
            sCurrentLine = reader.readLine();
            line++;
            //Read First Line
            int nProducts = Integer.parseInt(sCurrentLine);
            sCurrentLine = reader.readLine();
            line++;
            sCurrLineSplit = sCurrentLine.split(" ");
        }catch(Exception e){
            System.err.println("Parse Exception");
            sCurrLineSplit = new String[0];
        }

        int[] weights = new int[sCurrLineSplit.length];
        for(int i=0; i<sCurrLineSplit.length; i++){
            weights[i]=(Integer.parseInt(sCurrLineSplit[i]));
        }
        return weights;
    }

    private Warehouse[] parseWarehouses(int nWarehouses, int[] weights){
        //public Warehouse(int locX, int locY, int numProductTypes)
        Warehouse[] warehouses = new Warehouse[nWarehouses];
        for(int i=0; i<nWarehouses; i++){
            try {
                sCurrentLine = reader.readLine();
                line++;
                //Read First Line
                String sCurrLineSplit[] = sCurrentLine.split(" ");
                warehouses[i] = new Warehouse(Integer.parseInt(sCurrLineSplit[0]), Integer.parseInt(sCurrLineSplit[1]), weights.length);

                sCurrentLine = reader.readLine();
                line++;
                String sCurrLineSplit2[] = sCurrentLine.split(" ");
                List<Product> list = new ArrayList<Product>();
                for(int j=0; j<sCurrLineSplit2.length; j++){
                    for(int k=0; k<Integer.parseInt(sCurrLineSplit2[j]); k++){
                        list.add(new Product(j, weights[j]));
                    }
                }
                warehouses[i].addProducts(list);

            }catch(Exception e){
                warehouses = new Warehouse[0];
            }
        }
        return warehouses;
    }
}
