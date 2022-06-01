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
    }  
    
    public void movement()
    {
        int randomNumber = Greenfoot.getRandomNumber(100);
        deltaY = 0;
        Counter++;
        
        if (randomNumber < 50)
        {
            deltaY = deltaY + EnemySpeed;
        }
        
        if (randomNumber > 50)
        {
            deltaY = deltaY - EnemySpeed;
        }
        
        setLocation(getX(), getY() + deltaY);
    }
}
