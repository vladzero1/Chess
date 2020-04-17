package gui;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javafx.util.Pair;
import mainGame.PiecesType;

public class PieceGUI {

	PiecesType pieceType;
	boolean isPlayer1;
	Pair<Integer, Integer> position;
	Image img = null;
	
	public PieceGUI(PiecesType pieceType, boolean isPlayer1, Pair<Integer, Integer> position)
	{
		this.pieceType = pieceType;
		this.isPlayer1 = isPlayer1;
		this.position = position;
		UpdateButtonImg();
	}
	
	public Image getPieceIcon()
	{
		if(img == null)
		{
			String iconURL = "";
			if (!isPlayer1) {
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
		}
		return img;
	}
	
	public void UpdateButtonImg()
	{
		img = getPieceIcon();
		ChessWindow.gridList[position.getKey()][position.getValue()].setIcon(new ImageIcon(img));
	}
}
