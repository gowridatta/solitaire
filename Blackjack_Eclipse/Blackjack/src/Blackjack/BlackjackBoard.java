/**
 * 
 */
package Blackjack;

import java.util.List;

/**
 * @author Dhiraj Koppanathi
 *
 */
public class BlackjackBoard extends Board {
	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 24;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 11};
	
	
	public BlackjackBoard() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
		
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see Blackjack.Board#isLegal(java.util.List)
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see Blackjack.Board#anotherPlayIsPossible()
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int checkHandVal(List<Integer> Hand) {
		// TODO Auto-generated method stub
		int total = 0;
		for (Integer v : Hand) {
			total += v;
		}
		return total;
	}

}
