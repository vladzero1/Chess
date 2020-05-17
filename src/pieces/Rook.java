package pieces;

import java.util.ArrayList;
import java.util.List;

import gui.ChessWindow;
import javafx.util.Pair;
import mainGame.Grid;
import mainGame.PiecesType;
import mainGame.Player;

public class Rook extends Piece{

	public Rook(Pair<Integer, Integer> position, Player player) {
		super(PiecesType.Rook, position, player);
	}

	@Override
	public List<Pair<Integer, Integer>> getMovementIndexList() {
		List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
		for (int i = index.getKey()-1; i >= 0; i--) //up
		{
			if(i >= 0)
			{
				Grid targetGrid = ChessWindow.gridList[i][index.getValue()];
				if(!targetGrid.PieceIsExist())
				{
					list.add(targetGrid.getIndex());
				}
				else
				{
					break;
				}
			}
		}
		for(int i = index.getKey()+1; i < 8;i++) //down
		{
			Grid targetGrid = ChessWindow.gridList[i][index.getValue()];
			if(!targetGrid.PieceIsExist())
			{
				list.add(targetGrid.getIndex());
			}
			else
			{
				break;
			}
		}
		for(int i = index.getValue()-1;i >= 0;i--) //left
		{
			Grid targetGrid = ChessWindow.gridList[index.getKey()][i];
			if(!targetGrid.PieceIsExist())
			{
				list.add(targetGrid.getIndex());
			}
			else
			{
				break;
			}
		}
		for(int i = index.getValue()+1; i < 8;i++) //down
		{
			Grid targetGrid = ChessWindow.gridList[index.getKey()][i];
			if(!targetGrid.PieceIsExist())
			{
				list.add(targetGrid.getIndex());
			}
			else
			{
				break;
			}
		}
		
		return list;
	}

	@Override
	public List<Pair<Integer, Integer>> getAttackIndexList() {
		
		List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
		
		for (int i = index.getKey()-1; i >= 0; i--) //up
		{
			Grid targetGrid = ChessWindow.gridList[i][index.getValue()];
			if(targetGrid.PieceIsExist())
			{
				if(targetGrid.getPiece().player.getPlayerColour() != player.getPlayerColour())
				{
					list.add(targetGrid.getIndex());
					break;
				}
				break;
			}
		}
		for(int i = index.getKey()+1; i < 8;i++) //down
		{
			Grid targetGrid = ChessWindow.gridList[i][index.getValue()];
			if(targetGrid.PieceIsExist())
			{
				if(targetGrid.getPiece().player.getPlayerColour() != player.getPlayerColour())
				{
					list.add(targetGrid.getIndex());
					break;
				}
				break;
			}
		}
		for(int i = index.getValue()-1;i >= 0;i--) //left
		{
			Grid targetGrid = ChessWindow.gridList[index.getKey()][i];
			if(targetGrid.PieceIsExist())
			{
				if(targetGrid.getPiece().player.getPlayerColour() != player.getPlayerColour())
				{
					list.add(targetGrid.getIndex());
					break;
				}
				break;
			}
		}
		for(int i = index.getValue()+1; i < 8;i++) //down
		{
			Grid targetGrid = ChessWindow.gridList[index.getKey()][i];
			if(targetGrid.PieceIsExist())
			{
				if(targetGrid.getPiece().player.getPlayerColour() != player.getPlayerColour())
				{
					list.add(targetGrid.getIndex());
					break;
				}
				break;
			}
		}
	return list;
	}
	
	@Override
	public void AfterMove() {
		// TODO Auto-generated method stub
		
	}


}
