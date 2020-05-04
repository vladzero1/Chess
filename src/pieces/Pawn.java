package pieces;

import java.util.ArrayList;
import java.util.List;

import gui.ChessWindow;
import javafx.util.Pair;
import mainGame.Grid;
import mainGame.PiecesType;
import mainGame.Player;
import mainGame.PlayerColour;

public class Pawn extends Piece{

	boolean isEverMove = false;
	public Pawn(Pair<Integer, Integer> position, Player player) {
		super(PiecesType.Pawn, position, player);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Pair<Integer, Integer>> getMovementIndexList(Pair<Integer, Integer> index) {
		// TODO Auto-generated method stub
		List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
		if(player.getPlayerColour() == PlayerColour.White)
		{
			
			Grid targetGrid = ChessWindow.gridList[index.getKey()-1][index.getValue()];
			if(!targetGrid.PieceIsExist())
			{
				list.add(targetGrid.getIndex());
				
				targetGrid = ChessWindow.gridList[index.getKey()-2][index.getValue()];
				if(!targetGrid.PieceIsExist() && !isEverMove )
				{
					list.add(new Pair<Integer, Integer>(index.getKey()-2, index.getValue()));
				}
			}
			if(index.getValue()-1 >= 0)
			{
				targetGrid = ChessWindow.gridList[index.getKey()-1][index.getValue()-1];
				if(targetGrid.PieceIsExist())
				{
					if(targetGrid.getPiece().player.getPlayerColour() == PlayerColour.Black)
					{
						list.add(targetGrid.getIndex());
					}
				}
			}
			if(index.getValue()+1 <= 7)
			{
				targetGrid = ChessWindow.gridList[index.getKey()-1][index.getValue()+1];
				if(targetGrid.PieceIsExist())
				{
					if(targetGrid.getPiece().player.getPlayerColour() == PlayerColour.Black)
					{
						list.add(targetGrid.getIndex());
					}
				}
			}
		}
		else if(player.getPlayerColour() == PlayerColour.Black)
		{
			Grid targetGrid = ChessWindow.gridList[index.getKey()+1][index.getValue()];
			if(!targetGrid.PieceIsExist())
			{
				list.add(targetGrid.getIndex());
				targetGrid = ChessWindow.gridList[index.getKey()+2][index.getValue()];
				if(!targetGrid.PieceIsExist() && !isEverMove)
				{
					list.add(targetGrid.getIndex());
				}
			}

			
			if(index.getValue()-1 >= 0)
			{
				targetGrid = ChessWindow.gridList[index.getKey()+1][index.getValue()-1];
				if(targetGrid.PieceIsExist())
				{
					if(targetGrid.getPiece().player.getPlayerColour() == PlayerColour.White)
					{
						list.add(targetGrid.getIndex());
					}
				}
			}
			if(index.getValue()+1 <= 7)
			{
				targetGrid = ChessWindow.gridList[index.getKey()+1][index.getValue()+1];
				if(targetGrid.PieceIsExist())
				{
					if(targetGrid.getPiece().player.getPlayerColour() == PlayerColour.White)
					{
						list.add(targetGrid.getIndex());
					}
				}
			}
		}
		return list;
	}

	@Override
	public void AfterMove() {
		// TODO Auto-generated method stub
		isEverMove = true;
	}

}
