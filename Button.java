import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Button extends Label
{
    private String name;
    public Button(String str)
    {
        super(str, 26);
        name = str;
    }

    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            if (name.equals("PAUSED"))
            {
                ((GameofLife)getWorld()).pause();
                name="RUN";
                setValue(name);
            }
            else if (name.equals("RUN"))
            {
                ((GameofLife)getWorld()).pause();
                name="PAUSED";
                setValue(name);
            }
            else if (name.equals("CLEAR"))
            {
                ((GameofLife)getWorld()).clear();
            }
            else if (name.equals("Glider"))
            {
                ((GameofLife)getWorld()).setCurrentPattern(1);
            }
            else if (name.equals("Ten-In-A-Row"))
            {
                ((GameofLife)getWorld()).setCurrentPattern(2);
            }
        }
    }
}
