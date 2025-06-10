import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class English extends Button
{
    public English(GreenfootImage btnImg, Runnable action)
    {
        super(btnImg, action);
    }
    
    public String getLanguage(){
        return "english";
    }
}
