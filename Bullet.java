import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    int bulletSpeed = -10;
     public Bullet()
    {
        GreenfootImage image = getImage();  
        image.mirrorHorizontally();
        setImage(image);
    }
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveBullet();
        isTouching();
    }
    
    public void moveBullet()
    {
        move(bulletSpeed);
    }
    
    public void isTouching()
    {
        if (isTouching(ProtectiveOrb.class))
        {
            getWorld().removeObject(this);
            return;
        }
        
        if (getX() < 1)
        {
            getWorld().removeObject(this);
            return;
        }
    }
}
