/**
 * 
 */
package Solitaire;

import java.util.ArrayList;

/**
 * @author Dhiraj Koppanathi
 * @version 5/1/2019
 */
public class Deck {
	
	public ArrayList<Card> dealtCards = new ArrayList<Card>();
	public ArrayList<Card> undealtCards = new ArrayList<Card>();
	private int size;
	
	private static final String[] SUITS = {"hearts", "spades", "diamonds", "clovers"};
	private static final String[] RANKS = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
	
	public Deck() {
		createDeck();
		shuffle();
	}
	
	public void createDeck(){
		for (String s : SUITS) {
			for (String r : RANKS) {
				Card c = new Card(s, r);
				undealtCards.add(c); 
			}
		}
		setSize(undealtCards.size());
	}
	
	public void shuffle() {
		for (int k = undealtCards.size() - 1; k > 0; k--) {
			int howMany = k + 1;
			int start = 0;
			int randPos = (int) (Math.random() * howMany) + start;
			Card temp = undealtCards.get(k);
			undealtCards.set(k, undealtCards.get(randPos));
			undealtCards.set(randPos, temp);
		}
		size = undealtCards.size();
	}
	
	public Card deal() {
		if (undealtCards.isEmpty()) {
			return null;
		}
		size--;
		Card c = undealtCards.remove(size);
		dealtCards.add(c);
		return c;
	}
	
	public int getSize() {
		return size;
	}
	
	private void setSize(int size) {
		this.size = size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

}
