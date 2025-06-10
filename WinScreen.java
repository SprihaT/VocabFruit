import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class WinScreen extends World
{
    public WinScreen()
    {    
        super(960, 540, 1); 
        this.createRestartButton();
    }
    
        private void createRestartButton() 
    { 
        Button btn = new Button(new GreenfootImage("buttons/restart.png"), () -> Greenfoot.setWorld(new MainScreen()));
        this.addObject(btn, getWidth()/2, getHeight()/2 + 100);
    }
}
