import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Game extends World
{
    // Used to generate, shuffle and maintain cards flipped in the world.
    private ArrayList<Card> board = new ArrayList<Card>();
    private ArrayList<Card> chosenCards = new ArrayList<Card>();
    private int correctChoices = 0;
    private static final int BOARD_SIZE = 12;
    private static final int DEFAULT_X_POS = 130;
    private static final int DEFAULT_Y_POS = 140;
    private static final int DEFAULT_Y2_POS = 400;
    
    private String language = "";
    public Game(String l)
    {    
        super(960, 540, 1);
        language = l;
        this.adjustBackground();
        this.prepareBoard();
        this.prepareGameWorld();
    }
    
    private void adjustBackground() 
    {
        GreenfootImage bg = this.getBackground();
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
    }
    
    private void prepareBoard() 
    {
        this.generateCards();
        Collections.shuffle(this.board);
    }
 
    
    private void generateCards() 
    {
        int cardAmount = BOARD_SIZE/2;
        for (int i = 1; i <= cardAmount; i++) 
        {
            this.board.add(new Card(i,language));
            this.board.add(new Card(i,language));
        }
    }
    
    private void prepareGameWorld() 
    {
        int initialBoardSize = board.size();
        
        for (int i = 0; i < initialBoardSize; i++) 
            this.addObject(board.remove(0), calculateX(i), calculateY(i));
    }
    
    private int calculateX(int count)
    {
        int newPos = DEFAULT_X_POS + (count * 140);
        // Recalculate position in case card is out of bounds
        if (newPos > this.getWidth()) 
        {
            count -= BOARD_SIZE/2;
            newPos = DEFAULT_X_POS + (count * 140);
        }
        
        return newPos;
    }
    
    private int calculateY(int count)
    {
        return (count >= BOARD_SIZE / 2) ? DEFAULT_Y2_POS : DEFAULT_Y_POS;
    }
    
    public void addChosenCards(Card card) 
    {
        this.chosenCards.add(card);
        
        if (this.chosenCards.size() == 2)
            this.handleChoice();
    }
    
    private void handleChoice() 
    {
        Card firstChoice = this.chosenCards.remove(0);
        Card secondChoice = this.chosenCards.remove(0);
        
        if (firstChoice.getId() != secondChoice.getId()) 
        {
            Greenfoot.playSound("sounds/wrong.mp3");
            Greenfoot.delay(50);
            firstChoice.flipCard();
            secondChoice.flipCard();
            return;
        }
        
        Greenfoot.playSound("sounds/correct.mp3");
        this.correctChoices += 2;
        if (this.correctChoices == BOARD_SIZE) 
            endGame();
    }
    
    private static void endGame() 
    {
        Greenfoot.playSound("sounds/win.mp3");
        Greenfoot.setWorld(new WinScreen());
    }

}
