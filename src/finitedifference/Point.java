package finitedifference;

/**
 * @author Luc Bettaieb
 * EECS 309, Finite Difference Method
 * 
 * This class simulates a point in the grid.  Each point has an assigned value
 * and can be an edge or corner (or both).
 */
public class Point {
    private boolean corner;
    private boolean edge;
    
    private Point north;
    private Point south;
    private Point east;
    private Point west;
    
    private double voltage;
    
    public Point(){
        corner = false;
        
        edge = false;
        
        voltage = 0;
        
        north = null;
        south = null;
        east = null;
        west = null;
    }
    
    public void setNorth(Point p){
        this.north = p;
    }
    
    public void setSouth(Point p){
        this.south = p;
    }
    
    public void setEast(Point p){
        this.east = p;
    }
    
    public void setWest(Point p){
        this.west = p;
    }
    
    public double getVoltage(){
        return voltage;
    }
    
    public void setVoltage(double v){
        voltage = v;
    }
    
    public void setCorner(boolean b){
        corner = b;
    }
    
    public boolean isCorner(){
        return corner;
    }
    
    public Point getNorth(){
        return north;
    }
    
    public Point getSouth(){
        return south;
    }
    
    public Point getEast(){
        return east;
    }
    
    public Point getWest(){
        return west;
    }
}
