package pieces;

import java.util.ArrayList;
import java.util.List;

import gui.ChessWindow;
import javafx.util.Pair;
import mainGame.Grid;
import mainGame.PiecesType;
import mainGame.Player;
import mainGame.PlayerColour;

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

	@Override
	public List<Pair<Integer, Integer>> getCheckSolveIndexList() {
		List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
		list.add(index);

		Pair<Integer, Integer> kingIndex = null;
		if(player.getPlayerColour() == PlayerColour.White)
		{
			kingIndex = ChessWindow.getKing(PlayerColour.Black).index;			
		}
		else
		{
			kingIndex = ChessWindow.getKing(PlayerColour.White).index;
		}
		
		if(kingIndex.getKey() < index.getKey() && kingIndex.getValue() == index.getValue())//up
		{
			for (int i = index.getKey()-1; i > kingIndex.getKey(); i--)
			{
				list.add(new Pair<Integer, Integer>(i,index.getValue()));
			}
		}
		else if(kingIndex.getKey() > index.getKey() && kingIndex.getValue() == index.getValue())//down
		{
			for (int i = kingIndex.getKey()-1; i < index.getKey(); i--)
			{
				list.add(new Pair<Integer, Integer>(i,index.getValue()));
			}
		}
		else if(kingIndex.getKey() == index.getKey() && kingIndex.getValue() < index.getValue())//left
		{
			for (int i = index.getValue()-1; i > kingIndex.getValue();i--)
			{
				list.add(new Pair<Integer, Integer>(index.getKey(),i));
			}
		}
		else if(kingIndex.getKey() == index.getKey() && kingIndex.getValue() > index.getValue())//right
		{
			for (int i = kingIndex.getValue()-1; i < index.getValue(); i--)
			{
				list.add(new Pair<Integer, Integer>(i,index.getValue()));
			}
		}
		return list;
	}


}
