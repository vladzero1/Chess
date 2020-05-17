package mainGame;

import java.util.List;

import gui.ChessWindow;
import javafx.util.Pair;
import pieces.King;
import pieces.Piece;

public class GameManager {
	public static GameManager instance;

	public int turn = 1;
	public boolean isCheck = false;

	public static void main(String[] args)
	{
		new Board();
		new GameManager();
	}
	
	public GameManager() {
		instance = this;
	}
	
	public void IncreaseTurn()
	{
		turn++;
	}

	public void setIsCheck(Piece piece)
	{
		List<Pair<Integer,Integer>> indexList = piece.getAttackIndexList();
		for(Pair<Integer, Integer> index : indexList)
		{
			if(ChessWindow.gridList[index.getKey()][index.getValue()].getPiece() instanceof King)
			{
				isCheck= true;
				return;
			}
		}
		isCheck = false;
	}
	
	public void IsCheckmate()
	{
		if(turn%2 == 1)//white
		{
			System.out.println("check white");
			King kingPiece = ChessWindow.getKing(PlayerColour.White);
			List<Pair<Integer,Integer>> KingCurrentMove = kingPiece.getMovementIndexList(); 
			for (Piece piece : ChessWindow.whitePieceList) {
				List<Pair<Integer,Integer>> movementIndex = piece.getMovementIndexList();
				for(Pair<Integer, Integer> index : movementIndex)
				{
					if(KingCurrentMove.contains(index))
					{

						KingCurrentMove.remove(index);
					}
				}
			}
			if(KingCurrentMove.size() == 0 && isCheck)//checkmate
			{
				System.out.println("Checkmate white");
			}
		}
		else //black
		{
			System.out.println("check black");
			King kingPiece = ChessWindow.getKing(PlayerColour.Black);
			List<Pair<Integer,Integer>> KingCurrentMove = kingPiece.getMovementIndexList(); 
			for (Piece piece : ChessWindow.blackPieceList) {
				List<Pair<Integer,Integer>> movementIndex = piece.getMovementIndexList();
				for(Pair<Integer, Integer> index : movementIndex)
				{
					if(KingCurrentMove.contains(index))
					{
						KingCurrentMove.remove(index);
					}
				}
			}
			if(KingCurrentMove.size() == 0 && isCheck)//checkmate
			{
				System.out.println("Checkmate black");
			}
		}
	}
}
