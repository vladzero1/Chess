package pieces;

import java.util.ArrayList;
import java.util.List;

import gui.ChessWindow;
import javafx.util.Pair;
import mainGame.Grid;
import mainGame.PiecesType;
import mainGame.Player;

public class Bishop extends Piece {

	public Bishop(Pair<Integer, Integer> position, Player player) {
		super(PiecesType.Bishop, position, player);
	}

	@Override
	public List<Pair<Integer, Integer>> getMovementIndexList() {
		List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer,Integer>>();
		int loopAmount;
		//1st quadrant
		loopAmount = Math.min(index.getKey(), Math.abs(index.getValue()-7));
		for(int i = 1;i<=loopAmount;i++)
		{
			Grid targetGrid = ChessWindow.gridList[index.getKey()-i][index.getValue()+i];
			if(!targetGrid.PieceIsExist())
			{
				list.add(targetGrid.getIndex());
			}
			else
			{
				break;
			}	
		}
		
		//2nd quadrant
		loopAmount = Math.min(index.getKey(), index.getValue());
		for(int i = 1;i<=loopAmount;i++)
		{
			Grid targetGrid = ChessWindow.gridList[index.getKey()-i][index.getValue()-i];
			if(!targetGrid.PieceIsExist())
			{
				list.add(targetGrid.getIndex());
			}
			else
			{
				break;
			}
		}
		
		//3rd quadrant
		loopAmount = Math.min(Math.abs(index.getKey()-7), index.getValue());
		for(int i = 1;i<=loopAmount;i++)
		{
			Grid targetGrid = ChessWindow.gridList[index.getKey()+i][index.getValue()-i];
			if(!targetGrid.PieceIsExist())
			{
				list.add(targetGrid.getIndex());
			}
			else
			{
				break;
			}
		}
		
		//4th quadrant
		loopAmount = Math.min(Math.abs(index.getKey()-7), Math.abs(index.getValue()-7));
		for(int i = 1;i<=loopAmount;i++)
		{
			Grid targetGrid = ChessWindow.gridList[index.getKey()+i][index.getValue()+i];
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
		List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer,Integer>>();
		int loopAmount;
		//1st quadrant
		loopAmount = Math.min(index.getKey(), Math.abs(index.getValue()-7));
		for(int i = 1;i<=loopAmount;i++)
		{
			Grid targetGrid =ChessWindow.gridList[index.getKey()-i][index.getValue()+i];
			if(targetGrid.PieceIsExist())
			{
				if(targetGrid.getPiece().player.getPlayerColour() != player.getPlayerColour())
				{
					list.add(targetGrid.getIndex());
				}
				break;
			}				
		}
		
		//2nd quadrant
		loopAmount = Math.min(index.getKey(), index.getValue());
		for(int i = 1;i<=loopAmount;i++)
		{
			Grid targetGrid = ChessWindow.gridList[index.getKey()-i][index.getValue()-i];
			if(targetGrid.PieceIsExist())
			{
				if(targetGrid.getPiece().player.getPlayerColour() != player.getPlayerColour())
				{
					list.add(targetGrid.getIndex());
				}
				break;
			}
		}
		
		//3rd quadrant
		loopAmount = Math.min(Math.abs(index.getKey()-7), index.getValue());
		for(int i = 1;i<=loopAmount;i++)
		{
			Grid targetGrid = ChessWindow.gridList[index.getKey()+i][index.getValue()-i];
			if(targetGrid.PieceIsExist())
			{
				if(targetGrid.getPiece().player.getPlayerColour() != player.getPlayerColour())
				{
					list.add(targetGrid.getIndex());
				}
				break;
			}
		}
		
		//4th quadrant
		loopAmount = Math.min(Math.abs(index.getKey()-7), Math.abs(index.getValue()-7));
		for(int i = 1;i<=loopAmount;i++)
		{
			Grid targetGrid = ChessWindow.gridList[index.getKey()+i][index.getValue()+i];
			if(targetGrid.PieceIsExist())
			{
				if(targetGrid.getPiece().player.getPlayerColour() != player.getPlayerColour())
				{
					list.add(targetGrid.getIndex());
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
