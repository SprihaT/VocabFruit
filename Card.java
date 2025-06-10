import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Card extends Actor
{
    private int id;
    private GreenfootImage cardImg;
    private static final GreenfootImage backImg = new GreenfootImage("back.jpg");
    private boolean isFlipped;
    
    public Card(int id, String language) 
    {
        this.id = id;
        //The language should be customized by the button that is pressed
        this.cardImg = new GreenfootImage("cards/"+ language +"_card_" + id + ".jpg");
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this) && !isFlipped) 
        {
            this.flipCard();
            ((Game)this.getWorld()).addChosenCards(this);
        }
    }
    
    public void flipCard() 
    {
       this.setImage(this.isFlipped ? backImg : this.cardImg);
       this.isFlipped = !this.isFlipped;
    }
    
    public int getId() 
    {
        return this.id;
    }
}
