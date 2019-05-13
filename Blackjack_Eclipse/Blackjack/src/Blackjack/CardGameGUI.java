package Blackjack;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;

/**
 * This class provides a GUI for solitaire games related to Elevens.
 */
public class CardGameGUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** Height of the game frame. */
	private static final int DEFAULT_HEIGHT = 800;
	/** Width of the game frame. */
	private static final int DEFAULT_WIDTH = 800;
	/** Width of a card. */
	private static final int CARD_WIDTH = 73;
	/** Height of a card. */
	private static final int CARD_HEIGHT = 97;
	/** Row (y coord) of the upper left corner of the first card. */
	private static final int LAYOUT_TOP = 100;
	/** Column (x coord) of the upper left corner of the first card. */
	private static final int LAYOUT_LEFT = 100;
	/** Distance between the upper left x coords of
	 *  two horizonally adjacent cards. */
	private static final int LAYOUT_WIDTH_INC = 50;
	/** Distance between the upper left y coords of
	 *  two vertically adjacent cards. */
	private static final int LAYOUT_HEIGHT_INC = 100;
	/** y coord of the "Replace" button. */
	private static final int BUTTON_TOP = 30;
	/** x coord of the "Replace" button. */
	private static final int BUTTON_LEFT = 570;
	/** Distance between the tops of the "Replace" and "Restart" buttons. */
	private static final int BUTTON_HEIGHT_INC = 50;
	/** y coord of the "n undealt cards remain" label. */
	private static final int LABEL_TOP = 160;
	/** x coord of the "n undealt cards remain" label. */
	private static final int LABEL_LEFT = 540;
	/** Distance between the tops of the "n undealt cards" and
	 *  the "You lose/win" labels. */
	private static final int LABEL_HEIGHT_INC = 35;

	/** The board (Board subclass). */
	private Board board;

	/** The main panel containing the game components. */
	private JPanel panel;
	/** The hit button. */
	private JButton hitButton;
	/** The stay button. */
	private JButton stayButton;
	/** The "number of undealt cards remain" message. */
	private JLabel statusMsg;
	/** The "you've won n out of m games" message. */
	private JLabel totalsMsg;
	/** The card displays. */
	private JLabel[] playerDisplayCards;
	private JLabel[] compDisplayCards;
	
