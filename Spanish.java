import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Spanish extends Button
{
    public Spanish(GreenfootImage btnImg, Runnable action)
    {
        super(btnImg, action);
    }
    
    public String getLanguage(){
        return "spanish";
    }
}
