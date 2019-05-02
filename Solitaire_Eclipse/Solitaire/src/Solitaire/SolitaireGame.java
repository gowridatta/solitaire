package Solitaire;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SolitaireGame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolitaireGame window = new SolitaireGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SolitaireGame() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JButton btn1 = new JButton("first");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		JButton btn2 = new JButton("second");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		JButton btn3 = new JButton("third");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		JButton btn4 = new JButton("fourth");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		JButton btn5 = new JButton("fifth");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		JButton btn6 = new JButton("sixth");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		JButton btn7 = new JButton("seventh");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		JButton btn8 = new JButton("eighth");
		
		frame = new JFrame();
		frame.setTitle("Solitaire Game");
		frame.setBounds(100, 100, 1220, 742);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 1, 1, 1));
		frame.setVisible(true);
		
		frame.getContentPane().add(btn1);
		frame.getContentPane().add(btn2);
		frame.getContentPane().add(btn3);
		frame.getContentPane().add(btn4);
		frame.getContentPane().add(btn5);
		frame.getContentPane().add(btn6);
		frame.getContentPane().add(btn7);
		frame.add(btn8);
	}
}