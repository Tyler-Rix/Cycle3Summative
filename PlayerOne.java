import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerOne extends Actor
{
    int deltaY;
    int PLAYERSPEED = 5;
    /**
     * Act - do whatever the PlayerOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
    }
    
    public void movement()
    {
        deltaY = 0;
        
        if (Greenfoot.isKeyDown("w"))
        {
            deltaY = deltaY - PLAYERSPEED;
        }
        
        if (Greenfoot.isKeyDown("s"))
        {
            deltaY = deltaY + PLAYERSPEED;
        }
        
        setLocation(getX(), getY() + deltaY);
    }
}
