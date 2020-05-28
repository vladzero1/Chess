package pieces;

import java.util.ArrayList;
import java.util.List;

import gui.ChessWindow;
import javafx.util.Pair;
import mainGame.Grid;
import mainGame.PiecesType;
import mainGame.Player;

public class Knight extends Piece {

	public Knight(Pair<Integer, Integer> position, Player player) {
		super(PiecesType.Knight, position, player);
	}

	@Override
	public List<Pair<Integer, Integer>> getMovementIndexList() {
		// TODO Auto-generated method stub
		List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
		Grid targetGrid;
		if(index.getKey()-2 >= 0)
		{
			if(index.getValue()-1 >= 0)
			{
				targetGrid = ChessWindow.gridList[index.getKey()-2][index.getValue()-1];
				if(!targetGrid.PieceIsExist())
					list.add(targetGrid.getIndex());
			}
			if(index.getValue()+1 <=7)
			{
				targetGrid = ChessWindow.gridList[index.getKey()-2][index.getValue()+1];
				if(!targetGrid.PieceIsExist())
					list.add(targetGrid.getIndex());
			}
		}
		if(index.getKey()+2 <= 7)
		{
			if(index.getValue()-1 >= 0)
			{
				targetGrid = ChessWindow.gridList[index.getKey()+2][index.getValue()-1];
				if(!targetGrid.PieceIsExist())
					list.add(targetGrid.getIndex());
			}
			if(index.getValue()+1 <=7)
			{
				targetGrid = ChessWindow.gridList[index.getKey()+2][index.getValue()+1];
				if(!targetGrid.PieceIsExist())
					list.add(targetGrid.getIndex());
			}
		}
		if(index.getValue()-2 >= 0)
		{
			if(index.getKey()-1 >= 0)
			{
				targetGrid = ChessWindow.gridList[index.getKey()-1][index.getValue()-2];
				if(!targetGrid.PieceIsExist())
					list.add(targetGrid.getIndex());
			}
			if(index.getKey()+1 <=7)
			{
				targetGrid = ChessWindow.gridList[index.getKey()+1][index.getValue()-2];
				if(!targetGrid.PieceIsExist())
					list.add(targetGrid.getIndex());
			}
		}
		if(index.getValue()+2 <= 7)
		{
			if(index.getKey()-1 >= 0)
			{
				targetGrid = ChessWindow.gridList[index.getKey()-1][index.getValue()+2];
				if(!targetGrid.PieceIsExist())
					list.add(targetGrid.getIndex());
			}
			if(index.getKey()+1 <=7)
			{
				targetGrid = ChessWindow.gridList[index.getKey()+1][index.getValue()+2];
				if(!targetGrid.PieceIsExist())
					list.add(targetGrid.getIndex());
			}
		}
		return list;
	}

	
	@Override
	public List<Pair<Integer, Integer>> getAttackIndexList() {
		List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
		Grid targetGrid;
		if(index.getKey()-2 >= 0)
		{
			if(index.getValue()-1 >= 0)
			{
				targetGrid = ChessWindow.gridList[index.getKey()-2][index.getValue()-1];
				if(targetGrid.PieceIsExist())
				{
					if(player.getPlayerColour() != targetGrid.getPiece().player.getPlayerColour())
						list.add(targetGrid.getIndex());				
				}
			}
			if(index.getValue()+1 <=7)
			{
				targetGrid = ChessWindow.gridList[index.getKey()-2][index.getValue()+1];
				if(targetGrid.PieceIsExist())
				{
					if(player.getPlayerColour() != targetGrid.getPiece().player.getPlayerColour())
						list.add(targetGrid.getIndex());
				}
			}
		}
		if(index.getKey()+2 <= 7)
		{
			if(index.getValue()-1 >= 0)
			{
				targetGrid = ChessWindow.gridList[index.getKey()+2][index.getValue()-1];
				if(targetGrid.PieceIsExist())
				{
					if(player.getPlayerColour() != targetGrid.getPiece().player.getPlayerColour())
						list.add(targetGrid.getIndex());
				}
			}
			if(index.getValue()+1 <=7)
			{
				targetGrid = ChessWindow.gridList[index.getKey()+2][index.getValue()+1];
				if(targetGrid.PieceIsExist())
				{
					if(player.getPlayerColour() != targetGrid.getPiece().player.getPlayerColour())
						list.add(targetGrid.getIndex());
				}
			}
		}
		if(index.getValue()-2 >= 0)
		{
			if(index.getKey()-1 >= 0)
			{
				targetGrid = ChessWindow.gridList[index.getKey()-1][index.getValue()-2];
				if(targetGrid.PieceIsExist())
				{
					if(player.getPlayerColour() != targetGrid.getPiece().player.getPlayerColour())
						list.add(targetGrid.getIndex());
				}
			}
			if(index.getKey()+1 <=7)
			{
				targetGrid = ChessWindow.gridList[index.getKey()+1][index.getValue()-2];
				if(targetGrid.PieceIsExist())
				{
					if(player.getPlayerColour() != targetGrid.getPiece().player.getPlayerColour())
						list.add(targetGrid.getIndex());
				}
			}
		}
		if(index.getValue()+2 <= 7)
		{
			if(index.getKey()-1 >= 0)
			{
				targetGrid = ChessWindow.gridList[index.getKey()-1][index.getValue()+2];
				if(targetGrid.PieceIsExist())
				{
					if(player.getPlayerColour() != targetGrid.getPiece().player.getPlayerColour())
						list.add(targetGrid.getIndex());				
				}
			}
			if(index.getKey()+1 <=7)
			{
				targetGrid = ChessWindow.gridList[index.getKey()+1][index.getValue()+2];
				if(targetGrid.PieceIsExist())
				{
					if(player.getPlayerColour() != targetGrid.getPiece().player.getPlayerColour())
						list.add(targetGrid.getIndex());		
				}
			}
		}
		return list;
	}
	
	@Override
	public void AfterMove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pair<Integer, Integer>> getCheckSolveIndexList() {
		List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
		list.add(this.index);
		return list;
	}



}
