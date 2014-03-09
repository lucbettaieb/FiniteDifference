package finitedifference;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import org.tc33.jheatchart.HeatChart;

/**
 * @author Luc Bettaieb
 * EECS 309, Finite Difference Method for Laplace's Equation
 * 
 * HeatChart Library from http://www.javaheatmap.com/
 */

public class Laplace {
    static Grid theGrid = new Grid(20, 10); //Defines resolution of grid
    private final static int RESOLUTION = 100;
    
    public static void main(String[] kittens) throws IOException{
        System.out.println("Finite Difference Method for Laplace's Equation");
        initializeGrid();
        
        for(int hi = 0; hi < RESOLUTION; hi++){
            for(int i = 1; i < theGrid.getWidth()-1; i++){
                for (int j = 1; j < theGrid.getHeight()-1; j++){
                
                    theGrid.getPoint(i, j).setVoltage((.25) * ( theGrid.getPoint(i, j).getNorth().getVoltage() + theGrid.getPoint(i, j).getSouth().getVoltage() + theGrid.getPoint(i, j).getEast().getVoltage() + theGrid.getPoint(i, j).getWest().getVoltage()));
                
                }
            }
        }

        printGrid();
        HeatChart map = new HeatChart(theGrid.getVoltageArray());
        map.setTitle("Voltage Distribution, #1");
        map.setXAxisLabel("X Axis");
        map.setYAxisLabel("Y Axis");
        
        map.saveToFile(new File("laplace.png"));
    }
    
    public static void initializeGrid(){
        for(int i = 0; i < theGrid.getWidth(); i++){
            
            for(int j = 0; j < theGrid.getHeight(); j++){
                theGrid.getPoint(0,j).setVoltage(10);
                
                if (theGrid.getPoint(i, j).isCorner()){
                    theGrid.getPoint(i, j).setVoltage(0);
                }
                
            }
        }
        
        
        
    }
    
    public static void printGrid(){
        
        DecimalFormat df = new DecimalFormat("#.##");

        for(int i = 0; i < theGrid.getWidth(); i++){
            for(int j = 0; j < theGrid.getHeight(); j++){
                System.out.print(df.format(theGrid.getPoint(i, j).getVoltage()) + "  \t "); 
            }
            System.out.println();
        }
    }
    
}
