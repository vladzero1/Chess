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
	Image img = null;
	
	public Piece(PiecesType piecesType, Pair<Integer, Integer> index, Player player)
	{
		this.pieceType = piecesType;
		this.player = player;
		
		UpdateButton(index);
		ChessWindow.gridList[index.getKey()][index.getValue()].setPiece(this);
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
	
	public void UpdateButton(Pair<Integer, Integer> index)
	{
		img = getPieceIcon();
		
		JButton button = ChessWindow.gridList[index.getKey()][index.getValue()].getButton();
		ChessWindow.gridList[index.getKey()][index.getValue()].setPiece(this);
		button.setIcon(new ImageIcon(img));
		
		button.setName(player.getPlayerColour().name() + " " + pieceType.name());
	}
	
	public abstract List<Pair<Integer, Integer>> getMovementIndexList(Pair<Integer, Integer> index);

	public abstract void AfterMove();
}
