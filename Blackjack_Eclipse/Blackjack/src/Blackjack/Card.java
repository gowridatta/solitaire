package Blackjack;

/**
 * Card.java
 *
 * <code>Card</code> represents a playing card.
 * @author Dhiraj Koppanathi
 * @version 5/9/2019
 * 
 */
public class Card {

    /**
     * String value that holds the suit of the card
     */
    private String suit;

    /**
     * String value that holds the rank of the card
     */
    private String rank;    
    
    /**
     * String value that holds the image file of the card.
     */
    private String img;

    /**
     * integer value that holds the face value of the card.
     */
    private int pointValue;
    


   /**
     * Creates a new <code>Card</code> instance.
     *
     * @param cardRank  a <code>String</code> value
     *                  containing the rank of the card
     * @param cardSuit  a <code>String</code> value
     *                  containing the suit of the card
     * @param cardPointValue an <code>int</code> value
     *                  containing the point value of the card
     */
    public Card(String cardRank, String cardSuit, int cardPointValue) {
        //initializes a new Card with the given rank, suit, and point value
        setRank(cardRank);
        setSuit(cardSuit);
        setImg("cards/" + cardRank + cardSuit + ".gif");
        setPointValue(cardPointValue);
    }


    /**
     * Accesses this <code>Card's</code> suit.
     * @return this <code>Card's</code> suit.
     */
    public String suit() {
        return suit;
    }

    /**
     * Accesses this <code>Card's</code> rank.
     * @return this <code>Card's</code> rank.
     */
    public String rank() {
        return rank;
    }

    /**
     * Accesses this <code>Card's</code> image file.
     * @return this <code>Card's</code> img.
     */
   public String getImg() {
		return img;
	}
   
	/**
     * Accesses this <code>Card's</code> point value.
     * @return this <code>Card's</code> point value.
     */
    public int pointValue() {
        return pointValue;
    }
    
    /**
     * Sets this <code>Card's</code> suit.
     * @param String suit.
     */
    public void setSuit(String suit) {
    	if(suit.equals("spades")   ||
    	   suit.equals("hearts")   ||
    	   suit.equals("diamonds") ||
    	   suit.equals("clubs")) {
    		this.suit = suit;
    	} else {
    		throw new IllegalArgumentException("Invalid Suit");
    		}
    }
    
    /**
     * Sets this <code>Card's</code> rank.
     * @param String rank.
     */
	public void setRank(String rank) {
		if (rank.equals("ace")   ||
			rank.equals("2")     ||
			rank.equals("3")     ||
			rank.equals("4")     ||
			rank.equals("5")     ||
			rank.equals("6")     || 
			rank.equals("7")     ||
			rank.equals("8")     ||
			rank.equals("9")     ||
			rank.equals("10")    ||
			rank.equals("jack")  ||
			rank.equals("queen") ||
			rank.equals("king")) 
		{
			this.rank = rank;
		}
		else {
			throw new IllegalArgumentException("Invalid Rank");
		}
	}

   /**
    * Sets this <code>Card's</code> image file.
    * @param String img.
    */
	public void setImg(String img) {
		this.img = img;
	}

   /**
	* Sets this <code>Card's</code> face value.
	* @param int val.
	*/	
	public void setPointValue(int val) {
		if (val >= 1 && val <= 11) {
			this.pointValue = val;
		}
		else {
			throw new IllegalArgumentException("Invalid Point Value");
		}
	}

   
    /** Compare this card with the argument.
     * @param otherCard the other card to compare to this
     * @return true if the rank, suit, and point value of this card
     *              are equal to those of the argument;
     *         false otherwise.
     */
    public boolean matches(Card otherCard) {
        return otherCard.suit().equals(this.suit())
            && otherCard.rank().equals(this.rank())
            && otherCard.pointValue() == this.pointValue();
    }

	/**
	 * Converts the rank, suit, and point value into a string in the format
	 *     "[Rank] of [Suit] (point value = [PointValue])".
	 * This provides a useful way of printing the contents
	 * of a <code>Deck</code> in an easily readable format or performing
	 * other similar functions.
	 *
	 * @return a <code>String</code> containing the rank, suit,
	 *         and point value of the card.
	 */
	@Override
	public String toString() {
		return rank + " of " + suit + " (point value = " + pointValue + ")";
	}
}

