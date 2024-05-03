import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Cell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cell extends Actor
{
    GreenfootImage liveImg, deadImg;
    boolean live = false; //dead is live=false
    boolean nextLive=false;
    boolean update = false; //alternative between update and calculate
    public Cell()
    {
        this(false);
    }
    
    public Cell(boolean a)
    {
        live = a;
        liveImg = new GreenfootImage(25,25); 
        liveImg.setColor(Color.YELLOW);
        liveImg.fill();
        
        deadImg = new GreenfootImage(25,25);
        deadImg.setColor(Color.GRAY);
        deadImg.fill();
        
        setImage(deadImg);
    }
    /**
     * Act - do whatever the Cell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
            live = !live;
        if (!((GameofLife)getWorld()).paused())
        {
            if (update)
                update();
            else calculate();
            update = !update;
        }
            
        if (update)
            update();
        else calculate();
        update = !update;
        if (live)
            setImage(liveImg);
        else setImage(deadImg);
    }
    private void update()
    {
        live=nextLive;
    }
    private void calculate()
    {
        List <Cell> friends = getNeighbours (1, true, Cell.class);
        int count = 0;
        for (Cell c:friends)
        {
            if (c.live)
                count++;
        }
        //1. If live and less than 2 live neighbours dies
        if (live && count<2)
        nextLive=false;
        //2. Any live cell with 2 or 3 neighbours says live
        else if (live && count<=3)
        nextLive=true;
              
        //3. Any live cell with more than 3 neighbours dies
        else nextLive=false;
        //4. Any dead cell with exactly 3 live neighbours become live
        if (!live && count==3)
        nextLive=true;
    }
}
