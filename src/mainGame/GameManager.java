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

	public void setIsCheck()
	{
		List<Piece> pieceList;
		if(turn%2 == 1)
			pieceList= ChessWindow.whitePieceList;
		else
			pieceList = ChessWindow.blackPieceList;
		
		for(Piece piece : pieceList)
		{
			List<Pair<Integer,Integer>> indexList = piece.getAttackIndexList();
			for(Pair<Integer, Integer> index : indexList)
			{
				if(ChessWindow.gridList[index.getKey()][index.getValue()].getPiece().getType() == PiecesType.King)
				{
					isCheck = true;
					ChessWindow.checkPieceList.add(piece);
				}
			}
		}
		if(isCheck)
		{
			System.out.println("isCheck = " + isCheck);
			return;
		}
		isCheck = false;
		System.out.println("isCheck = " + isCheck);
	}
	
	public void IsCheckmate()
	{
		King kingPiece;
		List<Piece> pieceList;
		
		if(turn%2 == 1)//white
		{
			kingPiece = ChessWindow.getKing(PlayerColour.Black);
			pieceList = ChessWindow.whitePieceList;
		}
		else
		{
			kingPiece = ChessWindow.getKing(PlayerColour.White);
			pieceList = ChessWindow.blackPieceList;
		}

		List<Pair<Integer,Integer>> kingCurrentMove = kingPiece.getMovementIndexList(); 
		for (Piece piece : pieceList) {
			if(piece.getType() != PiecesType.King)
			{
				List<Pair<Integer,Integer>> movementIndex = piece.getMovementIndexList();
				for(Pair<Integer, Integer> index : movementIndex)
				{
					if(kingCurrentMove.contains(index))
					{
						kingCurrentMove.remove(index);
					}
				}
			}
		}
		if(kingCurrentMove.size() == 0 && ChessWindow.checkPieceList.size()>1)
		{
			System.out.println("checkmate 1");
			return;
		}
		else if(kingCurrentMove.size()!=0)
		{
			System.out.println("not checkmate");
			return;
		}
		for (Piece checkPiece : ChessWindow.checkPieceList) {
			List<Pair<Integer,Integer>> movementIndex = checkPiece.getCheckSolveIndexList();
			for (Piece piece : pieceList) {
				List<Pair<Integer,Integer>> movementIndex1= piece.getMovementIndexList();
				for(Pair<Integer, Integer> index : movementIndex1)
				{
					if(movementIndex.contains(index))
					{
						System.out.println("not checkmate");
						return;
					}
				}
			}
		}
	}
}
