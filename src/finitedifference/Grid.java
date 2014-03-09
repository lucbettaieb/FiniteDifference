package finitedifference;

/**
 * @author Luc Bettaieb
 * EECS 309, Finite Difference Method
 * 
 * This class simulates a grid of points with values at each point. It also
 * initialized the points so that each point knows its north, south, east, and
 * west neighbors.
 */
public class Grid {
    
    private int width;
    private int height;
    private Point[][] grid;
            
    public Grid(int x, int y){
       this.width = x;
       this.height = y;
       
       grid = new Point[y][x]; 
       
       for(int i = 0; i < y; i++)
            for(int j = 0; j < x; j++) {
                grid[i][j] = new Point();         
            }

       grid[0][0].setCorner(true);
       grid[0][x-1].setCorner(true);
       grid[y-1][0].setCorner(true);
       grid[y-1][x-1].setCorner(true);
       
       
       
       
       
       for(int i = 1; i < width-1; i++) { 
            for(int j = 1; j < height-1; j++) {
                
                    grid[j][i].setNorth(grid[j-1][i]);
                    grid[j][i].setSouth(grid[j+1][i]);
                    grid[j][i].setEast(grid[j][i+1]);
                    grid[j][i].setWest(grid[j][i-1]);
                    
            }
        }
    }
    
    public Point getPoint(int x, int y){
        return grid[y][x];
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public double[][] getVoltageArray(){
        
        double[][] r = new double[width][height];
        
        for(int i = 0; i < width; i++)
            for(int j = 0; j < height; j++) {
                r[i][j] = grid[j][i].getVoltage();         
            }
        
        
        return r;
    }
}
