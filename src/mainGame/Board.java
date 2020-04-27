package mainGame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import gui.ChessWindow;
import javafx.util.Pair;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class Board {
	int[][] gameBoard = new int[8][8];
	Player player1;
	Player player2;
	
	public Board()
	{
		GenerateBoard();
		player1 = new Player(PlayerColour.White);
		player2 = new Player(PlayerColour.Black);
		GeneratePieces(player1, player2); 
	}
	
	private void GeneratePieces(Player player1, Player player2)
	{
		for (int row = 0; row < 2; row++) 
		{
			for (int col = 0; col < 8; col++) 
			{
				Pair<Integer, Integer> position = new Pair<Integer, Integer>(row, col);
				if (row == 0 && col == 0 || row == 0 && col == 7) 
					{new Rook(position, player2);}
				else if (row == 0 && col == 1 || row == 0 && col == 6) 
					{new Bishop(position, player2);}
				else if (row == 0 && col == 2 || row == 0 && col == 5)
					{new Knight(position, player2);}
				else if (row == 0 && col == 3)
					{new Queen(position, player2);}
				else if (row == 0 && col == 4)
					{new King(position, player2);}
				else if(row == 1)
					{new Pawn(position, player2);}
			}
		}
		for(int row = 6; row < 8;row++)
		{
			for (int col = 0; col < 8; col++) 
			{
				Pair<Integer, Integer> position = new Pair<Integer, Integer>(row, col);
				if (row == 7 && col == 0 || row == 7 && col == 7) 
					{new Rook(position, player1);}
				else if (row == 7 && col == 1 || row == 7 && col == 6) 
					{new Bishop(position, player1);}
				else if (row == 7 && col == 2 || row == 7 && col == 5)
					{new Knight(position, player1);}
				else if (row == 7 && col == 3)
					{new Queen(position, player1);}
				else if (row == 7 && col == 4)
					{new King(position, player1);}
				else if(row == 6)
					{new Pawn(position, player1);}
			}
		}
		
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
}
