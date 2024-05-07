import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameofLife extends World
{
    private boolean paused = true;
    private int currentPattern = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameofLife()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(30, 20, 26); 
        addCells();
        prepare();
    }
    public void setCurrentPattern(int p)
    {
        currentPattern = p;
    }
    public void radar(int x, int y)
    {
        runPattern(currentPattern, x, y);
        currentPattern = 0;
        
        
    }
    public void clear()
    {
        List <Cell> cells = getObjects(Cell.class);
        for (Cell c:cells)
            c.setLive(false);
    }
    public boolean paused()
    {
        return paused;
    }
    public void pause()
    {
        paused = !paused;
    }
    private void addCells()
    {
        for (int i = 1; i<29; i++)
        for (int j = 1; j < 19; j++)
        addObject(new Cell(Greenfoot.getRandomNumber(10)<2), i, j);
    }
    private void prepare()
    {
        Button button = new Button("PAUSED");
        addObject(button,2,19);
        Button button2 = new Button("CLEAR");
        addObject(button2,8,27);
        Button button3 = new Button("Glider");
        addObject(button3,14,27);
        Button button4 = new Button("Ten-In-A-Row");
        addObject(button4,20,27);
    }
    int [][][] patt = {{{0,0}},{{0,-1},{1,0},{-1,1},{0,1},{1,1}}, //glider
    {{-4,0},{-3,0},{-2,0},{-1,0},{0,0},{1,0},{2,0},{3,0},{4,0},{5,0}} //ten in a row
    };
    public void runPattern(int yes, int x, int y)
    {
        for(int i=0; i<patt[yes].length; i++)
        {
            List <Cell> cells = getObjectsAt(x+patt[yes][i][0], y+patt[yes][i][1], Cell.class);
            if (cells.size()>0)
            
            cells.get(0).setLive(true);
        }
    }
}
