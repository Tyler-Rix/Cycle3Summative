import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProtectiveOrb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProtectiveOrb extends Actor
{
    int Counter = 0;
    /**
     * Act - do whatever the ProtectiveOrb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        orbsCounter();
    } 
    
    public void orbsCounter()
    {
        Counter++;
        
        if (Counter == 100)
        {
            getWorld().removeObject(this);
            Counter = 0;
        }
    }
}
