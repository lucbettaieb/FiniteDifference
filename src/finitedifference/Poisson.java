package finitedifference;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import org.tc33.jheatchart.HeatChart;
import java.awt.Dimension;

/**
 * @author Luc Bettaieb
 * EECS 309, Finite Difference Method for Poisson's Equation
 * 
 * HeatChart Library from http://www.javaheatmap.com/
 */
public class Poisson {
    static Grid theGrid = new Grid(20, 10); //Defines resolution of grid
    private final static int RESOLUTION = 100;
    private final static double RHO = Math.pow(10, -6);
    private final static double D = .1;
    private final static double EPSILON = 80*8.85* Math.pow(10,-12);
    
    
    
    
    
    public static void main(String[] kittens) throws IOException{
        System.out.println("Finite Difference Method for Poisson's Equation");
        initializeGrid();
        
        for(int hi = 0; hi < RESOLUTION; hi++){
            for(int i = 1; i < theGrid.getWidth()-1; i++){
                for (int j = 1; j < theGrid.getHeight()-1; j++){
                
                    theGrid.getPoint(i, j).setVoltage((.25) * ( theGrid.getPoint(i, j).getNorth().getVoltage() + theGrid.getPoint(i, j).getSouth().getVoltage() + theGrid.getPoint(i, j).getEast().getVoltage() + theGrid.getPoint(i, j).getWest().getVoltage() + ((RHO*D*D)/EPSILON)));
                
                }
            }
        }
        
        
        printGrid();
        HeatChart map = new HeatChart(theGrid.getVoltageArray());
        map.setTitle("Voltage Distribution, #2");
        map.setXAxisLabel("X Axis");
        map.setYAxisLabel("Y Axis");
        
        //map.setHighValueColour(Color.YELLOW);
        //map.setLowValueColour(Color.RED);
        
        map.saveToFile(new File("poisson.png"));
    }
    
    public static void initializeGrid(){
        for(int i = 0; i < theGrid.getWidth(); i++){
            
            //System.out.print("| ");
            for(int j = 0; j < theGrid.getHeight(); j++){
                theGrid.getPoint(0,j).setVoltage(10);
                
                
                
                if (theGrid.getPoint(i, j).isCorner()){
                    theGrid.getPoint(i, j).setVoltage(0);
                }
                
                //System.out.print(theGrid.getPoint(i, j).getVoltage() + " | "); 
                
            }
            
            //System.out.println();
        }
        
        
        
    }
    
    public static void printGrid(){
        
        DecimalFormat df = new DecimalFormat("#.###");
        
        for(int i = 0; i < theGrid.getWidth(); i++){
            
            
            for(int j = 0; j < theGrid.getHeight(); j++){
                
                System.out.print(df.format(theGrid.getPoint(i, j).getVoltage()) + "  \t "); 
                
            }
            
            System.out.println();
        }
    }
    
}
