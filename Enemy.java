import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    int EnemySpeed = 5;//Enemy speed
    int deltaY;//Sets y as a variable
    int Counter = 0;//Sets counter to zero
    int attackCounter = 0;//Sets attackCounter to zero
    int attackInterval = 25;//Sets the attackInterval
    int INTERVAL = 90;//Sets interval to zero
    public Enemy()//Flips the enemy image
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
        deltaY = 0;//Sets delta y to zero
        Counter++;//Starts the counter
        
        
        if (Counter == 2 * INTERVAL)//Resets counter
        {
            Counter = 0;
        }
      
        if (Counter < 1 * INTERVAL)//If lower than 1 interval
        {
            deltaY = deltaY + EnemySpeed;//Sets delta y to plus enemy speed
          
        }
        else if (Counter > 1 * INTERVAL)//If higher than 1 interval
        {
            deltaY = deltaY - EnemySpeed;//Sets delta y to minus enemy speed
          
        }
        
        setLocation(getX(), getY() + deltaY);//Sets enemy location
    }
    
    public void attack()
    {
        Bullet bullet = new Bullet();//Makes new bullet
        getWorld().addObject(bullet, getX(), getY());//Adds bullet to the enemys location
    }
    
    public void attackTimer()
    {
        attackCounter++;//Starts counter
        
        if (attackCounter == 2 * attackInterval)//Resets counter
        {
            attackCounter = 0;
        }
        
        if (attackCounter == 0 * attackInterval)//If equal to 0 times attack interval
        {
            attack();//Runs attack
        }
        else if (attackCounter == 1 * attackInterval)//If equal to 1 times attack interval
        {
            attack();//Run attack
        }
    }
}
