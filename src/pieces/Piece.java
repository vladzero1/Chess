package pieces;

import javafx.util.Pair;
import mainGame.PiecesType;
import mainGame.Player;

public abstract class Piece {
	PiecesType piecesType;
	Player player;
	Pair<Integer, Integer> position;
	
	public Piece(PiecesType piecesType, Pair<Integer, Integer> position, Player player)
	{
		this.piecesType = piecesType;
		this.position = position;
		this.player = player;
	}
	
	public PiecesType getType() {return piecesType;}
	
	public abstract void isValidMovement();
	
}
