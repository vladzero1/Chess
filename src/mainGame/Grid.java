package mainGame;

import java.awt.Color;
import java.util.List;

import javax.swing.JButton;

import gui.ChessWindow;
import javafx.util.Pair;
import pieces.Piece;

public class Grid {
	JButton button;
	private Piece piece;
	private Pair<Integer, Integer> index;
	boolean isShowMove = false;
	boolean isShowAttack = false;
	public Grid(JButton button, Pair<Integer, Integer> index)
	{
		this.button = button;
		this.index = index;
	}

	public void PiecesMove(PiecesType piecesType, JButton button)
	{
		if(isShowMove)
		{
			RemoveShowMove();
			ChessWindow.selectedGrid = null;
			isShowMove = false;
		}
		else
		{
			if(ChessWindow.selectedGrid != null)
			{
				RemoveShowMove();
			}
			ChessWindow.selectedGrid =  ChessWindow.gridList[index.getKey()][index.getValue()];
			ShowMove();
			isShowMove = true;
		}

	}
	
	public void ShowMove()
	{
		List<Pair<Integer, Integer>> moveIndexList = piece.getMovementIndexList();
		if(moveIndexList.size() != 0)
		{
			for(Pair<Integer, Integer> tempIndex : moveIndexList)
			{
				Grid affectedGrid = ChessWindow.gridList[tempIndex.getKey()][tempIndex.getValue()];
				affectedGrid.button.setBackground(Color.BLUE);
				affectedGrid.isShowMove = true;
			}
		}
		
		List<Pair<Integer, Integer>> attackIndexList = piece.getAttackIndexList();
		if(attackIndexList.size() != 0)
		{
			for(Pair<Integer, Integer> tempIndex : attackIndexList)
			{
				Grid affectedGrid = ChessWindow.gridList[tempIndex.getKey()][tempIndex.getValue()];
				affectedGrid.button.setBackground(Color.RED);
				affectedGrid.isShowMove = true;
				affectedGrid.isShowAttack = true;
			}
		}
	}
	
	public void RemoveShowMove()
	{
		Grid grid = ChessWindow.selectedGrid;
		List<Pair<Integer, Integer>> moveIndexList = grid.getPiece().getMovementIndexList();
		
		if(moveIndexList != null)
		{
			for(Pair<Integer, Integer> tempIndex : moveIndexList)
			{
				int sumPosition = tempIndex.getKey() + tempIndex.getValue();
				Grid affectedGrid = ChessWindow.gridList[tempIndex.getKey()][tempIndex.getValue()];
				if (sumPosition % 2 == 0)
					affectedGrid.getButton().setBackground(Color.WHITE);
				else
					affectedGrid.getButton().setBackground(Color.GRAY);
				affectedGrid.isShowMove = false;
			}
		}
		
		// don't forget to change
		List<Pair<Integer, Integer>> attackIndexList = grid.getPiece().getAttackIndexList();
		
		if(attackIndexList != null)
		{
			for(Pair<Integer, Integer> tempIndex : attackIndexList)
			{
				int sumPosition = tempIndex.getKey() + tempIndex.getValue();
				Grid affectedGrid = ChessWindow.gridList[tempIndex.getKey()][tempIndex.getValue()];
				if (sumPosition % 2 == 0)
					affectedGrid.getButton().setBackground(Color.WHITE);
				else
					affectedGrid.getButton().setBackground(Color.GRAY);
				affectedGrid.isShowMove = false;
				affectedGrid.isShowAttack = false;
			}
		}
		grid.isShowMove = false;
	}
	
	public void ResetGrid()
	{
		button.setName("Grid");
		button.setIcon(null);
		piece = null;
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

	public boolean PieceIsExist()
	{
		return piece != null ? true : false;		
	}
	
	public JButton getButton()
	{
		return button;
	}
	
	public void setPiece(Piece piece)
	{
		this.piece = piece;
	}
	
	public Piece getPiece()
	{
		return piece == null ? null : piece;
	}
	
	public Pair<Integer, Integer> getIndex()
	{
		return index;
	}
	
	public boolean getIsShowMove()
	{
		return isShowMove;
	}
	
	public boolean getIsShowAttack()
	{
		return isShowAttack;
	}
}
