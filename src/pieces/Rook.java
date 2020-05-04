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
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Pair<Integer, Integer>> getMovementIndexList(Pair<Integer, Integer> index) {
		// TODO Auto-generated method stub
		System.out.println("index = " + index);
		List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
		if(player.getPlayerColour() == PlayerColour.White)
		{
			for (int i = index.getKey()-1; i >= 0; i--) //up
			{
				if(i >= 0)
				{
					Grid targetGrid = ChessWindow.gridList[i][index.getValue()];
					if(!targetGrid.PieceIsExist())
					{
						list.add(targetGrid.getIndex());
					}
					else if(targetGrid.PieceIsExist())
					{
						if(targetGrid.getPiece().player.getPlayerColour() == PlayerColour.Black) //attack
						{
							list.add(targetGrid.getIndex());
							break;
						}
						else
						{
							break;
						}
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
				else if(targetGrid.PieceIsExist())
				{
					if(targetGrid.getPiece().player.getPlayerColour() == PlayerColour.Black) //attack
					{
						list.add(targetGrid.getIndex());
						break;
					}
					else
					{
						break;
					}
				}
			}
			for(int i = index.getValue()-1;i >= 0;i--) //left
			{
				Grid targetGrid = ChessWindow.gridList[index.getKey()][i];
				if(!targetGrid.PieceIsExist())
				{
					list.add(targetGrid.getIndex());
				}
				else if(targetGrid.PieceIsExist())
				{
					if(targetGrid.getPiece().player.getPlayerColour() == PlayerColour.Black) //attack
					{
						list.add(targetGrid.getIndex());
						break;
					}
					else
					{
						break;
					}
				}
			}
			for(int i = index.getValue()+1; i < 8;i++) //down
			{
				Grid targetGrid = ChessWindow.gridList[index.getKey()][i];
				if(!targetGrid.PieceIsExist())
				{
					list.add(targetGrid.getIndex());
				}
				else if(targetGrid.PieceIsExist())
				{
					if(targetGrid.getPiece().player.getPlayerColour() == PlayerColour.Black) //attack
					{
						list.add(targetGrid.getIndex());
						break;
					}
					else
					{
						break;
					}
				}
			}
		}
		else if(player.getPlayerColour() == PlayerColour.Black)
		{
			
		}
		
		return list;
	}

	@Override
	public void AfterMove() {
		// TODO Auto-generated method stub
		
	}

}
