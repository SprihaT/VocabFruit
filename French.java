import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class French extends Button
{
    public French(GreenfootImage btnImg, Runnable action)
    {
        super(btnImg, action);
    }
    
    public String getLanguage(){
        return "french";
    }
}
