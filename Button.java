import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor
{
    protected Runnable action;
    
    public Button(GreenfootImage btnImg, Runnable action) 
    {
        this.action = action;
        btnImg.scale(240, 100);
        setImage(btnImg);
    }
    
    public void act(){
        if (Greenfoot.mouseClicked(this)) {
            action.run();
        }
    }
}
