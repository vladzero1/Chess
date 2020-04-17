package pieces;

import gui.PieceGUI;
import javafx.util.Pair;
import mainGame.PiecesType;
import mainGame.Player;

public abstract class Piece {
	PiecesType pieceType;
	Player player;
	Pair<Integer, Integer> position;
	PieceGUI pieceGUI;
	
	public Piece(PiecesType piecesType, Pair<Integer, Integer> position, Player player)
	{
		this.pieceType = piecesType;
		this.position = position;
		this.player = player;
		
		pieceGUI = new PieceGUI(piecesType, player.getIsPlayer1(), position);
	}
	
	public PiecesType getType() {return pieceType;}
	
	public abstract void isValidMovement();
	
}
