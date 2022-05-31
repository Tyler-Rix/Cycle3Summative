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
    ProtectiveOrb[] orbs = new ProtectiveOrb[6];
    
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
    }
    
    public void spawnOrbs()
    {
        int X = getX();
        int Y = getY();
        
        if (Greenfoot.isKeyDown("c"))
        {
            for (int i = 1; i < 10;i++)
            {
                getWorld().addObject(orbs[0], X , Y + orbDistanceY);
                getWorld().addObject(orbs[1], X , Y - orbDistanceY);
                getWorld().addObject(orbs[2], X - orbDistanceX, Y );
                getWorld().addObject(orbs[3], X + orbDistanceX, Y );
            }
            // for (int i = 1; i < 10; i++)
            // {
                // int aX = X + 10;
                // int aY = Y;
                // getWorld().addObject(new ProtectiveOrb(), aY , aY);
            // }
        }
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
        orbs[0].setLocation(getX(), getY() + deltaY + orbDistanceY);
        orbs[1].setLocation(getX(), getY() + deltaY - orbDistanceY);
        orbs[2].setLocation(getX() - orbDistanceX, getY() + deltaY);
        orbs[3].setLocation(getX() + orbDistanceX, getY() + deltaY);
    }
}