//	private ArrayList<Card> playerCards;
//	private ArrayList<Card> compCards;
	
	/** The win message. */
	private JLabel winMsg;
	/** The loss message. */
	private JLabel lossMsg;
	/** The coordinates of the card displays. */
	private Point[] playerCardCoords;
	private Point[] compCardCoords;

	/** kth element is true iff the user has selected card #k. */
	// private boolean[] selections;
	/** The number of games won. */
	private int totalWins;
	/** The number of games played. */
	private int totalGames;


	/**
	 * Initialize the GUI.
	 * @param gameBoard is a <code>Board</code> subclass.
	 */
	public CardGameGUI(Board gameBoard) {
		board = gameBoard;
		totalWins = 0;
		totalGames = 0;

		// Initialize cardCoords using 5 cards per row
		
		board.playerCards.add(board.deck.deal());
		board.playerCards.add(board.deck.deal());
		
		board.compCards.add(board.deck.deal());
		board.compCards.add(board.deck.deal());
		
		compCardCoords = new Point[12];
		playerCardCoords = new Point[12];
		
		
		compCardCoords[0] = new Point(LAYOUT_LEFT, LAYOUT_TOP);
		compCardCoords[1] = new Point(LAYOUT_LEFT + LAYOUT_WIDTH_INC, LAYOUT_TOP);
		
		playerCardCoords[0] = new Point(LAYOUT_LEFT, LAYOUT_TOP + LAYOUT_HEIGHT_INC);
		playerCardCoords[1] = new Point(LAYOUT_LEFT + LAYOUT_WIDTH_INC, LAYOUT_TOP + LAYOUT_HEIGHT_INC);

		// selections = new boolean[board.size()];
		initDisplay();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		repaint();
	}
	
	public Card dealCard() {
		Card r = board.deck.deal();
		return r;
	}

	/**
	 * Run the game.
	 */
	public void displayGame() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
			}
		});
	}
	
	public void displayCards() {
		System.out.println("Dealers Cards: ");
		for(int c = 0; c < board.compCards.size(); c++) {
			compCardCoords[c] = new Point(LAYOUT_LEFT * ((LAYOUT_WIDTH_INC) * (c+1)), LAYOUT_TOP);
			
			System.out.println(board.compCards.get(c));
		}
		
		compDisplayCards = new JLabel[(compCardCoords.length)];
		for (int k = 0; k < compCardCoords.length; k++) {
			compDisplayCards[k] = new JLabel();
			panel.add(compDisplayCards[k]);
			for (Point p : compCardCoords) {
				if (p != null) {
					compDisplayCards[k].setBounds(p.x, p.y,
										CARD_WIDTH, CARD_HEIGHT);
				}
			}
		}
		
		for (int k = 0; k < board.compCards.size(); k++) {
			String cardImageFileName =
					board.compCards.get(k).getImg();
			URL imageURL = getClass().getResource(cardImageFileName);
			if (imageURL != null) {
				ImageIcon icon = new ImageIcon(imageURL);
				compDisplayCards[k].setIcon(icon);
				compDisplayCards[k].setVisible(true);
			} else {
				throw new RuntimeException(
						"Card image not found: \"" + cardImageFileName + "\"");
			}
	    }
		
		System.out.println("Players Cards: ");
		for(int c = 0; c < board.playerCards.size(); c++) {
			playerCardCoords[c] = new Point(LAYOUT_LEFT * ((LAYOUT_WIDTH_INC) * (c+1)), LAYOUT_TOP + LAYOUT_HEIGHT_INC);
			
			System.out.println(board.playerCards.get(c));
		}
		
		playerDisplayCards = new JLabel[(playerCardCoords.length)];
		for (int l = 0; l < playerCardCoords.length; l++) {
			playerDisplayCards[l] = new JLabel();
			panel.add(playerDisplayCards[l]);
			for (Point p : playerCardCoords) {
				if (p != null) {
					playerDisplayCards[l].setBounds(p.x, p.y,
										CARD_WIDTH, CARD_HEIGHT);
				}
			}
		}
		
		for (int k = 0; k < board.playerCards.size(); k++) {
				String cardImageFileName =
									board.playerCards.get(k).getImg();
				URL imageURL = getClass().getResource(cardImageFileName);
				if (imageURL != null) {
						ImageIcon icon = new ImageIcon(imageURL);
						playerDisplayCards[k].setIcon(icon);
						playerDisplayCards[k].setVisible(true);
				} else {
						throw new RuntimeException(
								"Card image not found: \"" + cardImageFileName + "\"");
					}
		  
		}
		
		pack();
		panel.repaint();
	}

	/**
	 * Draw the display (cards and messages).
	 */
	public void repaint() {
		for (int k = 0; k < board.compCards.size(); k++) {
			String cardImageFileName =
					board.compCards.get(k).getImg();
			URL imageURL = getClass().getResource(cardImageFileName);
			if (imageURL != null) {
				ImageIcon icon = new ImageIcon(imageURL);
				compDisplayCards[k].setIcon(icon);
				compDisplayCards[k].setVisible(true);
			} else {
				throw new RuntimeException(
						"Card image not found: \"" + cardImageFileName + "\"");
			}
	    }
		
		for (int k = 0; k < board.playerCards.size(); k++) {
		     if (board.playerCards.get(k) != null) {
				String cardImageFileName =
									board.playerCards.get(k).getImg();
				URL imageURL = getClass().getResource(cardImageFileName);
				if (imageURL != null) {
						ImageIcon icon = new ImageIcon(imageURL);
						playerDisplayCards[k].setIcon(icon);
						playerDisplayCards[k].setVisible(true);
						} else {
								throw new RuntimeException(
										"Card image not found: \"" + cardImageFileName + "\"");
							}
		      }
		}
		
		displayCards();
		
		statusMsg.setText(board.deckSize()
			+ " undealt cards remain.");
		statusMsg.setVisible(true);
		totalsMsg.setText("You've won " + totalWins
			 + " out of " + totalGames + " games.");
		totalsMsg.setVisible(true);
		pack();
		panel.repaint();
	}

	/**
	 * Initialize the display.
	 */
	private void initDisplay()	{
		panel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};

		// If board object's class name follows the standard format
		// of ...Board or ...board, use the prefix for the JFrame title
		String className = board.getClass().getSimpleName();
		int classNameLen = className.length();
		int boardLen = "Board".length();
		String boardStr = className.substring(classNameLen - boardLen);
		if (boardStr.equals("Board") || boardStr.equals("board")) {
			int titleLength = classNameLen - boardLen;
			setTitle(className.substring(0, titleLength));
		}

		// Calculate number of rows of cards (5 cards per row)
		// and adjust JFrame height if necessary
		int numCardRows = 2;
		int height = DEFAULT_HEIGHT;
		if (numCardRows > 2) {
			height += (numCardRows - 2) * LAYOUT_HEIGHT_INC;
		}

		this.setSize(new Dimension(DEFAULT_WIDTH, height));
		panel.setLayout(null);
		panel.setPreferredSize(
			new Dimension(DEFAULT_WIDTH - 20, height - 20));
		playerDisplayCards = new JLabel[(playerCardCoords.length)];
		compDisplayCards = new JLabel[(compCardCoords.length)];
		for (int k = 0; k < compCardCoords.length; k++) {
			compDisplayCards[k] = new JLabel();
			panel.add(compDisplayCards[k]);
			for (Point p : compCardCoords) {
				if (p != null) {
					compDisplayCards[k].setBounds(p.x, p.y,
										CARD_WIDTH, CARD_HEIGHT);
				}

			}
		}
		for (int l = 0; l < playerCardCoords.length; l++) {
			playerDisplayCards[l] = new JLabel();
			panel.add(playerDisplayCards[l]);
			for (Point p : playerCardCoords) {
				if (p != null) {
					playerDisplayCards[l].setBounds(p.x, p.y,
										CARD_WIDTH, CARD_HEIGHT);
				}
			}
		}
			
			// displayCards[k].addMouseListener(new MyMouseListener());
			// selections[k] = false;

		hitButton = new JButton();
		hitButton.setText("Hit");
		panel.add(hitButton);
		hitButton.setBounds(BUTTON_LEFT, BUTTON_TOP, 100, 30);
		hitButton.addActionListener(this);

		stayButton = new JButton();
		stayButton.setText("Stay");
		panel.add(stayButton);
		stayButton.setBounds(BUTTON_LEFT, BUTTON_TOP + BUTTON_HEIGHT_INC,
										100, 30);
		stayButton.addActionListener(this);

		statusMsg = new JLabel(
			board.deckSize() + " undealt cards remain.");
		panel.add(statusMsg);
		statusMsg.setBounds(LABEL_LEFT, LABEL_TOP, 250, 30);

		winMsg = new JLabel();
		winMsg.setBounds(LABEL_LEFT, LABEL_TOP + LABEL_HEIGHT_INC, 200, 30);
		winMsg.setFont(new Font("SansSerif", Font.BOLD, 25));
		winMsg.setForeground(Color.GREEN);
		winMsg.setText("You win!");
		panel.add(winMsg);
		winMsg.setVisible(false);

		lossMsg = new JLabel();
		lossMsg.setBounds(LABEL_LEFT, LABEL_TOP + LABEL_HEIGHT_INC, 200, 30);
		lossMsg.setFont(new Font("SanSerif", Font.BOLD, 25));
		lossMsg.setForeground(Color.RED);
		lossMsg.setText("Sorry, you lose.");
		panel.add(lossMsg);
		lossMsg.setVisible(false);

		totalsMsg = new JLabel("You've won " + totalWins
			+ " out of " + totalGames + " games.");
		totalsMsg.setBounds(LABEL_LEFT, LABEL_TOP + 2 * LABEL_HEIGHT_INC,
								  250, 30);
		panel.add(totalsMsg);

