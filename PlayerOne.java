import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerOne extends Actor
{
    int deltaX;//Makes x movement a variable
    int deltaY;//Makes y movement a variable
    int PLAYERSPEED = 5;//Players speed
    int cooldown = 0;//Starts cooldown timer at zero
    ProtectiveOrb[] orbs = new ProtectiveOrb[8];//Makes orbs = 8 different orbs
    SimpleTimer timer = new SimpleTimer();//Makes new timer and timer a variable
    
    public PlayerOne()
    {
        orbs[0] = new ProtectiveOrb();//Sets the orbs
        for (int i = 0; i < orbs.length; i++)//Adds the orbs
        {
            orbs[i] = new ProtectiveOrb();
        }
        
        timer.mark();//Starts timer on game start
    }
    
    /**
     * Act - do whatever the PlayerOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
        orbsFollow();
        cooldown();
        time();
        gameOver();
    }
    
    
    
    public void time()
    {
        int time = timer.millisElapsed();//Makes time in milliseconds
        
        getWorld().showText("Time elapsed: " + time, 100 , 20);//Shows a timer in the top left
    }
    
    public void gameOver()
    {
        int time = timer.millisElapsed();//Makes time in milliseconds
        if (isTouching(Bullet.class))
        {
            Greenfoot.setWorld(new GameOver(time));//Makes gameover with time survived moving over
        }
    }
    
    public void cooldown()
    {
        if (cooldown > 0)//Checks if cooldown sis greater than zero
        {
            cooldown--;//Minuses cooldown till zero
        }
        if (Greenfoot.isKeyDown("c") && (cooldown == 0))//Checks cooldown is over and c is presses
        {
            spawnOrbs();//Calls spawn orbs
            cooldown = 350;//Cooldown is set to 350
            
        }
        
    }
    
    public void spawnOrbs()
    {
        int X = getX();//Gets players x 
        int Y = getY();//Gets players y
                
        
        for (int i = 0; i < orbs.length;i++)//Runs loop
        {
                getWorld().addObject(orbs[i], X , Y);//Adds orbs to center of player
                orbs[i].setRotation(i * 45);//Rotates orbs
                orbs[i].move(85);//moves them to final spot
        }
        
    }
    
    
    
    public void movement()
    {
        deltaY = 0;//Sets delta y
        deltaX = 0;//Sets delta x
        if (Greenfoot.isKeyDown("w"))//Is pressing w
        {
            deltaY = deltaY - PLAYERSPEED;//Sets delta why to minus player speed
        }
        
        if (Greenfoot.isKeyDown("s"))//Is pressing s
        {
            deltaY = deltaY + PLAYERSPEED;//Sets delta why to plus player speed
        }
        
        setLocation (getX() + deltaX, getY() + deltaY);//Sets the location of the player
    }
    
    public void orbsFollow()
    {
        
        
            for (int i = 0; i < orbs.length;i++)//Runs loop
            {
                 if (orbs[i].getWorld() == getWorld())//if orbs are in the world
                 {
                     orbs[i].setLocation(orbs[i].getX() + deltaX,orbs[i].getY() + deltaY);//Orbs follow player
                 }
            }
        
    }
}
