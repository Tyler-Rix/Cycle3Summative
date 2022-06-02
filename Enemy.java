import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    int EnemySpeed = 5;
    int deltaY;
    int Counter = 0;
    int attackCounter = 0;
    int attackInterval = 30;
    int INTERVAL = 90;
    public Enemy()
    {
        GreenfootImage image = getImage();  
        image.mirrorHorizontally();
        setImage(image);
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
        attackTimer();
    }  
    
    public void movement()
    {
        int randomNumber = Greenfoot.getRandomNumber(100);
        deltaY = 0;
        Counter++;
        
        
        if (Counter == 2 * INTERVAL)
        {
            Counter = 0;
        }
      
        if (Counter < 1 * INTERVAL)
        {
            deltaY = deltaY + EnemySpeed;
          
        }
        else if (Counter > 1 * INTERVAL)
        {
            deltaY = deltaY - EnemySpeed;
          
        }
        
        setLocation(getX(), getY() + deltaY);
    }
    
    public void attack()
    {
        Bullet bullet = new Bullet();
        getWorld().addObject(bullet, getX(), getY());
    }
    
    public void attackTimer()
    {
        attackCounter++;
        
        if (attackCounter == 2 * attackInterval)
        {
            attackCounter = 0;
        }
        
        if (attackCounter == 0 * attackInterval)
        {
            attack();
        }
        else if (attackCounter == 1 * attackInterval)
        {
            attack();
        }
    }
}
