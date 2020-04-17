package mainGame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import gui.ChessWindow;

public class Board {
	int[][] gameBoard = new int[8][8];
	
	public Board()
	{
		GenerateBoard();
		
	}
	
	void GeneratePieces(Player player)
	{
		
	}
	
	private void GenerateBoard()
	{
		JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        ChessWindow window = new ChessWindow();
        frame.add(window);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	private void GeneratePieces() {
		
	}
}
