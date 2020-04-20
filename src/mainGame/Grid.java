package mainGame;

import java.awt.Color;

import javax.swing.JButton;

import gui.ChessWindow;
import javafx.util.Pair;
import pieces.Piece;

public class Grid {
	JButton button;
	Piece piece;
	Pair<Integer, Integer> index;
	boolean isShowMove = false;
	public Grid(JButton button, Pair<Integer, Integer> index)
	{
		this.button = button;
		this.index = index;
	}

	public void PiecesMove(PiecesType piecesType, JButton button)
	{
		System.out.println(ChessWindow.selectedGrid);
		System.out.println(isShowMove);
		if(isShowMove)
		{
			ChessWindow.selectedGrid = null;
			System.out.println("move removed");
		}
		else
		{
			if(ChessWindow.selectedGrid != null)
			{
				System.out.println("move removed");
			}
			ChessWindow.selectedGrid =  ChessWindow.gridList[index.getKey()][index.getValue()];
			ShowMove();
		}
		isShowMove = !isShowMove;
	}
	
	public void ShowMove()
	{
		Pair<Integer, Integer>[] indexList= piece.getMovementIndex(index);
		for(Pair<Integer, Integer> tempIndex : indexList)
		{
			int row = tempIndex.getKey();
			int col = tempIndex.getValue();
			ChessWindow.gridList[row][col].button.setBackground(Color.BLUE);
		}
	}
	
	public void RemoveShowMove()
	{
		Pair<Integer, Integer>[] indexList= piece.getMovementIndex(index);
		for(Pair<Integer, Integer> tempIndex : indexList)
		{
			int sumPosition = tempIndex.getKey() + tempIndex.getValue();
			if (sumPosition % 2 == 0)
				button.setBackground(Color.WHITE);
			else
				button.setBackground(Color.GRAY);
		}
	}
	
	public PiecesType checkPieceType(String buttonName)
	{
		if(buttonName.contains("Rook"))
			return PiecesType.Rook;
		else if(buttonName.contains("Bishop"))
			return PiecesType.Bishop;
		else if(buttonName.contains("Knight"))
			return PiecesType.Knight;
		else if(buttonName.contains("Queen"))
			return PiecesType.Queen;
		else if(buttonName.contains("King"))
			return PiecesType.King;
		else if(buttonName.contains("Pawn"))
			return PiecesType.Pawn;
		
		return null;
	}
	
	public JButton getButton()
	{
		return button;
	}
	
	public void setPieceType(Piece piece)
	{
		this.piece = piece;
	}
}
