package gui;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javafx.util.Pair;
import mainGame.PiecesType;
import mainGame.PlayerColour;

public class PieceGUI {

	PiecesType type;
	PlayerColour colour;
	Pair<Integer, Integer> position;
	Image img = null;
	
	public PieceGUI(PiecesType pieceType, PlayerColour playerColour, Pair<Integer, Integer> position)
	{
		type = pieceType;
		colour = playerColour;
		this.position = position;
		UpdateButtonImg();
	}
	
	public Image getPieceIcon()
	{
		if(img == null)
		{
			String iconURL = "";
			if (colour == PlayerColour.Black) {
				iconURL = "Assets/black";
			} else {
				iconURL = "Assets/white";
			}
			if (type == PiecesType.King) {
				iconURL += "King.png";
			} else if (type == PiecesType.Queen) {
				iconURL += "Queen.png";
			} else if (type == PiecesType.Bishop) {
				iconURL += "Bishop.png";
			} else if (type == PiecesType.Knight) {
				iconURL += "Knight.png";
			} else if (type == PiecesType.Rook) {
				iconURL += "Rook.png";
			} else if (type == PiecesType.Pawn) {
				iconURL += "Pawn.png";
			}
			try {
				img = ImageIO.read(getClass().getResource(iconURL));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	}
	
	public void UpdateButtonImg()
	{
		img = getPieceIcon();
		ChessWindow.gridList[position.getKey()][position.getValue()].setIcon(new ImageIcon(img));
	}
}
