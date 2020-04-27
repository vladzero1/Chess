package pieces;

import java.awt.Image;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import gui.ChessWindow;
import javafx.util.Pair;
import mainGame.PiecesType;
import mainGame.Player;
import mainGame.PlayerColour;

public abstract class Piece {
	PiecesType pieceType;
	Player player;
	Pair<Integer, Integer> position;
	Image img = null;
	
	public Piece(PiecesType piecesType, Pair<Integer, Integer> position, Player player)
	{
		this.pieceType = piecesType;
		this.player = player;
		this.position = position;
		
		UpdateButton(position);
		ChessWindow.gridList[position.getKey()][position.getValue()].setPiece(this);
	}
	
	public PiecesType getType() {return pieceType;}
	
	public Image getPieceIcon()
	{
		String iconURL = "";
		if (player.getPlayerColour() == PlayerColour.Black) {
			iconURL = "Assets/black";
		} else {
			iconURL = "Assets/white";
		}
		if (pieceType == PiecesType.King) {
			iconURL += "King.png";
		} else if (pieceType == PiecesType.Queen) {
			iconURL += "Queen.png";
		} else if (pieceType == PiecesType.Bishop) {
			iconURL += "Bishop.png";
		} else if (pieceType == PiecesType.Knight) {
			iconURL += "Knight.png";
		} else if (pieceType == PiecesType.Rook) {
			iconURL += "Rook.png";
		} else if (pieceType == PiecesType.Pawn) {
			iconURL += "Pawn.png";
		}
		try {
			img = ImageIO.read(getClass().getResource(iconURL));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public void UpdateButton(Pair<Integer, Integer> position)
	{
		img = getPieceIcon();
		
		JButton button = ChessWindow.gridList[position.getKey()][position.getValue()].getButton();
		ChessWindow.gridList[position.getKey()][position.getValue()].setPiece(this);
		button.setIcon(new ImageIcon(img));
		
		button.setName(player.getPlayerColour().name() + " " + pieceType.name());
	}
	
	public abstract void isValidMovement();
	
	public abstract List<Pair<Integer, Integer>> getMovementIndexList(Pair<Integer, Integer> position);

	public abstract void AfterMove();
}
