import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameofLife extends World
{
    private boolean paused = true;
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
        addObject(new Cell(Greenfoot.getRandomNumber(10)==0), i, j);
    }
    private void prepare()
    {
        Button button = new Button("PAUSED");
        addObject(button,2,19);
    }
}
