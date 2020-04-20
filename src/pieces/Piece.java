package pieces;

import gui.ChessWindow;
import gui.PieceGUI;
import javafx.util.Pair;
import mainGame.PiecesType;
import mainGame.Player;

public abstract class Piece {
	PiecesType pieceType;
	Player player;
	
	public Piece(PiecesType piecesType, Pair<Integer, Integer> position, Player player)
	{
		this.pieceType = piecesType;
		this.player = player;
		
		new PieceGUI(piecesType, player.getColour(), position, this);
		ChessWindow.gridList[position.getKey()][position.getValue()].setPieceType(this);
	}
	
	public PiecesType getType() {return pieceType;}
	
	public abstract void isValidMovement();
	
	public  abstract Pair<Integer, Integer>[] getMovementIndex(Pair<Integer, Integer> position);
}
