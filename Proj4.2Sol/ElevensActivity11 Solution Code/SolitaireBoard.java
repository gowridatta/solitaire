import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class SolitaireBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SolitaireBoard extends Board
{
    // instance variables - replace the example below with your own
    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 7;

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
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        
    private ArrayList<List<Card>> boardLists = new ArrayList<List<Card>>();
        
    public SolitaireBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
     }
    
     
    public void placeCards(){
        List<Card> r1 = new ArrayList<Card>();
        int i = 0;
        while( i < 1 ) {
            r1.add(deck.deal());
            i++;
        }
        
        List<Card> r2 = new ArrayList<Card>();
        int j = 0;
        while( j < 2 ) {
            r2.add(deck.deal());
            j++;
        }
        
        List<Card> r3 = new ArrayList<Card>();
        int k = 0;
        while( k < 3 ) {
            r3.add(deck.deal());
            k++;
        }
        
        List<Card> r4 = new ArrayList<Card>();
        int l = 0;
        while( l < 4 ) {
            r4.add(deck.deal());
            l++;
        }
        
        List<Card> r5 = new ArrayList<Card>();
        int m = 0;
        while( m < 5 ) {
            r5.add(deck.deal());
            m++;
        }
        
        List<Card> r6 = new ArrayList<Card>();
        int n = 0;
        while( n < 6 ) {
            r6.add(deck.deal());
            n++;
        }
        
        List<Card> r7 = new ArrayList<Card>();
        int o = 0;
        while( o < 3 ) {
            r7.add(deck.deal());
            o++;
        }
        
        boardLists.add(0, r1);
        boardLists.add(1, r2);
        boardLists.add(2, r3);
        boardLists.add(3, r4);
        boardLists.add(4, r5);
        boardLists.add(5, r6);
        boardLists.add(6, r7);
        System.out.println(boardLists);
    }
    
    
    public boolean isLegal(List<Integer> selectedCards){
        return false;
    }
    public boolean anotherPlayIsPossible(){
        return false;
    }
}
