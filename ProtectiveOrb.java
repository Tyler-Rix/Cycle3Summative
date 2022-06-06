import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProtectiveOrb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProtectiveOrb extends Actor
{
    int Counter = 0;//Sets counter to zero
    /**
     * Act - do whatever the ProtectiveOrb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        orbsCounter();
        removeOrbs();
    } 
    
    public void orbsCounter()
    {
        Counter++;//Starts counter
        
        if (Counter == 100)//If counter equals zero 
        {
            getWorld().removeObject(this);//Remove all orbs
            Counter = 0;//Set counter to zero
        }
    }
    
    public void removeOrbs()
    {
        //Why would you want to do this from a game point of veiw
        if (Greenfoot.isKeyDown("c") && (Greenfoot.isKeyDown("shift")))//Check if c and shift are pressed at the same time
        {
            getWorld().removeObject(this);//Remove all orbs
        }
    }
}