//		if (!board.anotherPlayIsPossible()) {
//			signalLoss();
//		}

		pack();
		getContentPane().add(panel);
		getRootPane().setDefaultButton(hitButton);
		panel.setVisible(true);
		
	}

	/**
	 * Deal with the user clicking on something other than a button or a card.
	 */
	private void signalError() {
		Toolkit t = panel.getToolkit();
		t.beep();
	}

	/**
	 * Returns the image that corresponds to the input card.
	 * Image names have the format "[Rank][Suit].GIF" or "[Rank][Suit]S.GIF",
	 * for example "aceclubs.GIF" or "8heartsS.GIF". The "S" indicates that
	 * the card is selected.
	 *
	 * @param c Card to get the image for
	 * @param isSelected flag that indicates if the card is selected
	 * @return String representation of the image
	 */
	private String imageFileName(Card c) {
		String str = "cards/";
		if (c == null) {
			return "cards/back1.GIF";
		}
		str += c.rank() + c.suit();
//		if (isSelected) {
//			str += "S";
//		}
		str += ".GIF";
		return str;
	}

	/**
	 * Respond to a button click (on either the "Replace" button
	 * or the "Restart" button).
	 * @param e the button click action event
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(hitButton)) {
			// Gather all the selected cards.
//			List<Integer> selection = new ArrayList<Integer>();
//			for (int k = 0; k < board.size(); k++) {
//				if (selections[k]) {
//					selection.add(new Integer(k));
//				}
//			}
//			// Make sure that the selected cards represent a legal replacement.
//			if (!board.isLegal(selection)) {
//				signalError();
//				return;
//			}
//			for (int k = 0; k < board.size(); k++) {
//				selections[k] = false;
//			}
//			// Do the replace.
//			board.replaceSelectedCards(selection);
//			if (board.isEmpty()) {
//				signalWin();
//			} else if (!board.anotherPlayIsPossible()) {
//				signalLoss();
//			}
			List<Integer> dealerHandValues = new ArrayList<Integer>(board.compCards.size());
			for (int i = 0; i < board.compCards.size(); i++) {
				dealerHandValues.add(board.compCards.get(i).pointValue());
			}
			if (board.checkHandVal(dealerHandValues) < 21) {
				board.compCards.add(board.deck.deal());
				repaint();
			} else {
				repaint();
			} 
			
			board.playerCards.add(board.deck.deal());
			List<Integer> handValues = new ArrayList<Integer>(board.playerCards.size());
			for(int i = 0; i < board.playerCards.size(); i++) {
				handValues.add(board.playerCards.get(i).pointValue());
			}
			if (board.checkHandVal(handValues) == 21 && (board.checkHandVal(dealerHandValues) != 21)) {
				signalWin();
				repaint();
			} else if (board.checkHandVal(handValues) > 21){
				signalLoss();
				repaint();
			} else {
				repaint();
			}
			// repaint();
		} else if (e.getSource().equals(stayButton)) {
//			board.newGame();
//			getRootPane().setDefaultButton(hitButton);
//			winMsg.setVisible(false);
//			lossMsg.setVisible(false);
//			if (!board.anotherPlayIsPossible()) {
//				signalLoss();
//				lossMsg.setVisible(true);
//			}
//			for (int i = 0; i < selections.length; i++) {
//				selections[i] = false;
//			}
			List<Integer> dealerHandValues = new ArrayList<Integer>(board.compCards.size());
			for (int i = 0; i < board.compCards.size(); i++) {
				dealerHandValues.add(board.compCards.get(i).pointValue());
			}
			
			List<Integer> handValues = new ArrayList<Integer>(board.playerCards.size());
			for(int i = 0; i < board.playerCards.size(); i++) {
				handValues.add(board.playerCards.get(i).pointValue());
			}
			
			while (board.checkHandVal(dealerHandValues) < 21) {
				Card r = board.deck.deal();
				board.compCards.add(r);
				dealerHandValues.add(r.pointValue());
				repaint();
			}
			
			if ((board.checkHandVal(dealerHandValues) > 21) && (board.checkHandVal(handValues) == 21)) {
				signalWin();
				repaint();
			} else if ((board.checkHandVal(handValues) == 21) && (board.checkHandVal(dealerHandValues) == 21)) {
				System.out.println("Tie");
				repaint();
			} else if ((board.checkHandVal(handValues) < 21) && (board.checkHandVal(dealerHandValues) == 21)) {
				signalLoss();
				repaint();
			} else if ((board.checkHandVal(handValues) < board.checkHandVal(dealerHandValues))){
				signalLoss();
				repaint();
			} else {
				repaint();
			}
			
			repaint();
	}
}

	/**
	 * Display a win.
	 */
	private void signalWin() {
		getRootPane().setDefaultButton(stayButton);
		winMsg.setVisible(true);
		totalWins++;
		totalGames++;
	}

	/**
	 * Display a loss.
	 */
	private void signalLoss() {
		getRootPane().setDefaultButton(stayButton);
		lossMsg.setVisible(true);
		totalGames++;
	}
}
