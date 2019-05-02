package Solitaire;

import java.util.ArrayList;

public class CardStack{
	
	Deck d = new Deck();
	private ArrayList<Card> row = new ArrayList<Card>();
	private int numRow;
	
	public CardStack(int r) {
		setNumRow(r);
		int i = 0;
		while (i < r) {
			row.add(d.deal());
			i++;
		}
		row.get(r-1).toggleFace();
	}

	public int getNumRow() {
		return numRow;
	}

	public void setNumRow(int numRow) {
		this.numRow = numRow;
	}
	
	public boolean isLegal(Card selected, Card moved) {
		if(((selected.getVal() - 1) == moved.getVal()) && 
			!(selected.getColor().equals(moved.getColor()))) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addCard(Card...cards) {
		for(Card c : cards) {
			row.add(c);
		}
	}
	
	public void removeCard(Card...cards) {
		for(Card c : cards) {
			row.remove(c);
		}
	}

}
