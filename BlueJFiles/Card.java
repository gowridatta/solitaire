
/**
 * Write a description of class Card here.
 * 
 * @author Dhiraj Koppanathi 
 * @version 4/25/2019
 */
public class Card
{
    // instance variables - replace the example below with your own
    private int val;
    private String suit;
    private String rank;
    private int color;
    public static final int RED = 1;
    public static final int BLUE = 0;

    /**
     * Constructor for objects of class Card
     */
    public Card(int v, String s, String r, int c)
    {
        setVal(v);
        setSuit(s);
        setRank(r);
        setColor(c);
        
    }

    /**
     * Setter Method for Value of Card
     * 
     * @param  v   value of the card 
     */
    public void setVal(int v)
    {
        // put your code here
        this.val = v;
    }
    /**
     * Getter Method for Value of Card
     * 
     * @return  v   value of the card 
     */
    public int getVal()
    {
        // put your code here
        return this.val;
    }
    /**
     * Setter Method for Suit of Card
     * 
     * @param  s   suit of the card
     */
    public void setSuit(String s)
    {
        // put your code here
        this.suit = s;
    }
    /**
     * Getter Method for Suit of Card
     * 
     * @return  s   suit of the card 
     */
    public String getSuit()
    {
        // put your code here
        return this.suit;
    }
    /**
     * Setter Method for Rank of Card
     * 
     * @param  r   rank of the card 
     */
    public void setRank(String r)
    {
        // put your code here
        this.rank = r;
    }
    /**
     * Getter Method for rank of Card
     * 
     * @return  r   rank of the card 
     */
    public String getRank()
    {
        // put your code here
        return this.rank;
    }
    /**
     * Setter Method for Color of Card
     * 
     * @param  c   color of the card 
     */
    public void setColor(int c)
    {
        // put your code here
        this.color = c;
    }
    /**
     * Getter Method for Color of Card
     * 
     * @return  c   value of the card 
     */
    public int getColor()
    {
        // put your code here
        return this.color;
    }
}
