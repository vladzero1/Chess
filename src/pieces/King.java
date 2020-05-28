package pieces;

import java.util.ArrayList;
import java.util.List;

import gui.ChessWindow;
import javafx.util.Pair;
import mainGame.Grid;
import mainGame.PiecesType;
import mainGame.Player;

public class King extends Piece{

	public King(Pair<Integer, Integer> position, Player player) {
		super(PiecesType.King, position, player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Pair<Integer, Integer>> getMovementIndexList() {
		List<Pair<Integer, Integer>> list =  new ArrayList<Pair<Integer,Integer>>();
		Grid targetGrid;
		if(index.getKey()+1 <=7)
		{
			if(index.getValue()-1 >= 0)
			{
				targetGrid = ChessWindow.gridList[index.getKey()+1][index.getValue()-1];
				if(!targetGrid.PieceIsExist())
					list.add(targetGrid.getIndex());
			}
			
			if(index.getValue()+1 <= 7)
			{
				targetGrid = ChessWindow.gridList[index.getKey()+1][index.getValue()+1];
				if(!targetGrid.PieceIsExist())
					list.add(targetGrid.getIndex());
			}
			
			targetGrid = ChessWindow.gridList[index.getKey()+1][index.getValue()];
			if(!targetGrid.PieceIsExist())
				list.add(targetGrid.getIndex());
		}
		
		if(index.getKey()-1 >=0)
		{
			if(index.getValue()-1 >= 0)
			{
				targetGrid = ChessWindow.gridList[index.getKey()-1][index.getValue()-1];
				if(!targetGrid.PieceIsExist())
					list.add(targetGrid.getIndex());
			}
			
			if(index.getValue()+1 <= 7)
			{
				targetGrid = ChessWindow.gridList[index.getKey()-1][index.getValue()+1];
				if(!targetGrid.PieceIsExist())
					list.add(targetGrid.getIndex());
			}
			
			targetGrid = ChessWindow.gridList[index.getKey()-1][index.getValue()];
			if(!targetGrid.PieceIsExist())
				list.add(targetGrid.getIndex());
		}
		
		if(index.getValue()-1 >= 0)
		{
			targetGrid = ChessWindow.gridList[index.getKey()][index.getValue()-1];
			if(!targetGrid.PieceIsExist())
				list.add(targetGrid.getIndex());
		}
		
		if(index.getValue()+1 <= 7)
		{
			targetGrid = ChessWindow.gridList[index.getKey()][index.getValue()+1];
			if(!targetGrid.PieceIsExist())
				list.add(targetGrid.getIndex());
		}
		return list;
	}

	@Override
	public List<Pair<Integer, Integer>> getAttackIndexList() {
		List<Pair<Integer, Integer>> list =  new ArrayList<Pair<Integer,Integer>>();
		Grid targetGrid;
		if(index.getKey()+1 <=7)
		{
			if(index.getValue()-1 >= 0)
			{
				targetGrid = ChessWindow.gridList[index.getKey()+1][index.getValue()-1];
				if(targetGrid.PieceIsExist())
				{
					if(targetGrid.getPiece().player.getPlayerColour() != player.getPlayerColour())
						list.add(targetGrid.getIndex());		
				}
			}
			
			if(index.getValue()+1 <= 7)
			{
				targetGrid = ChessWindow.gridList[index.getKey()+1][index.getValue()+1];
				if(targetGrid.PieceIsExist())
				{
					if(targetGrid.getPiece().player.getPlayerColour() != player.getPlayerColour())
						list.add(targetGrid.getIndex());		
				}
			}
			
			targetGrid = ChessWindow.gridList[index.getKey()+1][index.getValue()];
			if(targetGrid.PieceIsExist())
			{
				if(targetGrid.getPiece().player.getPlayerColour() != player.getPlayerColour())
					list.add(targetGrid.getIndex());		
			}
		}
		
		if(index.getKey()-1 >=0)
		{
			if(index.getValue()-1 >= 0)
			{
				targetGrid = ChessWindow.gridList[index.getKey()-1][index.getValue()-1];
				if(targetGrid.PieceIsExist())
				{
					if(targetGrid.getPiece().player.getPlayerColour() != player.getPlayerColour())
						list.add(targetGrid.getIndex());		
				}
			}
			
			if(index.getValue()+1 <= 7)
			{
				targetGrid = ChessWindow.gridList[index.getKey()-1][index.getValue()+1];
				if(targetGrid.PieceIsExist())
				{
					if(targetGrid.getPiece().player.getPlayerColour() != player.getPlayerColour())
						list.add(targetGrid.getIndex());		
				}
			}
			
			targetGrid = ChessWindow.gridList[index.getKey()-1][index.getValue()];
			if(targetGrid.PieceIsExist())
			{
				if(targetGrid.getPiece().player.getPlayerColour() != player.getPlayerColour())
					list.add(targetGrid.getIndex());		
			}
		}
		
		if(index.getValue()-1 >= 0)
		{
			targetGrid = ChessWindow.gridList[index.getKey()][index.getValue()-1];
			if(targetGrid.PieceIsExist())
			{
				if(targetGrid.getPiece().player.getPlayerColour() != player.getPlayerColour())
					list.add(targetGrid.getIndex());		
			}
		}
		
		if(index.getValue()+1 <= 7)
		{
			targetGrid = ChessWindow.gridList[index.getKey()][index.getValue()+1];
			if(targetGrid.PieceIsExist())
			{
				if(targetGrid.getPiece().player.getPlayerColour() != player.getPlayerColour())
					list.add(targetGrid.getIndex());		
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
		list.add(index);
		return list;
	}


}
