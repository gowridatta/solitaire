/**
 * 
 */
package Blackjack;

/**
 * @author Dhiraj Koppanathi
 *
 */
public class BlackjackRunner {

	/**
	 * 
	 */
	public BlackjackRunner() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Board board = new BlackjackBoard();
		CardGameGUI gui = new CardGameGUI(board);
		gui.displayGame();
	}
		

}


