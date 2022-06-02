import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerOne extends Actor
{
    int deltaX;
    int deltaY;
    int PLAYERSPEED = 5;
    int orbDistanceY = 65;
    int orbDistanceX = 80;
    boolean orbsInWorld = false;
    ProtectiveOrb[] orbs = new ProtectiveOrb[8];
    
    public PlayerOne()
    {
        orbs[0] = new ProtectiveOrb();
        for (int i = 0; i < orbs.length; i++)
        {
            orbs[i] = new ProtectiveOrb();
        }
        
    }
    
    /**
     * Act - do whatever the PlayerOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
        spawnOrbs();
        orbsFollow();
    }
    
    public void spawnOrbs()
    {
        int X = getX();
        int Y = getY();
        
        if (Greenfoot.isKeyDown("c") && orbsInWorld == false)
        {
            for (int i = 0; i < orbs.length;i++)
            {
                getWorld().addObject(orbs[i], X , Y);
                orbs[i].setRotation(i * 45);
                orbs[i].move(85);
            }
            
            orbsInWorld = true;
        }
        
        
    }
    
    public void movement()
    {
        deltaY = 0;
        deltaX = 0;
        if (Greenfoot.isKeyDown("w"))
        {
            deltaY = deltaY - PLAYERSPEED;
        }
        
        if (Greenfoot.isKeyDown("s"))
        {
            deltaY = deltaY + PLAYERSPEED;
        }
        
        setLocation (getX() + deltaX, getY() + deltaY);
    }
    
    public void orbsFollow()
    {
        
        
            for (int i = 0; i < orbs.length;i++)
            {
                 if (orbs[i].getWorld() == getWorld())
                 {
                     orbs[i].setLocation(orbs[i].getX() + deltaX,orbs[i].getY() + deltaY);
                 }
            }
        
    }
}
