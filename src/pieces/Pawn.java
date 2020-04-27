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
	public void isValidMovement() {
		// TODO Auto-generated method stub
		
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
				
				targetGrid = ChessWindow.gridList[position.getKey()-2][position.getValue()];
				if(!targetGrid.PieceIsExist() && !isEverMove )
				{
					list.add(new Pair<Integer, Integer>(position.getKey()-2, position.getValue()));
				}
			}
			targetGrid = ChessWindow.gridList[position.getKey()-1][position.getValue()-1];
			if(targetGrid.PieceIsExist())
			{
				System.out.println("1");
				if(targetGrid.getPiece().player.getPlayerColour() == PlayerColour.Black)
				{
					System.out.println("tes");
					list.add(targetGrid.getIndex());
				}
			}
			targetGrid = ChessWindow.gridList[position.getKey()-1][position.getValue()+1];
			if(targetGrid.PieceIsExist())
			{
				if(targetGrid.getPiece().player.getPlayerColour() == PlayerColour.Black)
				{
					System.out.println("tes");
					list.add(targetGrid.getIndex());
				}
			}
		}
		else
		{
			if(!ChessWindow.gridList[position.getKey()+1][position.getValue()].PieceIsExist())
			{
				list.add(new Pair<Integer, Integer>(position.getKey()+1, position.getValue()));
				if(!ChessWindow.gridList[position.getKey()+2][position.getValue()].PieceIsExist() && !isEverMove)
				{
					list.add(new Pair<Integer, Integer>(position.getKey()+2, position.getValue()));
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
