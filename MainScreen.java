import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MainScreen extends World
{
    public MainScreen()
    {    
        super(960, 540, 1);

        this.adjustBackground();
        this.createStartButton();
        
    }
    
    private void adjustBackground() 
    {
        GreenfootImage bg = this.getBackground();
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
    }
    
    private void createStartButton() 
    { 
        Spanish sbtn = new Spanish(new GreenfootImage("buttons/spanish.png"), () -> Greenfoot.setWorld(new Game("spanish")));
        this.addObject(sbtn, getWidth()/2-275, getHeight()/2);
        English btn = new English(new GreenfootImage("buttons/english.png"), () -> Greenfoot.setWorld(new Game("english")));
        this.addObject(btn, getWidth()/2, getHeight()/2);
        French fbtn = new French(new GreenfootImage("buttons/french.png"), () -> Greenfoot.setWorld(new Game("french")));
        this.addObject(fbtn, getWidth()/2+275, getHeight()/2);
    }
}
